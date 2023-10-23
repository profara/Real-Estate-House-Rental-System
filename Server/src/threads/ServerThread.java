/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package threads;

import constant.MyServerConstants;
import domen.Admin;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import konfiguracija.PodesavanjaKonekcije;
import konstante.KonekcijaKonstante;

/**
 *
 * @author Alek
 */
public class ServerThread extends Thread {

    private ServerSocket serverSocket;
    private static List<HandleClientThread> clients;
    

    public ServerThread() throws IOException {
        serverSocket = new ServerSocket(Integer.parseInt(PodesavanjaKonekcije.getInstance().getProperty(KonekcijaKonstante.KONEKCIJA_PORT)));
        clients = new ArrayList<>();
    }

    @Override
    public void run() {
        while (!serverSocket.isClosed()) {
            try {
                System.out.println("Cekam klijenta...");
                Socket socket = serverSocket.accept();
                HandleClientThread thread = new HandleClientThread(socket);
                thread.start();
                clients.add(thread);
                System.out.println("Klijent se povezao!");
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
        stopAllThreads();
    }

    private void stopAllThreads() {
        for (HandleClientThread client : clients) {
            try {
                client.getSocket().close();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }

    private List<Admin> getAllAdmins() {
        List<Admin> admins = new ArrayList<>();
        for (HandleClientThread client : clients) {
            admins.add(client.getAdmin());
        }
        return admins;
    }

    public ServerSocket getServerSocket() {
        return serverSocket;
    }
    
    public static List<Admin> getPrijavljeniAdmini(){
        List<Admin> admini = new ArrayList<>();
        for(HandleClientThread client : clients){
            admini.add(client.getAdmin());
        }
        return admini;
    }

}
