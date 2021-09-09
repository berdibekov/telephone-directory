package com.berdibekov.service;

import com.berdibekov.domain.Contact;
import com.berdibekov.dto.ContactDto;
import com.berdibekov.dto.ContactFilterDto;
import com.berdibekov.mapper.ContactMapper;
import com.berdibekov.repository.ContactRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class PhoneDictService {
    private final ContactRepository contactRepository;
    private final ContactMapper contactMapper;

    public PhoneDictService(ContactRepository contactRepository, ModelMapper modelMapper, ContactMapper contactMapper) {
        this.contactRepository = contactRepository;
        this.contactMapper = contactMapper;
    }

    @Transactional
    public Contact createContact(ContactDto contactDto) {
        Contact contact = contactMapper.toEntity(contactDto);
        contact = contactRepository.save(contact);
        return contact;
    }

    public void updateContact(Long contactId, ContactDto contactDto) {
        Optional<Contact> contactOptional = contactRepository.findById(contactId);
    }

    public List<Contact> getContacts(ContactFilterDto contactFilterDto) {
        return contactRepository.findAllByFirstNameLike(contactFilterDto.getFirstNamePattern());


    }
}
