/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package formdenemesi;

import javax.swing.JOptionPane;

/**
 *
 * @author Sefa
 */
public class HesapMakinesi extends javax.swing.JFrame {

    /**
     * Creates new form HesapMakinesi
     */
    public HesapMakinesi() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        BirinciSayi = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        İkinciSayi = new javax.swing.JTextField();
        toplamButon = new javax.swing.JButton();
        CıkarmaButon = new javax.swing.JButton();
        SonucLabel = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        BirinciSayi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BirinciSayiActionPerformed(evt);
            }
        });

        jLabel1.setText("Birinci sayı");

        jLabel2.setText("İkinci sayısı");

        toplamButon.setText("+");
        toplamButon.setToolTipText("add");
        toplamButon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                toplamButonActionPerformed(evt);
            }
        });

        CıkarmaButon.setText("-");
        CıkarmaButon.setToolTipText("subtract");
        CıkarmaButon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CıkarmaButonActionPerformed(evt);
            }
        });

        SonucLabel.setFont(new java.awt.Font("Yu Gothic UI", 2, 18)); // NOI18N
        SonucLabel.setText("Cevap : ");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(57, 57, 57)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(BirinciSayi)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2)
                            .addComponent(İkinciSayi, javax.swing.GroupLayout.DEFAULT_SIZE, 159, Short.MAX_VALUE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(49, 49, 49)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(SonucLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(toplamButon)
                                .addGap(18, 18, 18)
                                .addComponent(CıkarmaButon)))))
                .addContainerGap(184, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(42, 42, 42)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(BirinciSayi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(İkinciSayi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(toplamButon)
                    .addComponent(CıkarmaButon))
                .addGap(18, 18, 18)
                .addComponent(SonucLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(58, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void BirinciSayiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BirinciSayiActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_BirinciSayiActionPerformed

    private void toplamButonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_toplamButonActionPerformed
        int sayi1 = 0, sayi2 = 0;
        try{
             sayi1 = Integer.parseInt(
                this.BirinciSayi.getText());
        }catch(Exception e){
            JOptionPane.showMessageDialog(this, "hatalı giriş", "hata", JOptionPane.ERROR_MESSAGE);
        }
        
        
        try{
             sayi2 = Integer.parseInt(
                this.İkinciSayi.getText());
        }catch(Exception e){
            JOptionPane.showMessageDialog(this, "hatalı giriş", "hata", JOptionPane.ERROR_MESSAGE);
        }
        int toplam = sayi1 + sayi2;
        
        this.SonucLabel.setText("sonuc" + toplam);
        
    }//GEN-LAST:event_toplamButonActionPerformed

    private void CıkarmaButonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CıkarmaButonActionPerformed
        int sayi1 = 0, sayi2 = 0;
        try {
            sayi1 = Integer.parseInt(
                    this.BirinciSayi.getText());
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "hatalı giriş", "hata", JOptionPane.ERROR_MESSAGE);
        }

        try {
            sayi2 = Integer.parseInt(
                    this.İkinciSayi.getText());
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "hatalı giriş", "hata", JOptionPane.ERROR_MESSAGE);
        }
        int sonuc = sayi1 - sayi2;

        this.SonucLabel.setText("sonuc" + sonuc);

    }//GEN-LAST:event_CıkarmaButonActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(HesapMakinesi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(HesapMakinesi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(HesapMakinesi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(HesapMakinesi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new HesapMakinesi().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField BirinciSayi;
    private javax.swing.JButton CıkarmaButon;
    private javax.swing.JLabel SonucLabel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JButton toplamButon;
    private javax.swing.JTextField İkinciSayi;
    // End of variables declaration//GEN-END:variables
}
