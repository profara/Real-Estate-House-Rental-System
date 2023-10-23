/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package config;

import constant.MyServerConstants;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Alek
 */
public class DatabaseConfig {

    private static DatabaseConfig instance;
    private Properties properties;

    private DatabaseConfig() {
        try {
            properties = new Properties();
            properties.load(new FileInputStream(MyServerConstants.DB_CONFIG_PATH));
        } catch (Exception ex) {
            ex.printStackTrace();

        }
    }
    
    public static DatabaseConfig getInstance(){
        if(instance == null)
            instance = new DatabaseConfig();
        return instance;
    }
    
    public void ucitaj() throws Exception {
        properties.store(new FileOutputStream(MyServerConstants.DB_CONFIG_PATH), "");
    }
    
    public String getProperty(String key){
        return properties.getProperty(key, "n/a");
    }
    
    public void setProperty(String key, String value){
        properties.setProperty(key, value);
    }
    
    

}
