/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package io.progame.Book;

import io.progame.Generic.GenericService;
import io.progame.Book.Book;
import io.progame.Student.Student;
import io.progame.utility.Message;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.Query;



/**
 *
 * @author Cliente
 */
@Stateless
public class BookService extends GenericService<Book> {

    
    public BookService() {
        super(Book.class);
    }
    
    public List<Book> findByAll(Book book){
        
        String sql = "select b from Book b where ";
        
        if (book.getTitle() != null && !book.getTitle().equals("")) {
            sql += "lower(b.title) like lower(:title) and ";
        }
        
        if(book.getIsbn() != null && !book.getIsbn().equals("")){
            sql += "b.isbn like :isbn and ";
        }
        
                
        
        sql+= "b.active = true";
        
        Query query = getEntityManager().createQuery(sql, Book.class);

        if (book.getTitle() != null && !book.getTitle().equals("")) {
            query.setParameter("title", "%"+book.getTitle()+"%");
        }
        if(book.getIsbn() != null && !book.getIsbn().equals("")){
            query.setParameter("isbn", "%"+book.getIsbn()+"%");
        }
    

        return query.getResultList();
    }
    
    public void subtract(Book book) {
        Book existingBook = find(book.getId());

    if (existingBook != null) {
        int newQuantity = existingBook.getQuantityDisponible() - 1;
        if (newQuantity >= 0) {
            existingBook.setQuantityDisponible(newQuantity);
            update(existingBook);
            Message.msg("Empréstimo realizado com sucesso!!!");
        } else {
            Message.msg("Quantidade insuficiente de livros disponíveis no estoque");
        }
    } else {
        Message.msg("Livro não encontrado");
        
    
     
}
     
    }
    
    public void returnBookQuantity(Book book){

        Book existingBook = find(book.getId());

    if (existingBook != null) {
        int newQuantity = existingBook.getQuantityDisponible() + 1;
        
        if (newQuantity <= existingBook.getQuantity()) {
            existingBook.setQuantityDisponible(newQuantity);
            update(existingBook);
            Message.msg("Livro Devolvido com sucesso!!!");
        } else {
            Message.msg("");
        }
    } else {
        Message.msg("Livro não encontrado");
        
    }
    }
    
     public List<Book> findBookTitle(String title) {
        String sql = "select e from Book e where e.active = true";

        if (title != null) {
            sql += " and lower(e.title) like lower(:title)";
        }
        

        sql += " ORDER BY e.title ASC";

        Query query = getEntityManager().createQuery(sql);

        if (title != null) {
            query.setParameter("title", "%" + title.trim() + "%");
        }
        

        return query.getResultList();
    }
     
     public void quantityDisponibleNewBook(Book book){
         Book existingBook = find(book.getId());
         if(existingBook != null){
            if(!(existingBook.getQuantity() <=0)){
                existingBook.setQuantityDisponible(existingBook.getQuantity());
                update(existingBook);
            }
             
         }
     }
     
     public void updateQuantityDisponibleBook(Book book){
         Book existingBook = find(book.getId());
         
         if(existingBook != null){
             System.out.println(existingBook.getQuantity()+"novo"+ existingBook.getQuantityDisponible());
             if (existingBook.getQuantity() == existingBook.getQuantityDisponible()){
                 book.setQuantityDisponible(book.getQuantity());
                update(book);
                
                
             }
             else if(existingBook.getQuantity() < book.getQuantity()){
                book.setQuantityDisponible((book.getQuantity() - existingBook.getQuantity())+ existingBook.getQuantityDisponible());
                 System.out.println("tudo");
             }
             else if(existingBook.getQuantity() > book.getQuantity()){
                 book.setQuantityDisponible(existingBook.getQuantity() - book.getQuantity() - existingBook.getQuantityDisponible());
                 System.out.println("bem");
             }
             
             
             System.out.println(book.getQuantity()+"novo"+ book.getQuantityDisponible());
             
         }else{
             Message.msg("Livro não encontrado");
         }
     }
     
    public void removeBook(Book book){
        Book existingBook = find(book.getId());
        if(existingBook != null){
            existingBook.setActive(Boolean.FALSE);
            update(existingBook);
        }
    }
}
