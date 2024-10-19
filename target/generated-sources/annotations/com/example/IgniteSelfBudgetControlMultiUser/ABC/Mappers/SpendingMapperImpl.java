package com.example.IgniteSelfBudgetControlMultiUser.ABC.Mappers;

import com.example.IgniteSelfBudgetControlMultiUser.DTO.SpendingDTO;
import com.example.IgniteSelfBudgetControlMultiUser.Entities.Account;
import com.example.IgniteSelfBudgetControlMultiUser.Entities.CreditStatus;
import com.example.IgniteSelfBudgetControlMultiUser.Entities.Purpose;
import com.example.IgniteSelfBudgetControlMultiUser.Entities.Spending;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-10-19T17:33:41+0100",
    comments = "version: 1.5.2.Final, compiler: javac, environment: Java 17.0.10 (Amazon.com Inc.)"
)
@Component
public class SpendingMapperImpl implements SpendingMapper {

    @Override
    public SpendingDTO toSpendingDTO(Spending spending) {
        if ( spending == null ) {
            return null;
        }

        SpendingDTO spendingDTO = new SpendingDTO();

        spendingDTO.setPurposeId( spendingPurposeId( spending ) );
        spendingDTO.setPurposeCode( spendingPurposeCode( spending ) );
        spendingDTO.setPurposeDescription( spendingPurposeDescription( spending ) );
        spendingDTO.setCreditStatusId( spendingCreditStatusId( spending ) );
        spendingDTO.setCreditStatusCode( spendingCreditStatusCode( spending ) );
        spendingDTO.setCreditStatusDescription( spendingCreditStatusDescription( spending ) );
        spendingDTO.setAccountId( spendingAccountId( spending ) );
        spendingDTO.setAccountCode( spendingAccountCode( spending ) );
        spendingDTO.setAccountDescription( spendingAccountDescription( spending ) );
        spendingDTO.setId( spending.getId() );
        spendingDTO.setCode( spending.getCode() );
        spendingDTO.setAmountToSpend( spending.getAmountToSpend() );
        spendingDTO.setActionDate( spending.getActionDate() );
        spendingDTO.setNotes( spending.getNotes() );

        return spendingDTO;
    }

    @Override
    public Spending fromSpendingDTO(SpendingDTO spendingDTO) {
        if ( spendingDTO == null ) {
            return null;
        }

        Spending spending = new Spending();

        spending.setPurpose( spendingDTOToPurpose( spendingDTO ) );
        spending.setCreditStatus( spendingDTOToCreditStatus( spendingDTO ) );
        spending.setAccount( spendingDTOToAccount( spendingDTO ) );
        spending.setId( spendingDTO.getId() );
        spending.setCode( spendingDTO.getCode() );
        spending.setNotes( spendingDTO.getNotes() );
        spending.setAmountToSpend( spendingDTO.getAmountToSpend() );
        spending.setActionDate( spendingDTO.getActionDate() );

        return spending;
    }

    private Long spendingPurposeId(Spending spending) {
        if ( spending == null ) {
            return null;
        }
        Purpose purpose = spending.getPurpose();
        if ( purpose == null ) {
            return null;
        }
        Long id = purpose.getId();
        if ( id == null ) {
            return null;
        }
        return id;
    }

    private String spendingPurposeCode(Spending spending) {
        if ( spending == null ) {
            return null;
        }
        Purpose purpose = spending.getPurpose();
        if ( purpose == null ) {
            return null;
        }
        String code = purpose.getCode();
        if ( code == null ) {
            return null;
        }
        return code;
    }

    private String spendingPurposeDescription(Spending spending) {
        if ( spending == null ) {
            return null;
        }
        Purpose purpose = spending.getPurpose();
        if ( purpose == null ) {
            return null;
        }
        String description = purpose.getDescription();
        if ( description == null ) {
            return null;
        }
        return description;
    }

    private Long spendingCreditStatusId(Spending spending) {
        if ( spending == null ) {
            return null;
        }
        CreditStatus creditStatus = spending.getCreditStatus();
        if ( creditStatus == null ) {
            return null;
        }
        Long id = creditStatus.getId();
        if ( id == null ) {
            return null;
        }
        return id;
    }

    private String spendingCreditStatusCode(Spending spending) {
        if ( spending == null ) {
            return null;
        }
        CreditStatus creditStatus = spending.getCreditStatus();
        if ( creditStatus == null ) {
            return null;
        }
        String code = creditStatus.getCode();
        if ( code == null ) {
            return null;
        }
        return code;
    }

    private String spendingCreditStatusDescription(Spending spending) {
        if ( spending == null ) {
            return null;
        }
        CreditStatus creditStatus = spending.getCreditStatus();
        if ( creditStatus == null ) {
            return null;
        }
        String description = creditStatus.getDescription();
        if ( description == null ) {
            return null;
        }
        return description;
    }

    private Long spendingAccountId(Spending spending) {
        if ( spending == null ) {
            return null;
        }
        Account account = spending.getAccount();
        if ( account == null ) {
            return null;
        }
        Long id = account.getId();
        if ( id == null ) {
            return null;
        }
        return id;
    }

    private String spendingAccountCode(Spending spending) {
        if ( spending == null ) {
            return null;
        }
        Account account = spending.getAccount();
        if ( account == null ) {
            return null;
        }
        String code = account.getCode();
        if ( code == null ) {
            return null;
        }
        return code;
    }

    private String spendingAccountDescription(Spending spending) {
        if ( spending == null ) {
            return null;
        }
        Account account = spending.getAccount();
        if ( account == null ) {
            return null;
        }
        String description = account.getDescription();
        if ( description == null ) {
            return null;
        }
        return description;
    }

    protected Purpose spendingDTOToPurpose(SpendingDTO spendingDTO) {
        if ( spendingDTO == null ) {
            return null;
        }

        Purpose purpose = new Purpose();

        purpose.setId( spendingDTO.getPurposeId() );

        return purpose;
    }

    protected CreditStatus spendingDTOToCreditStatus(SpendingDTO spendingDTO) {
        if ( spendingDTO == null ) {
            return null;
        }

        CreditStatus creditStatus = new CreditStatus();

        creditStatus.setId( spendingDTO.getCreditStatusId() );

        return creditStatus;
    }

    protected Account spendingDTOToAccount(SpendingDTO spendingDTO) {
        if ( spendingDTO == null ) {
            return null;
        }

        Account account = new Account();

        account.setId( spendingDTO.getAccountId() );

        return account;
    }
}
