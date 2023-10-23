/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repository.db.impl;

import domen.Izdavanje;
import domen.Klijent;
import domen.Lokacija;
import domen.PotvrdaOIzdavanju;
import domen.Stan;
import java.io.IOException;
import java.util.List;
import repository.db.DbRepository;
import java.sql.*;
import java.util.ArrayList;
import repository.db.DbConnectionFactory;

/**
 *
 * @author Alek
 */
public class RepositoryPotvrda implements DbRepository<PotvrdaOIzdavanju, Klijent> {
    
    private Connection connection;

    @Override
    public List<PotvrdaOIzdavanju> getAll() throws Exception {
        List<PotvrdaOIzdavanju> potvrde = new ArrayList<>();
        try {
            String upit = "SELECT p.potvrdaID, p.cena, p.jmbg, k.ime, k.prezime, k.email, k.adresa FROM potvrdaoizdavanju p JOIN klijent k ON p.jmbg = k.jmbg";
            connection=DbConnectionFactory.getInstance().getKonekciju();

            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(upit);
            while (rs.next()) {
                
                List<Izdavanje> izdavanja = new ArrayList<>();
                PotvrdaOIzdavanju potvrda = new PotvrdaOIzdavanju();
                potvrda.setPotvrdaID(rs.getInt("p.potvrdaID"));
                potvrda.setCena(rs.getDouble("p.cena"));
                Klijent k = new Klijent();
                k.setJMBG(rs.getString("p.jmbg"));
                k.setIme(rs.getString("k.ime"));
                k.setPrezime(rs.getString("k.prezime"));
                k.setEmail(rs.getString("k.email"));
                k.setAdresa(rs.getString("k.adresa"));
                potvrda.setKlijent(k);
                
                String query = "SELECT i.stanID, i.potvrdaID, i.datumOD, i.datumDO, i.vreme, s.kvadratura, s.brojSoba, s.sprat, s.pttBroj, l.naziv FROM izdavanje i JOIN stan s ON i.stanID = s.stanID JOIN lokacija l on s.pttBroj = l.pttBroj WHERE potvrdaID = " + potvrda.getPotvrdaID();
                Statement statement1 = connection.createStatement();
                ResultSet resultSet = statement1.executeQuery(query);
                while(resultSet.next()){
                    Izdavanje izdavanje = new Izdavanje();
                    izdavanje.setDatumDO(new Date(resultSet.getDate("i.datumDO").getTime()));
                    izdavanje.setDatumOD(new Date(resultSet.getDate("i.datumOD").getTime()));
                    izdavanje.setPotvrda(potvrda);
                    izdavanje.setVreme(resultSet.getString("i.vreme"));
                    
                    Stan stan = new Stan();
                    stan.setStanID(resultSet.getInt("i.stanID"));
                    stan.setSprat(resultSet.getInt("s.sprat"));
                    stan.setBrojSoba(resultSet.getInt("s.brojSoba"));
                    stan.setKvadratura(resultSet.getDouble("s.kvadratura"));
                    
                    Lokacija lokacija = new Lokacija();
                    lokacija.setPttBroj(resultSet.getLong("s.pttBroj"));
                    lokacija.setNaziv(resultSet.getString("l.naziv"));
                    
                    stan.setLokacija(lokacija);
                    
                    izdavanje.setStan(stan);
                    
                    izdavanja.add(izdavanje);
                    
                    
                }
                
                potvrda.setIzdavanja(izdavanja);
                
                potvrde.add(potvrda);
            }

            rs.close();
            statement.close();
            System.out.println("Uspesno vracena lista Potvrda");
        } catch (SQLException ex) {
            System.out.println("Neuspesno vracanje liste Potvrda");
            ex.printStackTrace();
            throw ex;

        }

        return potvrde;
    }

    @Override
    public void add(PotvrdaOIzdavanju potvrda) throws Exception {
        try {
            connection = DbConnectionFactory.getInstance().getKonekciju();

            String query = "INSERT INTO potvrdaoizdavanju(cena, jmbg) VALUES (?,?)";
            PreparedStatement statement = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);

            statement.setDouble(1, potvrda.getCena());
            statement.setString(2, potvrda.getKlijent().getJMBG());

            statement.executeUpdate();
            ResultSet rs = statement.getGeneratedKeys();

            if (rs.next()) {
                Integer potvrdaID = rs.getInt(1);
                potvrda.setPotvrdaID(potvrdaID);

                query = "INSERT INTO izdavanje(stanID, potvrdaID, datumOD, datumDO, vreme) VALUES (?,?,?,?,?)";
                statement = connection.prepareStatement(query);

                for (Izdavanje izdavanje : potvrda.getIzdavanja()) {
                    statement.setInt(1, izdavanje.getStan().getStanID());
                    statement.setInt(2, izdavanje.getPotvrda().getPotvrdaID());
                    statement.setDate(3, new Date(izdavanje.getDatumOD().getTime()));
                    statement.setDate(4, new Date(izdavanje.getDatumDO().getTime()));
                    statement.setString(5, izdavanje.getVreme());

                    statement.executeUpdate();
                }
                statement.close();
                System.out.println("Uspesno kreirana potvrda!");

            } else {
                throw new Exception("Potvrda id nije generisan!");
            }
        } catch(SQLException ex){
            ex.printStackTrace();
            System.out.println("Neuspesno kreirana potvrda!");
            throw ex;
        }

    }

    @Override
    public void delete(PotvrdaOIzdavanju potvrda) throws SQLException, IOException {
        try{
            String upit = "DELETE FROM potvrdaoizdavanju WHERE potvrdaID = ?";
            connection = DbConnectionFactory.getInstance().getKonekciju();
            PreparedStatement preparedStatement = connection.prepareStatement(upit);
            preparedStatement.setInt(1, potvrda.getPotvrdaID());
            preparedStatement.executeUpdate();
            System.out.println("Potvrda uspesno obrisana!");
            preparedStatement.close();
        } catch(SQLException ex){
            ex.printStackTrace();
            System.out.println("Neuspesno brisanje potvrde!");
            throw ex;
        }
        
    }

