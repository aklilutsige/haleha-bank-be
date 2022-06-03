package com.haleha.controller;

import com.haleha.model.Contact;
import com.haleha.repository.ContactRepository;
import org.springframework.security.access.prepost.PostFilter;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Date;
import java.util.Random;

@RestController
public class ContactController {
    public static final String URL = "/contact";

    private final ContactRepository contactRepository;

    public ContactController(ContactRepository contactRepository) {
        this.contactRepository = contactRepository;
    }

    @PostMapping(URL)
    @PostFilter("filterObject.contactName == 'Test'")
    public Contact getContact(@RequestBody Contact  contact){
        contact.setContactId(getServiceRquNumber());
        contact.setCreateDt(new Date(System.currentTimeMillis()));
        return contactRepository.save(contact);
    }
    public String getServiceRquNumber(){
        Random random = new Random();
        int ranNum = random.nextInt(999999999 - 9999) + 9999;
        return "SR" + ranNum;
    }
}
