/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package view.form;


import domen.Klijent;
import java.awt.Frame;
import java.util.ArrayList;
import java.util.List;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import kontroler.Kontroler;
import modeliTabele.TableModelKlijent;

/**
 *
 * @author Alek
 */
public class FrmPretragaKlijenata extends javax.swing.JDialog {

    private List<Klijent> klijenti;
    private Frame parent;

    /**
     * Creates new form FrmPretragaKlijenata
     */
    public FrmPretragaKlijenata(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        this.parent = parent;
        setLocationRelativeTo(parent);
        try {
            srediFormu();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Error in view initialization: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblPretraziJMBG = new javax.swing.JLabel();
        txtJMBG = new javax.swing.JTextField();
        btnPretrazi = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblKlijenti = new javax.swing.JTable();
        btnIzmeni = new javax.swing.JButton();
        btnObrisi = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Pretrazi klijenta");

        lblPretraziJMBG.setText("Pretrazi po JMBG-u:");

        btnPretrazi.setText("Pretrazi");
        btnPretrazi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPretraziActionPerformed(evt);
            }
        });

        tblKlijenti.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(tblKlijenti);

        btnIzmeni.setText("Izmeni");
        btnIzmeni.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnIzmeniActionPerformed(evt);
            }
        });

        btnObrisi.setText("Obrisi");
        btnObrisi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnObrisiActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblPretraziJMBG, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(txtJMBG))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 681, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 15, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnPretrazi, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnIzmeni, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnObrisi, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblPretraziJMBG)
                    .addComponent(txtJMBG, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnPretrazi))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(31, 31, 31)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 341, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(62, 62, 62)
                        .addComponent(btnIzmeni)
                        .addGap(18, 18, 18)
                        .addComponent(btnObrisi)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnPretraziActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPretraziActionPerformed
        String jmbg = txtJMBG.getText().trim();

        try {
            Klijent k = Kontroler.getInstance().getKlijentById(jmbg);
            klijenti = new ArrayList<>();
            klijenti.add(k);

            TableModelKlijent tmk = (TableModelKlijent) tblKlijenti.getModel();
            tmk.setKlijenti(klijenti);
            tmk.fireTableDataChanged();
        } catch (Exception ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(this, "Neuspesna pretraga klijenta: " + ex.getMessage(), "Greska", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnPretraziActionPerformed

    private void btnObrisiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnObrisiActionPerformed
        int selected = tblKlijenti.getSelectedRow();

        if (selected != -1) {
            Klijent k = klijenti.get(selected);
            try {
                Kontroler.getInstance().obrisiKlijenta(k);
                osveziTabelu(selected);
                JOptionPane.showMessageDialog(this, "Uspesno obrisan klijent!", "Potvrda", JOptionPane.INFORMATION_MESSAGE);
            } catch (Exception ex) {
                ex.printStackTrace();
                JOptionPane.showMessageDialog(this, "Izabrani klijent je vezan za potvrdu!", "Greska", JOptionPane.ERROR_MESSAGE);

            }
        } else {
            JOptionPane.showMessageDialog(this, "Morate odabrati klijenta!", "Greska", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnObrisiActionPerformed

    private void btnIzmeniActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIzmeniActionPerformed
        int selected = tblKlijenti.getSelectedRow();

        if (selected != -1) {
            Klijent k = klijenti.get(selected);
            FrmIzmenaKlijenta fik = new FrmIzmenaKlijenta(parent, true, k);
            fik.setVisible(true);
            osveziTabelu();

        }
    }//GEN-LAST:event_btnIzmeniActionPerformed

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnIzmeni;
    private javax.swing.JButton btnObrisi;
    private javax.swing.JButton btnPretrazi;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblPretraziJMBG;
    private javax.swing.JTable tblKlijenti;
    private javax.swing.JTextField txtJMBG;
    // End of variables declaration//GEN-END:variables

    private void srediFormu() throws Exception {
        postaviModel();

    }

    private void postaviModel() throws Exception {
        klijenti = new ArrayList<>();

        klijenti = Kontroler.getInstance().getKlijenti();
        System.out.println("Uspesno ucitana lista klijenata!");

        TableModelKlijent tmk = new TableModelKlijent(klijenti);
        tblKlijenti.setModel(tmk);
    }

    private void osveziTabelu(int index) {
        TableModelKlijent tmk = (TableModelKlijent) tblKlijenti.getModel();
        tmk.getKlijenti().remove(index);
        tmk.fireTableDataChanged();

    }

    private void osveziTabelu() {
        TableModelKlijent tmk = (TableModelKlijent) tblKlijenti.getModel();
        tmk.fireTableDataChanged();
    }
}