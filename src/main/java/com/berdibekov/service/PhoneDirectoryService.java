package com.berdibekov.service;

import com.berdibekov.domain.Contact;
import com.berdibekov.dto.ContactDto;
import com.berdibekov.dto.ContactFilterDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface PhoneDirectoryService {
    Contact createContact(ContactDto contactDto);

    void updateContact(Long contactId, ContactDto contactDto);

    Page<Contact> getAllContacts(Pageable pageable);

    Page<Contact> getFilteredContacts(ContactFilterDto contactFilterDto, Pageable pageable);

    Contact getContactById(Long contactId);
}
