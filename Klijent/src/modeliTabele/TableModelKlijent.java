/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modeliTabele;

import domen.Klijent;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Alek
 */
public class TableModelKlijent extends AbstractTableModel{
    
    private List<Klijent> klijenti;
    private String[] naziviKolona = {"JMBG", "Ime", "Prezime", "Email", "Adresa"};
    private Class[] klaseKolona = {String.class, String.class, String.class, String.class, String.class};
    
    public TableModelKlijent(List<Klijent> klijenti){
        this.klijenti = klijenti;
    }

    @Override
    public int getRowCount() {
        return klijenti.size();
    }

    @Override
    public int getColumnCount() {
        return naziviKolona.length;
    }

    @Override
    public String getColumnName(int column) {
        if(column > naziviKolona.length){
            return "N/A";
        }
        return naziviKolona[column];
    }

    @Override
    public Class<?> getColumnClass(int columnIndex) {
        if(columnIndex > klaseKolona.length){
            return Object.class;
        }
        return klaseKolona[columnIndex];
    }
    

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Klijent k = klijenti.get(rowIndex);
        
        switch(columnIndex){
            case 0:
                return k.getJMBG();
            case 1:
                return k.getIme();
            case 2:
                return k.getPrezime();
            case 3:
                return k.getEmail();
            case 4:
                return k.getAdresa();
            default:
                return "N/A";
        }
    }

    public List<Klijent> getKlijenti() {
        return klijenti;
    }

    public void setKlijenti(List<Klijent> klijenti) {
        this.klijenti = klijenti;
    }
    
    
    
}
