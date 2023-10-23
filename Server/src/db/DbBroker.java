/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package db;

import domen.pomocni.OpstiDomenskiObjekat;
import java.util.List;

/**
 *
 * @author Alek
 */
public interface DbBroker {

    public List<OpstiDomenskiObjekat> vratiSveBezUslova(OpstiDomenskiObjekat odo) throws Exception;

    public List<OpstiDomenskiObjekat> vratiSve(OpstiDomenskiObjekat odo) throws Exception;

    public void ubaci(OpstiDomenskiObjekat odo) throws Exception;

    public void izmeni(OpstiDomenskiObjekat odo) throws Exception;

    public void obrisi(OpstiDomenskiObjekat odo) throws Exception;

    public List<OpstiDomenskiObjekat> pronadji(OpstiDomenskiObjekat odo) throws Exception;
    
    public OpstiDomenskiObjekat pronadjiJedinstven(OpstiDomenskiObjekat odo) throws Exception;

}
