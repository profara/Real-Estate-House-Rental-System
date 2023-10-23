/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package domen;

import domen.pomocni.OpstiDomenskiObjekat;
import java.io.Serializable;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Alek
 */
public class Stan implements Serializable, OpstiDomenskiObjekat {

    private int stanID;
    private double kvadratura;
    private int brojSoba;
    private int sprat;
    private Lokacija lokacija;
    private List<Izdavanje> izdavanja;

    public Stan() {
    }

    public Stan(int stanID, double kvadratura, int brojSoba, int sprat, Lokacija lokacija) {
        this.stanID = stanID;
        this.kvadratura = kvadratura;
        this.brojSoba = brojSoba;
        this.sprat = sprat;
        this.lokacija = lokacija;
    }

    public Stan(double kvadratura, int brojSoba, int sprat, Lokacija lokacija) {
        this.kvadratura = kvadratura;
        this.brojSoba = brojSoba;
        this.sprat = sprat;
        this.lokacija = lokacija;
    }

    public int getStanID() {
        return stanID;
    }

    public void setStanID(int stanID) {
        this.stanID = stanID;
    }

    public double getKvadratura() {
        return kvadratura;
    }

    public void setKvadratura(double kvadratura) {
        this.kvadratura = kvadratura;
    }

    public int getBrojSoba() {
        return brojSoba;
    }

    public void setBrojSoba(int brojSoba) {
        this.brojSoba = brojSoba;
    }

    public int getSprat() {
        return sprat;
    }

    public void setSprat(int sprat) {
        this.sprat = sprat;
    }

    public Lokacija getLokacija() {
        return lokacija;
    }

    public void setLokacija(Lokacija lokacija) {
        this.lokacija = lokacija;
    }

    public List<Izdavanje> getIzdavanja() {
        return izdavanja;
    }

    public void setIzdavanja(List<Izdavanje> izdavanja) {
        this.izdavanja = izdavanja;
    }

    @Override
    public String toString() {
        return lokacija + " - " + kvadratura;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 29 * hash + this.stanID;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Stan other = (Stan) obj;
        return this.stanID == other.stanID;
    }

    @Override
    public String vratiVrednostiAtributa() {
        return /*stanID + ", "*/ + kvadratura + ", " + brojSoba + ", " + sprat + ", " + (lokacija == null ? null : lokacija.getPttBroj());
    }

    @Override
    public String postaviVrednostAtributa() {
        return "stanID=" + stanID + ", kvadratura=" + kvadratura + ", brojSoba=" + brojSoba + ", sprat=" + sprat + ", pttBroj=" + (lokacija == null ? null : lokacija.getPttBroj());
    }

    @Override
    public String vratiImeKlase() {
        return Stan.class.getSimpleName();
    }

    @Override
    public String vratiUslovZaNadjiSlog() {
        return "stanID=" + stanID;
    }

    @Override
    public String vratiUslovZaNadjiSlogove() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public OpstiDomenskiObjekat napuni(ResultSet rs) throws Exception {
        Stan stan = new Stan();
        try {
            while (rs.next()) {
                Lokacija lokacija = new Lokacija();
                lokacija.setPttBroj(rs.getLong("pttBroj"));
                lokacija.setNaziv(rs.getString("naziv"));

                int stanID = rs.getInt("stanID");
                double kvadratura = rs.getDouble("kvadratura");
                int brojSoba = rs.getInt("brojSoba");
                int sprat = rs.getInt("sprat");

                stan = new Stan(stanID, kvadratura, brojSoba, sprat, lokacija);
            }
            return stan;
        } catch (Exception ex) {
            throw new Exception("Greska prilikom punjenja objekta iz baze!");
        }
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
        if(rs.next()){
            int stanID = rs.getInt(1);
            this.stanID = stanID;
        }
    }

}
