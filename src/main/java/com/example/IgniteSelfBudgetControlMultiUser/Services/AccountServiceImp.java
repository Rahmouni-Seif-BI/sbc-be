package com.example.IgniteSelfBudgetControlMultiUser.Services;

import com.example.IgniteSelfBudgetControlMultiUser.ABC.Mappers.AccountMapper;
import com.example.IgniteSelfBudgetControlMultiUser.ABC.Mappers.CreditEntityMapper;
import com.example.IgniteSelfBudgetControlMultiUser.ABC.Mappers.RepaymentEntityMapper;
import com.example.IgniteSelfBudgetControlMultiUser.ABC.Utils.Global;
import com.example.IgniteSelfBudgetControlMultiUser.DTO.*;
import com.example.IgniteSelfBudgetControlMultiUser.Entities.Account;
import com.example.IgniteSelfBudgetControlMultiUser.Entities.Spending;
import com.example.IgniteSelfBudgetControlMultiUser.Entities.UserEntity;
import com.example.IgniteSelfBudgetControlMultiUser.Repositories.IAccountRepository;
import com.example.IgniteSelfBudgetControlMultiUser.Repositories.IDepositeRepository;
import com.example.IgniteSelfBudgetControlMultiUser.Repositories.ISpendingRepository;
import com.example.IgniteSelfBudgetControlMultiUser.Repositories.IUserEntityRepository;
import com.example.IgniteSelfBudgetControlMultiUser.Services.Abstract.IAbstractService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
@AllArgsConstructor
public class AccountServiceImp implements IAccountService, IAbstractService<AccountDTO> {

    @Autowired
    IAccountRepository iAccountRepository;

    @Autowired
    ISpendingRepository iSpendingRepository;

    @Autowired
    SpendingServiceImp spendingServiceImp;

    @Autowired
    IDepositeRepository iDepositeRepository;
    @Autowired
    DepositeServiceImp depositeServiceImp;

    @Autowired
    private CreditEntityMapper creditEntityMapper;

    @Autowired
    private RepaymentEntityMapper repaymentEntityMapper;


    @Autowired
    private IUserEntityRepository iUserEntityRepository;

    @Autowired
    private Global global;

    @Autowired
    AccountMapper accountMapper;


    @Override
    public AccountDTO load(Long id) {
        UserEntity user = global.getCurrentUser();
        Account account = iAccountRepository.getAccountByIdAndUserId(id, user.getId());
        account.setOwner(user.getName() + " " + user.getSurname());
        AccountDTO accountDTO = accountMapper.toAccountDTO(account);
        getSpendingList(accountDTO);
        getDepositeList(accountDTO);
        calculateAmounts(accountDTO);


        return accountDTO;
    }

    private void calculateAmounts(AccountDTO accountDTO) {

        //Calculate Spent
        accountDTO.setAmountConsumed(
                (float) accountDTO.getSpendingDTOList().stream()
                        .mapToDouble(SpendingDTO::getAmountToSpend)  // Extract and sum the amountToSpend
                        .sum()
        );
        //Calculate total deposit
        accountDTO.setAmountBalance(
                (float) accountDTO.getDepositeDTOList().stream()
                        .mapToDouble(DepositeDTO::getAmountToDeposite)  // Extract and sum the amountToSpend
                        .sum()
        );
        //Calculate Rest
        accountDTO.setAmountRest(accountDTO.getAmountBalance() - accountDTO.getAmountConsumed());
    }

    public List<AccountDTO> getAll() {
        UserEntity user = global.getCurrentUser();
        List<Account> accounts = iAccountRepository.findAccountsByUser_Id(user.getId());
        List<AccountDTO> accountDTOS = new ArrayList<>();

        for (Account account : accounts) {
            accountDTOS.add(load(account.getId()));
        }
        return accountDTOS;
    }

    @Override
    public AccountDTO save(AccountDTO entity) throws Exception {
        UserEntity user = global.getCurrentUser();
        Account account = accountMapper.fromAccountDTO(entity);
        account.setUser(user);
        account = iAccountRepository.save(account);

        return load(account.getId());
    }

    @Override
    public List<AccountDTO> saveAll(List<AccountDTO> entities) throws Exception {
        return null;
    }

    @Override
    public void delete(Long id) {
        iAccountRepository.deleteById(id);
    }


    public void getSpendingList(AccountDTO accountDTO) {
        List<SpendingDTO> spendingDTOList = spendingServiceImp.getSpendingListByAccountId(accountDTO.getId());
        accountDTO.setSpendingDTOList(spendingDTOList);
    }

    public void getDepositeList(AccountDTO accountDTO) {
        List<DepositeDTO> depositeDTOList = depositeServiceImp.getDepositeListByAccountId(accountDTO.getId());
        accountDTO.setDepositeDTOList(depositeDTOList);
    }



    // credit System
    public void calculateRemainingBalance(AccountDTO accountDTO) {
//        float remainingBalance = accountDTO.getCalculatedAmountbalance() - accountDTO.getCalculatedAmountconsumed();
//        accountDTO.setCalculatedAmountRest(remainingBalance);
    }


    //Credit
    public List<CreditEntityDTO> getCreditsGivenByAccount(Long accountId) {
//        AccountDTO creditorAccount = iAccountRepository.findById(accountId)
//                .orElseThrow(() -> new NotFoundException("Creditor accountDTO not found"));
//        return creditEntityMapper.toDTOList(creditorAccount.getCreditsGiven()); // Use the mapper to map entities to DTOs;
        return null;
    }


    @Override
    public List<CreditEntityDTO> getCreditsReceivedByAccount(Long accountId) {
//        AccountDTO debtorAccount = iAccountRepository.findById(accountId)
//                .orElseThrow(() -> new NotFoundException("Debtor accountDTO not found"));
//        return creditEntityMapper.toDTOList(debtorAccount.getCreditsReceived()); // Use the mapper to map entities to DTOs;
        return null;
    }

    @Override
    public List<RepaymentEntityDTO> getRepaymentsReceivedByAccount(Long accountId) {
//        AccountDTO creditorAccount = iAccountRepository.findById(accountId)
//                .orElseThrow(() -> new NotFoundException("Creditor accountDTO not found"));
//        return repaymentEntityMapper.toDTOList(creditorAccount.getRepaymentsReceived()); // Use the mapper to map entities to DTOs;
        return null;
    }

    @Override
    public List<RepaymentEntityDTO> getRepaymentsMadeByAccount(Long accountId) {
//        AccountDTO debtorAccount = iAccountRepository.findById(accountId)
//                .orElseThrow(() -> new NotFoundException("Debtor accountDTO not found"));
//        return repaymentEntityMapper.toDTOList(debtorAccount.getRepaymentsMade()); // Use the mapper to map entities to DTOs;
        return null;
    }
    // END credit System


    //TODELETE

    public Account depositAccount(Long accountId, float amountToDepose) throws Exception {
        return null;
    }

}
