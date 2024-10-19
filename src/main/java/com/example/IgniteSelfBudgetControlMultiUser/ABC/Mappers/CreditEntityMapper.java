package com.example.IgniteSelfBudgetControlMultiUser.ABC.Mappers;

import com.example.IgniteSelfBudgetControlMultiUser.DTO.CreditEntityDTO;
import com.example.IgniteSelfBudgetControlMultiUser.Entities.CreditEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface CreditEntityMapper {

    @Mapping(source = "debtorAccount.id", target = "debtorAccountId")
    @Mapping(source = "debtorAccount.code", target = "debtorAccountCode")
    @Mapping(source = "debtorAccount.description", target = "debtorAccountDescription")
    @Mapping(source = "creditorAccount.id", target = "creditorAccountId")
    @Mapping(source = "creditorAccount.code", target = "creditorAccountCode")
    @Mapping(source = "creditorAccount.description", target = "creditorAccountDescription")
    CreditEntityDTO toCreditEntityDto(CreditEntity creditEntity);
    @Mapping(source = "debtorAccountId", target = "debtorAccount.id")
    @Mapping(target = "debtorAccount.code", ignore = true)
    @Mapping(target = "debtorAccount.description", ignore = true)
    @Mapping(source = "creditorAccountId", target = "creditorAccount.id")
    @Mapping(target = "creditorAccount.code", ignore = true)
    @Mapping(target = "creditorAccount.description", ignore = true)
    CreditEntity fromCreditEntityDTO(CreditEntityDTO accountDTO);
}
