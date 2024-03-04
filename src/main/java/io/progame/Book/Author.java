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
public class Author implements Serializable{
    @Id
    @SequenceGenerator(name = "seq_author", sequenceName = "seq_author", initialValue = 1)
    @GeneratedValue(generator = "seq_author", strategy = GenerationType.SEQUENCE)
    private Long id;
    private String name;
    

    public Author() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    

    @Override
    public String toString() {
        return "Author{" + "id=" + id + ", name=" + name + '}';
    }
    
    
}
