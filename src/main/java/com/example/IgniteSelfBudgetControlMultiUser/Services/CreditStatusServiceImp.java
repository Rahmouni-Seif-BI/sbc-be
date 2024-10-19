package com.example.IgniteSelfBudgetControlMultiUser.Services;

import com.example.IgniteSelfBudgetControlMultiUser.ABC.Mappers.CreditStatusMapper;
import com.example.IgniteSelfBudgetControlMultiUser.ABC.Utils.Global;
import com.example.IgniteSelfBudgetControlMultiUser.DTO.CreditStatusDTO;
import com.example.IgniteSelfBudgetControlMultiUser.DTO.CreditStatusDTO;
import com.example.IgniteSelfBudgetControlMultiUser.Entities.CreditStatus;
import com.example.IgniteSelfBudgetControlMultiUser.Entities.CreditStatus;
import com.example.IgniteSelfBudgetControlMultiUser.Entities.UserEntity;
import com.example.IgniteSelfBudgetControlMultiUser.Repositories.ICreditStatusRepository;
import com.example.IgniteSelfBudgetControlMultiUser.Services.Abstract.IAbstractService;
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
public class CreditStatusServiceImp implements ICreditStatusService, IAbstractService<CreditStatusDTO> {

    @Autowired
    ICreditStatusRepository iCreditStatusRepository;

    @Autowired
    CreditStatusMapper creditStatusMapper;
    
    @Autowired
    Global global;

    @Override
    public CreditStatusDTO load(Long id) {

        CreditStatus creditEntity = iCreditStatusRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Item with id :" + id + " not found"));
        CreditStatusDTO creditEntityDTO = creditStatusMapper.toCreditStatusDTO(creditEntity);
        return creditEntityDTO;
    }

    @Override
    public List<CreditStatusDTO> getAll() {

        UserEntity user = global.getCurrentUser();
        List<CreditStatus> creditEntities = iCreditStatusRepository.findCreditStatusByUser_Id(user.getId());
        List<CreditStatusDTO> creditEntityDTOS = new ArrayList<>();

        for (CreditStatus creditEntity : creditEntities) {
            creditEntityDTOS.add(load(creditEntity.getId()));
        }
        return creditEntityDTOS;
    }
    
    @Override
    public CreditStatusDTO save(CreditStatusDTO entity) throws Exception {
        UserEntity user = global.getCurrentUser();
        CreditStatus creditStatus = creditStatusMapper.fromCreditStatusDTO(entity);
        creditStatus.setUser(user);
        creditStatus = iCreditStatusRepository.save(creditStatus);

        return  load(creditStatus.getId());    }

    @Override
    public List<CreditStatusDTO> saveAll(List<CreditStatusDTO> entities) throws Exception {
        return null; //iCreditStatusRepository.saveAll(entities);
    }
    
    @Override
    public void delete(Long id) {
        iCreditStatusRepository.deleteById(id);
    }
    
}
