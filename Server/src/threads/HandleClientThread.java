/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package threads;

import controller.Kontroler;
import domen.Admin;
import domen.Klijent;
import domen.Lokacija;
import domen.PotvrdaOIzdavanju;
import domen.Stan;
import domen.pomocni.KriterijumiStan;
import domen.pomocni.OpstiDomenskiObjekat;
import java.io.IOException;
import java.net.Socket;
import java.util.List;
import komunikacija.Operations;
import komunikacija.Receiver;
import komunikacija.Request;
import komunikacija.Response;
import komunikacija.ResponseType;
import komunikacija.Sender;

/**
 *
 * @author Alek
 */
public class HandleClientThread extends Thread {

    private Socket socket;
    private Admin admin;

    public HandleClientThread(Socket socket) throws IOException {
        this.socket = socket;
    }

    @Override
    public void run() {
        while (!socket.isClosed()) {
            try {
                Request request = (Request) new Receiver(socket).receive();
                Response response = handleRequest(request);
                new Sender(socket).send(response);
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    }

    public Socket getSocket() {
        return socket;
    }

    private Response handleRequest(Request request) {
        int operation = request.getOperation();
        switch (operation) {
            case Operations.LOGIN:
                return login(request);
            case Operations.GET_LOCATIONS:
                return getLocations();
            case Operations.ADD_APARTMENT:
                return addApartment(request);
            case Operations.GET_APARTMENTS:
                return getApartments();
            case Operations.GET_APARTMENTS_BY_CRITERIA:
                return getAparmentsByCriteria(request);
            case Operations.DELETE_APARTMENT:
                return deleteApartment(request);
            case Operations.EDIT_APARTMENT:
                return editApartment(request);
            case Operations.ADD_CLIENT:
                return addClient(request);
            case Operations.GET_CLIENTS:
                return getClients();
            case Operations.DELETE_CLIENT:
                return deleteClient(request);
            case Operations.FIND_CLIENT:
                return findClient(request);
            case Operations.ADD_CONFIRMATION:
                return addConfirmation(request);
            case Operations.EDIT_CLIENT:
                return editClient(request);
            case Operations.GET_CONFIRMATIONS:
                return getConfirmations();
            case Operations.GET_CONFIRMATIONS_BY_CLIENT:
                return getConfirmationsByClient(request);
            case Operations.DELETE_CONFIRMATION:
                return deleteConfirmation(request);
            case Operations.EDIT_CONFIRMATION:
                return editConfirmation(request);
        }
        return null;
    }

    private Response login(Request request) {
        Response response = new Response();
        Admin requestAdmin = (Admin) request.getArgument();

        try {
            Admin admin = (Admin) Kontroler.getInstance().login(requestAdmin);
            System.out.println("Uspesna prijava na sistem!");
            response.setResponseType(ResponseType.SUCCESS);
            response.setResult(admin);
            this.admin = admin;
        } catch (Exception ex) {
            ex.printStackTrace();
            response.setResponseType(ResponseType.ERROR);
            response.setException(ex);
        }
        return response;
    }

    public Admin getAdmin() {
        return admin;
    }

    private Response getLocations() {
        Response response = new Response();

        try {
            List<OpstiDomenskiObjekat> lokacije = Kontroler.getInstance().getLokacije(new Lokacija());
            System.out.println("Uspesno ucitana lista lokacija!");
            response.setResponseType(ResponseType.SUCCESS);
            response.setResult(lokacije);
        } catch (Exception ex) {
            ex.printStackTrace();
            response.setResponseType(ResponseType.ERROR);
            response.setException(ex);
        }
        return response;
    }

    private Response addApartment(Request request) {
        Response response = new Response();
        Stan stan = (Stan) request.getArgument();

        try {
            Kontroler.getInstance().dodajStan(stan);
            System.out.println("Stan uspesno dodat!");
            response.setResponseType(ResponseType.SUCCESS);
        } catch (Exception ex) {
            ex.printStackTrace();
            response.setResponseType(ResponseType.ERROR);
            response.setException(ex);
        }
        return response;
    }

    private Response getApartments() {
        Response response = new Response();

        try {
            List<OpstiDomenskiObjekat> stanovi = Kontroler.getInstance().getStanovi(new Stan());
            System.out.println("Uspesno ucitana lista stanova!");
            response.setResponseType(ResponseType.SUCCESS);
            response.setResult(stanovi);
        } catch (Exception ex) {
            ex.printStackTrace();
            response.setResponseType(ResponseType.ERROR);
            response.setException(ex);
        }
        return response;
    }

    private Response getAparmentsByCriteria(Request request) {
        Response response = new Response();
        KriterijumiStan ks = (KriterijumiStan) request.getArgument();

        try {
            List<OpstiDomenskiObjekat> stanovi = Kontroler.getInstance().pretraziStanove(ks);
            System.out.println("Uspesno ucitana lista stanova po kriterijumima!");
            response.setResponseType(ResponseType.SUCCESS);
            response.setResult(stanovi);
        } catch (Exception ex) {
            ex.printStackTrace();
            response.setResponseType(ResponseType.ERROR);
            response.setException(ex);
        }
        return response;
    }

    private Response deleteApartment(Request request) {
        Response response = new Response();
        Stan stan = (Stan) request.getArgument();

        try {
            Kontroler.getInstance().obrisiStan(stan);
            System.out.println("Stan uspesno obrisan!");
            response.setResponseType(ResponseType.SUCCESS);
        } catch (Exception ex) {
            ex.printStackTrace();
            response.setResponseType(ResponseType.ERROR);
            response.setException(ex);
        }
        return response;
    }

    private Response editApartment(Request request) {
        Response response = new Response();
        Stan stan = (Stan) request.getArgument();

        try {
            Kontroler.getInstance().izmeniStan(stan);
            System.out.println("Stan uspesno izmenjen!");
            response.setResponseType(ResponseType.SUCCESS);
        } catch (Exception ex) {
            ex.printStackTrace();
            response.setResponseType(ResponseType.ERROR);
            response.setException(ex);
        }
        return response;
    }

    private Response addClient(Request request) {
        Response response = new Response();
        Klijent klijent = (Klijent) request.getArgument();

        try {
            Kontroler.getInstance().dodajKlijenta(klijent);
            System.out.println("Klijent uspesno dodat!");
            response.setResponseType(ResponseType.SUCCESS);
        } catch (Exception ex) {
            ex.printStackTrace();
            response.setResponseType(ResponseType.ERROR);
            response.setException(ex);
        }
        return response;
    }

    private Response getClients() {
        Response response = new Response();

        try {
            List<OpstiDomenskiObjekat> klijenti = Kontroler.getInstance().getKlijenti(new Klijent());
            System.out.println("Uspesno ucitana lista klijenata!");
            response.setResponseType(ResponseType.SUCCESS);
            response.setResult(klijenti);
        } catch (Exception ex) {
            ex.printStackTrace();
            response.setResponseType(ResponseType.ERROR);
            response.setException(ex);
        }
        return response;
    }

    private Response deleteClient(Request request) {
        Response response = new Response();
        Klijent klijent = (Klijent) request.getArgument();

        try {
            Kontroler.getInstance().obrisiKlijenta(klijent);
            System.out.println("Klijent uspesno obrisan!");
            response.setResponseType(ResponseType.SUCCESS);
        } catch (Exception ex) {
            ex.printStackTrace();
            response.setResponseType(ResponseType.ERROR);
            response.setException(ex);
        }
        return response;
    }

    private Response findClient(Request request) {
        Response response = new Response();
        String jmbg = (String) request.getArgument();
        Klijent k = new Klijent();
        k.setJMBG(jmbg);

        try {
            OpstiDomenskiObjekat klijent = Kontroler.getInstance().getKlijentById((k));
            System.out.println("Klijent uspesno pronadjen!");
            response.setResponseType(ResponseType.SUCCESS);
            response.setResult(klijent);
        } catch (Exception ex) {
            ex.printStackTrace();
            response.setResponseType(ResponseType.ERROR);
            response.setException(ex);
        }
        return response;
    }

    private Response addConfirmation(Request request) {
        Response response = new Response();
        PotvrdaOIzdavanju potvrda = (PotvrdaOIzdavanju) request.getArgument();

        try {
            Kontroler.getInstance().dodajPotvrdu(potvrda);
            System.out.println("Potvrda uspesno dodata!");
            response.setResponseType(ResponseType.SUCCESS);
        } catch (Exception ex) {
            ex.printStackTrace();
            response.setResponseType(ResponseType.ERROR);
            response.setException(ex);
        }
        return response;
    }

    private Response editClient(Request request) {
        Response response = new Response();
        Klijent klijent = (Klijent) request.getArgument();

        try {
            Kontroler.getInstance().izmeniKlijenta(klijent);
            System.out.println("Klijent uspesno izmenjen!");
            response.setResponseType(ResponseType.SUCCESS);
        } catch (Exception ex) {
            ex.printStackTrace();
            response.setResponseType(ResponseType.ERROR);
            response.setException(ex);
        }
        return response;
    }

    private Response getConfirmations() {
        Response response = new Response();

        try {
            List<OpstiDomenskiObjekat> potvrde = Kontroler.getInstance().getPotvrde(new PotvrdaOIzdavanju());
            System.out.println("Uspesno ucitana lista potvrda!");
            response.setResponseType(ResponseType.SUCCESS);
            response.setResult(potvrde);
        } catch (Exception ex) {
            ex.printStackTrace();
            response.setResponseType(ResponseType.ERROR);
            response.setException(ex);
        }
        return response;
    }

    private Response getConfirmationsByClient(Request request) {
        Response response = new Response();
        Klijent klijent = (Klijent) request.getArgument();

        try {
            List<OpstiDomenskiObjekat> potvrde = Kontroler.getInstance().pretraziPotvrde(klijent);
            System.out.println("Uspesno ucitana lista potvrda po klijentu!");
            response.setResponseType(ResponseType.SUCCESS);
            response.setResult(potvrde);
        } catch (Exception ex) {
            ex.printStackTrace();
            response.setResponseType(ResponseType.ERROR);
            response.setException(ex);
        }
        return response;
    }

    private Response deleteConfirmation(Request request) {
        Response response = new Response();
        PotvrdaOIzdavanju potvrda = (PotvrdaOIzdavanju) request.getArgument();

        try {
            Kontroler.getInstance().obrisiPotvrdu(potvrda);
            System.out.println("Potvrda uspesno obrisana!");
            response.setResponseType(ResponseType.SUCCESS);
        } catch (Exception ex) {
            ex.printStackTrace();
            response.setResponseType(ResponseType.ERROR);
            response.setException(ex);
        }
        return response;
    }

    private Response editConfirmation(Request request) {
        Response response = new Response();
        PotvrdaOIzdavanju potvrda = (PotvrdaOIzdavanju) request.getArgument();

        try {
            Kontroler.getInstance().izmeniPotvrdu(potvrda);
            System.out.println("Potvrda uspesno izmenjena!");
            response.setResponseType(ResponseType.SUCCESS);
        } catch (Exception ex) {
            ex.printStackTrace();
            response.setResponseType(ResponseType.ERROR);
            response.setException(ex);
        }
        return response;
    }

}
