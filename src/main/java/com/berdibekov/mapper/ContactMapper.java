package com.berdibekov.mapper;

import com.berdibekov.domain.Contact;
import com.berdibekov.dto.ContactDto;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.stereotype.Component;

import java.util.Objects;

@Component
public class ContactMapper {

    private final ModelMapper modelMapper;

    public ContactMapper(ModelMapper mapper) {
        this.modelMapper = mapper;
        this.modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
    }

    public Contact toEntity(ContactDto contactDto) {
    return modelMapper.map(contactDto, Contact.class);
    }

    public ContactDto toDto(Contact entity) {
        if (Objects.isNull(entity)) {
            return null;
        }
        return modelMapper.map(entity, ContactDto.class);
    }
}