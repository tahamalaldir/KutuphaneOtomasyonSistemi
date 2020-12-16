


public class AdminPanel extends javax.swing.JFrame {
    
    /**
     * Creates new form AdminPanel
     */
    String LoginUser;
    public AdminPanel() {
        initComponents();
    }
    public AdminPanel(String loginUser)
        {
            initComponents();
            this.LoginUser=loginUser;
            String getValue=ShowAdmin.getText();
            ShowAdmin.setText("Hoşgeldin "+loginUser);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        KitapIslemleri = new javax.swing.JButton();
        PersonelIslemleri = new javax.swing.JButton();
        UyeIslemleri = new javax.swing.JButton();
        Logout = new javax.swing.JButton();
        ShowAdmin = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Admin Panel");
        setLocation(new java.awt.Point(450, 100));
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowActivated(java.awt.event.WindowEvent evt) {
                formWindowActivated(evt);
            }
        });

        KitapIslemleri.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/book.png"))); // NOI18N
        KitapIslemleri.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                KitapIslemleriActionPerformed(evt);
            }
        });

        PersonelIslemleri.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/personel.png"))); // NOI18N
        PersonelIslemleri.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PersonelIslemleriActionPerformed(evt);
            }
        });

        UyeIslemleri.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/uye.png"))); // NOI18N

        Logout.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/logout_red.png"))); // NOI18N
        Logout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LogoutActionPerformed(evt);
            }
        });

        ShowAdmin.setText("jLabel1");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(50, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(KitapIslemleri, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(UyeIslemleri, javax.swing.GroupLayout.Alignment.TRAILING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(PersonelIslemleri)
                    .addComponent(Logout))
                .addGap(50, 50, 50))
            .addGroup(layout.createSequentialGroup()
                .addGap(83, 83, 83)
                .addComponent(ShowAdmin)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(ShowAdmin)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(KitapIslemleri)
                    .addComponent(PersonelIslemleri))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(UyeIslemleri)
                    .addComponent(Logout))
                .addContainerGap(50, Short.MAX_VALUE))
        );

        ShowAdmin.getAccessibleContext().setAccessibleName("ShowAdmin");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void LogoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LogoutActionPerformed
        dispose();
        Login login = new Login ();
        login.setVisible(true);
    }//GEN-LAST:event_LogoutActionPerformed

    private void PersonelIslemleriActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PersonelIslemleriActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_PersonelIslemleriActionPerformed

    private void KitapIslemleriActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_KitapIslemleriActionPerformed
           dispose();
        KitapIslemleri kitapislemleri = new KitapIslemleri();
        kitapislemleri.setVisible(true);
        
    }//GEN-LAST:event_KitapIslemleriActionPerformed

    private void formWindowActivated(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowActivated
       
    }//GEN-LAST:event_formWindowActivated
    
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
            java.util.logging.Logger.getLogger(AdminPanel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AdminPanel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AdminPanel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AdminPanel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AdminPanel().setVisible(true);
                ShowAdmin.setText("naber");
                
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton KitapIslemleri;
    private javax.swing.JButton Logout;
    private javax.swing.JButton PersonelIslemleri;
    private static javax.swing.JLabel ShowAdmin;
    private javax.swing.JButton UyeIslemleri;
    // End of variables declaration//GEN-END:variables
}