/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package domen.pomocni;

import domen.Lokacija;
import domen.Stan;
import java.io.Serializable;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author Alek
 */
public class KriterijumiStan implements Serializable, OpstiDomenskiObjekat {

    private Stan stanMin;
    private Stan stanMax;

    public KriterijumiStan() {
    }

    public KriterijumiStan(Stan stanMin, Stan stanMax) {
        this.stanMin = stanMin;
        this.stanMax = stanMax;
    }

    public Stan getStanMin() {
        return stanMin;
    }

    public void setStanMin(Stan stanMin) {
        this.stanMin = stanMin;
    }

    public Stan getStanMax() {
        return stanMax;
    }

    public void setStanMax(Stan stanMax) {
        this.stanMax = stanMax;
    }

    @Override
    public String vratiVrednostiAtributa() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public String postaviVrednostAtributa() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public String vratiImeKlase() {
        return Stan.class.getSimpleName();
    }

    @Override
    public String vratiUslovZaNadjiSlog() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public String vratiUslovZaNadjiSlogove() {
        return "kvadratura >= " + stanMin.getKvadratura() + " AND s.kvadratura <= " + stanMax.getKvadratura() + " AND s.brojSoba >= " + stanMin.getBrojSoba() + " AND s.brojSoba <= " + stanMax.getBrojSoba() + ""
                + " AND sprat >= " + stanMin.getSprat() + " AND sprat <= " + stanMax.getSprat() + " AND s.pttBroj = " + stanMax.getLokacija().getPttBroj();
    }

    @Override
    public OpstiDomenskiObjekat napuni(ResultSet rs) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public ArrayList<OpstiDomenskiObjekat> napuniSve(ResultSet rs) throws Exception {
        ArrayList<OpstiDomenskiObjekat> lista = new ArrayList<>();
        try {
            while (rs.next()) {
                Lokacija lokacija = new Lokacija();
                lokacija.setPttBroj(rs.getLong("pttBroj"));
                lokacija.setNaziv(rs.getString("naziv"));

                int stanID = rs.getInt("stanID");
                double kvadratura = rs.getDouble("kvadratura");
                int brojSoba = rs.getInt("brojSoba");
                int sprat = rs.getInt("sprat");

                Stan stan = new Stan(stanID, kvadratura, brojSoba, sprat, lokacija);
                lista.add(stan);
            }
            return lista;
        } catch (Exception ex) {
            throw new Exception("Greska prilikom punjenja objekta iz baze!");
        }
    }

    @Override
    public String vratiTabeluSaUslovomSpajanja() {
        return "s JOIN lokacija l ON s.pttBroj = l.pttBroj";
    }

    @Override
    public String vratiKoloneTabele() {
        return "kvadratura, brojSoba, sprat, pttBroj";
    }

    @Override
    public void postaviKljuc(ResultSet rs) throws Exception {
        return;
    }

}
