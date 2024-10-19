package com.example.IgniteSelfBudgetControlMultiUser.ABC.Mappers;

import com.example.IgniteSelfBudgetControlMultiUser.DTO.PurposeDTO;
import com.example.IgniteSelfBudgetControlMultiUser.Entities.Purpose;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-09-07T21:20:23+0100",
    comments = "version: 1.5.2.Final, compiler: javac, environment: Java 17.0.10 (Amazon.com Inc.)"
)
@Component
public class PurposeMapperImpl implements PurposeMapper {

    @Override
    public PurposeDTO toPurposeDTO(Purpose purpose) {
        if ( purpose == null ) {
            return null;
        }

        PurposeDTO purposeDTO = new PurposeDTO();

        purposeDTO.setId( purpose.getId() );
        purposeDTO.setCode( purpose.getCode() );
        purposeDTO.setDescription( purpose.getDescription() );
        purposeDTO.setDefaultPrice( purpose.getDefaultPrice() );

        return purposeDTO;
    }

    @Override
    public Purpose fromPurposeDTO(PurposeDTO purposeDTO) {
        if ( purposeDTO == null ) {
            return null;
        }

        Purpose purpose = new Purpose();

        purpose.setId( purposeDTO.getId() );
        purpose.setCode( purposeDTO.getCode() );
        purpose.setDescription( purposeDTO.getDescription() );
        purpose.setDefaultPrice( purposeDTO.getDefaultPrice() );

        return purpose;
    }
}
