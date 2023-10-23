/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package view.form;

import domen.Lokacija;
import domen.Stan;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import klijent.komunikacija.Communication;
import komunikacija.Operations;
import komunikacija.Request;
import komunikacija.Response;
import kontroler.Kontroler;

/**
 *
 * @author Alek
 */
public class FrmNoviStan extends javax.swing.JDialog {

    /**
     * Creates new form FrmNoviStan
     */
    public FrmNoviStan(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
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

        lblKvadratura = new javax.swing.JLabel();
        txtKvadratura = new javax.swing.JTextField();
        lblBrojSoba = new javax.swing.JLabel();
        txtBrojSoba = new javax.swing.JTextField();
        lblSprat = new javax.swing.JLabel();
        txtSprat = new javax.swing.JTextField();
        lblLokacija = new javax.swing.JLabel();
        cmbLokacija = new javax.swing.JComboBox<>();
        btnDodaj = new javax.swing.JButton();
        lblErrorKvadratura = new javax.swing.JLabel();
        lblErrorBrojSoba = new javax.swing.JLabel();
        lblErrorSprat = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Dodavanje novog stana");

        lblKvadratura.setText("Kvadratura:");

        lblBrojSoba.setText("Broj soba:");

        lblSprat.setText("Sprat:");

        lblLokacija.setText("Lokacija:");

        cmbLokacija.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        btnDodaj.setText("Dodaj stan");
        btnDodaj.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDodajActionPerformed(evt);
            }
        });

        lblErrorKvadratura.setForeground(new java.awt.Color(255, 0, 0));
        lblErrorKvadratura.setText("jLabel1");

        lblErrorBrojSoba.setForeground(new java.awt.Color(255, 0, 0));
        lblErrorBrojSoba.setText("jLabel1");

        lblErrorSprat.setForeground(new java.awt.Color(255, 0, 0));
        lblErrorSprat.setText("jLabel1");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblErrorSprat)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(btnDodaj)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lblLokacija, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(cmbLokacija, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lblKvadratura, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(txtKvadratura))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(lblBrojSoba, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(txtBrojSoba))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(lblSprat, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(txtSprat, javax.swing.GroupLayout.PREFERRED_SIZE, 218, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addComponent(lblErrorKvadratura, javax.swing.GroupLayout.Alignment.LEADING))
                    .addComponent(lblErrorBrojSoba))
                .addContainerGap(28, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(46, 46, 46)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblKvadratura)
                    .addComponent(txtKvadratura, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(12, 12, 12)
                .addComponent(lblErrorKvadratura)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblBrojSoba)
                    .addComponent(txtBrojSoba, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(12, 12, 12)
                .addComponent(lblErrorBrojSoba)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblSprat)
                    .addComponent(txtSprat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(12, 12, 12)
                .addComponent(lblErrorSprat)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblLokacija)
                    .addComponent(cmbLokacija, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 56, Short.MAX_VALUE)
                .addComponent(btnDodaj)
                .addGap(47, 47, 47))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnDodajActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDodajActionPerformed
        try {
            if (validateForm()) {
                return;
            }
            Stan stan = new Stan();
            stan.setKvadratura(Double.parseDouble(txtKvadratura.getText().trim()));
            stan.setBrojSoba(Integer.parseInt(txtBrojSoba.getText().trim()));
            stan.setSprat(Integer.parseInt(txtSprat.getText().trim()));
            stan.setLokacija((Lokacija) cmbLokacija.getSelectedItem());

            Kontroler.getInstance().dodajStan(stan);
            JOptionPane.showMessageDialog(this, "Stan uspesno sacuvan!");
            txtBrojSoba.setText("");
            txtKvadratura.setText("");
            txtSprat.setText("");
        } catch (Exception ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(this, "Greska: \n" + ex.getMessage(), "Greska", JOptionPane.ERROR_MESSAGE);

        }
    }//GEN-LAST:event_btnDodajActionPerformed

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnDodaj;
    private javax.swing.JComboBox<Object> cmbLokacija;
    private javax.swing.JLabel lblBrojSoba;
    private javax.swing.JLabel lblErrorBrojSoba;
    private javax.swing.JLabel lblErrorKvadratura;
    private javax.swing.JLabel lblErrorSprat;
    private javax.swing.JLabel lblKvadratura;
    private javax.swing.JLabel lblLokacija;
    private javax.swing.JLabel lblSprat;
    private javax.swing.JTextField txtBrojSoba;
    private javax.swing.JTextField txtKvadratura;
    private javax.swing.JTextField txtSprat;
    // End of variables declaration//GEN-END:variables

    private void srediFormu() throws Exception {
        popuniComboLokacija();
        lblErrorBrojSoba.setVisible(false);
        lblErrorKvadratura.setVisible(false);
        lblErrorSprat.setVisible(false);
    }

    private void popuniComboLokacija() throws Exception {
        cmbLokacija.removeAllItems();

        ArrayList<Lokacija> lokacije = (ArrayList<Lokacija>) Kontroler.getInstance().getLokacije();
        for (Lokacija lokacija : lokacije) {
            cmbLokacija.addItem(lokacija);
        }

    }

    private boolean validateForm() {
        boolean flag = false;
        if (txtKvadratura.getText().trim().isEmpty()) {
            flag = true;
            lblErrorKvadratura.setText("Morate uneti kvadraturu stana!");
            lblErrorKvadratura.setVisible(true);
        }
        if (txtBrojSoba.getText().trim().isEmpty()) {
            flag = true;
            lblErrorBrojSoba.setText("Morate uneti broj soba stana!");
            lblErrorBrojSoba.setVisible(true);
        }
        if (txtSprat.getText().trim().isEmpty()) {
            flag = true;
            lblErrorSprat.setText("Morate uneti sprat stana!");
            lblErrorSprat.setVisible(true);
        }

        return flag;
    }

}
