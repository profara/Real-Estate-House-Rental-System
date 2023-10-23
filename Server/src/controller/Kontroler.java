/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import domen.Admin;
import domen.Klijent;
import domen.Lokacija;
import domen.PotvrdaOIzdavanju;
import domen.Stan;
import domen.pomocni.KriterijumiStan;
import domen.pomocni.OpstiDomenskiObjekat;
import java.util.ArrayList;
import java.util.List;
import so.AbstractSO;
import so.admin.AdminiSO;
import so.klijent.AddKlijentSO;
import so.klijent.DeleteClientSO;
import so.klijent.EditKlijentSO;
import so.klijent.FindKlijentSO;
import so.klijent.GetKlijentiSO;
import so.lokacije.GetLokacijeSO;
import so.potvrda.AddPotvrdaSO;
import so.potvrda.DeletePotvrdaSO;
import so.potvrda.EditPotvrdaSO;
import so.potvrda.FindPotvrdeSO;
import so.potvrda.GetPotvrdeSO;
import so.stan.AddStanSO;
import so.stan.DeleteStanSO;
import so.stan.EditStanSO;
import so.stan.GetStanoviSO;
import so.stan.SearchStanoviSO;

/**
 *
 * @author Alek
 */
public class Kontroler {

    private static Kontroler instance;

    private Kontroler() {
    }

    public static Kontroler getInstance() {
        if (instance == null) {
            instance = new Kontroler();
        }
        return instance;
    }

    public OpstiDomenskiObjekat login(Admin admin) throws Exception {
        AdminiSO adminiSO = new AdminiSO();
        adminiSO.execute(admin);
        ArrayList<OpstiDomenskiObjekat> admini = adminiSO.getAdmini();

        for (OpstiDomenskiObjekat odo : admini) {
            if (odo.equals(admin)) {
                return odo;
            }
        }

        throw new Exception("Nepostojeci korisnik!");

    }

    public ArrayList<OpstiDomenskiObjekat> getLokacije(Lokacija l) throws Exception {
        GetLokacijeSO getLokacijeSO = new GetLokacijeSO();
        getLokacijeSO.execute(l);
        return getLokacijeSO.getLokacije();
    }

    public void dodajKlijenta(Klijent klijent) throws Exception {
        AbstractSO addKlijentSO = new AddKlijentSO();
        addKlijentSO.execute(klijent);
    }

    public void dodajStan(Stan stan) throws Exception {
        AbstractSO addStanSO = new AddStanSO();
        addStanSO.execute(stan);
    }

    public ArrayList<OpstiDomenskiObjekat> getStanovi(Stan stan) throws Exception {
        GetStanoviSO getStanoviSO = new GetStanoviSO();
        getStanoviSO.execute(stan);

        return getStanoviSO.getStanovi();
    }

    public void obrisiStan(Stan stan) throws Exception {
        AbstractSO deleteStanSO = new DeleteStanSO();
        deleteStanSO.execute(stan);
    }

    public void dodajPotvrdu(PotvrdaOIzdavanju potvrda) throws Exception {
        AbstractSO addPotvrdaSO = new AddPotvrdaSO();
        addPotvrdaSO.execute(potvrda);
    }

    public List<OpstiDomenskiObjekat> pretraziStanove(KriterijumiStan ks) throws Exception {
        SearchStanoviSO searchStanoviSO = new SearchStanoviSO();
        try {

            searchStanoviSO.execute(ks);
        } catch (Exception ex) {
            throw new Exception("Neuspesna pretraga stanova!");
        }
        return searchStanoviSO.getStanovi();

    }

    public void izmeniStan(Stan stan) throws Exception {
        AbstractSO editStanSO = new EditStanSO();
        editStanSO.execute(stan);
    }

    public ArrayList<OpstiDomenskiObjekat> getKlijenti(Klijent k) throws Exception {
        GetKlijentiSO getKlijentiSO = new GetKlijentiSO();
        getKlijentiSO.execute(k);
        return getKlijentiSO.getKlijenti();
    }

    public OpstiDomenskiObjekat getKlijentById(Klijent k) throws Exception {
        FindKlijentSO findKlijentSO = new FindKlijentSO();

        try {
            findKlijentSO.execute(k);
        } catch (Exception ex) {
            throw new Exception("Klijent sa JMBG-om " + k.getJMBG() + " ne postoji u sistemu!");
        }

        return findKlijentSO.getKlijent();
    }

    public void obrisiKlijenta(Klijent k) throws Exception {
        AbstractSO deleteKlijentSO = new DeleteClientSO();
        deleteKlijentSO.execute(k);
    }

    public void izmeniKlijenta(Klijent klijent) throws Exception {
        AbstractSO editKlijentSO = new EditKlijentSO();
        editKlijentSO.execute(klijent);
    }

    public ArrayList<OpstiDomenskiObjekat> getPotvrde(PotvrdaOIzdavanju p) throws Exception {
        GetPotvrdeSO getPotvrdeSO = new GetPotvrdeSO();
        getPotvrdeSO.execute(p);
        return getPotvrdeSO.getPotvrde();
    }

    public List<OpstiDomenskiObjekat> pretraziPotvrde(Klijent k) throws Exception {
        FindPotvrdeSO findPotvrdeSO = new FindPotvrdeSO();
        findPotvrdeSO.execute(k);

        return findPotvrdeSO.getPotvrde();
    }

    public void obrisiPotvrdu(PotvrdaOIzdavanju potvrda) throws Exception {
        AbstractSO deletePotvrdaSO = new DeletePotvrdaSO();
        deletePotvrdaSO.execute(potvrda);
    }

    public void izmeniPotvrdu(PotvrdaOIzdavanju potvrda) throws Exception {
        AbstractSO editPotvrdaSO = new EditPotvrdaSO();
        editPotvrdaSO.execute(potvrda);
    }

}
