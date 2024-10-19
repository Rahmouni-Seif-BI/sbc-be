package com.example.IgniteSelfBudgetControlMultiUser.ABC.Mappers;

import com.example.IgniteSelfBudgetControlMultiUser.DTO.RepaymentEntityDTO;
import com.example.IgniteSelfBudgetControlMultiUser.Entities.Account;
import com.example.IgniteSelfBudgetControlMultiUser.Entities.RepaymentEntity;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-10-19T16:28:28+0100",
    comments = "version: 1.5.2.Final, compiler: javac, environment: Java 17.0.10 (Amazon.com Inc.)"
)
@Component
public class RepaymentEntityMapperImpl implements RepaymentEntityMapper {

    @Override
    public RepaymentEntityDTO toRepaymentEntityDTO(RepaymentEntity repaymentEntity) {
        if ( repaymentEntity == null ) {
            return null;
        }

        RepaymentEntityDTO repaymentEntityDTO = new RepaymentEntityDTO();

        repaymentEntityDTO.setDebtorAccountId( repaymentEntityDebtorAccountId( repaymentEntity ) );
        repaymentEntityDTO.setDebtorAccountCode( repaymentEntityDebtorAccountCode( repaymentEntity ) );
        repaymentEntityDTO.setDebtorAccountDescription( repaymentEntityDebtorAccountDescription( repaymentEntity ) );
        repaymentEntityDTO.setCreditorAccountId( repaymentEntityCreditorAccountId( repaymentEntity ) );
        repaymentEntityDTO.setCreditorAccountCode( repaymentEntityCreditorAccountCode( repaymentEntity ) );
        repaymentEntityDTO.setCreditorAccountDescription( repaymentEntityCreditorAccountDescription( repaymentEntity ) );
        repaymentEntityDTO.setId( repaymentEntity.getId() );
        repaymentEntityDTO.setAmountRepaid( repaymentEntity.getAmountRepaid() );
        repaymentEntityDTO.setRepaymentDate( repaymentEntity.getRepaymentDate() );

        return repaymentEntityDTO;
    }

    @Override
    public RepaymentEntity fromRepaymentEntityDTO(RepaymentEntityDTO repaymentEntityDTO) {
        if ( repaymentEntityDTO == null ) {
            return null;
        }

        RepaymentEntity repaymentEntity = new RepaymentEntity();

        repaymentEntity.setDebtorAccount( repaymentEntityDTOToAccount( repaymentEntityDTO ) );
        repaymentEntity.setCreditorAccount( repaymentEntityDTOToAccount1( repaymentEntityDTO ) );
        repaymentEntity.setId( repaymentEntityDTO.getId() );
        repaymentEntity.setAmountRepaid( repaymentEntityDTO.getAmountRepaid() );
        repaymentEntity.setRepaymentDate( repaymentEntityDTO.getRepaymentDate() );

        return repaymentEntity;
    }

    private Long repaymentEntityDebtorAccountId(RepaymentEntity repaymentEntity) {
        if ( repaymentEntity == null ) {
            return null;
        }
        Account debtorAccount = repaymentEntity.getDebtorAccount();
        if ( debtorAccount == null ) {
            return null;
        }
        Long id = debtorAccount.getId();
        if ( id == null ) {
            return null;
        }
        return id;
    }

    private String repaymentEntityDebtorAccountCode(RepaymentEntity repaymentEntity) {
        if ( repaymentEntity == null ) {
            return null;
        }
        Account debtorAccount = repaymentEntity.getDebtorAccount();
        if ( debtorAccount == null ) {
            return null;
        }
        String code = debtorAccount.getCode();
        if ( code == null ) {
            return null;
        }
        return code;
    }

    private String repaymentEntityDebtorAccountDescription(RepaymentEntity repaymentEntity) {
        if ( repaymentEntity == null ) {
            return null;
        }
        Account debtorAccount = repaymentEntity.getDebtorAccount();
        if ( debtorAccount == null ) {
            return null;
        }
        String description = debtorAccount.getDescription();
        if ( description == null ) {
            return null;
        }
        return description;
    }

    private Long repaymentEntityCreditorAccountId(RepaymentEntity repaymentEntity) {
        if ( repaymentEntity == null ) {
            return null;
        }
        Account creditorAccount = repaymentEntity.getCreditorAccount();
        if ( creditorAccount == null ) {
            return null;
        }
        Long id = creditorAccount.getId();
        if ( id == null ) {
            return null;
        }
        return id;
    }

    private String repaymentEntityCreditorAccountCode(RepaymentEntity repaymentEntity) {
        if ( repaymentEntity == null ) {
            return null;
        }
        Account creditorAccount = repaymentEntity.getCreditorAccount();
        if ( creditorAccount == null ) {
            return null;
        }
        String code = creditorAccount.getCode();
        if ( code == null ) {
            return null;
        }
        return code;
    }

    private String repaymentEntityCreditorAccountDescription(RepaymentEntity repaymentEntity) {
        if ( repaymentEntity == null ) {
            return null;
        }
        Account creditorAccount = repaymentEntity.getCreditorAccount();
        if ( creditorAccount == null ) {
            return null;
        }
        String description = creditorAccount.getDescription();
        if ( description == null ) {
            return null;
        }
        return description;
    }

    protected Account repaymentEntityDTOToAccount(RepaymentEntityDTO repaymentEntityDTO) {
        if ( repaymentEntityDTO == null ) {
            return null;
        }

        Account account = new Account();

        account.setId( repaymentEntityDTO.getDebtorAccountId() );

        return account;
    }

    protected Account repaymentEntityDTOToAccount1(RepaymentEntityDTO repaymentEntityDTO) {
        if ( repaymentEntityDTO == null ) {
            return null;
        }

        Account account = new Account();

        account.setId( repaymentEntityDTO.getCreditorAccountId() );

        return account;
    }
}
