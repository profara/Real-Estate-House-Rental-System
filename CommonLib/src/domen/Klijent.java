/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package domen;

import domen.pomocni.OpstiDomenskiObjekat;
import java.io.Serializable;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Objects;

/**
 *
 * @author Alek
 */
public class Klijent implements Serializable, OpstiDomenskiObjekat {

    private String JMBG;
    private String ime;
    private String prezime;
    private String email;
    private String adresa;

    public Klijent() {
    }

    public Klijent(String JMBG, String ime, String prezime, String email, String adresa) {
        this.JMBG = JMBG;
        this.ime = ime;
        this.prezime = prezime;
        this.email = email;
        this.adresa = adresa;
    }

    public String getJMBG() {
        return JMBG;
    }

    public void setJMBG(String JMBG) {
        this.JMBG = JMBG;
    }

    public String getIme() {
        return ime;
    }

    public void setIme(String ime) {
        this.ime = ime;
    }

    public String getPrezime() {
        return prezime;
    }

    public void setPrezime(String prezime) {
        this.prezime = prezime;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAdresa() {
        return adresa;
    }

    public void setAdresa(String adresa) {
        this.adresa = adresa;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 31 * hash + Objects.hashCode(this.JMBG);
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
        final Klijent other = (Klijent) obj;
        return Objects.equals(this.JMBG, other.JMBG);
    }

    @Override
    public String toString() {
        return ime + " " + prezime;
    }

    @Override
    public String vratiVrednostiAtributa() {
        return (JMBG == null ? null : "'" + JMBG + "'") + ", " + (ime == null ? null : "'" + ime + "'") + ", " + (prezime == null ? null : "'" + prezime + "'") + ", " + (email == null ? null : "'" + email + "'") + ", " + (adresa == null ? null : "'" + adresa + "'");
    }

    @Override
    public String postaviVrednostAtributa() {
        return "jmbg=" + (JMBG == null ? null : "'" + JMBG + "'") + ", ime=" + (ime == null ? null : "'" + ime + "'") + ", prezime=" + (prezime == null ? null : "'" + prezime + "'") + ", email=" + (email == null ? null : "'" + email + "'") + ", adresa=" + (adresa == null ? null : "'" + adresa + "'");
    }

    @Override
    public String vratiImeKlase() {
        return Klijent.class.getSimpleName();
    }

    @Override
    public String vratiUslovZaNadjiSlog() {
        return "jmbg=" + "'" + JMBG + "'";
    }

    @Override
    public String vratiUslovZaNadjiSlogove() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public OpstiDomenskiObjekat napuni(ResultSet rs) throws Exception {
        Klijent k = new Klijent();
        try {
            while (rs.next()) {
                k.setJMBG(rs.getString("jmbg"));
                k.setIme(rs.getString("ime"));
                k.setPrezime(rs.getString("prezime"));
                k.setEmail(rs.getString("email"));
                k.setAdresa(rs.getString("adresa"));
            }
            return k;
        } catch (Exception ex) {
            throw new Exception("Greska prilikom punjenja objekta iz baze!");
        }
    }

    @Override
    public ArrayList<OpstiDomenskiObjekat> napuniSve(ResultSet rs) throws Exception {
        ArrayList<OpstiDomenskiObjekat> lista = new ArrayList<>();
        try {
            while (rs.next()) {
                Klijent k = new Klijent();
                k.setJMBG(rs.getString("jmbg"));
                k.setIme(rs.getString("ime"));
                k.setPrezime(rs.getString("prezime"));
                k.setEmail(rs.getString("email"));
                k.setAdresa(rs.getString("adresa"));
                
                lista.add(k);
            }
            return lista;
        } catch (Exception ex) {
            throw new Exception("Greska prilikom punjenja objekta iz baze!");
        }
    }

    @Override
    public String vratiTabeluSaUslovomSpajanja() {
        return "";
    }

    @Override
    public String vratiKoloneTabele() {
        return "jmbg, ime, prezime, email, adresa";
    }

    @Override
    public void postaviKljuc(ResultSet rs) throws Exception {
        return;
    }

}
