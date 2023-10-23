/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repository.db.impl;

import repository.db.*;
import domen.Lokacija;
import domen.Stan;
import domen.pomocni.KriterijumiStan;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Alek
 */
public class RepositoryStan implements DbRepository<Stan, KriterijumiStan> {

    private Connection connection;

    public RepositoryStan() {

    }

    public void add(Stan stan) throws SQLException, IOException {
        try {
            String upit = "INSERT INTO Stan (kvadratura,brojSoba,sprat,pttBroj) VALUES (?,?,?,?)";
            connection = DbConnectionFactory.getInstance().getKonekciju();

            PreparedStatement preparedStatement = connection.prepareStatement(upit, Statement.RETURN_GENERATED_KEYS);

            preparedStatement.setDouble(1, stan.getKvadratura());
            preparedStatement.setInt(2, stan.getBrojSoba());
            preparedStatement.setInt(3, stan.getSprat());
            preparedStatement.setLong(4, stan.getLokacija().getPttBroj());

            preparedStatement.executeUpdate();
            ResultSet rs = preparedStatement.getGeneratedKeys();
            if (rs.next()) {
                stan.setStanID(rs.getInt(1));
            }

            preparedStatement.close();
            System.out.println("Stan uspesno dodat!");
        } catch (SQLException ex) {
            System.out.println("Neuspesno dodavanje stana!");
            ex.printStackTrace();
            throw ex;
        }
    }

    public List<Stan> getAll() throws SQLException, IOException {

        List<Stan> stanovi = new ArrayList<>();

        try {
            String query = "SELECT s.stanid, s.kvadratura, s.brojSoba, s.sprat, l.naziv, s.pttBroj FROM stan s JOIN lokacija l ON s.pttBroj = l.pttBroj";
            connection = DbConnectionFactory.getInstance().getKonekciju();

            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(query);

            while (rs.next()) {
                Stan stan = new Stan();
                stan.setStanID(rs.getInt("s.stanid"));
                stan.setKvadratura(rs.getDouble("s.kvadratura"));
                stan.setBrojSoba(rs.getInt("s.brojSoba"));
                stan.setSprat(rs.getInt("s.sprat"));
                Lokacija l = new Lokacija();
                l.setNaziv(rs.getString("l.naziv"));
                l.setPttBroj(rs.getLong("s.pttBroj"));
                stan.setLokacija(l);
                stanovi.add(stan);
            }
            rs.close();
            statement.close();
            System.out.println("Uspesno ucitavanje liste Stan!");
        } catch (SQLException ex) {
            ex.printStackTrace();
            System.out.println("Neuspesno vracanje liste Stan!");
            throw ex;
        }

        return stanovi;

    }

    public void delete(Stan stan) throws SQLException, IOException {
        try {
            String upit = "DELETE FROM stan WHERE stanID = ?";
            connection = DbConnectionFactory.getInstance().getKonekciju();
            PreparedStatement preparedStatement = connection.prepareStatement(upit);
            preparedStatement.setInt(1, stan.getStanID());
            preparedStatement.executeUpdate();
            System.out.println("Stan uspesno obrisan!");
            preparedStatement.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
            System.out.println("Neuspesno brisanje stana!");
            throw ex;
        }
    }

   
    @Override
    public void update(Stan stan) throws Exception {
        try{
        String upit = "UPDATE stan SET kvadratura = " + stan.getKvadratura() + ", brojSoba = " + stan.getBrojSoba() + ", sprat = " + stan.getSprat() +
                ", pttBroj = " + stan.getLokacija().getPttBroj() +" WHERE stanID = " + stan.getStanID();
        connection = DbConnectionFactory.getInstance().getKonekciju();
        Statement statement = connection.createStatement();
        statement.executeUpdate(upit);
        System.out.println("Stan uspesno izmenjen!");
        statement.close();
        } catch(SQLException ex){
            ex.printStackTrace();
            System.out.println("Neuspesna izmena stana!");
            throw ex;
        }
    }

    

    @Override
    public Stan getById(KriterijumiStan k) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<Stan> pretrazi(KriterijumiStan ks) throws Exception {
        List<Stan> stanovi = new ArrayList<>();
        
        try {
            String upit = "SELECT s.stanID, s.kvadratura, s.brojSoba, s.sprat, s.pttBroj, l.naziv FROM stan s JOIN lokacija l ON s.pttBroj = l.pttBroj"
                    + " WHERE s.kvadratura >= " + ks.getStanMin().getKvadratura() + " AND s.kvadratura <= " + ks.getStanMax().getKvadratura() + " AND s.brojSoba >= " + ks.getStanMin().getBrojSoba() + " AND s.brojSoba <= " + ks.getStanMax().getBrojSoba() + ""
                    + " AND sprat >= " + ks.getStanMin().getSprat() + " AND sprat <= " + ks.getStanMax().getSprat() + " AND s.pttBroj = " + ks.getStanMax().getLokacija().getPttBroj();
            connection = DbConnectionFactory.getInstance().getKonekciju();
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(upit);
            
            while(rs.next()){
                Stan s = new Stan();
                s.setStanID(rs.getInt("s.stanID"));
                s.setKvadratura(rs.getDouble("s.kvadratura"));
                s.setBrojSoba(rs.getInt("s.brojSoba"));
                s.setSprat(rs.getInt("s.sprat"));
                
                Lokacija l = new Lokacija();
                l.setNaziv(rs.getString("l.naziv"));
                l.setPttBroj(rs.getLong("s.pttBroj"));
                
                s.setLokacija(l);
                
                stanovi.add(s);
            }
            rs.close();
            statement.close();
            
            System.out.println("Uspesna pretraga stanova!");

        } catch (SQLException ex) {
            ex.printStackTrace();
            System.out.println("Neuspesna pretraga stanova!");
            throw ex;
        }
        return stanovi;
    }

}
