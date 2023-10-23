/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package so.potvrda;

import domen.Izdavanje;
import domen.PotvrdaOIzdavanju;
import domen.pomocni.OpstiDomenskiObjekat;
import so.AbstractSO;

/**
 *
 * @author Alek
 */
public class EditPotvrdaSO extends AbstractSO{

    @Override
    protected void precondition(Object param) throws Exception {
        if(param == null || !(param instanceof PotvrdaOIzdavanju)){
            throw new Exception("Los parametar!");
        }
    }

    @Override
    protected void executeOperation(Object param) throws Exception {
        dbBroker.izmeni((OpstiDomenskiObjekat) param);
        
        Izdavanje izdavanje = new Izdavanje();
        PotvrdaOIzdavanju p = (PotvrdaOIzdavanju) param;
        izdavanje.setPotvrda(p);
        dbBroker.obrisi(izdavanje);
        for(Izdavanje i : p.getIzdavanja()){
            dbBroker.ubaci(i);
        }
    }
    
}
