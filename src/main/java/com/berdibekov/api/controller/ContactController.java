package com.berdibekov.api.controller;

import com.berdibekov.dto.ContactFilterDto;
import com.berdibekov.dto.error.ErrorDetail;
import com.berdibekov.domain.Contact;
import com.berdibekov.dto.ContactDto;
import com.berdibekov.service.PhoneDictService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;

@Controller
@RequestMapping("/api/")
public class ContactController {

    private final PhoneDictService phoneDictService;

    public ContactController(PhoneDictService phoneDictService) {
        this.phoneDictService = phoneDictService;
    }

    @RequestMapping(value = "/contacts", method = RequestMethod.POST)
    @ApiOperation(value = "Creates a new contact")
    @ApiResponses(value = {@ApiResponse(code = 201, message = "Passenger Created Successfully"),
            @ApiResponse(code = 500, message = "Error creating Poll", response = ErrorDetail.class)})

    public ResponseEntity<Void> createContact(@Valid @RequestBody ContactDto contactDto) {
        Contact contact = phoneDictService.createContact(contactDto);
        HttpHeaders responseHeaders = getHttpHeadersForNewResource(contact.getId());
        return new ResponseEntity<>(null, responseHeaders, HttpStatus.CREATED);
    }

    @RequestMapping(value = "/contacts/{contactId}", method = RequestMethod.POST)
    @ApiOperation(value = "Update contact")
    @ApiResponses(value = {@ApiResponse(code = 201, message = "Passenger Created Successfully"),
            @ApiResponse(code = 500, message = "Error creating Poll", response = ErrorDetail.class)})

    public ResponseEntity<Void> updateContact(@PathVariable Long contactId, @Valid @RequestBody ContactDto contactDto) {
        phoneDictService.updateContact(contactId, contactDto);
        Contact contact = phoneDictService.createContact(contactDto);
        HttpHeaders responseHeaders = getHttpHeadersForNewResource(contact.getId());
        return new ResponseEntity<>(null, responseHeaders, HttpStatus.CREATED);
    }

    @RequestMapping(value = "/contacts/searches", method = RequestMethod.POST)
    @ApiOperation(value = "Get filtered contacts")
    @ApiResponses(value = {@ApiResponse(code = 201, message = "Passenger Created Successfully"),
            @ApiResponse(code = 500, message = "Error creating Poll", response = ErrorDetail.class)})

    public ResponseEntity<?> getContacts(@RequestBody ContactFilterDto contactFilterDto) {
        List<Contact> contacts = phoneDictService.getContacts(contactFilterDto);
        return new ResponseEntity<>(contacts, HttpStatus.OK);
    }

    private HttpHeaders getHttpHeadersForNewResource(Long id) {
        HttpHeaders responseHeaders = new HttpHeaders();
        URI newPollUri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(id).toUri();
        responseHeaders.setLocation(newPollUri);
        return responseHeaders;
    }
}
