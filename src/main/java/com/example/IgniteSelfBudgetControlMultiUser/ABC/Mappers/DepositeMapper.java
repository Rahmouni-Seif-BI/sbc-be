package com.example.IgniteSelfBudgetControlMultiUser.ABC.Mappers;

import com.example.IgniteSelfBudgetControlMultiUser.DTO.DepositeDTO;
import com.example.IgniteSelfBudgetControlMultiUser.Entities.Deposite;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")

public interface DepositeMapper {
    @Mapping(source = "account.id", target = "accountId")
    @Mapping(source = "account.code", target = "accountCode")
    @Mapping(source = "account.description", target = "accountDescription")
    DepositeDTO toDepositeDTO(Deposite deposite);
    @Mapping(source = "accountId", target = "account.id")
    @Mapping(target = "account.code", ignore = true)
    @Mapping(target = "account.description", ignore = true)
    Deposite fromDepositeDTO(DepositeDTO depositeDTO);
}
