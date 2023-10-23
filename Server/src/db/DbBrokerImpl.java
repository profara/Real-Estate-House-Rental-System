/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package db;

import java.sql.Statement;
import domen.pomocni.OpstiDomenskiObjekat;
import java.util.ArrayList;
import java.util.List;
import java.sql.Connection;
import java.sql.PreparedStatement;
import repository.db.DbConnectionFactory;
import java.sql.ResultSet;

/**
 *
 * @author Alek
 */
public class DbBrokerImpl implements DbBroker {

    @Override
    public List<OpstiDomenskiObjekat> vratiSveBezUslova(OpstiDomenskiObjekat odo) throws Exception {
        ArrayList<OpstiDomenskiObjekat> lista;
        Connection konekcija = DbConnectionFactory.getInstance().getKonekciju();
        String upit = "SELECT * FROM " + odo.vratiImeKlase();
        System.out.println(upit);
        Statement statement = konekcija.createStatement();
        ResultSet rs = statement.executeQuery(upit);
        lista = odo.napuniSve(rs);
        rs.close();
        statement.close();
        return lista;
    }

    @Override
    public List<OpstiDomenskiObjekat> vratiSve(OpstiDomenskiObjekat odo) throws Exception {
        ArrayList<OpstiDomenskiObjekat> lista;
        Connection konekcija = DbConnectionFactory.getInstance().getKonekciju();
        String upit = "SELECT * FROM " + odo.vratiImeKlase() + " " + odo.vratiTabeluSaUslovomSpajanja();
        System.out.println(upit);
        Statement statement = konekcija.createStatement();
        ResultSet rs = statement.executeQuery(upit);
        lista = odo.napuniSve(rs);
        rs.close();
        statement.close();
        return lista;
    }

    @Override
    public void ubaci(OpstiDomenskiObjekat odo) throws Exception {
        Connection konekcija = DbConnectionFactory.getInstance().getKonekciju();
        String upit = "INSERT INTO " + odo.vratiImeKlase() + " (" + odo.vratiKoloneTabele() +  " ) " + " VALUES (" + odo.vratiVrednostiAtributa() + ")";
        System.out.println(upit);
        PreparedStatement preparedStatement = konekcija.prepareStatement(upit, Statement.RETURN_GENERATED_KEYS);
        preparedStatement.executeUpdate();
        ResultSet rs = preparedStatement.getGeneratedKeys();
        odo.postaviKljuc(rs);
        preparedStatement.close();
    }

    @Override
    public void izmeni(OpstiDomenskiObjekat odo) throws Exception {
        Connection konekcija = DbConnectionFactory.getInstance().getKonekciju();
        String upit = "UPDATE " + odo.vratiImeKlase() + " SET " + odo.postaviVrednostAtributa() + " WHERE " + odo.vratiUslovZaNadjiSlog();
        PreparedStatement preparedStatement = konekcija.prepareStatement(upit);
        System.out.println(upit);
        preparedStatement.executeUpdate(upit);
        preparedStatement.close();
    }

    @Override
    public void obrisi(OpstiDomenskiObjekat odo) throws Exception {
        Connection konekcija = DbConnectionFactory.getInstance().getKonekciju();
        String upit = "DELETE FROM " + odo.vratiImeKlase() + " WHERE " + odo.vratiUslovZaNadjiSlog();
        PreparedStatement preparedStatement = konekcija.prepareStatement(upit);
        System.out.println(upit);
        preparedStatement.executeUpdate(upit);
        preparedStatement.close();
    }

    @Override
    public List<OpstiDomenskiObjekat> pronadji(OpstiDomenskiObjekat odo) throws Exception {
        Connection konekcija = DbConnectionFactory.getInstance().getKonekciju();
        String upit = "SELECT * FROM " + odo.vratiImeKlase() + " " + odo.vratiTabeluSaUslovomSpajanja() + " WHERE " + odo.vratiUslovZaNadjiSlogove();
        System.out.println(upit);
        Statement statement = konekcija.createStatement();
        ResultSet rs = statement.executeQuery(upit);
        List<OpstiDomenskiObjekat> rezultat = odo.napuniSve(rs);
        rs.close();
        statement.close();

        return rezultat;
    }

    @Override
    public OpstiDomenskiObjekat pronadjiJedinstven(OpstiDomenskiObjekat odo) throws Exception {
        Connection konekcija = DbConnectionFactory.getInstance().getKonekciju();
        String upit = "SELECT * FROM " + odo.vratiImeKlase() + " " + odo.vratiTabeluSaUslovomSpajanja() + " WHERE " + odo.vratiUslovZaNadjiSlog();
        System.out.println(upit);
        Statement statement = konekcija.createStatement();
        ResultSet rs = statement.executeQuery(upit);
        OpstiDomenskiObjekat rezultat = odo.napuni(rs);
        rs.close();
        statement.close();

        return rezultat;
    }

}
