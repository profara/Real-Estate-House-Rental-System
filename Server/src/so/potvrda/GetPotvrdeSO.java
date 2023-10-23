/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package so.potvrda;

import domen.Izdavanje;
import domen.PotvrdaOIzdavanju;
import domen.pomocni.OpstiDomenskiObjekat;
import java.util.ArrayList;
import java.util.List;
import so.AbstractSO;

/**
 *
 * @author Alek
 */
public class GetPotvrdeSO extends AbstractSO{
    private ArrayList<OpstiDomenskiObjekat> potvrde = new ArrayList<>();

    @Override
    protected void precondition(Object param) throws Exception {
        if(param == null || !(param instanceof PotvrdaOIzdavanju)){
            throw new Exception("Los parametar!");
        }
    }

    @Override
    protected void executeOperation(Object param) throws Exception {
        ArrayList<OpstiDomenskiObjekat> listaPotvrde = (ArrayList<OpstiDomenskiObjekat>) dbBroker.vratiSve((OpstiDomenskiObjekat) param);
        
        PotvrdaOIzdavanju potvrda = new PotvrdaOIzdavanju();
        Izdavanje izdavanje = new Izdavanje();
        
        ArrayList<OpstiDomenskiObjekat> listaIzdavanja = (ArrayList<OpstiDomenskiObjekat>) dbBroker.vratiSve(izdavanje);
        
        for (OpstiDomenskiObjekat opstiDomenskiObjekat : listaPotvrde) {
            potvrda = (PotvrdaOIzdavanju) opstiDomenskiObjekat;
            ArrayList<Izdavanje> izdavanja = new ArrayList<>();
            
            for(OpstiDomenskiObjekat odo : listaIzdavanja){
                izdavanje = (Izdavanje) odo;
                if(potvrda.getPotvrdaID() == izdavanje.getPotvrda().getPotvrdaID()){
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
