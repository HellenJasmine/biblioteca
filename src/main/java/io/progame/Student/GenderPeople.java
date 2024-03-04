/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Enum.java to edit this template
 */
package io.progame.Student;

/**
 *
 * @author Cliente
 */
public enum GenderPeople {
    FEMININO("Feminino"),
    MASCULINO("Masculino");
    
    private final String descricao;
    
    GenderPeople(String descricao){
        this.descricao = descricao;
    }
    public String getDescricao(){
        return descricao;
    }
    
}
