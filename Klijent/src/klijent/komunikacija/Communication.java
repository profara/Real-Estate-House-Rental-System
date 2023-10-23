/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package klijent.komunikacija;

import domen.Stan;
import java.net.Socket;
import komunikacija.Receiver;
import komunikacija.Request;
import komunikacija.Response;
import komunikacija.Sender;

/**
 *
 * @author Alek
 */
public class Communication {

    private static Communication instance;
    private Socket socket;

    private Communication() {

    }

    public static Communication getInstance() {
        if (instance == null) {
            instance = new Communication();
        }
        return instance;
    }

    public void setSocket(Socket socket) {
        this.socket = socket;
    }

    public Response login(Request request) throws Exception {
        new Sender(socket).send(request);
        System.out.println("Zahtev za prijavu na sistem poslat!");
        return (Response) new Receiver(socket).receive();

    }

    public Response getLocations(Request request) throws Exception {
        new Sender(socket).send(request);
        System.out.println("Zahtev za lokacije uspesno poslat!");
        return (Response) new Receiver(socket).receive();
    }

    public Response addApartment(Request request) throws Exception {
        new Sender(socket).send(request);
        System.out.println("Zahtev za dodavanje stana uspesno poslat!");
        return (Response) new Receiver(socket).receive();
    }

    public Response getApartments(Request request) throws Exception {
        new Sender(socket).send(request);
        System.out.println("Zahtev za stanove uspesno poslat!");
        return (Response) new Receiver(socket).receive();
    }

    public Response getAparmentsByCriteria(Request request) throws Exception {
        new Sender(socket).send(request);
        System.out.println("Zahtev za stanove po kriterijumima uspesno poslat!");
        return (Response) new Receiver(socket).receive();
    }

    public Response deleteAparment(Request request) throws Exception {
        new Sender(socket).send(request);
        System.out.println("Zahtev za brisanje stana uspesno poslat!");
        return (Response) new Receiver(socket).receive();
    }

    public Response editApartment(Request request) throws Exception {
        new Sender(socket).send(request);
        System.out.println("Zahtev za izmenu stana uspesno poslat!");
        return (Response) new Receiver(socket).receive();
    }

    public Response addClient(Request request) throws Exception {
        new Sender(socket).send(request);
        System.out.println("Zahtev za dodavanje klijenta uspesno poslat!");
        return (Response) new Receiver(socket).receive();
    }

    public Response getClients(Request request) throws Exception {
        new Sender(socket).send(request);
        System.out.println("Zahtev za klijente uspesno poslat!");
        return (Response) new Receiver(socket).receive();
    }

    public Response deleteClient(Request request) throws Exception {
        new Sender(socket).send(request);
        System.out.println("Zahtev za brisanje klijenta uspesno poslat!");
        return (Response) new Receiver(socket).receive();
    }

    public Response findClient(Request request) throws Exception {
        new Sender(socket).send(request);
        System.out.println("Zahtev za pronalazenje klijenta uspesno poslat!");
        return (Response) new Receiver(socket).receive();
    }

    public Response addConfirmation(Request request) throws Exception {
        new Sender(socket).send(request);
        System.out.println("Zahtev za dodavanje potvrde uspesno poslat!");
        return (Response) new Receiver(socket).receive();
    }

    public Response editClient(Request request) throws Exception {
        new Sender(socket).send(request);
        System.out.println("Zahtev za izmenu klijenta uspesno poslat!");
        return (Response) new Receiver(socket).receive();
    }

    public Response getConfirmations(Request request) throws Exception {
        new Sender(socket).send(request);
        System.out.println("Zahtev za potvrdama uspesno poslat!");
        return (Response) new Receiver(socket).receive();
    }

    public Response getConfirmationsByClient(Request request) throws Exception {
        new Sender(socket).send(request);
        System.out.println("Zahtev za potvrdama po klijentu uspesno poslat!");
        return (Response) new Receiver(socket).receive();
    }

    public Response deleteConfirmation(Request request) throws Exception {
        new Sender(socket).send(request);
        System.out.println("Zahtev za brisanje potvrde uspesno poslat!");
        return (Response) new Receiver(socket).receive();
    }

    public Response editConfirmation(Request request) throws Exception {
        new Sender(socket).send(request);
        System.out.println("Zahtev za izmenu potvrde uspesno poslat!");
        return (Response) new Receiver(socket).receive();
    }

}
