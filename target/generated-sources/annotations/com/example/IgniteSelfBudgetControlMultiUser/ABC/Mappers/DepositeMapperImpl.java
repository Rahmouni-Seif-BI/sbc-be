package com.example.IgniteSelfBudgetControlMultiUser.ABC.Mappers;

import com.example.IgniteSelfBudgetControlMultiUser.DTO.DepositeDTO;
import com.example.IgniteSelfBudgetControlMultiUser.Entities.Account;
import com.example.IgniteSelfBudgetControlMultiUser.Entities.Deposite;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-10-20T18:06:48+0100",
    comments = "version: 1.5.2.Final, compiler: javac, environment: Java 17.0.10 (Amazon.com Inc.)"
)
@Component
public class DepositeMapperImpl implements DepositeMapper {

    @Override
    public DepositeDTO toDepositeDTO(Deposite deposite) {
        if ( deposite == null ) {
            return null;
        }

        DepositeDTO depositeDTO = new DepositeDTO();

        depositeDTO.setAccountId( depositeAccountId( deposite ) );
        depositeDTO.setAccountCode( depositeAccountCode( deposite ) );
        depositeDTO.setAccountDescription( depositeAccountDescription( deposite ) );
        depositeDTO.setId( deposite.getId() );
        depositeDTO.setCode( deposite.getCode() );
        depositeDTO.setAmountToDeposite( deposite.getAmountToDeposite() );
        depositeDTO.setActionDate( deposite.getActionDate() );
        depositeDTO.setNotes( deposite.getNotes() );

        return depositeDTO;
    }

    @Override
    public Deposite fromDepositeDTO(DepositeDTO depositeDTO) {
        if ( depositeDTO == null ) {
            return null;
        }

        Deposite deposite = new Deposite();

        deposite.setAccount( depositeDTOToAccount( depositeDTO ) );
        deposite.setId( depositeDTO.getId() );
        deposite.setCode( depositeDTO.getCode() );
        deposite.setNotes( depositeDTO.getNotes() );
        deposite.setAmountToDeposite( depositeDTO.getAmountToDeposite() );
        deposite.setActionDate( depositeDTO.getActionDate() );

        return deposite;
    }

    private Long depositeAccountId(Deposite deposite) {
        if ( deposite == null ) {
            return null;
        }
        Account account = deposite.getAccount();
        if ( account == null ) {
            return null;
        }
        Long id = account.getId();
        if ( id == null ) {
            return null;
        }
        return id;
    }

    private String depositeAccountCode(Deposite deposite) {
        if ( deposite == null ) {
            return null;
        }
        Account account = deposite.getAccount();
        if ( account == null ) {
            return null;
        }
        String code = account.getCode();
        if ( code == null ) {
            return null;
        }
        return code;
    }

    private String depositeAccountDescription(Deposite deposite) {
        if ( deposite == null ) {
            return null;
        }
        Account account = deposite.getAccount();
        if ( account == null ) {
            return null;
        }
        String description = account.getDescription();
        if ( description == null ) {
            return null;
        }
        return description;
    }

    protected Account depositeDTOToAccount(DepositeDTO depositeDTO) {
        if ( depositeDTO == null ) {
            return null;
        }

        Account account = new Account();

        account.setId( depositeDTO.getAccountId() );

        return account;
    }
}
