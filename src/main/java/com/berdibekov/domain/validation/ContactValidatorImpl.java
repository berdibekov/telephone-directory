package com.berdibekov.domain.validation;

import com.berdibekov.domain.Contact;
import org.springframework.stereotype.Service;

@Service
public class ContactValidatorImpl implements ContactValidator{
    @Override
    public void validate(Contact contact) {
        //There will be validation of Contact
    }
}
