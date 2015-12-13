/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vektorel.kutuphane.semaruken.gui;

import com.vektorel.kutuphane.semaruken.entity.KisiOdunc;
import com.vektorel.kutuphane.semaruken.entity.Kullanici;
import com.vektorel.kutuphane.semaruken.service.KisiOduncService;
import java.util.Date;
import java.util.List;

/**
 *
 * @author vektorel
 */
public class frmAnaSayfa extends javax.swing.JFrame {

    KisiOduncService kisiOduncService = new KisiOduncService();
    public static Kullanici aktifKullanici;

    /**
     * Creates new form frmAnaSayfa
     */
    public frmAnaSayfa(Kullanici kullanici) {
        initComponents();
        aktifKullanici = kullanici;
        lblHost.setText("Hoşgeldiniz" + kullanici.getUsername());
        tabloDoldur();
    }

   

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tblOdunc = new javax.swing.JTable();
        btnOdunc = new javax.swing.JButton();
        btnTeslim = new javax.swing.JButton();
        lblHost = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        tblOdunc.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(tblOdunc);

        btnOdunc.setText("Ödünç Ver");
        btnOdunc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnOduncActionPerformed(evt);
            }
        });

        btnTeslim.setText("Kitap teslim");
        btnTeslim.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTeslimActionPerformed(evt);
            }
        });

        jMenu1.setText("İşlemler");

        jMenuItem1.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_K, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem1.setText("Kişi işlemleri");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem1);

        jMenuItem2.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_B, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem2.setText("Kitap İşlemleri");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem2);

        jMenuBar1.add(jMenu1);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 466, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnTeslim)
                .addGap(30, 30, 30)
                .addComponent(btnOdunc)
                .addContainerGap())
            .addComponent(lblHost, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 247, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnTeslim)
                    .addComponent(btnOdunc))
                .addGap(18, 18, 18)
                .addComponent(lblHost, javax.swing.GroupLayout.DEFAULT_SIZE, 20, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnOduncActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOduncActionPerformed
            dlgOduncVer oduncVer=new dlgOduncVer(this, true);
            oduncVer.show();
            tabloDoldur();
    }//GEN-LAST:event_btnOduncActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void btnTeslimActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTeslimActionPerformed
        int rowId = tblOdunc.getSelectedRow();
        if (rowId != -1) {
            Long id = Long.valueOf(tblOdunc.getValueAt(rowId, 0).toString());
            KisiOdunc kisiOdunc = kisiOduncService.getById(id);
            kisiOdunc.setTeslimAlindi(Boolean.TRUE);
            kisiOdunc.setTeslimTarihi(new Date());
            kisiOdunc.setUpdtr(aktifKullanici.getUsername());
            kisiOdunc.setUpdtm(new Date());
            kisiOduncService.update(kisiOdunc);
            tabloDoldur();


        }
    }//GEN-LAST:event_btnTeslimActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        dlgKisiIslemleri islemleri=new dlgKisiIslemleri(this, true);
        islemleri.show();
    }//GEN-LAST:event_jMenuItem1ActionPerformed
    /**
     * @param args the command line arguments
     */
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnOdunc;
    private javax.swing.JButton btnTeslim;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblHost;
    private javax.swing.JTable tblOdunc;
    // End of variables declaration//GEN-END:variables

    private void tabloDoldur() {
        try {
            String[] header = new String[5];
            header[0] = "No";
            header[1] = "Ad Soyad";
            header[2] = "Kitap Adı";
            header[3] = "Ödünç Tarihi";
            header[4] = "Teslim Alındı";

            List<KisiOdunc> koList = kisiOduncService.getAll();
            String[][] data = new String[koList.size()][5];
            for (int i = 0; i < koList.size(); i++) {
                data[i][0] = String.valueOf(koList.get(i).getId());
                data[i][1] = koList.get(i).getKisi().getAdi() + " " + koList.get(i).getKisi().getSoyadi();
                data[i][2] = koList.get(i).getKitap().getKitapAdi();
                if(koList.get(i).getAlisTarihi()!=null)
                    data[i][3] = koList.get(i).getAlisTarihi().toLocaleString();
                if (koList.get(i).getTeslimAlindi() != null && koList.get(i).getTeslimAlindi()) {
                    data[i][4] = "evet";
                } else {
                    data[i][4] = "hayır";
                }

            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
