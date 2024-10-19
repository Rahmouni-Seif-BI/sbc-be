package com.example.IgniteSelfBudgetControlMultiUser.ABC.Mappers;

import com.example.IgniteSelfBudgetControlMultiUser.DTO.RepaymentEntityDTO;
import com.example.IgniteSelfBudgetControlMultiUser.Entities.RepaymentEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")

public interface RepaymentEntityMapper {
    @Mapping(source = "debtorAccount.id", target = "debtorAccountId")
    @Mapping(source = "debtorAccount.code", target = "debtorAccountCode")
    @Mapping(source = "debtorAccount.description", target = "debtorAccountDescription")
    @Mapping(source = "creditorAccount.id", target = "creditorAccountId")
    @Mapping(source = "creditorAccount.code", target = "creditorAccountCode")
    @Mapping(source = "creditorAccount.description", target = "creditorAccountDescription")
    RepaymentEntityDTO toRepaymentEntityDTO(RepaymentEntity repaymentEntity);
    @Mapping(source = "debtorAccountId", target = "debtorAccount.id")
    @Mapping(target = "debtorAccount.code", ignore = true)
    @Mapping(target = "debtorAccount.description", ignore = true)
    @Mapping(source = "creditorAccountId", target = "creditorAccount.id")
    @Mapping(target = "creditorAccount.code", ignore = true)
    @Mapping(target = "creditorAccount.description", ignore = true)
    RepaymentEntity fromRepaymentEntityDTO(RepaymentEntityDTO repaymentEntityDTO);
}
