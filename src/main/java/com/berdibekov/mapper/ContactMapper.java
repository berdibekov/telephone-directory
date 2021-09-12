package com.berdibekov.mapper;

import com.berdibekov.domain.Contact;
import com.berdibekov.dto.ContactDto;
import com.berdibekov.dto.ContactDtoValidator;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.stereotype.Component;

import java.util.Objects;

/**
 * This class maps Contact and its DTO ContactDto.
 */
@Component
public class ContactMapper {

    private final ModelMapper modelMapper;
    private final ContactDtoValidator contactDtoValidator;

    public ContactMapper(ModelMapper mapper, ContactDtoValidator contactDtoValidator) {
        this.modelMapper = mapper;
        this.contactDtoValidator = contactDtoValidator;
        this.modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
    }

    public Contact toEntity(ContactDto contactDto) {
        contactDtoValidator.validate(contactDto);
        return modelMapper.map(contactDto, Contact.class);
    }

    public ContactDto toDto(Contact entity) {
        if (Objects.isNull(entity)) {
            return null;
        }
        return modelMapper.map(entity, ContactDto.class);
    }
}