package com.example.IgniteSelfBudgetControlMultiUser.Services;

import com.example.IgniteSelfBudgetControlMultiUser.ABC.Mappers.SpendingMapper;
import com.example.IgniteSelfBudgetControlMultiUser.ABC.Utils.Global;
import com.example.IgniteSelfBudgetControlMultiUser.DTO.SpendingDTO;
import com.example.IgniteSelfBudgetControlMultiUser.DTO.SpendingDTO;
import com.example.IgniteSelfBudgetControlMultiUser.Repositories.*;
import com.example.IgniteSelfBudgetControlMultiUser.Services.Abstract.IAbstractService;
import com.example.IgniteSelfBudgetControlMultiUser.Entities.*;
import com.example.IgniteSelfBudgetControlMultiUser.DTO.SearchCriteria;
import com.example.IgniteSelfBudgetControlMultiUser.Repositories.ISpendingRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import javax.validation.ValidationException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

@Service
@Slf4j
@AllArgsConstructor
public class SpendingServiceImp implements ISpendingService, IAbstractService<SpendingDTO> {

    @Autowired
    ISpendingRepository iSpendingRepository;

    @Autowired
    IPurposeRepository iPurposeRepository;
    @Autowired
    ICreditStatusRepository iCreditStatusRepository;
    @Autowired
    IAccountRepository iAccountRepository;

    @Autowired
    SpendingMapper spendingMapper;

    @Autowired
    Global global;


    @Override
    public SpendingDTO load(Long id)
    {
        UserEntity user = global.getCurrentUser();
        Spending spending = iSpendingRepository.getSpendingsByIdAndUserId(id, user.getId());
        SpendingDTO spendingDTO  = spendingMapper.toSpendingDTO(spending);
        return spendingDTO;
    }

    public List<SpendingDTO> getAll()
    {
        UserEntity user = global.getCurrentUser();
        List<Spending> spendings = iSpendingRepository.getSpendingsByUser_Id(user.getId());
        List<SpendingDTO> spendingDTOS = new ArrayList<>();

        for (Spending spending : spendings) {
            spendingDTOS.add(load(spending.getId()));
        }
        return spendingDTOS;
    }

    @Override
    public SpendingDTO save(SpendingDTO entity) throws Exception
    {
        UserEntity user = global.getCurrentUser();
        Spending spending = spendingMapper.fromSpendingDTO(entity);

        spending.setUser(user);
        if (spending.getActionDate() == null)
        {
            spending.setActionDate(new Date());
        }

        spending = iSpendingRepository.save(spending);
        return  load(spending.getId());
    }

    @Override
    public List<SpendingDTO> saveAll(List<SpendingDTO> entities) throws Exception {
        return null; //iSpendingRepository.saveAll(entities);
    }

    @Override
    public void delete(Long id) {
        iSpendingRepository.deleteById(id);
    }


    public  List<SpendingDTO> getSpendingListByAccountId(Long accountId){
        UserEntity user = global.getCurrentUser();
        List<Spending> spendings = iSpendingRepository.getSpendingByAccount_IdAndUserId(accountId, user.getId());
        List<SpendingDTO> spendingDTOS = new ArrayList<>();

        for (Spending spending : spendings) {
            spendingDTOS.add(load(spending.getId()));
        }
        return spendingDTOS;
    }

//
//    @Override
//    public SpendingDTO save(SpendingDTO entity, Long param1, Long param2, Long param3) throws Exception {
//        //spending,purposeId,statusId,spendingId
//        Purpose purpose = iPurposeRepository.findById(param1) .orElseThrow(() -> new IllegalArgumentException("Invalid purpose Id"));
//        CreditStatus creditStatus = iCreditStatusRepository.findById(param2) .orElseThrow(() -> new IllegalArgumentException("Invalid creditStatus Id"));
//        Spending spending = iSpendingRepository.findById(param3) .orElseThrow(() -> new IllegalArgumentException("Invalid spending Id"));
//
//        entity.setPurpose(purpose);
//        entity.setCreditStatus(creditStatus);
//        entity.setSpending(spending);
//
//        if (entity.getActionDate() == null)
//        {
//            entity.setActionDate(new Date());
//        }
//
//        if (entity.getCode() == null)
//        {
//            // Generate a random number
//            Random random = new Random();
//            long randomNumber = random.nextLong(1000);
//            entity.setCode(String.valueOf(randomNumber));
//        }
//        iSpendingRepository.save(entity);
//        return null;
//    }
//
//    @Override
//    public List<SpendingDTO> getSpendingsBySpending(Long spendingId) throws Exception {
//        List<SpendingDTO> spendingList = iSpendingRepository.getSpendingsBySpending_Id(spendingId);
//        for( SpendingDTO spending : spendingList){
//            spending.getSpending().setCreditsGiven(null);
//            spending.getSpending().setCreditsReceived(null);
//            spending.getSpending().setRepaymentsMade(null);
//            spending.getSpending().setRepaymentsReceived(null);
//        }
//
//        return  spendingList;
//    }
//
//
//
//
//
//    public List<SpendingDTO> getSpendingsByPurpose(String purpose) {
//        List<SpendingDTO> spendingList = iSpendingRepository.getSpendingsByPurposeCode(purpose);
//        for( SpendingDTO spending : spendingList){
//            spending.getSpending().setCreditsGiven(null);
//            spending.getSpending().setCreditsReceived(null);
//            spending.getSpending().setRepaymentsMade(null);
//            spending.getSpending().setRepaymentsReceived(null);
//        }
//
//        return  spendingList;
//    }




}
