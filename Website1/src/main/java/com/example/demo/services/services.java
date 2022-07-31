package com.example.demo.services;

import com.example.demo.constants.EazySchoolConstants;
import com.example.demo.controller.ContactController;
import com.example.demo.model.Contact;
import com.example.demo.repository.contactRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.context.annotation.ApplicationScope;
import org.springframework.web.context.annotation.RequestScope;
import org.springframework.web.context.annotation.SessionScope;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@ApplicationScope
public class services {

    public int getCounter() {
        return counter;
    }

    @Autowired
private contactRepository contactRepository1;


    int counter=0;

    public void setCounter(int counter) {
        this.counter = counter;
    }

    public services(){
        System.out.println("Contact Service bean initialized");
    }


    private static Logger log= LoggerFactory.getLogger(ContactController.class);
    public boolean display(Contact contact) {
        boolean isSaved;
        contact.setStatus(EazySchoolConstants.OPEN);
        contact.setCreated_by(EazySchoolConstants.ANONYMOUS);
        contact.setCreated_at(LocalDateTime.now());
        Contact status = contactRepository1.save(contact);
        if (contact.getContact_id() > 0) {
            isSaved = true;
        } else {
            isSaved = false;
        }
        return isSaved;
    }

    public List<Contact> findOpenMsg() {
        List<Contact> msg=contactRepository1.findByStatus(EazySchoolConstants.OPEN);
        return msg;
    }

    public boolean closeMsg(int id, String name) {
        boolean b=false;
        Optional<Contact> var=contactRepository1.findById(id);
        var.ifPresent(contact1 -> {
            contact1.setStatus(EazySchoolConstants.CLOSE);

            contact1.setUpdated_by(contact1.getUpdated_by());
            contact1.setUpdated_at(LocalDateTime.now());
        });
      Contact updatedContact=  contactRepository1.save(var.get());
        if(updatedContact !=null && updatedContact.getUpdated_by()!=null){
            b=true;
        }
        return b;
    }
    }