//    @Override
//    public PotvrdaOIzdavanju getById(Integer k) throws Exception {
//        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
//    }
    
    

    @Override
    public void update(PotvrdaOIzdavanju potvrda) throws Exception {
        try {
            String upit = "UPDATE potvrdaoizdavanju SET cena = ?, jmbg = ? WHERE potvrdaID = ?";
            connection = DbConnectionFactory.getInstance().getKonekciju();
            PreparedStatement preparedStatement = connection.prepareStatement(upit);

            preparedStatement.setDouble(1, potvrda.getCena());
            preparedStatement.setString(2, potvrda.getKlijent().getJMBG());
            preparedStatement.setInt(3, potvrda.getPotvrdaID());
            
            preparedStatement.executeUpdate();
            
            String upitDelete = "DELETE FROM izdavanje WHERE potvrdaID = " + potvrda.getPotvrdaID();
            Statement statement = connection.createStatement();
            statement.executeUpdate(upitDelete);
            
            upit = "INSERT INTO izdavanje(stanID,potvrdaID, datumOD, datumDO, vreme) VALUES (?,?,?,?,?)";
            preparedStatement = connection.prepareStatement(upit);
            for(Izdavanje izdavanje : potvrda.getIzdavanja()){
                preparedStatement.setInt(1, izdavanje.getStan().getStanID());
                preparedStatement.setInt(2, potvrda.getPotvrdaID());
                preparedStatement.setDate(3, new Date(izdavanje.getDatumOD().getTime()));
                preparedStatement.setDate(4, new Date(izdavanje.getDatumDO().getTime()));
                preparedStatement.setString(5, izdavanje.getVreme());
                
                preparedStatement.executeUpdate();
            }
            
            System.out.println("Potvrda uspesno promenjena!");
            preparedStatement.close();
        } catch(SQLException ex){
            ex.printStackTrace();
            System.out.println("Neuspesna izmena potvrde!");
            throw ex;
        }
    }

    @Override
    public PotvrdaOIzdavanju getById(Klijent k) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<PotvrdaOIzdavanju> pretrazi(Klijent klijent) throws Exception {
        List<PotvrdaOIzdavanju> potvrde = new ArrayList<>();
        try {
            String upit = "SELECT p.potvrdaID, p.cena, p.jmbg, k.ime, k.prezime, k.email, k.adresa FROM potvrdaoizdavanju p JOIN klijent k ON p.jmbg = k.jmbg WHERE p.jmbg = ?";
            connection=DbConnectionFactory.getInstance().getKonekciju();

            PreparedStatement statement = connection.prepareStatement(upit);
            statement.setString(1, klijent.getJMBG());
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                
                List<Izdavanje> izdavanja = new ArrayList<>();
                PotvrdaOIzdavanju potvrda = new PotvrdaOIzdavanju();
                potvrda.setPotvrdaID(rs.getInt("p.potvrdaID"));
                potvrda.setCena(rs.getDouble("p.cena"));
                Klijent k = new Klijent();
                k.setJMBG(rs.getString("p.jmbg"));
                k.setIme(rs.getString("k.ime"));
                k.setPrezime(rs.getString("k.prezime"));
                k.setEmail(rs.getString("k.email"));
                k.setAdresa(rs.getString("k.adresa"));
                potvrda.setKlijent(k);
                
                String query = "SELECT i.stanID, i.potvrdaID, i.datumOD, i.datumDO, i.vreme, s.kvadratura, s.brojSoba, s.sprat, s.pttBroj, l.naziv FROM izdavanje i JOIN stan s ON i.stanID = s.stanID JOIN lokacija l on s.pttBroj = l.pttBroj WHERE potvrdaID = " + potvrda.getPotvrdaID();
                Statement statement1 = connection.createStatement();
                ResultSet resultSet = statement1.executeQuery(query);
                while(resultSet.next()){
                    Izdavanje izdavanje = new Izdavanje();
                    izdavanje.setDatumDO(new Date(resultSet.getDate("i.datumDO").getTime()));
                    izdavanje.setDatumOD(new Date(resultSet.getDate("i.datumOD").getTime()));
                    izdavanje.setPotvrda(potvrda);
                    izdavanje.setVreme(resultSet.getString("i.vreme"));
                    
                    Stan stan = new Stan();
                    stan.setStanID(resultSet.getInt("i.stanID"));
                    stan.setSprat(resultSet.getInt("s.sprat"));
                    stan.setBrojSoba(resultSet.getInt("s.brojSoba"));
                    stan.setKvadratura(resultSet.getDouble("s.kvadratura"));
                    
                    Lokacija lokacija = new Lokacija();
                    lokacija.setPttBroj(resultSet.getLong("s.pttBroj"));
                    lokacija.setNaziv(resultSet.getString("l.naziv"));
                    
                    stan.setLokacija(lokacija);
                    
                    izdavanje.setStan(stan);
                    
                    izdavanja.add(izdavanje);
                    
                    
                }
                
                potvrda.setIzdavanja(izdavanja);
                  
                potvrde.add(potvrda);
            }

            rs.close();
            statement.close();
            System.out.println("Uspesno vracena lista Potvrda");
        } catch (SQLException ex) {
            System.out.println("Neuspesno vracanje liste Potvrda");
            ex.printStackTrace();
            throw ex;

        }

        return potvrde;
    }

    

}
