package com.berdibekov.repository;

import com.berdibekov.domain.Contact;
import com.berdibekov.dto.ContactFilterDto;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Collection;
import java.util.List;

public interface ContactRepository extends JpaRepository<Contact,Long> {
    List<Contact> findAllByFirstNameLike(String firstNamePattern);
    List<Contact> findAllByFirstNameLikeAndLastNameLikeAndPatronymicLike(String firstName,String lastName,String patronymic);
}
