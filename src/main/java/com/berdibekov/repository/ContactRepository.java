package com.berdibekov.repository;

import com.berdibekov.domain.Contact;
import com.berdibekov.dto.ContactFilterDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.time.LocalDate;
import java.util.Collection;
import java.util.List;

public interface ContactRepository extends PagingAndSortingRepository<Contact, Long> {
    Page<Contact> findAllByFirstNameLikeAndLastNameLikeAndPatronymicLikeAndBirthDateIsBetween(String firstName,
                                                                                              String lastName,
                                                                                              String patronymic,
                                                                                              LocalDate from,
                                                                                              LocalDate to,
                                                                                              Pageable p);
}
