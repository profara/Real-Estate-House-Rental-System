/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repository.db.impl;

import repository.db.*;
import domen.Lokacija;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Alek
 */
public class RepositoryLokacija implements DbRepository<Lokacija, Long>{

    private java.sql.Connection connection;

    public RepositoryLokacija() {

    }

    public List<Lokacija> getAll() throws SQLException, IOException {
        List<Lokacija> lokacije = new ArrayList<>();
        try {
            String upit = "SELECT pttBroj, naziv FROM lokacija";
            connection=DbConnectionFactory.getInstance().getKonekciju();

            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(upit);
            while (rs.next()) {
                Lokacija lokacija = new Lokacija();
                lokacija.setPttBroj(rs.getLong("pttBroj"));
                lokacija.setNaziv(rs.getString("naziv"));

                lokacije.add(lokacija);
            }

            rs.close();
            statement.close();
            System.out.println("Uspesno vracena lista Lokacija");
        } catch (SQLException ex) {
            System.out.println("Neuspesno vracanje liste Lokacija");
            ex.printStackTrace();
            throw ex;

        }

        return lokacije;
    }

    @Override
    public void add(Lokacija t) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void delete(Lokacija t) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Lokacija getById(Long k) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void update(Lokacija t) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<Lokacija> pretrazi(Long k) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    

}
