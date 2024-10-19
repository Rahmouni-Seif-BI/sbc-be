package com.example.IgniteSelfBudgetControlMultiUser.Services;

import com.example.IgniteSelfBudgetControlMultiUser.ABC.Mappers.PurposeMapper;
import com.example.IgniteSelfBudgetControlMultiUser.ABC.Utils.Global;
import com.example.IgniteSelfBudgetControlMultiUser.DTO.PurposeDTO;
import com.example.IgniteSelfBudgetControlMultiUser.Entities.Purpose;
import com.example.IgniteSelfBudgetControlMultiUser.Entities.UserEntity;
import com.example.IgniteSelfBudgetControlMultiUser.Repositories.IPurposeRepository;
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
public class PurposeServiceImp implements IPurposeService, IAbstractService<PurposeDTO> {

    @Autowired
    IPurposeRepository iPurposeRepository;
    
    @Autowired
    PurposeMapper purposeMapper;
    
    @Autowired
    Global global;


    @Override
    public PurposeDTO load(Long id) {

        Purpose purpose = iPurposeRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Item with id :" + id + " not found"));
        PurposeDTO creditEntityDTO = purposeMapper.toPurposeDTO(purpose);
        return creditEntityDTO;
    }

    @Override
    public List<PurposeDTO> getAll() {

        UserEntity user = global.getCurrentUser();
        List<Purpose> purposeList = iPurposeRepository.findPurposeByUser_Id(user.getId());
        List<PurposeDTO> purposeDTOS = new ArrayList<>();

        for (Purpose purpose : purposeList) {
            purposeDTOS.add(load(purpose.getId()));
        }
        return purposeDTOS;
    }


    @Override
    public PurposeDTO save(PurposeDTO entity) throws Exception {
        UserEntity user = global.getCurrentUser();
        Purpose purpose = purposeMapper.fromPurposeDTO(entity);
        purpose.setUser(user);
        purpose = iPurposeRepository.save(purpose);
        return  load(purpose.getId());
    }

    @Override
    public List<PurposeDTO> saveAll(List<PurposeDTO> entities) throws Exception {
        return null; //iPurposeRepository.saveAll(entities);
    }


    @Override
    public void delete(Long id) {
        iPurposeRepository.deleteById(id);
    }
    
}
