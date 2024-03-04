/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package io.progame.Loan;

import io.progame.Book.Book;

import io.progame.Student.Student;
import io.progame.Book.BookService;
import io.progame.Student.Address;
import io.progame.Student.StudentService;

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
public class ManagerLoan implements Serializable{
    
    private Loan loan;
    private List<Loan> loans;
    private List<Loan> loansHistory;
    
    @EJB
    LoanService loanService;
    
    @EJB
    StudentService userService;
    
    @EJB
    BookService bookService;
    
    @PostConstruct
    public void instantiate(){
        Map<String, String> parms = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
        String visualizar = parms.get("visualizar");
        String editar = parms.get("editar");
        if(visualizar != null){
            loan = loanService.find(Long.valueOf(visualizar));
        }
        else if(editar != null){
            loan = loanService.find(Long.valueOf(editar));
        }
        else{
            loan = new Loan();
            loan.setStudent(new Student());
            loan.setBook(new Book());
            loans = new ArrayList<>();

           
        }
        
    }
    public void save(){
        if(loan.getId() == null){
            loanService.save(loan);
            removeQuantity(loan.getBook());
            instantiate();
            Message.msg("Empréstimo cadrastrado com sucesso!");}
        else{
            loanService.update(loan);
            instantiate();
        }
    }
    
    public void search(){
        
        loans = loanService.findByAll(loan);
    }
    public void seeHistory(){
   
        loansHistory = loanService.findAll();
    }
    
    public void removeQuantity(Book book){
        bookService.subtract(book);
    }
    public void returnBook(Loan loan){ 
        
       
        bookService.returnBookQuantity(loan.getBook());
        loanService.returnBook(loan);
        loans.remove(loan);
    }
    
    
    
   public List<Student> autocompleteName(String nome) {
        return userService.findStudentName(nome);
    }
    
    public List<Book> autocompleteBook(String title) {
        return bookService.findBookTitle(title);
    }
    
    
    
    
    
    
    
    
    public LoanService getLoanService() {
        return loanService;
    }

    public void setLoanService(LoanService loanService) {
        this.loanService = loanService;
    }

    public Loan getLoan() {
        return loan;
    }

    public void setLoan(Loan loan) {
        this.loan = loan;
    }

    public List<Loan> getLoans() {
        return loans;
    }

    public void setLoans(List<Loan> loans) {
        this.loans = loans;
    }

    public List<Loan> getLoansHistory() {
        return loansHistory;
    }

    public void setLoansHistory(List<Loan> loansHistory) {
        this.loansHistory = loansHistory;
    }
    
    
}
