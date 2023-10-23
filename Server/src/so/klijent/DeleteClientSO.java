/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package so.klijent;

import domen.Klijent;
import domen.pomocni.OpstiDomenskiObjekat;
import so.AbstractSO;

/**
 *
 * @author Alek
 */
public class DeleteClientSO extends AbstractSO{

    @Override
    protected void precondition(Object param) throws Exception {
        if(param == null || !(param instanceof Klijent)){
            throw new Exception("Los parametar!");
        }
    }

    @Override
    protected void executeOperation(Object param) throws Exception {
        dbBroker.obrisi((OpstiDomenskiObjekat) param);
    }
    
}
