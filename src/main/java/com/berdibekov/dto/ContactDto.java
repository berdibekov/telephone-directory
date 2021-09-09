package com.berdibekov.dto;

import com.berdibekov.domain.Address;
import com.berdibekov.domain.Email;
import com.berdibekov.domain.PhoneNumber;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
public class ContactDto {

    private String firstName;
    private String lastName;
    private String patronymic;
    private List<Address> addresses;
    private List<PhoneNumber> phoneNumbers;
    private List<Email> emails;
    private Date birthDate;
}
