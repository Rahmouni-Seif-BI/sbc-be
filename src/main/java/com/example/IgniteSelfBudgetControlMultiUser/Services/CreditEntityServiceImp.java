package com.example.IgniteSelfBudgetControlMultiUser.Services;

import com.example.IgniteSelfBudgetControlMultiUser.ABC.Mappers.CreditEntityMapper;
import com.example.IgniteSelfBudgetControlMultiUser.ABC.Utils.Global;
import com.example.IgniteSelfBudgetControlMultiUser.DTO.CreditEntityDTO;
import com.example.IgniteSelfBudgetControlMultiUser.Entities.CreditEntity;
import com.example.IgniteSelfBudgetControlMultiUser.Entities.UserEntity;
import com.example.IgniteSelfBudgetControlMultiUser.Repositories.IAccountRepository;
import com.example.IgniteSelfBudgetControlMultiUser.Repositories.ICreditEntityRepository;
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
public class CreditEntityServiceImp implements ICreditEntityService, IAbstractService<CreditEntityDTO> {

    @Autowired
    ICreditEntityRepository iCreditEntityRepository;

    @Autowired
    IAccountRepository iAccountRepository;

    @Autowired
    private CreditEntityMapper creditEntityMapper;

    @Autowired
    Global global;

    @Override
    public CreditEntityDTO load(Long id) {

        CreditEntity creditEntity = iCreditEntityRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Item with id :" + id + " not found"));
        CreditEntityDTO creditEntityDTO = creditEntityMapper.toCreditEntityDto(creditEntity);
        return creditEntityDTO;
    }

    @Override
    public List<CreditEntityDTO> getAll() {

        UserEntity user = global.getCurrentUser();
        List<CreditEntity> creditEntities = iCreditEntityRepository.findCreditEntityByUser_Id(user.getId());
        List<CreditEntityDTO> creditEntityDTOS = new ArrayList<>();

        for (CreditEntity creditEntity : creditEntities) {
            creditEntityDTOS.add(load(creditEntity.getId()));
        }
        return creditEntityDTOS;
    }


    @Override
    public CreditEntityDTO save(CreditEntityDTO entity) throws Exception {
        UserEntity user = global.getCurrentUser();
        CreditEntity creditEntity = creditEntityMapper.fromCreditEntityDTO(entity);
        creditEntity.setUser(user);
        creditEntity = iCreditEntityRepository.save(creditEntity);
        return  load(creditEntity.getId());
    }

    @Override
    public List<CreditEntityDTO> saveAll(List<CreditEntityDTO> entities) throws Exception {
        return null;
    }

    @Override
    public void delete(Long id) {
        iCreditEntityRepository.deleteById(id);
    }

}
