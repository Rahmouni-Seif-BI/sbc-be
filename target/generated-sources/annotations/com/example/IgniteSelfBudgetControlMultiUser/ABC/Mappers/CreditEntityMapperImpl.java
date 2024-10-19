package com.example.IgniteSelfBudgetControlMultiUser.ABC.Mappers;

import com.example.IgniteSelfBudgetControlMultiUser.DTO.CreditEntityDTO;
import com.example.IgniteSelfBudgetControlMultiUser.Entities.Account;
import com.example.IgniteSelfBudgetControlMultiUser.Entities.CreditEntity;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-10-19T17:33:41+0100",
    comments = "version: 1.5.2.Final, compiler: javac, environment: Java 17.0.10 (Amazon.com Inc.)"
)
@Component
public class CreditEntityMapperImpl implements CreditEntityMapper {

    @Override
    public CreditEntityDTO toCreditEntityDto(CreditEntity creditEntity) {
        if ( creditEntity == null ) {
            return null;
        }

        CreditEntityDTO creditEntityDTO = new CreditEntityDTO();

        creditEntityDTO.setDebtorAccountId( creditEntityDebtorAccountId( creditEntity ) );
        creditEntityDTO.setDebtorAccountCode( creditEntityDebtorAccountCode( creditEntity ) );
        creditEntityDTO.setDebtorAccountDescription( creditEntityDebtorAccountDescription( creditEntity ) );
        creditEntityDTO.setCreditorAccountId( creditEntityCreditorAccountId( creditEntity ) );
        creditEntityDTO.setCreditorAccountCode( creditEntityCreditorAccountCode( creditEntity ) );
        creditEntityDTO.setCreditorAccountDescription( creditEntityCreditorAccountDescription( creditEntity ) );
        creditEntityDTO.setId( creditEntity.getId() );
        creditEntityDTO.setAmount( creditEntity.getAmount() );
        creditEntityDTO.setInterestRate( creditEntity.getInterestRate() );
        creditEntityDTO.setStartDate( creditEntity.getStartDate() );
        creditEntityDTO.setEndDate( creditEntity.getEndDate() );

        return creditEntityDTO;
    }

    @Override
    public CreditEntity fromCreditEntityDTO(CreditEntityDTO accountDTO) {
        if ( accountDTO == null ) {
            return null;
        }

        CreditEntity creditEntity = new CreditEntity();

        creditEntity.setDebtorAccount( creditEntityDTOToAccount( accountDTO ) );
        creditEntity.setCreditorAccount( creditEntityDTOToAccount1( accountDTO ) );
        creditEntity.setId( accountDTO.getId() );
        creditEntity.setAmount( accountDTO.getAmount() );
        creditEntity.setInterestRate( accountDTO.getInterestRate() );
        creditEntity.setStartDate( accountDTO.getStartDate() );
        creditEntity.setEndDate( accountDTO.getEndDate() );

        return creditEntity;
    }

    private Long creditEntityDebtorAccountId(CreditEntity creditEntity) {
        if ( creditEntity == null ) {
            return null;
        }
        Account debtorAccount = creditEntity.getDebtorAccount();
        if ( debtorAccount == null ) {
            return null;
        }
        Long id = debtorAccount.getId();
        if ( id == null ) {
            return null;
        }
        return id;
    }

    private String creditEntityDebtorAccountCode(CreditEntity creditEntity) {
        if ( creditEntity == null ) {
            return null;
        }
        Account debtorAccount = creditEntity.getDebtorAccount();
        if ( debtorAccount == null ) {
            return null;
        }
        String code = debtorAccount.getCode();
        if ( code == null ) {
            return null;
        }
        return code;
    }

    private String creditEntityDebtorAccountDescription(CreditEntity creditEntity) {
        if ( creditEntity == null ) {
            return null;
        }
        Account debtorAccount = creditEntity.getDebtorAccount();
        if ( debtorAccount == null ) {
            return null;
        }
        String description = debtorAccount.getDescription();
        if ( description == null ) {
            return null;
        }
        return description;
    }

    private Long creditEntityCreditorAccountId(CreditEntity creditEntity) {
        if ( creditEntity == null ) {
            return null;
        }
        Account creditorAccount = creditEntity.getCreditorAccount();
        if ( creditorAccount == null ) {
            return null;
        }
        Long id = creditorAccount.getId();
        if ( id == null ) {
            return null;
        }
        return id;
    }

    private String creditEntityCreditorAccountCode(CreditEntity creditEntity) {
        if ( creditEntity == null ) {
            return null;
        }
        Account creditorAccount = creditEntity.getCreditorAccount();
        if ( creditorAccount == null ) {
            return null;
        }
        String code = creditorAccount.getCode();
        if ( code == null ) {
            return null;
        }
        return code;
    }

    private String creditEntityCreditorAccountDescription(CreditEntity creditEntity) {
        if ( creditEntity == null ) {
            return null;
        }
        Account creditorAccount = creditEntity.getCreditorAccount();
        if ( creditorAccount == null ) {
            return null;
        }
        String description = creditorAccount.getDescription();
        if ( description == null ) {
            return null;
        }
        return description;
    }

    protected Account creditEntityDTOToAccount(CreditEntityDTO creditEntityDTO) {
        if ( creditEntityDTO == null ) {
            return null;
        }

        Account account = new Account();

        account.setId( creditEntityDTO.getDebtorAccountId() );

        return account;
    }

    protected Account creditEntityDTOToAccount1(CreditEntityDTO creditEntityDTO) {
        if ( creditEntityDTO == null ) {
            return null;
        }

        Account account = new Account();

        account.setId( creditEntityDTO.getCreditorAccountId() );

        return account;
    }
}
