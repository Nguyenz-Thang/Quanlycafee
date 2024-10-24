package cafe.quanlihoadon;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
import cafe.User;
import cafe.quanlikh.ConnectDB;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import org.apache.commons.math3.stat.descriptive.summary.Product;

/**
 *
 * @author luuti
 */
public class ThemHoaDon extends javax.swing.JFrame {

    public ThemHoaDon() {
        initComponents();
    }
    private Dashboard das;

    public ThemHoaDon(Dashboard aThis) {
        das = aThis;
        initComponents();
        loadMaKhachHang();
        setNgayLapHoaDon();
        loadSanPham();
        loadMaKhuyenMai();
        this.setLocationRelativeTo(null);
        tieuDe();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTextField1 = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        xoaSanPham = new javax.swing.JButton();
        tbkm = new javax.swing.JLabel();
        maKhachHang = new javax.swing.JComboBox<>();
        chonSanPham = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        sanPhamDuocThem = new javax.swing.JTable();
        thanhToan = new javax.swing.JButton();
        huyHoaDon = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        tongTienHoaDon = new javax.swing.JTextPane();
        jScrollPane5 = new javax.swing.JScrollPane();
        maNhanVien = new javax.swing.JTextPane();
        jScrollPane6 = new javax.swing.JScrollPane();
        tenSanPhamDuocChon = new javax.swing.JTextPane();
        jScrollPane7 = new javax.swing.JScrollPane();
        soLuong = new javax.swing.JTextPane();
        themSanPham = new javax.swing.JButton();
        jLabel10 = new javax.swing.JLabel();
        khuyenMai = new javax.swing.JComboBox<>();
        jLabel11 = new javax.swing.JLabel();
        jScrollPane8 = new javax.swing.JScrollPane();
        tongTienHoaDonKhuyenMai = new javax.swing.JTextPane();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jScrollPane9 = new javax.swing.JScrollPane();
        ngayLapHoaDon = new javax.swing.JTextPane();
        suaSoLuong = new javax.swing.JButton();

        jTextField1.setText("jTextField1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setBackground(new java.awt.Color(51, 153, 255));
        jLabel1.setFont(new java.awt.Font("Segoe UI Black", 2, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 51, 51));
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/add.png"))); // NOI18N
        jLabel1.setText("Thêm hóa đơn");

        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel6.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel6.setText("Chọn sản phẩm");

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel4.setText("Tổng tiền hóa đơn");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel2.setText("Mã khách hàng");

        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel5.setText("Ngày lập hóa đơn");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel3.setText("Mã nhân viên");

        xoaSanPham.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        xoaSanPham.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/trash.png"))); // NOI18N
        xoaSanPham.setText("xóa sản phẩm");
        xoaSanPham.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                xoaSanPhamActionPerformed(evt);
            }
        });

        tbkm.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        tbkm.setForeground(new java.awt.Color(204, 0, 51));

        maKhachHang.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Mã khách hàng - Tên" }));
        maKhachHang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                maKhachHangActionPerformed(evt);
            }
        });

        chonSanPham.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Chọn sản phẩm" }));
        chonSanPham.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                chonSanPhamMouseClicked(evt);
            }
        });
        chonSanPham.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chonSanPhamActionPerformed(evt);
            }
        });

        sanPhamDuocThem.setModel(new javax.swing.table.DefaultTableModel(
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
        sanPhamDuocThem.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                sanPhamDuocThemMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(sanPhamDuocThem);

        thanhToan.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        thanhToan.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/bill.png"))); // NOI18N
        thanhToan.setText("Thanh toán");
        thanhToan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                thanhToanActionPerformed(evt);
            }
        });

        huyHoaDon.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        huyHoaDon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/cancel.png"))); // NOI18N
        huyHoaDon.setText("Hủy");
        huyHoaDon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                huyHoaDonActionPerformed(evt);
            }
        });

        tongTienHoaDon.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tongTienHoaDonKeyPressed(evt);
            }
        });
        jScrollPane3.setViewportView(tongTienHoaDon);

        maNhanVien.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                maNhanVienKeyPressed(evt);
            }
        });
        jScrollPane5.setViewportView(maNhanVien);

        tenSanPhamDuocChon.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tenSanPhamDuocChonKeyPressed(evt);
            }
        });
        jScrollPane6.setViewportView(tenSanPhamDuocChon);

        soLuong.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                soLuongKeyPressed(evt);
            }
        });
        jScrollPane7.setViewportView(soLuong);

        themSanPham.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        themSanPham.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/add.png"))); // NOI18N
        themSanPham.setText("thêm sản phẩm");
        themSanPham.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                themSanPhamActionPerformed(evt);
            }
        });

        jLabel10.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel10.setText("Khuyến mại");

        khuyenMai.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Khuyến mại" }));
        khuyenMai.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        khuyenMai.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                khuyenMaiActionPerformed(evt);
            }
        });

        jLabel11.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel11.setText("Tổng tiền hóa đơn(KM)");

        tongTienHoaDonKhuyenMai.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tongTienHoaDonKhuyenMaiKeyPressed(evt);
            }
        });
        jScrollPane8.setViewportView(tongTienHoaDonKhuyenMai);

        jLabel7.setText("Tên sản phẩm");

        jLabel8.setText("Số lượng");

        ngayLapHoaDon.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                ngayLapHoaDonKeyPressed(evt);
            }
        });
        jScrollPane9.setViewportView(ngayLapHoaDon);

        suaSoLuong.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        suaSoLuong.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/modification.png"))); // NOI18N
        suaSoLuong.setText("sửa số lượng");
        suaSoLuong.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                suaSoLuongActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(207, 207, 207)
                        .addComponent(huyHoaDon)
                        .addGap(320, 320, 320)
                        .addComponent(thanhToan))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(94, 94, 94)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel3))
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(111, 111, 111)
                                        .addComponent(chonSanPham, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(39, 39, 39)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel7)
                                            .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(110, 110, 110)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(maKhachHang, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jScrollPane9, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(393, 393, 393)
                                        .addComponent(tbkm, javax.swing.GroupLayout.PREFERRED_SIZE, 218, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel10)
                                    .addComponent(jLabel11))
                                .addGap(97, 97, 97)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jScrollPane3)
                                    .addComponent(jScrollPane8)
                                    .addComponent(khuyenMai, 0, 166, Short.MAX_VALUE)))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                .addGap(94, 94, 94)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 634, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel8)
                                    .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(themSanPham, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(xoaSanPham, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(suaSoLuong, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(maKhachHang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(tbkm, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(23, 23, 23)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel8)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jScrollPane9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel5))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel6)
                                        .addComponent(chonSanPham, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel7)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))))))
                .addGap(10, 10, 10)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 213, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(themSanPham)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(suaSoLuong)
                        .addGap(18, 18, 18)
                        .addComponent(xoaSanPham)
                        .addGap(70, 70, 70)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel10)
                    .addComponent(khuyenMai, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel11)
                    .addComponent(jScrollPane8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 30, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(thanhToan)
                    .addComponent(huyHoaDon))
                .addGap(45, 45, 45))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(408, 408, 408)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 208, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(44, 44, 44)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 965, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(43, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(16, 16, 16))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    // load mã khách hàng
    private void loadMaKhachHang() {
        try {
            Connection con = ConnectDB.KetnoiDB();
            String sql = "SELECT * FROM khachhang";
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);

            while (rs.next()) {
                String maKhach = rs.getString("makh");
                String tenKhachHang = rs.getString("tenkhachhang");
                maKhachHang.addItem(maKhach + " - " + tenKhachHang);
            }
            this.tenSanPhamDuocChon.setEnabled(false);
            this.tongTienHoaDonKhuyenMai.setEnabled(false);
            this.tongTienHoaDon.setEnabled(false);

            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // set ma nhan vien va ten nhan vien  
    public void setMaNhanVien(User user) {
        maNhanVien.setText(user.getManv() + " - " + user.getTennhanvien());
        maNhanVien.setEnabled(false);
    }

    // set ma nhan vien va ten nhan vien  
    public void setNgayLapHoaDon() {
        try {
            // Lấy thời gian hiện tại cho ngày lập hóa đơn
            LocalDateTime now = LocalDateTime.now();
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
            String formattedDateTime = now.format(formatter);
            ngayLapHoaDon.setText(formattedDateTime);
            ngayLapHoaDon.setEnabled(false);
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Lỗi khi thêm hóa đơn: " + e.getMessage());
        }

    }

    // load sản phẩm
    private void loadSanPham() {
        try {
            Connection con = ConnectDB.KetnoiDB();
            String sql = "SELECT * FROM sanpham"; // Giả sử có bảng khachhang
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);

            while (rs.next()) {
                String tenSanPham = rs.getString("tensanpham");
                chonSanPham.addItem(tenSanPham);
            }
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    private void xoaSanPhamActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_xoaSanPhamActionPerformed
        int selectedRow = sanPhamDuocThem.getSelectedRow(); // Lấy chỉ số hàng được chọn
        if (selectedRow >= 0) { // Kiểm tra xem có hàng nào được chọn không
            int confirm = JOptionPane.showConfirmDialog(this,
                    "Bạn có chắc chắn muốn xóa sản phẩm này?",
                    "Xác nhận xóa",
                    JOptionPane.YES_NO_OPTION);

            if (confirm == JOptionPane.YES_OPTION) { // Nếu người dùng chọn "Có"
                DefaultTableModel model = (DefaultTableModel) sanPhamDuocThem.getModel();
                model.removeRow(selectedRow); // Xóa hàng được chọn
                // Gọi phương thức tính tổng tiền sau khi xóa sản phẩm

            }
        } else {
            JOptionPane.showMessageDialog(this, "Vui lòng chọn sản phẩm để xóa.", "Thông báo", JOptionPane.WARNING_MESSAGE);
        }
        tinhTongTien();
    }//GEN-LAST:event_xoaSanPhamActionPerformed


    private void maKhachHangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_maKhachHangActionPerformed

    }//GEN-LAST:event_maKhachHangActionPerformed
    SanPham sanPham;
    private void chonSanPhamActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chonSanPhamActionPerformed

        soLuong.setText("");
        String tenSanPhamDuocChon = (String) chonSanPham.getSelectedItem();
        this.tenSanPhamDuocChon.setText(tenSanPhamDuocChon);

        String soLuongSanPham = soLuong.getText(); // lay so luong tu giao dien 
        sanPham = layThongTinSanPhamDaChon(tenSanPhamDuocChon); // Lấy thông tin sản phẩm
    }//GEN-LAST:event_chonSanPhamActionPerformed


    private void thanhToanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_thanhToanActionPerformed
        // TODO add your handling code here:
        try {
            // Lấy dữ liệu từ giao diện
            String maKhachHangGiaoDien = maKhachHang.getSelectedItem().toString();
            String str1[] = maKhachHangGiaoDien.split(" - "); // tách
            String maKhachHang_1 = str1[0];
            //
            String maNhanVienGiapDien = maNhanVien.getText().toString();
            String str2[] = maNhanVienGiapDien.split(" - "); // tách
            String maNhanVien_1 = str2[0];
            //
            String ngayLapHoaDon_1 = this.ngayLapHoaDon.getText();

            //
            String khuyenMaiGiaoDien = this.khuyenMai.getSelectedItem().toString();
            String str3[] = khuyenMaiGiaoDien.split(" - "); // tách
            String khuyenMai_1 = str3[0];
            //
            String tongTienText = tongTienHoaDonKhuyenMai.getText().trim(); // Lấy và trim chuỗi tổng tiền

            // Chuyển đổi sang java.sql.Timestamp để lưu vào cơ sở dữ liệu
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
            LocalDateTime localDateTime = LocalDateTime.parse(ngayLapHoaDon_1, formatter);
            java.sql.Timestamp sqlTimestamp = java.sql.Timestamp.valueOf(localDateTime);

            // Kiểm tra ràng buộc
            if (maKhachHang_1.equals("Mã khách hàng") || maKhachHang_1.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Vui lòng chọn khách hàng");
                return;
            }

            if (sanPhamDuocThem.getRowCount() == 0) {
                JOptionPane.showMessageDialog(this, "Vui lòng chọn ít nhất một sản phẩm");
                return;
            }

            // Chuyển đổi tổng tiền từ chuỗi sang số khi có >= 1 sản phẩm được chọn 
            double tongTienHoaDon_1 = Double.parseDouble(tongTienText);

            // Kết nối với cơ sở dữ liệu
            Connection con = ConnectDB.KetnoiDB();
            con.setAutoCommit(false);  // Tắt auto commit để thực hiện nhiều lệnh cùng lúc

            // Thêm hóa đơn vào bảng `hoadon`
            String sqlInsertHoaDon = "INSERT INTO hoadon (makh, manv, ngaylap, tongtien, makm) VALUES (?, ?, ?, ?, ?)";
            PreparedStatement psHoaDon = con.prepareStatement(sqlInsertHoaDon, Statement.RETURN_GENERATED_KEYS);
            System.out.println(khuyenMai_1);
            psHoaDon.setString(1, maKhachHang_1);
            psHoaDon.setString(2, maNhanVien_1);
            psHoaDon.setTimestamp(3, sqlTimestamp); // Sử dụng java.sql.Timestamp đã chuyển đổi
            psHoaDon.setDouble(4, tongTienHoaDon_1);
            psHoaDon.setString(5, khuyenMai_1);

            // Thực hiện lệnh thêm hóa đơn
            psHoaDon.executeUpdate();

            // Lấy mã hóa đơn vừa thêm (auto-increment)
            ResultSet rs = psHoaDon.getGeneratedKeys();
            int maHoaDon_1 = 0;
            if (rs.next()) {
                maHoaDon_1 = rs.getInt(1);  // Lấy mã hóa đơn vừa tạo
            }

            // Thêm từng chi tiết hóa đơn vào bảng `chitiethoadon`
            String sqlInsertChiTietHD = "INSERT INTO chitiethoadon (mahd, masp, soluong, gia, machitiethd) VALUES (?, ?, ?, ?, ?)";
            PreparedStatement psChiTietHD = con.prepareStatement(sqlInsertChiTietHD);
            for (int i = 0; i < sanPhamDuocThem.getRowCount(); i++) {
                String maChiTietHoaDon = "MCHD" + maHoaDon_1 + "" + (i + 1);
                String maSP = sanPhamDuocThem.getValueAt(i, 0).toString();  // Lấy mã sản phẩm từ cột 0
                int soLuong = Integer.parseInt(sanPhamDuocThem.getValueAt(i, 2).toString());  // Lấy số lượng từ cột 2
                double gia = Double.parseDouble(sanPhamDuocThem.getValueAt(i, 3).toString());  // Lấy giá từ cột 3

                psChiTietHD.setInt(1, maHoaDon_1);  // Mã hóa đơn
                psChiTietHD.setString(2, maSP);  // Mã sản phẩm
                psChiTietHD.setInt(3, soLuong);  // Số lượng
                psChiTietHD.setDouble(4, gia);  // Giá
                psChiTietHD.setString(5, maChiTietHoaDon);  // Mã chi tiết hóa đơn
                psChiTietHD.addBatch();  // Thêm vào batch
            }

            // Thực hiện batch
            psChiTietHD.executeBatch();

            // Commit transaction
            con.commit();
            System.out.println("Giao dịch thành công");

            // Hiển thị thông báo thành công
            JOptionPane.showMessageDialog(this, "Thêm hóa đơn thành công ,vui lòng thanh toán !");

            // Đóng kết nối
            psHoaDon.close();
            psChiTietHD.close();
            con.close();
            das.load_hd();

            ThanhToanHoaDon tthd = new ThanhToanHoaDon(this);
            tthd.setData(String.valueOf(maHoaDon_1), str1[1], str2[1], ngayLapHoaDon_1, tongTienText, str3[0]);
            tthd.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            tthd.setVisible(true);
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Lỗi khi thêm hóa đơn: " + e.getMessage());
        }


    }//GEN-LAST:event_thanhToanActionPerformed

    private void huyHoaDonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_huyHoaDonActionPerformed
        this.dispose();
    }//GEN-LAST:event_huyHoaDonActionPerformed

    private void tongTienHoaDonKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tongTienHoaDonKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_tongTienHoaDonKeyPressed

    private void chonSanPhamMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_chonSanPhamMouseClicked
        // TODO add your handling code here:


    }//GEN-LAST:event_chonSanPhamMouseClicked

    private void maNhanVienKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_maNhanVienKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_maNhanVienKeyPressed

    private void tenSanPhamDuocChonKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tenSanPhamDuocChonKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_tenSanPhamDuocChonKeyPressed

    private void soLuongKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_soLuongKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_soLuongKeyPressed


    private void themSanPhamActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_themSanPhamActionPerformed

        if (sanPham != null) {
            DefaultTableModel model = (DefaultTableModel) sanPhamDuocThem.getModel();
            boolean sanPhamDaTonTai = false;
            // Duyệt qua tất cả các dòng trong bảng để kiểm tra xem sản phẩm đã tồn tại hay chưa
            for (int i = 0; i < model.getRowCount(); i++) {
                String maSanPhamTrongBang = (String) model.getValueAt(i, 0); // Lấy mã sản phẩm từ cột đầu tiên
                if (maSanPhamTrongBang != null && maSanPhamTrongBang.equals(sanPham.getMaSanPham())) {
                    // Nếu sản phẩm đã tồn tại, tăng số lượng lên
                    String soLuongHienTaiString = model.getValueAt(i, 2).toString(); // Lấy số lượng từ cột 2 dưới dạng chuỗi
                    int soLuongHienTai = Integer.parseInt(soLuongHienTaiString); // Chuyển đổi chuỗi sang số nguyên
                    soLuongHienTai += Integer.parseInt(soLuong.getText()); // Tăng số lượng lên

                    model.setValueAt(soLuongHienTai, i, 2); // Cập nhật số lượng

                    // Cập nhật giá theo số lượng mới
                    double giaSanPham = sanPham.getGia(); // Giá của sản phẩm
                    model.setValueAt(giaSanPham * soLuongHienTai, i, 3); // Cập nhật giá

                    sanPhamDaTonTai = true;
                    break;
                }
            }

            // Nếu sản phẩm chưa tồn tại trong bảng thì thêm dòng mới
            if (!sanPhamDaTonTai) {
                model.addRow(new Object[]{
                    sanPham.getMaSanPham(), // Mã sản phẩm
                    sanPham.getTenSanPham(), // Tên sản phẩm
                    soLuong.getText(), // Số lượng mặc định là 1
                    sanPham.getGia() // Giá sản phẩm
                });
            }

        } else {
            JOptionPane.showMessageDialog(this, "Không tìm thấy thông tin sản phẩm.", "Lỗi", JOptionPane.ERROR_MESSAGE);
        }
        // Gọi phương thức tính tổng tiền sau khi thêm sản phẩm
        tinhTongTien();


    }//GEN-LAST:event_themSanPhamActionPerformed
    private void loadMaKhuyenMai() {
        try {
            Connection con = ConnectDB.KetnoiDB();
            String sql = "SELECT * FROM khuyenmai";
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);

            while (rs.next()) {
                String maKhuyenMai = rs.getString("makm");
                String tenKhuyenMai = rs.getString("tenkhuyenmai");
                String phanTramGiam = rs.getString("phantramgiam");

                khuyenMai.addItem(maKhuyenMai + " - " + tenKhuyenMai + " - " + phanTramGiam + "%");
            }
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
    private void khuyenMaiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_khuyenMaiActionPerformed
        String tenKhuyenMaiDuocChon = (String) khuyenMai.getSelectedItem();
        String str1[] = tenKhuyenMaiDuocChon.split(" - ");
        String maKhuyenMaiDaTach = str1[2];
        String str2[] = maKhuyenMaiDaTach.split("%");
        String phanTramDaTach = str2[0];
        tinhTongTienKhuyenMai(Integer.parseInt(phanTramDaTach));

    }//GEN-LAST:event_khuyenMaiActionPerformed

    private void tinhTongTienKhuyenMai(int phanTram) {
        DefaultTableModel model = (DefaultTableModel) sanPhamDuocThem.getModel();
        double tongTienKhuyenMai = 0;
        tongTienKhuyenMai = Double.parseDouble(this.tongTienHoaDon.getText()) * (100 - phanTram) / 100;
        // Cập nhật giá trị tổng tiền vào JTextField
        tongTienHoaDonKhuyenMai.setText(String.valueOf(tongTienKhuyenMai));

    }
    private void tongTienHoaDonKhuyenMaiKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tongTienHoaDonKhuyenMaiKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_tongTienHoaDonKhuyenMaiKeyPressed

    private void ngayLapHoaDonKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_ngayLapHoaDonKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_ngayLapHoaDonKeyPressed

    // lay thong tin san phẩm (giá) muốn sửa

    private void suaSoLuongActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_suaSoLuongActionPerformed
        // Lấy chỉ số hàng được chọn từ JTable
        int selectedRow = sanPhamDuocThem.getSelectedRow(); // Lấy chỉ số hàng được chọn
        if (selectedRow >= 0) { // Kiểm tra xem có hàng nào được chọn không
            DefaultTableModel model = (DefaultTableModel) sanPhamDuocThem.getModel();

            // Lấy số lượng mới từ JTextField
            int soLuongMoi = Integer.parseInt(this.soLuong.getText());

            // Cập nhật lại số lượng trong bảng
            model.setValueAt(soLuongMoi, selectedRow, 2); // Giả sử cột 2 là số lượng

            // Lấy tên sản phẩm từ cột tên
            String tenSanPham = (String) model.getValueAt(selectedRow, 1);

            // Lấy thông tin sản phẩm dựa trên tên
            SanPham sp = layThongTinSanPhamDaChon(tenSanPham);

            if (sp != null) {
                // Lấy giá của sản phẩm từ đối tượng SanPham và cập nhật lại giá tổng
                double giaSanPham = sp.getGia(); // Giá của sản phẩm
                double tongGiaMoi = giaSanPham * soLuongMoi; // Cập nhật tổng giá dựa trên số lượng mới
                model.setValueAt(tongGiaMoi, selectedRow, 3); // Cập nhật giá vào cột tổng giá (cột 3)
            } else {
                JOptionPane.showMessageDialog(this, "Không tìm thấy thông tin sản phẩm.", "Lỗi", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(this, "Vui lòng chọn sản phẩm để cập nhật.", "Thông báo", JOptionPane.WARNING_MESSAGE);
        }
        tinhTongTien();
    }//GEN-LAST:event_suaSoLuongActionPerformed

// chọn sản phẩm để sửa số lượng
    private void sanPhamDuocThemMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_sanPhamDuocThemMouseClicked

        // chọn sản phẩm để sửa số lượng
        // Lấy chỉ số hàng được chọn từ JTable
        int selectedRow = sanPhamDuocThem.getSelectedRow(); // Lấy chỉ số hàng được chọn
        if (selectedRow >= 0) { // Kiểm tra xem có hàng nào được chọn không
            DefaultTableModel model = (DefaultTableModel) sanPhamDuocThem.getModel();

            // Lấy dữ liệu từ bảng theo chỉ số hàng và các cột tương ứng
            String tenSanPham = (String) model.getValueAt(selectedRow, 1); // Giả sử cột 1 là tên sản phẩm
            int soLuong = Integer.parseInt(model.getValueAt(selectedRow, 2).toString()); // Giả sử cột 2 là số lượng

            // Set lại giá trị vào JTextField để sửa
            tenSanPhamDuocChon.setText(tenSanPham); // Đặt lại tên sản phẩm vào JTextField
            this.soLuong.setText(String.valueOf(soLuong)); // Đặt lại số lượng vào JTextField
        } else {
            JOptionPane.showMessageDialog(this, "Vui lòng chọn sản phẩm để sửa.", "Thông báo", JOptionPane.WARNING_MESSAGE);
        }

    }//GEN-LAST:event_sanPhamDuocThemMouseClicked

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
            java.util.logging.Logger.getLogger(ThemHoaDon.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ThemHoaDon.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ThemHoaDon.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ThemHoaDon.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ThemHoaDon().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> chonSanPham;
    private javax.swing.JButton huyHoaDon;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JScrollPane jScrollPane8;
    private javax.swing.JScrollPane jScrollPane9;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JComboBox<String> khuyenMai;
    private javax.swing.JComboBox<String> maKhachHang;
    private javax.swing.JTextPane maNhanVien;
    private javax.swing.JTextPane ngayLapHoaDon;
    private javax.swing.JTable sanPhamDuocThem;
    private javax.swing.JTextPane soLuong;
    private javax.swing.JButton suaSoLuong;
    private javax.swing.JLabel tbkm;
    private javax.swing.JTextPane tenSanPhamDuocChon;
    private javax.swing.JButton thanhToan;
    private javax.swing.JButton themSanPham;
    private javax.swing.JTextPane tongTienHoaDon;
    private javax.swing.JTextPane tongTienHoaDonKhuyenMai;
    private javax.swing.JButton xoaSanPham;
    // End of variables declaration//GEN-END:variables

    private SanPham layThongTinSanPhamDaChon(String tenSanPhamDuocChon) {
        SanPham sanPham = null; // Tạo một đối tượng sản phẩm để lưu thông tin
        try {
            Connection con = ConnectDB.KetnoiDB();
            String sql = "SELECT * FROM sanpham WHERE tensanpham = ?";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1, tenSanPhamDuocChon); // Đặt mã sản phẩm vào truy vấn
            ResultSet rs = pst.executeQuery();

            if (rs.next()) {
                // Giả sử bạn có các trường: masanpham, tensanpham, gia
                String maSanPham = rs.getString("masp");
                double giaSanPham = rs.getDouble("gia");
                sanPham = new SanPham(maSanPham, tenSanPhamDuocChon, giaSanPham);
            }

            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return sanPham; // Trả về đối tượng sản phẩm
    }

    private void tieuDe() {
// Khởi tạo mô hình bảng một lần, có thể trong constructor hoặc phương thức khởi tạo
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("Mã sản phẩm");
        model.addColumn("Tên sản phẩm");
        model.addColumn("Số lượng");
        model.addColumn("Giá");
        sanPhamDuocThem.setModel(model);

    }


    private void tinhTongTien() {
        DefaultTableModel model = (DefaultTableModel) sanPhamDuocThem.getModel();
        double tongTien = 0;

        for (int i = 0; i < model.getRowCount(); i++) {
            double gia = (double) model.getValueAt(i, 3); // Lấy giá từ cột thứ 4
            tongTien += gia; // Tính tổng tiền
        }
        // Cập nhật giá trị tổng tiền vào JTextField
        tongTienHoaDon.setText(String.valueOf(tongTien));
    }

}
