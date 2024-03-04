/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package io.progame.Book;


import java.io.Serializable;

import javax.persistence.Entity;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import javax.persistence.SequenceGenerator;

/**
 *
 * @author Cliente
 */
@Entity
public class Publisher implements Serializable{
    
    
    @Id
    @SequenceGenerator(name = "seq_publisher",sequenceName = "seq_publisher", initialValue = 1)
    @GeneratedValue(generator = "seq_publisher", strategy = GenerationType.SEQUENCE)
    private Long id;
    private String namePublisher;
    private String emailPublisher;
    private String phoneNumberPublisher;
    private String cnpj;
    private String ceo;
    
    public Publisher(){}

    public Publisher(Long id, String namePublisher, String emailPublisher, String phoneNumberPublisher, String cnpj, String ceo) {
        this.id = id;
        this.namePublisher = namePublisher;
        this.emailPublisher = emailPublisher;
        this.phoneNumberPublisher = phoneNumberPublisher;
        this.cnpj = cnpj;
        this.ceo = ceo;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNamePublisher() {
        return namePublisher;
    }

    public void setNamePublisher(String namePublisher) {
        this.namePublisher = namePublisher;
    }

    public String getEmailPublisher() {
        return emailPublisher;
    }

    public void setEmailPublisher(String emailPublisher) {
        this.emailPublisher = emailPublisher;
    }

    public String getPhoneNumberPublisher() {
        return phoneNumberPublisher;
    }

    public void setPhoneNumberPublisher(String phoneNumberPublisher) {
        this.phoneNumberPublisher = phoneNumberPublisher;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getCeo() {
        return ceo;
    }

    public void setCeo(String ceo) {
        this.ceo = ceo;
    }

    
    
    
}
