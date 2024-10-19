package com.example.IgniteSelfBudgetControlMultiUser.ABC.Mappers;

import com.example.IgniteSelfBudgetControlMultiUser.DTO.SpendingDTO;
import com.example.IgniteSelfBudgetControlMultiUser.Entities.Spending;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")

public interface SpendingMapper {

    @Mapping(source = "purpose.id", target = "purposeId")
    @Mapping(source = "purpose.code", target = "purposeCode")
    @Mapping(source = "purpose.description", target = "purposeDescription")
    @Mapping(source = "creditStatus.id", target = "creditStatusId")
    @Mapping(source = "creditStatus.code", target = "creditStatusCode")
    @Mapping(source = "creditStatus.description", target = "creditStatusDescription")
    @Mapping(source = "account.id", target = "accountId")
    @Mapping(source = "account.code", target = "accountCode")
    @Mapping(source = "account.description", target = "accountDescription")
    SpendingDTO toSpendingDTO(Spending spending);




    @Mapping(source = "purposeId", target = "purpose.id")
    @Mapping(target = "purpose.code", ignore = true)
    @Mapping(source = "creditStatusId", target = "creditStatus.id")
    @Mapping(target = "creditStatus.code", ignore = true)
    @Mapping(target = "creditStatus.description", ignore = true)
    @Mapping(source = "accountId", target = "account.id")
    @Mapping(target = "account.code", ignore = true)
    @Mapping(target = "account.description", ignore = true)
    Spending fromSpendingDTO(SpendingDTO spendingDTO);
}
