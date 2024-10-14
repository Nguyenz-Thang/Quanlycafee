package cafe.quanlihoadon;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */


import cafe.quanlihoadon.Dashboard;
import cafe.quanlikh.ConnectDB;
import java.awt.Frame;
import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import javax.swing.JOptionPane;
import java.text.SimpleDateFormat;
import java.util.Vector;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author luuti
 */
public class ChiTietHoaDon extends javax.swing.JFrame {

    public ChiTietHoaDon() {
        initComponents();
        this.setLocationRelativeTo(null);
    }
    private Dashboard das;

    public ChiTietHoaDon(Dashboard athis) {
        das = athis;
        initComponents();
        addListeners(); // Thêm sự kiện thay đổi cho các ô nhập liệu

        this.setLocation(120, 260);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        khachHang = new javax.swing.JTextPane();
        jLabel6 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        maHoaDon = new javax.swing.JTextPane();
        xoa = new javax.swing.JButton();
        sua = new javax.swing.JButton();
        jScrollPane5 = new javax.swing.JScrollPane();
        tongTien = new javax.swing.JTextPane();
        jLabel3 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jScrollPane6 = new javax.swing.JScrollPane();
        nhanVienLapHoaDon = new javax.swing.JTextPane();
        jScrollPane7 = new javax.swing.JScrollPane();
        tenSanPham = new javax.swing.JTextPane();
        jScrollPane8 = new javax.swing.JScrollPane();
        soLuong = new javax.swing.JTextPane();
        jScrollPane9 = new javax.swing.JScrollPane();
        giaDonVi = new javax.swing.JTextPane();
        jLabel10 = new javax.swing.JLabel();
        trangThai = new javax.swing.JComboBox<>();
        ngayLapHoaDon = new com.toedter.calendar.JDateChooser();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setBackground(new java.awt.Color(51, 153, 255));
        jLabel1.setFont(new java.awt.Font("Segoe UI Black", 2, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 51, 102));
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/file.png"))); // NOI18N
        jLabel1.setText("Chi tiết hóa đơn");

        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel2.setText("Mã hóa đơn");

        jScrollPane4.setViewportView(khachHang);

        jLabel6.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel6.setText("Khách hàng");

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel4.setText("Nhân viên lập hóa đơn");

        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel5.setText("Ngày lập hóa đơn");

        jScrollPane2.setViewportView(maHoaDon);

        xoa.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        xoa.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/delete.png"))); // NOI18N
        xoa.setText("Xóa");
        xoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                xoaActionPerformed(evt);
            }
        });

        sua.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        sua.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/diskette.png"))); // NOI18N
        sua.setText("Lưu");
        sua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                suaActionPerformed(evt);
            }
        });

        jScrollPane5.setViewportView(tongTien);

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel3.setText("Tên sản phẩm ");

        jLabel7.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel7.setText("Giá đơn vị");

        jLabel8.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel8.setText("Số lượng");

        jLabel9.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel9.setText("Tổng giá");

        jScrollPane6.setViewportView(nhanVienLapHoaDon);

        jScrollPane7.setViewportView(tenSanPham);

        jScrollPane8.setViewportView(soLuong);

        jScrollPane9.setViewportView(giaDonVi);

        jLabel10.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel10.setText("Trạng thái");

        trangThai.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "-----------", "Đã thanh toán", "Chưa thanh toán", "Đã hủy" }));
        trangThai.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                trangThaiActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(40, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                            .addComponent(jLabel7)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jScrollPane9, javax.swing.GroupLayout.PREFERRED_SIZE, 218, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                            .addComponent(jLabel8)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jScrollPane8, javax.swing.GroupLayout.PREFERRED_SIZE, 218, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addComponent(jLabel3)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 218, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addComponent(jLabel9)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 218, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                            .addComponent(xoa)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(sua))
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                            .addGap(165, 165, 165)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 218, Short.MAX_VALUE))
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel4)
                                .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(trangThai, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jScrollPane6, javax.swing.GroupLayout.DEFAULT_SIZE, 218, Short.MAX_VALUE)
                                .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 218, Short.MAX_VALUE)
                                .addComponent(ngayLapHoaDon, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))))
                .addGap(17, 17, 17))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 2, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel2)))
                .addGap(30, 30, 30)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(28, 28, 28)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel8)
                    .addComponent(jScrollPane8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(25, 25, 25)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel7)
                    .addComponent(jScrollPane9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(24, 24, 24)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel9)
                    .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(33, 33, 33)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5)
                    .addComponent(ngayLapHoaDon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(32, 32, 32)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6)
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(28, 28, 28)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(trangThai, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel4)
                    .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(42, 42, 42)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(xoa)
                    .addComponent(sua))
                .addGap(18, 18, 18))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(26, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 280, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(59, 59, 59))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(19, 19, 19))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void xoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_xoaActionPerformed
        try {
            String maHoaDon = this.maHoaDon.getText().trim();
            Connection con = ConnectDB.KetnoiDB();
            int confirm = JOptionPane.showConfirmDialog(this, "Bạn có chắc chắn muốn xóa?", "Xác nhận", JOptionPane.YES_NO_OPTION);
            if (confirm == 0) {
                String sql1 = "Delete from chitiethoadon where mahd='" + maHoaDon + "'";
                String sql2 = "Delete from hoadon where mahd='" + maHoaDon + "'";
                Statement st = con.createStatement();
                st.executeUpdate(sql1);
                st.executeUpdate(sql2);
                con.close();
                dispose();
                if (das != null) {
                    das.load_hd();// Gọi hàm load_hd() từ form gốc
                }
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Xóa không thành công");
            e.printStackTrace();
        }


    }//GEN-LAST:event_xoaActionPerformed

    private void suaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_suaActionPerformed
        String maHoaDon1 = maHoaDon.getText().trim();
        String tenSanPham1 = tenSanPham.getText().trim();
        String soLuong1 = soLuong.getText().trim();
        String giaDonVi1 = giaDonVi.getText().trim();
        String tongGia1 = tongTien.getText().trim();
        String khachHang1 = khachHang.getText().trim();
        String trangThai1 = (String) trangThai.getSelectedItem();
        String nhanVienLapHoaDon1 = nhanVienLapHoaDon.getText().trim();

        Date ngayLapHoaDon1 = new Date(ngayLapHoaDon.getDate().getTime());
        // Chuyển đổi giá trị 'soLuong1' và 'giaDonVi1' thành kiểu số và tính tổng giá
        

        try {
            Connection con = ConnectDB.KetnoiDB();
            String sql1 = "Update chitiethoadon Set soluong='" + soLuong1 + "',gia='" + giaDonVi1 + "' where mahd='" + maHoaDon1 + "' AND masp = (SELECT masp FROM sanpham WHERE tensanpham = '"+tenSanPham1+"') ";
            String sql2 = "Update hoadon Set ngaylap =N'" + ngayLapHoaDon1 + "',tongtien ='" + tongGia1 + "',trangthai =N'" + trangThai1 + "' where mahd ='" + maHoaDon1 + "' ";

            Statement st = con.createStatement();
            int confirm = JOptionPane.showConfirmDialog(this, "Bạn có chắc chắn muốn sửa?", "Xác nhận", JOptionPane.YES_NO_OPTION);
            if (confirm == 0) {
                st.executeUpdate(sql1);
                st.executeUpdate(sql2);

                con.close();
                dispose();
                if (das != null) {
                    das.load_hd(); // Gọi hàm load_km() từ form gốc
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }//GEN-LAST:event_suaActionPerformed

    private void trangThaiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_trangThaiActionPerformed

    }//GEN-LAST:event_trangThaiActionPerformed

    // Hàm thiết lập sự kiện thay đổi cho trường soLuong và giaDonVi
    private void addListeners() {
        // Lắng nghe sự thay đổi trong trường soLuong
        soLuong.getDocument().addDocumentListener(new DocumentListener() {
            public void changedUpdate(DocumentEvent e) {
                tinhTongGia(); // Gọi hàm tính tổng giá khi có thay đổi
            }

            public void removeUpdate(DocumentEvent e) {
                tinhTongGia();
            }

            public void insertUpdate(DocumentEvent e) {
                tinhTongGia();
            }
        });

        // Lắng nghe sự thay đổi trong trường giaDonVi
        giaDonVi.getDocument().addDocumentListener(new DocumentListener() {
            public void changedUpdate(DocumentEvent e) {
                tinhTongGia(); // Gọi hàm tính tổng giá khi có thay đổi
            }

            public void removeUpdate(DocumentEvent e) {
                tinhTongGia();
            }

            public void insertUpdate(DocumentEvent e) {
                tinhTongGia();
            }
        });
    }

// Hàm tính tổng giá dựa trên giá đơn vị và số lượng
    private void tinhTongGia() {
        try {
            String soLuongStr = soLuong.getText().trim(); // Lấy giá trị từ trường số lượng
            String giaDonViStr = giaDonVi.getText().trim(); // Lấy giá trị từ trường giá đơn vị

            // Chuyển đổi giá trị số lượng và giá đơn vị thành số
            int soLuongInt = Integer.parseInt(soLuongStr);
            double giaDonViDouble = Double.parseDouble(giaDonViStr);

            // Tính tổng giá trị
            double tongGia = soLuongInt * giaDonViDouble;

            // Cập nhật ô tổng tiền
            tongTien.setText(String.valueOf(tongGia));
        } catch (NumberFormatException e) {
            // Xử lý nếu người dùng nhập giá trị không hợp lệ
            tongTien.setText("0"); // Đặt tổng tiền về 0 nếu có lỗi
        }
    }

    public void setData(String mahd, String tenkhachhang, String tennhanvien, String ngaylap, String tongtien, String trangthai) {
        try {
            Connection con = ConnectDB.KetnoiDB();
            java.sql.Statement st = con.createStatement();

            // Sử dụng biến mahd thay vì chuỗi 'mahd'
            String sql = "SELECT sp.tensanpham AS 'Tên sản phẩm', "
                    + "cthd.soluong AS 'Số lượng', "
                    + "cthd.gia AS 'Giá đơn vị' "
                    + "FROM hoadon hd "
                    + "JOIN chitiethoadon cthd ON hd.mahd = cthd.mahd "
                    + "JOIN sanpham sp ON cthd.masp = sp.masp "
                    + "WHERE hd.mahd = '" + mahd + "'";

            ResultSet rs = st.executeQuery(sql);

            // Nếu ResultSet có dữ liệu
            if (rs.next()) {
                // Đặt giá trị vào các ô text dựa trên cột trả về
                tenSanPham.setText(rs.getString("Tên sản phẩm"));
                tenSanPham.setEnabled(false);
                soLuong.setText(rs.getString("Số lượng"));
                giaDonVi.setText(rs.getString("Giá đơn vị"));
            }

            // Đóng kết nối
            rs.close();
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        // Đặt các thông tin còn lại từ các tham số đã truyền vào
        maHoaDon.setText(mahd);
        maHoaDon.setEnabled(false);
        khachHang.setText(tenkhachhang);
        khachHang.setEnabled(false);
        // Xử lý định dạng ngày tháng
        try {
            java.util.Date ngayLapHoaDonn = new SimpleDateFormat("yyyy-MM-dd").parse(ngaylap);
            ngayLapHoaDon.setDate(ngayLapHoaDonn);
        } catch (Exception e) {
            e.printStackTrace();
        }
        tongTien.setText(tongtien);
        tongTien.setEnabled(false);
        nhanVienLapHoaDon.setText(tennhanvien);
        nhanVienLapHoaDon.setEnabled(false);
        trangThai.setSelectedItem(trangthai);

    }

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
            java.util.logging.Logger.getLogger(ChiTietHoaDon.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ChiTietHoaDon.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ChiTietHoaDon.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ChiTietHoaDon.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ChiTietHoaDon().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextPane giaDonVi;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JScrollPane jScrollPane8;
    private javax.swing.JScrollPane jScrollPane9;
    private javax.swing.JTextPane khachHang;
    private javax.swing.JTextPane maHoaDon;
    private com.toedter.calendar.JDateChooser ngayLapHoaDon;
    private javax.swing.JTextPane nhanVienLapHoaDon;
    private javax.swing.JTextPane soLuong;
    private javax.swing.JButton sua;
    private javax.swing.JTextPane tenSanPham;
    private javax.swing.JTextPane tongTien;
    private javax.swing.JComboBox<String> trangThai;
    private javax.swing.JButton xoa;
    // End of variables declaration//GEN-END:variables

}
