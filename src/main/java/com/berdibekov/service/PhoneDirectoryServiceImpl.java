package com.berdibekov.service;

import com.berdibekov.domain.Contact;
import com.berdibekov.dto.ContactDto;
import com.berdibekov.dto.ContactFilterDto;
import com.berdibekov.exception.ResourceNotFoundException;
import com.berdibekov.mapper.ContactMapper;
import com.berdibekov.repository.ContactRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Optional;

@Service
public class PhoneDirectoryServiceImpl implements PhoneDirectoryService {
    private final ContactRepository contactRepository;
    private final ContactMapper contactMapper;

    public PhoneDirectoryServiceImpl(ContactRepository contactRepository, ContactMapper contactMapper) {
        this.contactRepository = contactRepository;
        this.contactMapper = contactMapper;
    }

    @Override
    public Contact createContact(ContactDto contactDto) {
        Contact contact = contactMapper.toEntity(contactDto);
        contact = contactRepository.save(contact);
        return contact;
    }

    @Override
    public void updateContact(Long contactId, ContactDto contactDto) {
        Contact contact = contactMapper.toEntity(contactDto);
        contact.setId(contactId);
        contactRepository.save(contact);
    }

    @Override
    public Page<Contact> getAllContacts(Pageable pageable) {
        return contactRepository.findAll(pageable);
    }

    @Override
    public Page<Contact> getFilteredContacts(ContactFilterDto contactFilterDto, Pageable pageable) {
        if (contactFilterDto == null) {
            contactFilterDto = new ContactFilterDto();
        }
        if (contactFilterDto.getFirstNamePattern() == null) {
            contactFilterDto.setFirstNamePattern("%");
        }
        if (contactFilterDto.getLastNamePattern() == null) {
            contactFilterDto.setLastNamePattern("%");
        }
        if (contactFilterDto.getPatronymicPattern() == null) {
            contactFilterDto.setPatronymicPattern("%");
        }
        if (contactFilterDto.getBirthDateAfter() == null) {
            contactFilterDto.setBirthDateAfter(LocalDate.of(1, 1, 1));
        }
        if (contactFilterDto.getBirthDateBefore() == null) {
            contactFilterDto.setBirthDateBefore(LocalDate.of(9999, 1, 1));
        }
        return contactRepository.findAllByFirstNameLikeAndLastNameLikeAndPatronymicLikeAndBirthDateIsBetween(
                contactFilterDto.getFirstNamePattern(),
                contactFilterDto.getLastNamePattern(),
                contactFilterDto.getPatronymicPattern(),
                contactFilterDto.getBirthDateAfter(),
                contactFilterDto.getBirthDateBefore(),
                pageable);
    }

    @Override
    public Contact getContactById(Long contactId) {
        Optional<Contact> contactOptional = contactRepository.findById(contactId);
        if (contactOptional.isPresent()) {
            return contactOptional.get();
        }
        throw new ResourceNotFoundException("contact with id : " + contactId + " not found.");
    }
}
