/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package io.progame.Loan;

import io.progame.Book.Book;
import io.progame.Student.Student;
import io.progame.Generic.GenericEntity;
import java.io.Serializable;
import java.util.Date;
import java.util.Objects;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;

/**
 *
 * @author Cliente
 */
@Entity
public class Loan extends GenericEntity {
    @Id
    @SequenceGenerator(name = "seq_loan", sequenceName = "seq_loan", initialValue = 1)
    @GeneratedValue(generator = "seq_loan",  strategy = GenerationType.SEQUENCE)
    private Long id;
    @OneToOne
    private Student student;
    @OneToOne
    private Book book;


    public Loan() {
    }

    public Loan(Long id, Student student, Book book) {
        this.id = id;
        this.student = student;
        this.book = book;
        
    }
    

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 89 * hash + Objects.hashCode(this.id);
        hash = 89 * hash + Objects.hashCode(this.student);
        hash = 89 * hash + Objects.hashCode(this.book);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Loan other = (Loan) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        if (!Objects.equals(this.student, other.student)) {
            return false;
        }
        return Objects.equals(this.book, other.book);
    }

   
    
    
}
