package com.example.IgniteSelfBudgetControlMultiUser.ABC.Mappers;

import com.example.IgniteSelfBudgetControlMultiUser.DTO.CreditStatusDTO;
import com.example.IgniteSelfBudgetControlMultiUser.Entities.CreditStatus;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")

public interface CreditStatusMapper {
    CreditStatusDTO toCreditStatusDTO(CreditStatus creditStatus);
    CreditStatus fromCreditStatusDTO(CreditStatusDTO creditStatusDTO);
}
