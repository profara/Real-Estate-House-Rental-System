/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package so.potvrda;

import domen.Izdavanje;
import domen.PotvrdaOIzdavanju;
import domen.pomocni.OpstiDomenskiObjekat;
import java.util.ArrayList;
import so.AbstractSO;

/**
 *
 * @author Alek
 */
public class AddPotvrdaSO extends AbstractSO {

    @Override
    protected void precondition(Object param) throws Exception {
        if (param == null || !(param instanceof PotvrdaOIzdavanju)) {
            throw new Exception("Los parametar!");
        }

        ArrayList<OpstiDomenskiObjekat> lista = (ArrayList<OpstiDomenskiObjekat>) dbBroker.vratiSve((OpstiDomenskiObjekat) param);

        if (lista.contains((OpstiDomenskiObjekat) param)) {
            throw new Exception("Objekat vec postoji u sistemu!");
        }
    }

    @Override
    protected void executeOperation(Object param) throws Exception {
        PotvrdaOIzdavanju potvrda = (PotvrdaOIzdavanju) param;
        dbBroker.ubaci((OpstiDomenskiObjekat) param);
        for(Izdavanje izdavanje : potvrda.getIzdavanja()){
            izdavanje.setPotvrda(potvrda);
            dbBroker.ubaci(izdavanje);
        }
    }

}
