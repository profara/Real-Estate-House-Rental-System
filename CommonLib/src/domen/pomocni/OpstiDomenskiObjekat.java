/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package domen.pomocni;

import java.sql.ResultSet;
import java.util.ArrayList;
/**
 *
 * @author Alek
 */
public interface OpstiDomenskiObjekat {
    String vratiVrednostiAtributa();
    
    String postaviVrednostAtributa();
    
    String vratiImeKlase();
    
    String vratiUslovZaNadjiSlog();
    
    String vratiUslovZaNadjiSlogove();
    
    public OpstiDomenskiObjekat napuni(ResultSet rs) throws Exception;
    
    public ArrayList<OpstiDomenskiObjekat> napuniSve(ResultSet rs) throws Exception;
    
    public String vratiTabeluSaUslovomSpajanja();

    public String vratiKoloneTabele();

    public void postaviKljuc(ResultSet rs) throws Exception;

}
