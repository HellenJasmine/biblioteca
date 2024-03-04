/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package io.progame.utility;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

/**
 *
 * @author Cliente
 */
public class Message {
    public static void msg(String message){
           FacesContext.getCurrentInstance().addMessage("oi", new FacesMessage(message));
    }
    
    }

