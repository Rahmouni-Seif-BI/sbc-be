package com.example.IgniteSelfBudgetControlMultiUser.Services;

import com.example.IgniteSelfBudgetControlMultiUser.ABC.Utils.Global;
import com.example.IgniteSelfBudgetControlMultiUser.DTO.RepaymentEntityDTO;
import com.example.IgniteSelfBudgetControlMultiUser.Entities.RepaymentEntity;
import com.example.IgniteSelfBudgetControlMultiUser.Entities.UserEntity;
import com.example.IgniteSelfBudgetControlMultiUser.Services.Abstract.IAbstractService;
import com.example.IgniteSelfBudgetControlMultiUser.ABC.Mappers.RepaymentEntityMapper;
import com.example.IgniteSelfBudgetControlMultiUser.Repositories.IAccountRepository;
import com.example.IgniteSelfBudgetControlMultiUser.Repositories.IRepaymentEntityRepository;
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
public class RepaymentEntityServiceImp implements IRepaymentEntityService, IAbstractService<RepaymentEntityDTO> {

    @Autowired
    IRepaymentEntityRepository iRepaymentEntityRepository;

    @Autowired
    IAccountRepository iAccountRepository;

    @Autowired
    private RepaymentEntityMapper repaymentEntityMapper;

    @Autowired
    Global global;


    @Override
    public RepaymentEntityDTO load(Long id) {

        RepaymentEntity repaymentEntity = iRepaymentEntityRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Item with id :" + id + " not found"));
        RepaymentEntityDTO creditEntityDTO = repaymentEntityMapper.toRepaymentEntityDTO(repaymentEntity);
        return creditEntityDTO;
    }

    @Override
    public List<RepaymentEntityDTO> getAll() {

        UserEntity user = global.getCurrentUser();
        List<RepaymentEntity> repaymentEntityList = iRepaymentEntityRepository.findRepaymentEntityByUser_Id(user.getId());
        List<RepaymentEntityDTO> repaymentEntityDTOS = new ArrayList<>();

        for (RepaymentEntity repaymentEntity : repaymentEntityList) {
            repaymentEntityDTOS.add(load(repaymentEntity.getId()));
        }
        return repaymentEntityDTOS;
    }


    @Override
    public RepaymentEntityDTO save(RepaymentEntityDTO entity) throws Exception {
        UserEntity user = global.getCurrentUser();
        RepaymentEntity repaymentEntity = repaymentEntityMapper.fromRepaymentEntityDTO(entity);
        repaymentEntity.setUser(user);
        repaymentEntity = iRepaymentEntityRepository.save(repaymentEntity);
        return  load(repaymentEntity.getId());
    }


    @Override
    public List<RepaymentEntityDTO> saveAll(List<RepaymentEntityDTO> entities) throws Exception {
        return null;//iRepaymentEntityRepository.saveAll(entities);
    }

    @Override
    public void delete(Long id) {
        iRepaymentEntityRepository.deleteById(id);
    }

//    public List<RepaymentEntityDTO> getRepaymentEntities() {
//        List<RepaymentEntityDTO> repaymentEntityList = iRepaymentEntityRepository.findAll();
//        return  null;//repaymentEntityMapper.toDTOList(repaymentEntityList); // Use the mapper to map entities to DTOs;
//    }


}
