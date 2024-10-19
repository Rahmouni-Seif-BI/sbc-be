package com.example.IgniteSelfBudgetControlMultiUser.ABC.Mappers;

import com.example.IgniteSelfBudgetControlMultiUser.DTO.CreditStatusDTO;
import com.example.IgniteSelfBudgetControlMultiUser.Entities.CreditStatus;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-10-19T17:08:23+0100",
    comments = "version: 1.5.2.Final, compiler: javac, environment: Java 17.0.10 (Amazon.com Inc.)"
)
@Component
public class CreditStatusMapperImpl implements CreditStatusMapper {

    @Override
    public CreditStatusDTO toCreditStatusDTO(CreditStatus creditStatus) {
        if ( creditStatus == null ) {
            return null;
        }

        CreditStatusDTO creditStatusDTO = new CreditStatusDTO();

        creditStatusDTO.setId( creditStatus.getId() );
        creditStatusDTO.setCode( creditStatus.getCode() );
        creditStatusDTO.setDescription( creditStatus.getDescription() );

        return creditStatusDTO;
    }

    @Override
    public CreditStatus fromCreditStatusDTO(CreditStatusDTO creditStatusDTO) {
        if ( creditStatusDTO == null ) {
            return null;
        }

        CreditStatus creditStatus = new CreditStatus();

        creditStatus.setId( creditStatusDTO.getId() );
        creditStatus.setCode( creditStatusDTO.getCode() );
        creditStatus.setDescription( creditStatusDTO.getDescription() );

        return creditStatus;
    }
}
