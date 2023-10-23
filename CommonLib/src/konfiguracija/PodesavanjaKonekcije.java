/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package konfiguracija;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Properties;
import konstante.KonekcijaKonstante;

/**
 *
 * @author Alek
 */
public class PodesavanjaKonekcije {

    private static PodesavanjaKonekcije instance;
    private Properties properties;

    private PodesavanjaKonekcije() {
        try {
            properties = new Properties();
            properties.load(new FileInputStream(KonekcijaKonstante.KONEKCIJA_PUTANJA));
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public static PodesavanjaKonekcije getInstance() {
        if (instance == null) {
            instance = new PodesavanjaKonekcije();
        }
        return instance;
    }
    
    public void ucitaj() throws Exception{
        properties.store(new FileOutputStream(KonekcijaKonstante.KONEKCIJA_PUTANJA), "");
    }
    
    public String getProperty(String key){
        return properties.getProperty(key, "n/a");
    }
    
    public void setProperty(String key, String value){
        properties.setProperty(key, value);
    }

}
