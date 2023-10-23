/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modeliTabele;

import domen.PotvrdaOIzdavanju;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Alek
 */
public class TableModelPotvrda extends AbstractTableModel {

    private List<PotvrdaOIzdavanju> potvrde;
    private String[] naziviKolona = {"ID", "Cena"};
    private Class[] klaseKolona = {Integer.class, Double.class};
    
    public TableModelPotvrda(List<PotvrdaOIzdavanju> potvrde){
        this.potvrde = potvrde;
    }

    @Override
    public int getRowCount() {
        return potvrde.size();
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
        PotvrdaOIzdavanju potvrda = potvrde.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return potvrda.getPotvrdaID();
            case 1:
                return potvrda.getCena();
                
                default:
                    return "N/A";
        }
    }

    public List<PotvrdaOIzdavanju> getPotvrde() {
        return potvrde;
    }

    public void setPotvrde(List<PotvrdaOIzdavanju> potvrde) {
        this.potvrde = potvrde;
    }
    
    

}
