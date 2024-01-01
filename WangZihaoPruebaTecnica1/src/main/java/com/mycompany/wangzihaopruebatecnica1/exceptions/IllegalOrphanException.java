package com.mycompany.wangzihaopruebatecnica1.exceptions;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * Clase autogenerada de Netbeans que hereda de Exception
 * @author Zihao Wang
 */
public class IllegalOrphanException extends Exception {
    private List<String> messages;
    /**
     * 
     * Metodo autogenerado de Netbeans con un @param messages 
     */
    public IllegalOrphanException(List<String> messages) {
        super((messages != null && messages.size() > 0 ? messages.get(0) : null));
        if (messages == null) {
            this.messages = new ArrayList<String>();
        }
        else {
            this.messages = messages;
        }
    }
    public List<String> getMessages() {
        return messages;
    }
}
