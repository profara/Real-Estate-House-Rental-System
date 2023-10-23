/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package domen;

import domen.pomocni.OpstiDomenskiObjekat;
import java.io.Serializable;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;
import java.util.Objects;

/**
 *
 * @author Alek
 */
public class Izdavanje implements Serializable, OpstiDomenskiObjekat {

    private Date datumOD;
    private Date datumDO;
    private String vreme;
    private Stan stan;
    private PotvrdaOIzdavanju potvrda;

    public Izdavanje() {
    }

    public Izdavanje(Date datumOD, Date datumDO, String vreme, Stan stan, PotvrdaOIzdavanju potvrda) {
        this.datumOD = datumOD;
        this.datumDO = datumDO;
        this.vreme = vreme;
        this.stan = stan;
        this.potvrda = potvrda;
    }

    public Date getDatumOD() {
        return datumOD;
    }

    public void setDatumOD(Date datumOD) {
        this.datumOD = datumOD;
    }

    public Date getDatumDO() {
        return datumDO;
    }

    public void setDatumDO(Date datumDO) {
        this.datumDO = datumDO;
    }

    public String getVreme() {
        return vreme;
    }

    public void setVreme(String vreme) {
        this.vreme = vreme;
    }

    public PotvrdaOIzdavanju getPotvrda() {
        return potvrda;
    }

    public void setPotvrda(PotvrdaOIzdavanju potvrda) {
        this.potvrda = potvrda;
    }

    public Stan getStan() {
        return stan;
    }

    public void setStan(Stan stan) {
        this.stan = stan;
    }

    @Override
    public String toString() {
        return "Datum od: " + datumOD + "Datum do: " + datumDO + "Vreme: " + vreme;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 59 * hash + Objects.hashCode(this.datumOD);
        hash = 59 * hash + Objects.hashCode(this.datumDO);
        hash = 59 * hash + Objects.hashCode(this.vreme);
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
        final Izdavanje other = (Izdavanje) obj;
        if (!Objects.equals(this.vreme, other.vreme)) {
            return false;
        }
        if (!Objects.equals(this.datumOD, other.datumOD)) {
            return false;
        }
        return Objects.equals(this.datumDO, other.datumDO);
    }

    @Override
    public String vratiVrednostiAtributa() {
        return stan.getStanID() + ", " + potvrda.getPotvrdaID() + ", " + (datumOD == null ? null : "'" + new java.sql.Date(datumOD.getTime()) + "'") + ", " + (datumDO == null ? null : "'" + new java.sql.Date(datumDO.getTime()) + "'") + ", " + (vreme == null ? null : "'" + vreme + "'");
    }

    @Override
    public String postaviVrednostAtributa() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public String vratiImeKlase() {
        return Izdavanje.class.getSimpleName();
    }

    @Override
    public String vratiUslovZaNadjiSlog() {
        return " potvrdaID = " +  (potvrda == null ? null : potvrda.getPotvrdaID());
    }

    @Override
    public String vratiUslovZaNadjiSlogove() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public OpstiDomenskiObjekat napuni(ResultSet rs) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public ArrayList<OpstiDomenskiObjekat> napuniSve(ResultSet resultSet) throws Exception {
        ArrayList<OpstiDomenskiObjekat> lista = new ArrayList<>();

        while (resultSet.next()) {
            Izdavanje izdavanje = new Izdavanje();
            izdavanje.setDatumDO(new java.sql.Date(resultSet.getDate("i.datumDO").getTime()));
            izdavanje.setDatumOD(new java.sql.Date(resultSet.getDate("i.datumOD").getTime()));

            izdavanje.setVreme(resultSet.getString("i.vreme"));

            PotvrdaOIzdavanju potvrda = new PotvrdaOIzdavanju();
            potvrda.setPotvrdaID(resultSet.getInt("i.potvrdaID"));
            potvrda.setCena(resultSet.getDouble("p.cena"));

            Klijent k = new Klijent();
            k.setJMBG(resultSet.getString("k.jmbg"));
            k.setPrezime(resultSet.getString("k.prezime"));
            k.setIme(resultSet.getString("k.ime"));
            k.setAdresa(resultSet.getString("k.adresa"));
            k.setEmail(resultSet.getString("k.email"));

            potvrda.setKlijent(k);

            izdavanje.setPotvrda(potvrda);

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

            lista.add(izdavanje);

        }
        return lista;
    }

    @Override
    public String vratiTabeluSaUslovomSpajanja() {
        return " i JOIN stan s ON i.stanID = s.stanID JOIN lokacija l on s.pttBroj = l.pttBroj JOIN potvrdaoizdavanju p ON i.potvrdaID = p.potvrdaID JOIN klijent k ON p.jmbg = k.jmbg";
    }

    @Override
    public String vratiKoloneTabele() {
        return "stanID, potvrdaID, datumOD, datumDO, vreme";
    }

    @Override
    public void postaviKljuc(ResultSet rs) throws Exception {
        return;
    }

}
