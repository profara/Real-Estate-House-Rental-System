/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package so.potvrda;

import domen.Izdavanje;
import domen.Klijent;
import domen.PotvrdaOIzdavanju;
import domen.pomocni.OpstiDomenskiObjekat;
import java.util.ArrayList;
import so.AbstractSO;

/**
 *
 * @author Alek
 */
public class FindPotvrdeSO extends AbstractSO {

    private ArrayList<OpstiDomenskiObjekat> potvrde;

    @Override
    protected void precondition(Object param) throws Exception {
        if (param == null || !(param instanceof Klijent)) {
            throw new Exception("Los parametar!");
        }

    }

    @Override
    protected void executeOperation(Object param) throws Exception {
        PotvrdaOIzdavanju p = new PotvrdaOIzdavanju();
        p.setKlijent((Klijent) param);
        ArrayList<OpstiDomenskiObjekat> listaPotvrde = (ArrayList<OpstiDomenskiObjekat>) dbBroker.pronadji((OpstiDomenskiObjekat) p);

        PotvrdaOIzdavanju potvrda = new PotvrdaOIzdavanju();
        Izdavanje izdavanje = new Izdavanje();
        potvrde = new ArrayList<>();

        ArrayList<OpstiDomenskiObjekat> listaIzdavanja = (ArrayList<OpstiDomenskiObjekat>) dbBroker.vratiSve(izdavanje);

        for (OpstiDomenskiObjekat opstiDomenskiObjekat : listaPotvrde) {
            potvrda = (PotvrdaOIzdavanju) opstiDomenskiObjekat;
            ArrayList<Izdavanje> izdavanja = new ArrayList<>();

            for (OpstiDomenskiObjekat odo : listaIzdavanja) {
                izdavanje = (Izdavanje) odo;
                if (potvrda.getPotvrdaID() == izdavanje.getPotvrda().getPotvrdaID()) {
                    izdavanja.add(izdavanje);
                }
            }
            potvrda.setIzdavanja(izdavanja);
            potvrde.add(potvrda);
        }
    }

    public ArrayList<OpstiDomenskiObjekat> getPotvrde() {
        return potvrde;
    }
    
    

}
