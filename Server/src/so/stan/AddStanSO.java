/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package so.stan;

import domen.Stan;
import domen.pomocni.OpstiDomenskiObjekat;
import java.util.ArrayList;
import so.AbstractSO;

/**
 *
 * @author Alek
 */
public class AddStanSO extends AbstractSO{
    
    

    @Override
    protected void precondition(Object param) throws Exception {
        if(param == null || !(param instanceof Stan)){
            throw new Exception("Los parametar!");
        }
        ArrayList<OpstiDomenskiObjekat> lista = (ArrayList<OpstiDomenskiObjekat>) dbBroker.vratiSve((OpstiDomenskiObjekat)param);
        
        if(lista.contains((OpstiDomenskiObjekat)param)){
            throw new Exception("Objekat vec postoji!");
        }
        
    }

    @Override
    protected void executeOperation(Object param) throws Exception{
        dbBroker.ubaci((OpstiDomenskiObjekat)param);
    }

    
    
    
    
    
    
    
}
