/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package so.klijent;

import domen.Klijent;
import domen.pomocni.OpstiDomenskiObjekat;
import java.util.ArrayList;
import so.AbstractSO;

/**
 *
 * @author Alek
 */
public class FindKlijentSO extends AbstractSO{
    
    OpstiDomenskiObjekat klijent;

    @Override
    protected void precondition(Object param) throws Exception {
        if(param == null || !(param instanceof Klijent)){
            throw new Exception("Los parametar!");
        }
        
        ArrayList<OpstiDomenskiObjekat> lista = (ArrayList<OpstiDomenskiObjekat>) dbBroker.vratiSve((OpstiDomenskiObjekat) param);
        
        if(!lista.contains((OpstiDomenskiObjekat)param)){
            throw new Exception("Trazeni objekat ne postoji!");
        }
    }

    @Override
    protected void executeOperation(Object param) throws Exception {
        klijent = dbBroker.pronadjiJedinstven((OpstiDomenskiObjekat) param);
    }

    public OpstiDomenskiObjekat getKlijent() {
        return klijent;
    }
    
    
    
}
