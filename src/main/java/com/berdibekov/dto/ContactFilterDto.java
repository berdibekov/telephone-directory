package com.berdibekov.dto;

import lombok.Data;

import java.time.LocalDate;

/**
 * This data class represents contacts field patterns to be filtered.
 * example : firstNamePattern = A%  - Andrey , Anton ..
 * you can fill field pattern as you do it in SQL Like
 */
@Data
public class ContactFilterDto {
    private String firstNamePattern;
    private String lastNamePattern;
    private String patronymicPattern;
    private LocalDate birthDateBefore;
    private LocalDate birthDateAfter;
}
