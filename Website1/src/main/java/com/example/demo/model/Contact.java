package com.example.demo.model;

import lombok.Data;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.validator.constraints.CreditCardNumber;
import org.springframework.boot.autoconfigure.domain.EntityScan;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

@Entity
@Data
@Table(name="contact_msg")
public class Contact extends extra{

 @Id
 @GeneratedValue(strategy = GenerationType.AUTO,generator = "native")
 @GenericGenerator(name="native",strategy = "native")
   private int contact_id;
    @NotBlank(message="Name should not be blank")
    @Size(min=2,message="Name must ne atleast 3 characters long")
    private String name;

    @Column(name="mobilenum")
    private String mobileNum;
    private String email;
    private String subject;
    private String message;
    private String status;


}
