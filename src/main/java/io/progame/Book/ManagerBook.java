
package io.progame.Book;



import io.progame.utility.Message;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Named;




/**
 *
 * @author Cliente
 */

@Named
@ViewScoped
public class ManagerBook implements Serializable{
    
   @EJB
   BookService bookService;
   
   private Book book;
   private List<Book> books;
   
   @PostConstruct
   public void instantiate(){
       Map<String, String> parms = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
        String visualizar = parms.get("visualizar");
        String editar = parms.get("editar");
        
        if(visualizar != null){
            book = bookService.find(Long.valueOf(visualizar));
        }
        else if(editar != null){
            book = bookService.find(Long.valueOf(editar));
        }
        else{
            books = new ArrayList<>();
            book = new Book();
            book.setAuthor(new Author());
            
            book.setPublisher(new Publisher()); 
        }
        
   }
   
    
   
    public void saveBook(){
        if(book.getId() == null){
            Message.msg("Livro cadastrado com sucesso!");
            bookService.save(book);
            bookService.quantityDisponibleNewBook(book);
            instantiate();
    } else{
            bookService.updateQuantityDisponibleBook(book);
            bookService.update(book);
            
            instantiate();
        }
    }
    
    
    public void search(){
        
        books = bookService.findByAll(book);
    }
    
    public void remove(){
        bookService.removeBook(book);
    }
    
    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }
    

    
}
