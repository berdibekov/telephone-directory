package com.berdibekov.dto;

import lombok.Data;

import java.time.LocalDate;

@Data
public class ContactFilterDto {
    private String firstNamePattern;
    private String lastNamePattern;
    private String patronymicPattern;
    private LocalDate birthDateBefore;
    private LocalDate birthDateAfter;
}
