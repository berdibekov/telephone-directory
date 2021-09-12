package com.berdibekov.dto;

import org.springframework.stereotype.Service;

@Service
public class ContactDtoValidatorImpl implements ContactDtoValidator{
    @Override
    public void validate(ContactDto contactDto) {
        //There will be validator for DTO
    }
}
