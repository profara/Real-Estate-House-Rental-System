/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modeliTabele;

import domen.Izdavanje;
import domen.Klijent;
import domen.Stan;
import java.util.Date;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Alek
 */
public class TableModelTermini extends AbstractTableModel {

    private List<Izdavanje> izdavanja;
    private String[] naziviKolona = {"Klijent", "Stan", "Datum od", "Datum do"};
    private Class[] klaseKolona = {Klijent.class, Stan.class, Date.class, Date.class};
    
    public TableModelTermini(List<Izdavanje> izdavanja){
        this.izdavanja = izdavanja;
    }

    @Override
    public int getRowCount() {
        return izdavanja.size();
    }

    @Override
    public int getColumnCount() {
        return naziviKolona.length;
    }

    @Override
    public String getColumnName(int column) {
        return naziviKolona[column];
    }

    @Override
    public Class<?> getColumnClass(int columnIndex) {
        return klaseKolona[columnIndex];
    }
    
    
    
    

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Izdavanje izdavanje = izdavanja.get(rowIndex);

        switch (columnIndex) {
            case 0:
                return izdavanje.getPotvrda().getKlijent();
            case 1:
                return izdavanje.getStan();
            case 2:
                return izdavanje.getDatumOD();
            case 3:
                return izdavanje.getDatumDO();
            default:
                return "N/A";
        }
    }

    public void obrisiTermin(int index) {
        izdavanja.remove(index);
        
        fireTableDataChanged();
    }

}
