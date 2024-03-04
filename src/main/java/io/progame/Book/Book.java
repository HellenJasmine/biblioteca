/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package io.progame.Book;


import io.progame.Generic.GenericEntity;
import java.util.Date;
import java.util.Objects;
import javax.persistence.*;

/**
 *
 * @author Cliente
 */
@Entity
public class Book extends GenericEntity {
    
    @Id
    @SequenceGenerator(name = "seq_book", sequenceName = "seq_book", initialValue = 1)
    @GeneratedValue(generator = "seq_book", strategy = GenerationType.SEQUENCE)
    private Long id;
    
    private String title;
    
    @Column(unique = true)
    private String isbn;
    
    @OneToOne(cascade = CascadeType.ALL)
    private Publisher publisher;
    
    @OneToOne(cascade = CascadeType.ALL)
    private Author author;
    
    @Temporal(TemporalType.DATE)
    private Date publicationDateBook;
    private int quantity;
    private int quantityDisponible;
    private int numberPages;
    private String genderBook;
    

    public Book() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public Publisher getPublisher() {
        return publisher;
    }

    public void setPublisher(Publisher publisher) {
        this.publisher = publisher;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    public Date getPublicationDateBook() {
        return publicationDateBook;
    }

    public void setPublicationDateBook(Date publicationDateBook) {
        this.publicationDateBook = publicationDateBook;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getQuantityDisponible() {
        return quantityDisponible;
    }

    public void setQuantityDisponible(int quantityDisponible) {
        this.quantityDisponible = quantityDisponible;
    }

    public int getNumberPages() {
        return numberPages;
    }

    public void setNumberPages(int numberPages) {
        this.numberPages = numberPages;
    }

    public String getGenderBook() {
        return genderBook;
    }

    public void setGenderBook(String genderBook) {
        this.genderBook = genderBook;
    }

    @Override
    public String toString() {
        return "Book{" + "id=" + id + ", title=" + title + ", isbn=" + isbn + ", publisher=" + publisher + ", author=" + author + ", publicationDateBook=" + publicationDateBook + ", quantity=" + quantity + ", quantityDisponible=" + quantityDisponible + ", numberPages=" + numberPages + ", genderBook=" + genderBook + '}';
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + Objects.hashCode(this.id);
        hash = 97 * hash + Objects.hashCode(this.title);
        hash = 97 * hash + Objects.hashCode(this.isbn);
        hash = 97 * hash + Objects.hashCode(this.publisher);
        hash = 97 * hash + Objects.hashCode(this.author);
        hash = 97 * hash + Objects.hashCode(this.publicationDateBook);
        hash = 97 * hash + this.quantity;
        hash = 97 * hash + this.quantityDisponible;
        hash = 97 * hash + this.numberPages;
        hash = 97 * hash + Objects.hashCode(this.genderBook);
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
        final Book other = (Book) obj;
        if (this.quantity != other.quantity) {
            return false;
        }
        if (this.quantityDisponible != other.quantityDisponible) {
            return false;
        }
        if (this.numberPages != other.numberPages) {
            return false;
        }
        if (!Objects.equals(this.title, other.title)) {
            return false;
        }
        if (!Objects.equals(this.isbn, other.isbn)) {
            return false;
        }
        if (!Objects.equals(this.genderBook, other.genderBook)) {
            return false;
        }
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        if (!Objects.equals(this.publisher, other.publisher)) {
            return false;
        }
        if (!Objects.equals(this.author, other.author)) {
            return false;
        }
        return Objects.equals(this.publicationDateBook, other.publicationDateBook);
    }

}