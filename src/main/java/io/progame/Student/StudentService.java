/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package io.progame.Student;

import io.progame.Generic.GenericService;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.Query;

/**
 *
 * @author Cliente
 */
@Stateless
public class StudentService extends GenericService<Student> {

    public StudentService() {
        super(Student.class);
    }


    public List<Student> findByAll(Student student) {
        String sql = "select e from Student e where ";
        if(student.getNameStudent() != null && !student.getNameStudent().equals("")){
            sql +="lower(e.nameStudent) like lower(:nameStudent) and ";
        }
        if (student.getCpf() != null && !student.getCpf().equals("")) {
           sql += "e.cpf like :cpf and ";
        }
        if(student.getPhoneNumberStudent() != null && !student.getPhoneNumberStudent().equals("")){
            sql += "e.phoneNumberStudent like :phoneNumberStudent and ";
        }
        if(student.getEmailStudent() != null && !student.getEmailStudent().equals("")){
            sql += "lower(e.emailStudent) like lower(:emailStudent) and ";
        }
        
        sql+= "e.active = true";
        
        Query query = getEntityManager().createQuery(sql, Student.class);
        
        if(student.getNameStudent() != null && !student.getNameStudent().equals("")){
            query.setParameter("nameStudent", "%"+student.getNameStudent()+"%");
        }
        if (student.getCpf() != null && !student.getCpf().equals("")) {
            query.setParameter("cpf", "%"+student.getCpf()+"%");
        }
        
        if(student.getPhoneNumberStudent() != null && !student.getPhoneNumberStudent().equals("")){
            query.setParameter("phoneNumberStudent", "%"+student.getPhoneNumberStudent()+"%");
        }
        
        if(student.getEmailStudent() != null && !student.getEmailStudent().equals("") ){
            query.setParameter("emailStudent", "%"+student.getEmailStudent()+"%");
        }
        return query.getResultList();
    }
    
   /* public List<Student> All(Student student){
        String sl = "select u from Student u join u.data c where u.active = true and lower(c.name) like lower(:name)";
        Query query = getEntityManager().createQuery(sl, Student.class);
        query.setParameter("name", "%"+student.getNameStudent()+"%");

        return query.getResultList();
    }*/
    public List<Student> findStudentName(String name) {
        String sql = "select e from Student e where e.active = true";

        if (name != null) {
            sql += " and lower(e.nameStudent) like lower(:name)";
        }
        

        sql += " ORDER BY e.nameStudent ASC";

        Query query = getEntityManager().createQuery(sql);

        if (name != null) {
            query.setParameter("name", "%" + name.trim() + "%");
        }
        

        return query.getResultList();
    }
}

    
    
    
    
    
