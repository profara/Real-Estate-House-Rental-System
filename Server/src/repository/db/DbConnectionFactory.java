/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repository.db;

import config.DatabaseConfig;
import constant.MyServerConstants;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Connection;
import java.util.Properties;

/**
 *
 * @author Alek
 */
public class DbConnectionFactory {
    
    private Connection connection;
    private static DbConnectionFactory instance;

    private DbConnectionFactory() {
    }
    
    public static DbConnectionFactory getInstance(){
        if(instance == null){
            instance = new DbConnectionFactory();
        }
        
        return instance;
    }
    
    
    
    public Connection getKonekciju() throws SQLException, IOException {

        if (connection == null || connection.isClosed()) {
            try {
                String url = DatabaseConfig.getInstance().getProperty(MyServerConstants.DB_CONFIG_URL);
                String username = DatabaseConfig.getInstance().getProperty(MyServerConstants.DB_CONFIG_USERNAME);
                String password = DatabaseConfig.getInstance().getProperty(MyServerConstants.DB_CONFIG_PASSWORD);
                connection = DriverManager.getConnection(url, username, password);
                connection.setAutoCommit(false);
                System.out.println("Konekcija uspesno uspostavljena!");
            } catch (SQLException ex) {
                System.out.println("Neuspesno ustavljanje konekcije!");
                ex.printStackTrace();
                throw ex;
            }
        }
        return connection;
    }
    
}
