/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package kontroler;

import domen.Admin;
import domen.Klijent;
import domen.Lokacija;
import domen.PotvrdaOIzdavanju;
import domen.Stan;
import domen.pomocni.KriterijumiStan;
import java.util.ArrayList;
import java.util.List;
import klijent.komunikacija.Communication;
import komunikacija.Operations;
import komunikacija.Request;
import komunikacija.Response;
import komunikacija.ResponseType;


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

    public List<Lokacija> getLokacije() throws Exception {
        Request request = new Request(Operations.GET_LOCATIONS);
        Response response = Communication.getInstance().getLocations(request);

        if (response.getResponseType().equals(ResponseType.SUCCESS)) {
            ArrayList<Lokacija> lokacije = (ArrayList<Lokacija>) response.getResult();
            return lokacije;
        } else {
            throw response.getException();
        }
    }

    public Admin login(String username, String password) throws Exception {
        Admin admin = new Admin(username, password);

        Request request = new Request(Operations.LOGIN, admin);
        Response response = Communication.getInstance().login(request);

        if (response.getResponseType().equals(ResponseType.SUCCESS)) {
            admin = (Admin) response.getResult();
            return admin;
        } else {
            throw response.getException();
        }
    }

    public void dodajStan(Stan stan) throws Exception {
        Request request = new Request(Operations.ADD_APARTMENT, stan);
        Response response = Communication.getInstance().addApartment(request);

        if (response.getResponseType().equals(ResponseType.ERROR)) {
            throw response.getException();
        }
    }

    public List<Stan> getStanovi() throws Exception {
        Request request = new Request(Operations.GET_APARTMENTS);
        Response response = Communication.getInstance().getApartments(request);

        if (response.getResponseType().equals(ResponseType.SUCCESS)) {
            ArrayList<Stan> stanovi = (ArrayList<Stan>) response.getResult();
            return stanovi;
        } else {
            throw response.getException();
        }
    }

    public List<Stan> pretraziStanove(KriterijumiStan ks) throws Exception {
        Request request = new Request(Operations.GET_APARTMENTS_BY_CRITERIA, ks);
        Response response = Communication.getInstance().getAparmentsByCriteria(request);

        if (response.getResponseType().equals(ResponseType.SUCCESS)) {
            ArrayList<Stan> stanovi = (ArrayList<Stan>) response.getResult();
            return stanovi;
        } else {
            throw response.getException();
        }
    }

    public void obrisiStan(Stan stan) throws Exception {
        Request request = new Request(Operations.DELETE_APARTMENT, stan);
        Response response = Communication.getInstance().deleteAparment(request);

        if (response.getResponseType().equals(ResponseType.ERROR)) {
            throw response.getException();
        }
    }

    public void izmeniStan(Stan stan) throws Exception {
        Request request = new Request(Operations.EDIT_APARTMENT, stan);
        Response response = Communication.getInstance().editApartment(request);
        
        if(response.getResponseType().equals(ResponseType.ERROR)){
            throw response.getException();
        }
    }

    public void dodajKlijenta(Klijent klijent) throws Exception {
        Request request = new Request(Operations.ADD_CLIENT, klijent);
        Response response = Communication.getInstance().addClient(request);
        
        if(response.getResponseType().equals(ResponseType.ERROR)){
            throw response.getException();
        }
    }

    public List<Klijent> getKlijenti() throws Exception {
        Request request = new Request(Operations.GET_CLIENTS);
        Response response = Communication.getInstance().getClients(request);

        if (response.getResponseType().equals(ResponseType.SUCCESS)) {
            ArrayList<Klijent> klijenti = (ArrayList<Klijent>) response.getResult();
            return klijenti;
        } else {
            throw response.getException();
        }
    }

    public void obrisiKlijenta(Klijent klijent) throws Exception {
        Request request = new Request(Operations.DELETE_CLIENT, klijent);
        Response response = Communication.getInstance().deleteClient(request);

        if (response.getResponseType().equals(ResponseType.ERROR)) {
            throw response.getException();
        }
    }

    public Klijent getKlijentById(String jmbg) throws Exception {
        Request request = new Request(Operations.FIND_CLIENT, jmbg);
        Response response = Communication.getInstance().findClient(request);
        
        if(response.getResponseType().equals(ResponseType.SUCCESS)){
            return (Klijent) response.getResult();
        } else{
            throw response.getException();
        }
    }

    public void dodajPotvrdu(PotvrdaOIzdavanju potvrda) throws Exception {
        Request request = new Request(Operations.ADD_CONFIRMATION, potvrda);
        Response response = Communication.getInstance().addConfirmation(request);
        
        if(response.getResponseType().equals(ResponseType.ERROR)){
            throw response.getException();
        }
    }

    public void izmeniKlijenta(Klijent klijent) throws Exception {
        Request request = new Request(Operations.EDIT_CLIENT, klijent);
        Response response = Communication.getInstance().editClient(request);
        
        if(response.getResponseType().equals(ResponseType.ERROR)){
            throw response.getException();
        }
    }

    public List<PotvrdaOIzdavanju> getPotvrde() throws Exception {
        Request request = new Request(Operations.GET_CONFIRMATIONS);
        Response response = Communication.getInstance().getConfirmations(request);

        if (response.getResponseType().equals(ResponseType.SUCCESS)) {
            ArrayList<PotvrdaOIzdavanju> potvrde = (ArrayList<PotvrdaOIzdavanju>) response.getResult();
            return potvrde;
        } else {
            throw response.getException();
        }
    }

    public List<PotvrdaOIzdavanju> getPotvrdeByKlijent(Klijent klijent) throws Exception {
        Request request = new Request(Operations.GET_CONFIRMATIONS_BY_CLIENT, klijent);
        Response response = Communication.getInstance().getConfirmationsByClient(request);
        
        if(response.getResponseType().equals(ResponseType.SUCCESS)){
            ArrayList<PotvrdaOIzdavanju> potvrde = (ArrayList<PotvrdaOIzdavanju>) response.getResult();
            return potvrde;
        } else{
            throw response.getException();
        }
    }

    public void obrisiPotvrdu(PotvrdaOIzdavanju potvrda) throws Exception {
        Request request = new Request(Operations.DELETE_CONFIRMATION, potvrda);
        Response response = Communication.getInstance().deleteConfirmation(request);

        if (response.getResponseType().equals(ResponseType.ERROR)) {
            throw response.getException();
        }
    }

    public void izmeniPotvrdu(PotvrdaOIzdavanju potvrda) throws Exception {
        Request request = new Request(Operations.EDIT_CONFIRMATION, potvrda);
        Response response = Communication.getInstance().editConfirmation(request);
        
        if(response.getResponseType().equals(ResponseType.ERROR)){
            throw response.getException();
        }
    }

}
