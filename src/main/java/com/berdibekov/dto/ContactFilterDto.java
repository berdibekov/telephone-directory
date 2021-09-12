package com.berdibekov.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.time.LocalDate;

/**
 * This data class represents contacts field patterns to be filtered.
 * example : firstNamePattern = A%  - Andrey , Anton ..
 * you can fill field pattern as you do it in SQL Like
 */
@Data
public class ContactFilterDto {
    @ApiModelProperty(example = "An%")
    private String firstNamePattern;
    @ApiModelProperty(example = "%ov")
    private String lastNamePattern;
    @ApiModelProperty(example = "%vich")
    private String patronymicPattern;
    private LocalDate birthDateBefore;
    private LocalDate birthDateAfter;
}
