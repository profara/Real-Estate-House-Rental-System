/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modeliTabele;

import domen.Lokacija;
import domen.Stan;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Alek
 */
public class TableModelStan extends AbstractTableModel {

    private List<Stan> stanovi;
    private String[] naziviKolona = {"Kvadratura", "Broj soba", "Sprat", "Lokacija"};
    private Class[] klaseKolona = {Double.class, Integer.class, Integer.class, Lokacija.class};

    public TableModelStan(List<Stan> stanovi) {
        this.stanovi = stanovi;
    }

    @Override
    public int getRowCount() {
        if(stanovi == null)
            return 0;
        return stanovi.size();
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
        Stan stan = stanovi.get(rowIndex);
        switch(columnIndex){
            case 0:
                return stan.getKvadratura();
            case 1:
                return stan.getBrojSoba();
            case 2:
                return stan.getSprat();
            case 3:
                return stan.getLokacija();
            default:
                return "N/A";
        }
        
    }

    

    public List<Stan> getStanovi() {
        return stanovi;
    }

    public void setStanovi(List<Stan> stanovi) {
        this.stanovi = stanovi;
    }
    
    
    
    
    

}
