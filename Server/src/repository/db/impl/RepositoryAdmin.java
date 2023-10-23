/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repository.db.impl;

import repository.db.*;
import domen.Admin;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


/**
 *
 * @author Alek
 */
public class RepositoryAdmin implements DbRepository<Admin, Integer>{

    private Connection connection;

    public RepositoryAdmin() {

    }

    public List<Admin> getAll() throws Exception {
        List<Admin> admini = new ArrayList<>();
        try {
            String upit = "SELECT id, username, password FROM admin";
            connection=DbConnectionFactory.getInstance().getKonekciju();
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(upit);
            while (rs.next()) {
                Admin admin = new Admin();
                admin.setId(rs.getInt("id"));
                admin.setUsername(rs.getString("username"));
                admin.setPassword(rs.getString("password"));

                admini.add(admin);
            }

            System.out.println("Uspesno vracena lista Admina");
        } catch (SQLException ex) {
            //System.out.println("Neuspesno vracanje liste Admin");
            ex.printStackTrace();
            throw new Exception("Neuspesno vracanje liste Admin", ex);

        }

        return admini;
    }

    @Override
    public void add(Admin t) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void delete(Admin t) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Admin getById(Integer k) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void update(Admin t) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<Admin> pretrazi(Integer k) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
