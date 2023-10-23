/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package klijent;

import java.io.IOException;
import java.net.Socket;
import klijent.komunikacija.Communication;
import konfiguracija.PodesavanjaKonekcije;
import konstante.KonekcijaKonstante;
import view.form.FrmLogin;

/**
 *
 * @author Alek
 */
public class Klijent {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Klijent klijent = new Klijent();
        try {
            klijent.connect();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        
    }

    private void connect() throws IOException {
        String adresa = PodesavanjaKonekcije.getInstance().getProperty(KonekcijaKonstante.KONEKCIJA_ADRESA);
        int port = Integer.parseInt(PodesavanjaKonekcije.getInstance().getProperty(KonekcijaKonstante.KONEKCIJA_PORT));
        Socket socket = new Socket(adresa, port);
        System.out.println("Klijent se povezao...");
        Communication.getInstance().setSocket(socket);
        new FrmLogin(null, true).setVisible(true);
    }
    
}
