package com.example.IgniteSelfBudgetControlMultiUser.ABC.Mappers;

import com.example.IgniteSelfBudgetControlMultiUser.DTO.PurposeDTO;
import com.example.IgniteSelfBudgetControlMultiUser.Entities.Purpose;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")

public interface PurposeMapper {
    PurposeDTO toPurposeDTO(Purpose purpose);
    Purpose fromPurposeDTO(PurposeDTO purposeDTO);
}
