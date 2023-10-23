/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package komunikacija;

import java.io.Serializable;

/**
 *
 * @author Alek
 */
public class Request implements Serializable{
    private int operation;
    private Object argument;

    public Request(int operation) {
        this.operation = operation;
    }
    
    

    public Request(int operation, Object argument) {
        this.operation = operation;
        this.argument = argument;
    }

    public Object getArgument() {
        return argument;
    }

    public int getOperation() {
        return operation;
    }
    
    
    
    
}
