
import Kitap.*;
import Uye.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemListener;
import java.sql.ResultSet;
import KutuphaneOtomasyon.DbHelper;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.util.ArrayList;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class KitapEmanetForm extends javax.swing.JFrame {

    DefaultTableModel model;

    public void deneme(JComboBox cb, Kitap k) {
        cb.addItem(k);
    }

    public void uyee(JComboBox cbx, Uye u) {
        cbx.addItem(u);
    }

    public void refreshTable() {
        Connection connection = null;
        DbHelper DbHelper = new DbHelper();
        Statement statement = null;
        ArrayList<Kitap> kitaplar = null;
        DeleteTable();
        try {
            connection = DbHelper.getConnection();
            statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM emanet INNER JOIN uye ON uye.uye_id = emanet.uye_id INNER JOIN kitap ON kitap.kitap_id = emanet.kitap_id");
            kitaplar = new ArrayList<Kitap>();
            while (resultSet.next()) {
                String emanet_id = resultSet.getString("id");
                String uye_ad = resultSet.getString("uye_ad");
                String uye_soyad = resultSet.getString("uye_soyad");
                String kitap_adi = resultSet.getString("kitap_adi");
                String kitap_yazari = resultSet.getString("kitap_yazari");
                String kitap_turu = resultSet.getString("kitap_turu");
                String teslim_tarih = resultSet.getString("teslim_tarih");

                Object[] row = {emanet_id, uye_ad, uye_soyad, kitap_adi, kitap_yazari, kitap_turu, teslim_tarih};
                model.addRow(row);
            }
        } catch (SQLException exception) {
            DbHelper.showErrorMessage(exception);
        }
    }

    public void DeleteTable() {
        model = (DefaultTableModel) EmanetTablo.getModel();
        model.setRowCount(0);
    }

    public void ClearTextBox() {
        kitap_id.setText("");
        kitap_ad.setText("");
        kitap_yazar.setText("");
        kitap_yayinevi.setText("");
        kitap_turu.setText("");
        uye_id.setText("");
        uye_ad.setText("");
        uye_soyad.setText("");
        uye_tel.setText("");
        teslim_tarihi.setText("2020-12-20");
    }

    public KitapEmanetForm() {
        initComponents();
        refreshTable();
        KitapIslemler kitapislem = new KitapIslemler();
        ArrayList<Kitap> kitaplist = kitapislem.Listele();
        UyeIslemler uyeislem = new UyeIslemler();
        ArrayList<Uye> uyelist = uyeislem.Listele();
        for (int i = 0; i < kitaplist.size(); i++) {
            Kitap temp = kitaplist.get(i);
            var item = new Kitap(temp.getId(), temp.getAd(), temp.getYazar(), temp.getYayinevi(), temp.getTur(), temp.getBarkod(), temp.getRafNo());
            deneme(KitapCombobox, item);
        }
        for (int x = 0; x < uyelist.size(); x++) {
            Uye uy = uyelist.get(x);
            var items = new Uye(uy.getId(), uy.getAd(), uy.getSoyad(), uy.getTel(), uy.getMail(), uy.getOkitap());
            uyee(UyeCombobox, items);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        EmanetTablo = new javax.swing.JTable();
        KitapCombobox = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        uye_ad = new javax.swing.JTextField();
        uye_soyad = new javax.swing.JTextField();
        uye_tel = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        kitap_ad = new javax.swing.JTextField();
        kitap_yazar = new javax.swing.JTextField();
        kitap_yayinevi = new javax.swing.JTextField();
        kitap_turu = new javax.swing.JTextField();
        emanet_ver = new javax.swing.JButton();
        UyeCombobox = new javax.swing.JComboBox<>();
        buton_getir = new javax.swing.JButton();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        uye_id = new javax.swing.JTextField();
        kitap_id = new javax.swing.JTextField();
        teslim_tarihi = new javax.swing.JFormattedTextField();
        jLabel14 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jSeparator2 = new javax.swing.JSeparator();
        jLabel15 = new javax.swing.JLabel();
        emanet_sil = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Kitap Emanet");
        setLocation(new java.awt.Point(300, 100));
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowActivated(java.awt.event.WindowEvent evt) {
                formWindowActivated(evt);
            }
        });

        EmanetTablo.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "Emanet ID", "Uye Adı", "Uye Soyadı", "Kitap Adı", "Kitap Yazarı", "Kitap Türü", "Teslim Tarihi"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(EmanetTablo);

        KitapCombobox.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                KitapComboboxİtemStateChanged(evt);
            }
        });
        KitapCombobox.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                KitapComboboxMouseClicked(evt);
            }
        });
        KitapCombobox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                KitapComboboxActionPerformed(evt);
            }
        });

        jLabel1.setText("Uye Seçimi");

        jLabel2.setText("Kitap Barkod No");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel3.setText("Uye Bilgileri");

        uye_ad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                uye_adActionPerformed(evt);
            }
        });

        jLabel4.setText("Üye Ad");

        jLabel5.setText("Üye Soyad");

        jLabel6.setText("Üye Telefon");

        jLabel7.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel7.setText("Kitap Bilgileri");

        jLabel8.setText("Kitap Adı");

        jLabel9.setText("Kitap Yazarı");

        jLabel10.setText("Kitap Yayınevi");

        jLabel11.setText("Kitap Türü");

        kitap_turu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                kitap_turuActionPerformed(evt);
            }
        });

        emanet_ver.setText("Emanet Ver");
        emanet_ver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                emanet_verActionPerformed(evt);
            }
        });

        UyeCombobox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                UyeComboboxActionPerformed(evt);
            }
        });

        buton_getir.setText("Getir");
        buton_getir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buton_getirActionPerformed(evt);
            }
        });

        jLabel12.setText("Üye ID");

        jLabel13.setText("Kitap ID");

        teslim_tarihi.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.DateFormatter(new java.text.SimpleDateFormat("y-MM-d"))));
        teslim_tarihi.setText("2020-12-20");

        jLabel14.setText("Teslim Tarihi");

        jLabel15.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel15.setText("Üye&Kitap Seçim");

        emanet_sil.setText("Sil");
        emanet_sil.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                emanet_silActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(59, 59, 59)
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(36, 36, 36)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel13, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel8, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel9, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel10, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel11, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(kitap_id, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(kitap_ad, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGap(41, 41, 41)
                                .addComponent(jSeparator2))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGap(34, 34, 34)
                                .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(teslim_tarihi, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(kitap_turu, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(kitap_yayinevi, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(kitap_yazar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(68, 68, 68)
                                .addComponent(emanet_ver, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(36, 36, 36)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(jLabel5)
                                            .addComponent(jLabel6)
                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(jLabel12)
                                                .addComponent(jLabel4)))
                                        .addGap(37, 37, 37)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(uye_ad, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(uye_soyad, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(uye_tel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(uye_id, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(7, 7, 7)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                                .addComponent(jLabel3)
                                                .addGap(29, 29, 29)))))))
                        .addGap(114, 114, 114)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(emanet_sil, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel1)
                                    .addComponent(UyeCombobox, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(29, 29, 29)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(KitapCombobox, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(buton_getir))
                                    .addComponent(jLabel2)))
                            .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 239, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 646, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap())))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(uye_id, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 9, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(6, 6, 6)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addComponent(uye_ad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(uye_soyad, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addGap(12, 12, 12)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(uye_tel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 9, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(6, 6, 6)))
                        .addComponent(jLabel7)
                        .addGap(5, 5, 5)
                        .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel13)
                            .addComponent(kitap_id, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel8)
                            .addComponent(kitap_ad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel9)
                            .addComponent(kitap_yazar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(19, 19, 19)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel10)
                            .addComponent(kitap_yayinevi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(21, 21, 21)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel11)
                            .addComponent(kitap_turu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(34, 34, 34)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(teslim_tarihi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel14))
                        .addGap(28, 28, 28))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel15)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(UyeCombobox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(KitapCombobox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(buton_getir))
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 376, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addComponent(emanet_ver, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(5, 5, 5)
                        .addComponent(emanet_sil, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void emanet_verActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_emanet_verActionPerformed

        Connection connection = null;
        DbHelper DbHelper = new DbHelper();
        PreparedStatement statement = null;
        try {
            String uyeid = uye_id.getText();
            String kitapid = kitap_id.getText();
            String teslim = teslim_tarihi.getText();
            if (uye_id.getText().isEmpty()) {
                JOptionPane.showMessageDialog(null, "Lütfen tüm alanları doldurunuz.");
            } else {
                connection = DbHelper.getConnection();
                String sql = "insert into emanet (uye_id, kitap_id, teslim_tarih) values(?,?,?)";
                statement = connection.prepareStatement(sql);
                statement.setString(1, String.valueOf(uyeid));
                statement.setString(2, String.valueOf(kitapid));
                statement.setString(3, String.valueOf(teslim));
                int result = statement.executeUpdate();
                refreshTable();
                ClearTextBox();
            }
        } catch (SQLException exception) {
            DbHelper.showErrorMessage(exception);
        }
    }//GEN-LAST:event_emanet_verActionPerformed

    private void formWindowActivated(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowActivated

    }//GEN-LAST:event_formWindowActivated

    private void KitapComboboxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_KitapComboboxActionPerformed

    }//GEN-LAST:event_KitapComboboxActionPerformed

    private void KitapComboboxİtemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_KitapComboboxİtemStateChanged

    }//GEN-LAST:event_KitapComboboxİtemStateChanged

    private void KitapComboboxMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_KitapComboboxMouseClicked

    }//GEN-LAST:event_KitapComboboxMouseClicked

    private void UyeComboboxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_UyeComboboxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_UyeComboboxActionPerformed

    private void kitapinfo(Kitap k) {
        kitap_id.setText(String.valueOf(k.getId()));
        kitap_ad.setText(k.getAd());
        kitap_yazar.setText(k.getYazar());
        kitap_yayinevi.setText(k.getYayinevi());
        kitap_turu.setText(k.getTur());

    }

    private void uyeinfo(Uye u) {
        uye_id.setText(String.valueOf(u.getId()));
        uye_ad.setText(u.getAd());
        uye_soyad.setText(u.getSoyad());
        uye_tel.setText(String.valueOf(u.getTel()));
    }
    private void buton_getirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buton_getirActionPerformed
        kitapinfo((Kitap) KitapCombobox.getSelectedItem());
        uyeinfo((Uye) UyeCombobox.getSelectedItem());
    }//GEN-LAST:event_buton_getirActionPerformed

    private void kitap_turuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_kitap_turuActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_kitap_turuActionPerformed

    private void uye_adActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_uye_adActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_uye_adActionPerformed

    private void emanet_silActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_emanet_silActionPerformed
        if (EmanetTablo.getSelectionModel().isSelectionEmpty()) {
            JOptionPane.showMessageDialog(null, "Lütfen satır seçiniz..");
        } else {
            try {
                int row = EmanetTablo.getSelectedRow();
                String value = (EmanetTablo.getModel().getValueAt(row, 0).toString());
                Connection connection = null;
                DbHelper DbHelper = new DbHelper();
                PreparedStatement statement = null;
                try {
                    connection = DbHelper.getConnection();
                    String sql = "DELETE FROM emanet WHERE id = " + value;
                    statement = connection.prepareStatement(sql);
                    int result = statement.executeUpdate();

                } catch (SQLException exception) {
                    DbHelper.showErrorMessage(exception);
                } finally {
                    try {
                        statement.close();
                        connection.close();
                        refreshTable();
                        ClearTextBox();
                    } catch (SQLException ex) {

                    }
                }
            } catch (Exception e) {
            }
        }
    }//GEN-LAST:event_emanet_silActionPerformed

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
            java.util.logging.Logger.getLogger(KitapEmanetForm.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(KitapEmanetForm.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(KitapEmanetForm.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(KitapEmanetForm.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new KitapEmanetForm().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable EmanetTablo;
    private javax.swing.JComboBox<String> KitapCombobox;
    private javax.swing.JComboBox<String> UyeCombobox;
    private javax.swing.JButton buton_getir;
    private javax.swing.JButton emanet_sil;
    private javax.swing.JButton emanet_ver;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JTextField kitap_ad;
    private javax.swing.JTextField kitap_id;
    private javax.swing.JTextField kitap_turu;
    private javax.swing.JTextField kitap_yayinevi;
    private javax.swing.JTextField kitap_yazar;
    private javax.swing.JFormattedTextField teslim_tarihi;
    private javax.swing.JTextField uye_ad;
    private javax.swing.JTextField uye_id;
    private javax.swing.JTextField uye_soyad;
    private javax.swing.JTextField uye_tel;
    // End of variables declaration//GEN-END:variables
}
