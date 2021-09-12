package com.berdibekov.dto;

import com.berdibekov.domain.Address;
import com.berdibekov.domain.Email;
import com.berdibekov.domain.PhoneNumber;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@Data
public class ContactDto {
    @ApiModelProperty(example = "Andrey")
    private String firstName;
    @ApiModelProperty(example = "Smirnov")
    private String lastName;
    @ApiModelProperty(example = "Alekseevich")
    private String patronymic;
    private List<Address> addresses;
    private List<PhoneNumber> phoneNumbers;
    private List<Email> emails;
    private LocalDate birthDate;
}
