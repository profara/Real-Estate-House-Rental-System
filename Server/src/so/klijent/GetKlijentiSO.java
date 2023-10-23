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
public class GetKlijentiSO extends AbstractSO{
    
    private ArrayList<OpstiDomenskiObjekat> klijenti;

    @Override
    protected void precondition(Object param) throws Exception {
        if(param == null || !(param instanceof Klijent)){
            throw new Exception("Los parametar!");
        }
    }

    @Override
    protected void executeOperation(Object param) throws Exception {
        klijenti = (ArrayList<OpstiDomenskiObjekat>) dbBroker.vratiSve((OpstiDomenskiObjekat) param);
        System.out.println(klijenti);
    }

    public ArrayList<OpstiDomenskiObjekat> getKlijenti() {
        return klijenti;
    }
    
    
    
}
