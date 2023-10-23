/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repository.db.impl;

import repository.db.*;
import domen.Klijent;
import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Alek
 */
public class RepositoryKlijent implements DbRepository<Klijent, String> {

    private java.sql.Connection connection;

    public RepositoryKlijent() {

    }

    public void add(Klijent klijent) throws SQLException, IOException {
        try {
            String upit = "INSERT INTO klijent (jmbg,ime,prezime,email,adresa) VALUES (?,?,?,?,?)";
            connection = DbConnectionFactory.getInstance().getKonekciju();

            PreparedStatement preparedStatement = connection.prepareStatement(upit);

            preparedStatement.setString(1, klijent.getJMBG());
            preparedStatement.setString(2, klijent.getIme());
            preparedStatement.setString(3, klijent.getPrezime());
            preparedStatement.setString(4, klijent.getEmail());
            preparedStatement.setString(5, klijent.getAdresa());

            preparedStatement.executeUpdate();

            preparedStatement.close();
            System.out.println("Klijent uspesno dodat!");
        } catch (SQLException ex) {
            System.out.println("Neuspesno dodavanje klijenta!");
            ex.printStackTrace();
            throw ex;
        }
    }

    public List<Klijent> getAll() throws SQLException, IOException {
        List<Klijent> klijenti = new ArrayList<>();
        try {
            String query = "SELECT jmbg, ime, prezime, email, adresa FROM klijent";
            connection = DbConnectionFactory.getInstance().getKonekciju();

            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(query);
            while (rs.next()) {
                Klijent k = new Klijent();
                k.setJMBG(rs.getString("jmbg"));
                k.setIme(rs.getString("ime"));
                k.setPrezime(rs.getString("prezime"));
                k.setEmail(rs.getString("email"));
                k.setAdresa(rs.getString("adresa"));

                klijenti.add(k);
            }

            rs.close();
            statement.close();
            System.out.println("Uspesno vracena lista Klijent!");
        } catch (SQLException ex) {
            System.out.println("Neuspesno vracanje liste klijent!");
            ex.printStackTrace();
            throw ex;

        }

        return klijenti;
    }

    @Override
    public void delete(Klijent k) throws Exception {
        try {
            String upit = "DELETE FROM klijent WHERE jmbg = ?";
            connection = DbConnectionFactory.getInstance().getKonekciju();
            PreparedStatement preparedStatement = connection.prepareStatement(upit);
            preparedStatement.setString(1, k.getJMBG());
            preparedStatement.executeUpdate();
            System.out.println("Klijent uspesno obrisan!");
            preparedStatement.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
            System.out.println("Neuspesno brisanje klijenta!");
            throw ex;
        }
    }

    @Override
    public Klijent getById(String jmbg) throws Exception {
        Klijent k = new Klijent();
        String query = "SELECT jmbg, ime, prezime, email, adresa FROM klijent WHERE jmbg = ?";
        connection = DbConnectionFactory.getInstance().getKonekciju();
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        preparedStatement.setString(1, jmbg);
        ResultSet rs = preparedStatement.executeQuery();
        if (rs.next()) {
            k.setJMBG(rs.getString("jmbg"));
            k.setIme(rs.getString("ime"));
            k.setPrezime(rs.getString("prezime"));
            k.setEmail(rs.getString("email"));
            k.setAdresa(rs.getString("adresa"));
        }

        rs.close();
        preparedStatement.close();

        return k;

    }

    @Override
    public void update(Klijent k) throws Exception {
        try {
            String upit = "UPDATE klijent SET ime = ?, prezime = ?, email = ?, adresa = ? WHERE jmbg = ?";
            connection = DbConnectionFactory.getInstance().getKonekciju();
            PreparedStatement preparedStatement = connection.prepareStatement(upit);

            preparedStatement.setString(1, k.getIme());
            preparedStatement.setString(2, k.getPrezime());
            preparedStatement.setString(3, k.getEmail());
            preparedStatement.setString(4, k.getAdresa());
            preparedStatement.setString(5, k.getJMBG());

            preparedStatement.executeUpdate();
            System.out.println("Klijent uspesno promenjen!");
            preparedStatement.close();
        } catch(SQLException ex){
            ex.printStackTrace();
            System.out.println("Neuspesna izmena klijenta!");
            throw ex;
        }
    }

    @Override
    public List<Klijent> pretrazi(String k) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
