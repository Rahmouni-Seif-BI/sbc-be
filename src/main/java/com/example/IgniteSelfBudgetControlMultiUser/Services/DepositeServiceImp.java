package com.example.IgniteSelfBudgetControlMultiUser.Services;

import com.example.IgniteSelfBudgetControlMultiUser.ABC.Mappers.DepositeMapper;
import com.example.IgniteSelfBudgetControlMultiUser.ABC.Utils.Global;
import com.example.IgniteSelfBudgetControlMultiUser.DTO.DepositeDTO;
import com.example.IgniteSelfBudgetControlMultiUser.DTO.SpendingDTO;
import com.example.IgniteSelfBudgetControlMultiUser.Services.Abstract.IAbstractService;
import com.example.IgniteSelfBudgetControlMultiUser.Entities.*;
import com.example.IgniteSelfBudgetControlMultiUser.Repositories.IAccountRepository;
import com.example.IgniteSelfBudgetControlMultiUser.Repositories.ICreditStatusRepository;
import com.example.IgniteSelfBudgetControlMultiUser.Repositories.IPurposeRepository;
import com.example.IgniteSelfBudgetControlMultiUser.Repositories.IDepositeRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
@AllArgsConstructor
public class DepositeServiceImp implements IDepositeService, IAbstractService<DepositeDTO> {

    @Autowired
    IDepositeRepository iDepositeRepository;
    @Autowired
    IPurposeRepository iPurposeRepository;
    @Autowired
    ICreditStatusRepository iCreditStatusRepository;
    @Autowired
    IAccountRepository iAccountRepository;

    @Autowired
    private Global global;
    
    @Autowired
    DepositeMapper depositeMapper;


    @Override
    public DepositeDTO load(Long id) {

        Deposite deposite = iDepositeRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Item with id :" + id + " not found"));
        DepositeDTO depositeDTO = depositeMapper.toDepositeDTO(deposite);
        return depositeDTO;
    }

    @Override
    public List<DepositeDTO> getAll() {

        UserEntity user = global.getCurrentUser();
        List<Deposite> deposites = iDepositeRepository.findDepositeByUser_Id(user.getId());
        List<DepositeDTO> depositeDTOS = new ArrayList<>();

        for (Deposite deposite : deposites) {
            depositeDTOS.add(load(deposite.getId()));
        }
        return depositeDTOS;
    }
    
      
    @Override
    public DepositeDTO save(DepositeDTO entity) throws Exception {
        UserEntity user = global.getCurrentUser();
        Deposite deposite = depositeMapper.fromDepositeDTO(entity);
        deposite.setUser(user);
        deposite = iDepositeRepository.save(deposite);
        return  load(deposite.getId());    }




    @Override
    public List<DepositeDTO> saveAll(List<DepositeDTO> entities) throws Exception {
        return null;//iDepositeRepository.saveAll(entities);
    }
    
    @Override
    public void delete(Long id) {
        iDepositeRepository.deleteById(id);
    }



    public  List<DepositeDTO> getDepositeListByAccountId(Long accountId){
        UserEntity user = global.getCurrentUser();
        List<Deposite> deposites = iDepositeRepository.getDepositeByAccount_IdAndUserId(accountId, user.getId());
        List<DepositeDTO> depositeDTOS = new ArrayList<>();

        for (Deposite deposite : deposites) {
            depositeDTOS.add(load(deposite.getId()));
        }
        return depositeDTOS;
    }
}
