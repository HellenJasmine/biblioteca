/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package io.progame.Student;

import io.progame.utility.Message;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;

import javax.faces.model.SelectItem;
import javax.faces.view.ViewScoped;
import javax.inject.Named;


import javax.faces.context.FacesContext;



/**
 *
 * @author Cliente
 */

@Named
@ViewScoped
public class ManagerStudent implements Serializable {
    
    @EJB
    StudentService studentService;
    
    
    private Student student;
    
    
    private List<Student> students;
    
    @PostConstruct
    public void instantiate(){
        Map<String, String> parms = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
        String visualizar = parms.get("visualizar");
        String editar = parms.get("editar");
        
        if(visualizar != null){
            student = studentService.find(Long.valueOf(visualizar));
        }
        else if(editar != null){
            student = studentService.find(Long.valueOf(editar));
        }
        else{
            student = new Student();
            student.setAddress(new Address());
           
        }
    }
    
    public void save(){
        if(student.getId() == null){
            studentService.save(student);
            instantiate();
            Message.msg("Estudante cadastrado com Sucesso!!!");
            
        }
        else{
            studentService.update(student);
            instantiate();
        }
    }
   
    
    public void search(){
       
        students = studentService.findByAll(student);
    }
    public void findAll(){
  
        students = studentService.findAll();
    }
    
    public void remove(){
        
   
    }
    
    public List<SelectItem> getGenero() {
        List<SelectItem> items = new ArrayList<>();
        for (GenderPeople item : GenderPeople.values()) {
            items.add(new SelectItem(item));
        }
        return items;
    }

    public StudentService getStudentService() {
        return studentService;
    }

    public void setStudentService(StudentService studentService) {
        this.studentService = studentService;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }


    
    
    
}
