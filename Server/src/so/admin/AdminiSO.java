/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package so.admin;

import db.DbBrokerImpl;
import domen.Admin;
import domen.pomocni.OpstiDomenskiObjekat;
import java.util.ArrayList;
import so.AbstractSO;

/**
 *
 * @author Alek
 */
public class AdminiSO extends AbstractSO{
    private ArrayList<OpstiDomenskiObjekat> admini;

    @Override
    protected void precondition(Object param) throws Exception {
        if(param == null || !(param instanceof Admin)){
            throw new Exception("Los parametar!");
        }
    }

    @Override
    protected void executeOperation(Object param) throws Exception {
        admini = (ArrayList<OpstiDomenskiObjekat>) dbBroker.vratiSveBezUslova((OpstiDomenskiObjekat) param);
    }

    public ArrayList<OpstiDomenskiObjekat> getAdmini() {
        return admini;
    }

   
    
    
    
}
