/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repository.db;

import domen.Lokacija;
import domen.Stan;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import repository.Repository;

/**
 *
 * @author Alek
 */
public interface DbRepository<T,K> extends Repository<T, K> {
    
    default public void connect() throws SQLException, IOException{
        DbConnectionFactory.getInstance().getKonekciju();
    }
    
    default public void disconnect() throws SQLException, IOException {
        DbConnectionFactory.getInstance().getKonekciju().close();
    }
    
    default public void commit() throws SQLException, IOException{
        DbConnectionFactory.getInstance().getKonekciju().commit();
    }
    
    default public void rollback() throws SQLException, IOException{
        DbConnectionFactory.getInstance().getKonekciju().rollback();
    }

    

   
    
}
