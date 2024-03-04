/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package io.progame.Loan;

import io.progame.Book.Book;
import io.progame.Generic.GenericService;
import io.progame.Loan.Loan;
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
public class LoanService extends GenericService<Loan> {
    
    public LoanService(){
    super(Loan.class);
    }
    
    public List<Loan> findByName(String name){
        return getEntityManager().createQuery(name + "SELECT u FROM Loan u WHERE u.user").getResultList();
    }
    
     public List<Loan> findByAll(Loan loan) {
        String sql = "select l from Loan l join l.student s join l.book b where l.active = true ";
        if (loan.getStudent().getNameStudent() != null && !loan.getStudent().getNameStudent().equals("")) {
            sql += "and lower(s.nameStudent) like lower (:nameStudent)";
        }
        if (loan.getBook().getTitle() != null && !loan.getBook().getTitle().equals("")){
            sql += "and lower(b.title) like lower(:title)";
        }
        
        
        Query query = getEntityManager().createQuery(sql, Loan.class);

        if (loan.getStudent().getNameStudent() != null && !loan.getStudent().getNameStudent().equals("")) {
            query.setParameter("nameStudent", "%"+loan.getStudent().getNameStudent()+"%");
        }
        if (loan.getBook().getTitle() != null && !loan.getBook().getTitle().equals("")){
            query.setParameter("title", "%"+loan.getBook().getTitle()+"%");
        }
        return query.getResultList();
    }
     
     public void returnBook(Loan loan){
         
         Loan loanExisting = find(loan.getId());
         
         if(loanExisting != null){
             System.out.println(loanExisting.getActive()+ "2");
            loanExisting.setActive(Boolean.FALSE);
            update(loanExisting);
         }
     }
     
    
        

        
}
