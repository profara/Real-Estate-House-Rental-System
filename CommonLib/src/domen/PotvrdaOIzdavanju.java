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
public class PotvrdaOIzdavanju implements Serializable, OpstiDomenskiObjekat {

    private int potvrdaID;
    private double cena;
    private List<Izdavanje> izdavanja;
    private Klijent klijent;

    public PotvrdaOIzdavanju() {
    }

    public PotvrdaOIzdavanju(int potvrdaID, double cena, List<Izdavanje> izdavanja, Klijent klijent) {
        this.potvrdaID = potvrdaID;
        this.cena = cena;
        this.izdavanja = izdavanja;
        this.klijent = klijent;
    }

    public PotvrdaOIzdavanju(double cena, List<Izdavanje> izdavanja, Klijent klijent) {
        this.cena = cena;
        this.izdavanja = izdavanja;
        this.klijent = klijent;
    }

    public int getPotvrdaID() {
        return potvrdaID;
    }

    public void setPotvrdaID(int potvrdaID) {
        this.potvrdaID = potvrdaID;
    }

    public double getCena() {
        return cena;
    }

    public void setCena(double cena) {
        this.cena = cena;
    }

    public List<Izdavanje> getIzdavanja() {
        return izdavanja;
    }

    public void setIzdavanja(List<Izdavanje> izdavanja) {
        this.izdavanja = izdavanja;
    }

    public Klijent getKlijent() {
        return klijent;
    }

    public void setKlijent(Klijent klijent) {
        this.klijent = klijent;
    }

    @Override
    public String toString() {
        return "Potvrda o izdavanju: " + potvrdaID + "Cena: " + cena + "Klijent: " + klijent;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 67 * hash + this.potvrdaID;
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
        final PotvrdaOIzdavanju other = (PotvrdaOIzdavanju) obj;
        return this.potvrdaID == other.potvrdaID;
    }

    @Override
    public String vratiVrednostiAtributa() {
        return cena + ", " + (klijent == null ? null : "'" + klijent.getJMBG() + "'");
    }

    @Override
    public String postaviVrednostAtributa() {
        return "cena = " + cena + ",jmbg = " + (klijent == null ? null : "'" + klijent.getJMBG() + "'");
    }

    @Override
    public String vratiImeKlase() {
        return PotvrdaOIzdavanju.class.getSimpleName();
    }

    @Override
    public String vratiUslovZaNadjiSlog() {
        return "potvrdaID = " + potvrdaID;
    }

    @Override
    public String vratiUslovZaNadjiSlogove() {
        return "p.jmbg = " + klijent.getJMBG();
    }

    @Override
    public OpstiDomenskiObjekat napuni(ResultSet rs) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public ArrayList<OpstiDomenskiObjekat> napuniSve(ResultSet rs) throws Exception {
        ArrayList<OpstiDomenskiObjekat> potvrde = new ArrayList<>();
        try {
            while (rs.next()) {
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

                potvrde.add(potvrda);
            }
            return potvrde;
        } catch (Exception ex) {
            throw new Exception("Greska prilikom uzimanja vrednosti iz baze!");
        }
    }

    @Override
    public String vratiTabeluSaUslovomSpajanja() {
        return " p JOIN klijent k ON p.jmbg = k.jmbg";
    }

    @Override
    public String vratiKoloneTabele() {
        return "cena, jmbg";
    }

    @Override
    public void postaviKljuc(ResultSet rs) throws Exception{
        if(rs.next()){
            int potvrdaID = rs.getInt(1);
            this.potvrdaID = potvrdaID;
        }
    }

}
