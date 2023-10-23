/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package so.lokacije;

import domen.Lokacija;
import domen.pomocni.OpstiDomenskiObjekat;
import java.util.ArrayList;
import java.util.List;
import so.AbstractSO;

/**
 *
 * @author Alek
 */
public class GetLokacijeSO extends AbstractSO{
    private ArrayList<OpstiDomenskiObjekat> lokacije;

    @Override
    protected void precondition(Object param) throws Exception {
        if(param == null || !(param instanceof Lokacija)){
            throw new Exception("Los parametar!");
        }
    }

    @Override
    protected void executeOperation(Object param) throws Exception {
        lokacije = (ArrayList<OpstiDomenskiObjekat>) dbBroker.vratiSveBezUslova((OpstiDomenskiObjekat) param);
    }

    public ArrayList<OpstiDomenskiObjekat> getLokacije() {
        return lokacije;
    }
    
    
    
}
