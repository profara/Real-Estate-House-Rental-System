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
public class GetStanoviSO extends AbstractSO{
    
    private ArrayList<OpstiDomenskiObjekat> stanovi;

    @Override
    protected void precondition(Object param) throws Exception {
        if(param == null || !(param instanceof Stan)){
            throw new Exception("Los parametar!");
        }
    }

    @Override
    protected void executeOperation(Object param) throws Exception {
        stanovi = (ArrayList<OpstiDomenskiObjekat>) dbBroker.vratiSve((OpstiDomenskiObjekat)param);
    }

    public ArrayList<OpstiDomenskiObjekat> getStanovi() {
        return stanovi;
    }
    
    
    
}
