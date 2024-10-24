/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package cafe.thongke;

import cafe.User;
import cafe.baocaoquanli.km;
import cafe.login;
import cafe.nhacungcap.nhacungcap;
import cafe.quanlihoadon.Dashboard;
import cafe.quanlikh.ConnectDB;
import cafe.quanlikh.main;
import cafe.quanlisp.sp;
import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Vector;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Acer
 */
public class thongke extends javax.swing.JFrame {

    /**
     * Creates new form thongke
     */
    User userzz = new User();
    public void setuser(User user){
        taik.setText(user.getTaikhoan());
        chucvu.setText(user.getChucvu());
        userzz=user;
    }
    public thongke() {
        initComponents();
        load_combonv();
        load_thongke();
        this.setLocationRelativeTo(null);
    }
    
    public void load_thongke() {
        String comboboxnv = (String) Combonv.getSelectedItem();
        String timkiem = txttimkiem.getText().trim();
        int day, day2, month, month2, year, year2;
        String ngaybd = null, ngaykt = null;

        // Lấy đối tượng Date từ JDateChooser
        java.util.Date date = ngay1.getDate();
        if (date != null) {
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(date);
            day = calendar.get(Calendar.DAY_OF_MONTH);
            month = calendar.get(Calendar.MONTH) + 1; // Tháng trong Calendar bắt đầu từ 0 nên phải cộng thêm 1
            year = calendar.get(Calendar.YEAR);
            ngaybd = year + "-" + month + "-" + day;  // Ngaybd là chuỗi định dạng yyyy-MM-dd
        }

        java.util.Date date2 = ngay2.getDate(); // Lấy đối tượng Date từ JDateChooser
        if (date2 != null) {
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(date2);
            day2 = calendar.get(Calendar.DAY_OF_MONTH);
            month2 = calendar.get(Calendar.MONTH) + 1;
            year2 = calendar.get(Calendar.YEAR);
            ngaykt = year2 + "-" + month2 + "-" + day2;  // Ngaykt là chuỗi định dạng yyyy-MM-dd
        }

        try {
            Connection con;
            con = ConnectDB.KetnoiDB();
            Statement st = con.createStatement();

            String sql = "";
            if (comboboxnv.equals("-- Tất cả --")) {
                sql = "SELECT hoadon.mahd, ngaylap, manv, makm, makh, tongtien, sum(soluong) "
                        + "FROM hoadon JOIN chitiethoadon ON hoadon.mahd = chitiethoadon.mahd where";

                if (ngaybd != null && ngaykt == null) {
                    sql += " ngaylap >= '" + ngaybd + "' and";
                }
                if (ngaybd == null && ngaykt != null) {
                    sql += " ngaylap <= '" + ngaykt + "' and";
                }
                if (ngaybd != null && ngaykt != null) {
                    sql += " ngaylap BETWEEN '" + ngaybd + "' AND '" + ngaykt + "' and";
                }
                sql += " (hoadon.mahd like '%" +timkiem+ "%' or manv like '%" +timkiem+ "%' or makm like '%" +timkiem+ "%' or makh like '%" +timkiem+ "%')";
                sql += " GROUP BY mahd, ngaylap, manv, makm, makh, tongtien";
            } else {
                sql = "SELECT hoadon.mahd, ngaylap, manv, makm, makh, tongtien, sum(soluong) "
                        + "FROM hoadon JOIN chitiethoadon ON hoadon.mahd = chitiethoadon.mahd "
                        + "WHERE hoadon.manv = '" + comboboxnv + "'";

                if (ngaybd != null && ngaykt == null) {
                    sql += " AND ngaylap >= '" + ngaybd + "'";
                }
                if (ngaybd == null && ngaykt != null) {
                    sql += " AND ngaylap <= '" + ngaykt + "'";
                }
                if (ngaybd != null && ngaykt != null) {
                    sql += " AND ngaylap BETWEEN '" + ngaybd + "' AND '" + ngaykt + "'";
                }
                sql += " and (hoadon.mahd like '%"+timkiem+"%' or manv like '%"+timkiem+"%' or makm like '%"+timkiem+"%' or makh like '%"+timkiem+"%')";
                sql += " GROUP BY mahd, ngaylap, manv, makm, makh, tongtien";
            }

            ResultSet rs = st.executeQuery(sql);

            // Định nghĩa tên các cột cho JTable
            String[] arr = {"STT", "Mã hóa đơn", "Thời gian", "Nhân viên", "Mã KM", "Mã KH", "Tổng tiền", "Số lượng"};
            DefaultTableModel model = new DefaultTableModel(arr, 0);

            // Điền dữ liệu từ ResultSet vào model
            int i = 1;
            while (rs.next()) {
                Vector v = new Vector();
                v.add(i);
                v.add(rs.getString("mahd"));
                v.add(rs.getString("ngaylap"));         // Mã hóa đơn
                v.add(rs.getString("manv"));            // Nhân viên
                v.add(rs.getString("makm"));            // Mã KM
                v.add(rs.getString("makh"));            // Mã KH
                v.add(rs.getString("tongtien"));        // Tổng tiền
                v.add(rs.getString("sum(soluong)"));    // Số lượng
                model.addRow(v);
                i++;
            }

            // Gán model cho JTable
            tabletk.setModel(model);

            // Đóng kết nối
            con.close();
            tinhtoan();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void tinhtoan() {
        DefaultTableModel model = (DefaultTableModel) tabletk.getModel();
        int sohoadon = 0;
        double tongtien = 0;
        int soluong = 0;
        boolean ktthongke = false;
        for (int row = 0; row < model.getRowCount(); row++) {
            sohoadon++;
            String tien = model.getValueAt(row, 6).toString();  // Lấy tên sản phẩm từ bảng
            double tiendouble = Double.parseDouble(tien);
            tongtien += tiendouble;
            String sl = model.getValueAt(row, 7).toString();  // Lấy tên sản phẩm từ bảng
            int slint = Integer.parseInt(sl);
            soluong += slint;
            ktthongke = true;
        }

        // Nếu sản phẩm chưa tồn tại, thêm sản phẩm mới vào bảng
        if (ktthongke) {
            Vector v = new Vector();
            v.add("Tổng = ");
            v.add(sohoadon);
            v.add("");
            v.add("");
            v.add("");
            v.add("");// Số lượng ban đầu là 1
            v.add(tongtien);
            v.add(soluong);// Tổng tiền ban đầu = giá * 1
            model.addRow(v);
        }else{
            Vector v = new Vector();
            v.add("Không có dữ liệu...");
            model.addRow(v);
        }
        tabletk.setModel(model);
    }

    private void load_combonv() {
        try {
            Connection con = ConnectDB.KetnoiDB();
            String sql = "SELECT * FROM nhanvien"; // Giả sử có bảng khachhang
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);

//        maKhachHang.removeAllItems();
            while (rs.next()) {
                String mnv = rs.getString("manv");
                String tnv = rs.getString("tennhanvien");
                Combonv.addItem(mnv);
            }
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
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

        jPanel1 = new javax.swing.JPanel();
        chucvu = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        so = new javax.swing.JLabel();
        taik = new javax.swing.JLabel();
        nen = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabletk = new javax.swing.JTable();
        Combonv = new javax.swing.JComboBox<>();
        jScrollPane2 = new javax.swing.JScrollPane();
        txttimkiem = new javax.swing.JTextPane();
        buttontk = new javax.swing.JButton();
        txttong = new javax.swing.JLabel();
        txtsl = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        ngay1 = new com.toedter.calendar.JDateChooser();
        jLabel4 = new javax.swing.JLabel();
        ngay2 = new com.toedter.calendar.JDateChooser();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(160, 140, 119));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        chucvu.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        chucvu.setForeground(new java.awt.Color(255, 255, 255));
        chucvu.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jPanel1.add(chucvu, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 100, 150, 30));

        jLabel11.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/description.png"))); // NOI18N
        jLabel11.setText("Thống kê");
        jLabel11.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel11MouseClicked(evt);
            }
        });
        jPanel1.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 200, 210, -1));

        jLabel15.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(255, 255, 255));
        jLabel15.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel15.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/supplier.png"))); // NOI18N
        jLabel15.setText("Nhà cung cấp");
        jLabel15.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel15MouseClicked(evt);
            }
        });
        jPanel1.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 260, 210, -1));

        jLabel14.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(255, 255, 255));
        jLabel14.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel14.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/bill.png"))); // NOI18N
        jLabel14.setText("Tạo hóa đơn");
        jLabel14.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel14MouseClicked(evt);
            }
        });
        jPanel1.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 320, 210, -1));

        jLabel9.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/new-product.png"))); // NOI18N
        jLabel9.setText("Sản phẩm");
        jLabel9.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel9MouseClicked(evt);
            }
        });
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 380, 210, -1));

        jLabel12.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/shopping-online.png"))); // NOI18N
        jLabel12.setText("Khuyến mãi");
        jLabel12.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel12MouseClicked(evt);
            }
        });
        jPanel1.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 440, 210, -1));

        jLabel13.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/patient.png"))); // NOI18N
        jLabel13.setText("Khách hàng");
        jLabel13.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel13MouseClicked(evt);
            }
        });
        jPanel1.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 500, 210, -1));

        so.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        so.setForeground(new java.awt.Color(255, 255, 255));
        so.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        so.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/logout.png"))); // NOI18N
        so.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                soMouseClicked(evt);
            }
        });
        jPanel1.add(so, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 560, 210, -1));

        taik.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        taik.setForeground(new java.awt.Color(255, 255, 255));
        taik.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        taik.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/profile.png"))); // NOI18N
        taik.setText("  ");
        jPanel1.add(taik, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 60, 180, -1));

        nen.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/no.png"))); // NOI18N
        jPanel1.add(nen, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 210, 840));

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));

        tabletk.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null}
            },
            new String [] {
                "STT", "Mã hóa đơn", "Thời gian", "Nhân viên", "Mã KM", "Mã KH", "Tổng tiền", "Số lượng"
            }
        ));
        tabletk.setRowHeight(30);
        jScrollPane1.setViewportView(tabletk);

        Combonv.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "-- Tất cả --" }));
        Combonv.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                CombonvMouseClicked(evt);
            }
        });
        Combonv.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CombonvActionPerformed(evt);
            }
        });

        jScrollPane2.setViewportView(txttimkiem);

        buttontk.setText("Tìm kiếm");
        buttontk.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttontkActionPerformed(evt);
            }
        });

        txttong.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N

        txtsl.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        txtsl.setForeground(new java.awt.Color(153, 0, 51));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel2.setText("Nhân viên:");

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel1.setText("Từ");

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel4.setText("Đến ngày");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(37, 37, 37)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addGap(409, 409, 409)
                                .addComponent(txttong, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtsl, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 882, Short.MAX_VALUE)
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel4Layout.createSequentialGroup()
                                    .addGap(88, 88, 88)
                                    .addComponent(Combonv, javax.swing.GroupLayout.PREFERRED_SIZE, 206, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(21, 21, 21)
                                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 353, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(buttontk, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(50, 50, 50)
                        .addComponent(jLabel1)
                        .addGap(18, 18, 18)
                        .addComponent(ngay1, javax.swing.GroupLayout.PREFERRED_SIZE, 202, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel4)
                        .addGap(28, 28, 28)
                        .addComponent(ngay2, javax.swing.GroupLayout.PREFERRED_SIZE, 204, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(37, Short.MAX_VALUE))
            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel4Layout.createSequentialGroup()
                    .addGap(47, 47, 47)
                    .addComponent(jLabel2)
                    .addContainerGap(844, Short.MAX_VALUE)))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(Combonv, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(buttontk, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 27, Short.MAX_VALUE)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING)))
                .addGap(50, 50, 50)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addComponent(ngay2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1)
                    .addComponent(ngay1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(48, 48, 48)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 40, Short.MAX_VALUE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE, false)
                    .addComponent(txttong, javax.swing.GroupLayout.DEFAULT_SIZE, 33, Short.MAX_VALUE)
                    .addComponent(txtsl, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(75, 75, 75))
            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel4Layout.createSequentialGroup()
                    .addGap(34, 34, 34)
                    .addComponent(jLabel2)
                    .addContainerGap(699, Short.MAX_VALUE)))
        );

        jLabel3.setBackground(new java.awt.Color(51, 153, 255));
        jLabel3.setFont(new java.awt.Font("Segoe UI Black", 2, 24)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 51, 51));
        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/description.png"))); // NOI18N
        jLabel3.setText("Thống kê");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(401, 401, 401)
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 196, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(20, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void soMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_soMouseClicked
        int confirm = JOptionPane.showConfirmDialog(this, "Bạn có chắc chắn muốn đăng xuất", "Xác nhận", JOptionPane.YES_NO_OPTION);
        if (confirm == 0) {
            login gg = new login();
            gg.show();
            dispose();
        }
    }//GEN-LAST:event_soMouseClicked

    private void CombonvMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_CombonvMouseClicked

    }//GEN-LAST:event_CombonvMouseClicked

    private void buttontkActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttontkActionPerformed
        load_thongke();
    }//GEN-LAST:event_buttontkActionPerformed

    private void CombonvActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CombonvActionPerformed
        load_thongke();
    }//GEN-LAST:event_CombonvActionPerformed

    private void jLabel11MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel11MouseClicked
        thongke d = new thongke();
        d.show();
        d.setuser(userzz);
        dispose();
    }//GEN-LAST:event_jLabel11MouseClicked

    private void jLabel15MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel15MouseClicked
        nhacungcap c = new nhacungcap();
        c.show();
        c.setuser(userzz);
        dispose();
    }//GEN-LAST:event_jLabel15MouseClicked

    private void jLabel14MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel14MouseClicked
        Dashboard d = new Dashboard();
        d.show();
        d.setuser(userzz);
        dispose();
    }//GEN-LAST:event_jLabel14MouseClicked

    private void jLabel9MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel9MouseClicked
        sp s = new sp();
        s.show();
        s.setuser(userzz);
        dispose();
    }//GEN-LAST:event_jLabel9MouseClicked

    private void jLabel12MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel12MouseClicked
        km m = new km();
        m.show();
        m.setuser(userzz);
        dispose();
    }//GEN-LAST:event_jLabel12MouseClicked

    private void jLabel13MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel13MouseClicked
        main m = new main();
        m.show();
        m.setuser(userzz);
        dispose();
    }//GEN-LAST:event_jLabel13MouseClicked

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
            java.util.logging.Logger.getLogger(thongke.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(thongke.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(thongke.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(thongke.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new thongke().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> Combonv;
    private javax.swing.JButton buttontk;
    private javax.swing.JLabel chucvu;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel nen;
    private com.toedter.calendar.JDateChooser ngay1;
    private com.toedter.calendar.JDateChooser ngay2;
    private javax.swing.JLabel so;
    private javax.swing.JTable tabletk;
    private javax.swing.JLabel taik;
    private javax.swing.JLabel txtsl;
    private javax.swing.JTextPane txttimkiem;
    private javax.swing.JLabel txttong;
    // End of variables declaration//GEN-END:variables
}
