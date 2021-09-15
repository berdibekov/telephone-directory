package com.berdibekov.api.controller;

import com.berdibekov.domain.Contact;
import com.berdibekov.dto.ContactDto;
import com.berdibekov.dto.ContactFilterDto;
import com.berdibekov.service.PhoneDirectoryService;
import com.berdibekov.service.PhoneDirectoryServiceImpl;
import io.swagger.annotations.ApiOperation;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;

@Controller
@RequestMapping("/api/")
public class ContactController {

    private final PhoneDirectoryService phoneDirectoryServiceImpl;

    public ContactController(PhoneDirectoryServiceImpl phoneDirectoryServiceImpl) {
        this.phoneDirectoryServiceImpl = phoneDirectoryServiceImpl;
    }

    @PostMapping(value = "/contacts")
    @ApiOperation(value = "Creates a new contact")

    public ResponseEntity<Void> createContact(@Valid @RequestBody ContactDto contactDto) {
        Contact contact = phoneDirectoryServiceImpl.createContact(contactDto);
        HttpHeaders responseHeaders = getHttpHeadersForNewResource(contact.getId());
        return new ResponseEntity<>(null, responseHeaders, HttpStatus.CREATED);
    }

    @PutMapping(value = "/contacts/{contactId}")
    @ApiOperation(value = "Update contact")

    public ResponseEntity<Void> updateContact(@PathVariable Long contactId, @Valid @RequestBody ContactDto contactDto) {
        phoneDirectoryServiceImpl.updateContact(contactId, contactDto);
        Contact contact = phoneDirectoryServiceImpl.createContact(contactDto);
        HttpHeaders responseHeaders = getHttpHeadersForNewResource(contact.getId());
        return new ResponseEntity<>(null, responseHeaders, HttpStatus.CREATED);
    }

    @GetMapping(value = "/contacts/{contactId}")
    @ApiOperation(value = "Get contact with specified id")

    public ResponseEntity<Contact> getContact(@PathVariable Long contactId) {
        Contact contact = phoneDirectoryServiceImpl.getContactById(contactId);
        HttpHeaders responseHeaders = getHttpHeadersForNewResource(contact.getId());
        return new ResponseEntity<>(contact, responseHeaders, HttpStatus.CREATED);
    }

    @PostMapping(value = "/contacts/searches")
    @ApiOperation(value = "Get filtered contacts")

    public ResponseEntity<Page<Contact>> getFilteredContacts(@RequestBody(required = false) ContactFilterDto contactFilterDto,
                                                             Pageable pageable) {
        Page<Contact> contacts = phoneDirectoryServiceImpl.getFilteredContacts(contactFilterDto, pageable);
        return new ResponseEntity<>(contacts, HttpStatus.OK);
    }

    private HttpHeaders getHttpHeadersForNewResource(Long id) {
        HttpHeaders responseHeaders = new HttpHeaders();
        URI newPollUri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(id).toUri();
        responseHeaders.setLocation(newPollUri);
        return responseHeaders;
    }
}
