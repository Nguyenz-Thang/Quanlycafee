package cafe.quanlihoadon;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
import cafe.User;
import cafe.baocaoquanli.km;
import cafe.baocaoquanli.suakm;
import cafe.login;
import cafe.nhacungcap.nhacungcap;
import cafe.quanlikh.ConnectDB;
import cafe.quanlikh.main;
import cafe.quanlinhanvien.nv;
import cafe.quanlisp.sp;
import cafe.thongke.thongke;
import com.mysql.cj.xdevapi.Statement;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Iterator;
import java.util.Vector;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.table.DefaultTableModel;
import org.apache.poi.ss.usermodel.BorderStyle;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.CreationHelper;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.HorizontalAlignment;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.VerticalAlignment;
import org.apache.poi.xssf.usermodel.XSSFFont;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 *
 * @author luuti
 */
public class Dashboard extends javax.swing.JFrame {

    /**
     * Creates new form Dashboard
     */
    User userzz = new User();

    public void setuser(User user) {
        taik.setText(user.getTaikhoan());
        chucvu.setText(user.getChucvu());
        userzz = user;
        if (user.getChucvu().equals("Admin") || user.getChucvu().equals("Quản lý")) {
            ImageIcon icon = new ImageIcon(getClass().getResource("/icon/add-user.png"));
            butnhanvien.setIcon(icon);
            butnhanvien.setText("Nhân viên");
            butnhanvien.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    nv v = new nv();
                    v.show();
                    v.setuser(user);
                    dispose();
                }
            });
        }
    }

    public Dashboard() {
        initComponents();
        load_hd();
        this.setLocationRelativeTo(null);

    }

    public void load_hd() {
        try {
            Connection con;
            con = ConnectDB.KetnoiDB();
            java.sql.Statement st = con.createStatement();

            String sql = "SELECT hd.mahd, kh.tenkhachhang, nv.tennhanvien, hd.ngaylap, hd.tongtien, hd.makm "
                    + "FROM hoadon hd "
                    + "JOIN khachhang kh ON hd.makh = kh.makh "
                    + "JOIN nhanvien nv ON hd.manv = nv.manv ";
            ResultSet rs = st.executeQuery(sql);

            // Define column names for the JTable
            String[] arr = {"Mã hóa đơn", "Tên khách hàng", "Nhân viên lập hóa đơn", "Ngày lập hóa đơn", "Tổng tiền(KM)", "Mã KM"};
            DefaultTableModel model = new DefaultTableModel(arr, 0);

            // Populate the table model with data from the ResultSet
            while (rs.next()) {
                Vector v = new Vector();
                v.add(rs.getString("mahd"));         // Invoice ID
                v.add(rs.getString("tenkhachhang")); // Customer Name
                v.add(rs.getString("tennhanvien"));  // Employee Name
                v.add(rs.getString("ngaylap"));      // Date of invoice
                v.add(rs.getString("tongtien"));     // Total amount
                v.add(rs.getString("makm"));    // Status of the invoice
                model.addRow(v);
            }

            // Set the model for your JTable
            danhSachHoaDon.setModel(model);

            // Close the connection
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        themHoaDon = new javax.swing.JButton();
        jScrollPane5 = new javax.swing.JScrollPane();
        txtTimKiem = new javax.swing.JTextPane();
        timKiem = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        danhSachHoaDon = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        xuatExcel = new javax.swing.JButton();
        nhapExcel = new javax.swing.JButton();
        sapXep = new javax.swing.JComboBox<>();
        jPanel1 = new javax.swing.JPanel();
        butnhanvien = new javax.swing.JLabel();
        taik = new javax.swing.JLabel();
        chucvu = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        so = new javax.swing.JLabel();
        nen = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtDuongDan = new javax.swing.JTextPane();
        buttonBrowse = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        themHoaDon.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        themHoaDon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/add.png"))); // NOI18N
        themHoaDon.setText("Thêm hóa đơn");
        themHoaDon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                themHoaDonActionPerformed(evt);
            }
        });

        txtTimKiem.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtTimKiemMouseClicked(evt);
            }
        });
        jScrollPane5.setViewportView(txtTimKiem);

        timKiem.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        timKiem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/search.png"))); // NOI18N
        timKiem.setText("Tìm kiếm");
        timKiem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                timKiemActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(themHoaDon)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 329, Short.MAX_VALUE)
                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 218, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(timKiem)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(themHoaDon)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(timKiem, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane5))
                .addContainerGap())
        );

        danhSachHoaDon.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4", "Title 5", "Title 6"
            }
        ));
        danhSachHoaDon.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                danhSachHoaDonMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(danhSachHoaDon);

        jLabel1.setBackground(new java.awt.Color(51, 153, 255));
        jLabel1.setFont(new java.awt.Font("Segoe UI Black", 2, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 51));
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/campaign.png"))); // NOI18N
        jLabel1.setText("Quản lí hóa đơn");

        xuatExcel.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        xuatExcel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/excel.jpg"))); // NOI18N
        xuatExcel.setText("Xuất excel");
        xuatExcel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                xuatExcelActionPerformed(evt);
            }
        });

        nhapExcel.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        nhapExcel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/xls.png"))); // NOI18N
        nhapExcel.setText("Nhập File excel");
        nhapExcel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nhapExcelActionPerformed(evt);
            }
        });

        sapXep.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Sắp xếp", "sắp xếp tăng", "sắp xếp giảm" }));
        sapXep.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sapXepActionPerformed(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(160, 140, 119));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        butnhanvien.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        butnhanvien.setForeground(new java.awt.Color(255, 255, 255));
        butnhanvien.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        butnhanvien.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                butnhanvienMouseClicked(evt);
            }
        });
        jPanel1.add(butnhanvien, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 150, 210, 20));

        taik.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        taik.setForeground(new java.awt.Color(255, 255, 255));
        taik.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        taik.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/profile.png"))); // NOI18N
        taik.setText("  ");
        jPanel1.add(taik, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 60, 180, -1));

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

        nen.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/no.png"))); // NOI18N
        jPanel1.add(nen, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 210, 830));

        jScrollPane2.setViewportView(txtDuongDan);

        buttonBrowse.setText("Browse");
        buttonBrowse.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonBrowseActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(115, 115, 115)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(nhapExcel)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 267, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(27, 27, 27)
                                    .addComponent(buttonBrowse)
                                    .addGap(18, 18, 18)
                                    .addComponent(xuatExcel))
                                .addComponent(jScrollPane1)
                                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(294, 294, 294)
                                .addComponent(jLabel1))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(423, 423, 423)
                        .addComponent(sapXep, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(164, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                .addGap(56, 56, 56)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(sapXep, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(24, 24, 24)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 467, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(40, 40, 40)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(nhapExcel)
                        .addComponent(xuatExcel)
                        .addComponent(buttonBrowse))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void themHoaDonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_themHoaDonActionPerformed
        ThemHoaDon themHoaDon = new ThemHoaDon(this);
        themHoaDon.setMaNhanVien(userzz);
        themHoaDon.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        themHoaDon.show();
    }//GEN-LAST:event_themHoaDonActionPerformed

    private void txtTimKiemMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtTimKiemMouseClicked

    }//GEN-LAST:event_txtTimKiemMouseClicked

    private void timKiemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_timKiemActionPerformed
        String txt = txtTimKiem.getText().trim();
        try {
            Connection con;
            con = ConnectDB.KetnoiDB();
            java.sql.Statement st = con.createStatement();

            // Fixed the SQL query: added a space before "from hoadon hd"
            String sql = "SELECT hd.mahd, kh.tenkhachhang, nv.tennhanvien, hd.ngaylap, hd.tongtien, hd.makm "
                    + "from hoadon hd "
                    + "join nhanvien nv on hd.manv = nv.manv "
                    + "join khachhang kh on hd.makh = kh.makh "
                    + "where mahd like '%" + txt + "%' "
                    + "or tenkhachhang like N'%" + txt + "%' "
                    + "or tennhanvien like N'%" + txt + "%' "
                    + "or ngaylap like '%" + txt + "%' "
                    + "or tongtien like '%" + txt + "%' "
                    + "or makm like '%" + txt + "%'";

            ResultSet rs = st.executeQuery(sql);

            // Define column names for the JTable
            String[] arr = {"Mã hóa đơn", "Tên khách hàng", "Nhân viên lập hóa đơn", "Ngày lập hóa đơn", "Tổng tiền(KM)", "Mã KM"};
            DefaultTableModel model = new DefaultTableModel(arr, 0);

            // Populate the table model with data from the ResultSet
            boolean check = true;
            while (rs.next()) {
                check = false;
                Vector v = new Vector();
                v.add(rs.getString("mahd"));         // Invoice ID
                v.add(rs.getString("tenkhachhang")); // Customer Name
                v.add(rs.getString("tennhanvien"));  // Employee Name
                v.add(rs.getString("ngaylap"));      // Date of invoice
                v.add(rs.getString("tongtien"));     // Total amount
                v.add(rs.getString("makm"));    // Status of the invoice
                model.addRow(v);
            }
            if (check) {
                Vector v = new Vector();
                v.add("Không có dữ liệuuuuuuu");
                model.addRow(v);
            }
            // Set the model for your JTable
            danhSachHoaDon.setModel(model);
//
            // Close the connection
            con.close();

        } catch (Exception e) {
            e.printStackTrace();
        }


    }//GEN-LAST:event_timKiemActionPerformed

    private void danhSachHoaDonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_danhSachHoaDonMouseClicked
        int i;
        i = danhSachHoaDon.getSelectedRow();
        DefaultTableModel model = (DefaultTableModel) danhSachHoaDon.getModel();
//
        String maHoaDon = model.getValueAt(i, 0).toString();
        String tenKhachHang = model.getValueAt(i, 1).toString();
        String tenNhanVien = model.getValueAt(i, 2).toString();
        String ngayLap = model.getValueAt(i, 3).toString();
        String tongTien = model.getValueAt(i, 4).toString();
        String maKhuyenMai = model.getValueAt(i, 5).toString();

        ChiTietHoaDon cthd = new ChiTietHoaDon(this);
        cthd.setData(maHoaDon, tenKhachHang, tenNhanVien, ngayLap, tongTien, maKhuyenMai);
        cthd.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        cthd.setVisible(true);
    }//GEN-LAST:event_danhSachHoaDonMouseClicked

    private static CellStyle DinhdangHeader(XSSFSheet sheet) {
        // Create font
        XSSFFont font = sheet.getWorkbook().createFont();
        font.setFontName("Times New Roman");
        font.setBold(true);
        font.setFontHeightInPoints((short) 12); // font size
        font.setColor(IndexedColors.WHITE.getIndex()); // text color

        // Create CellStyle
        CellStyle cellStyle = sheet.getWorkbook().createCellStyle();
        cellStyle.setFont(font);
        cellStyle.setAlignment(HorizontalAlignment.CENTER);
        cellStyle.setVerticalAlignment(VerticalAlignment.TOP);
        cellStyle.setFillForegroundColor(IndexedColors.DARK_GREEN.getIndex());
        cellStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);
        cellStyle.setBorderBottom(BorderStyle.THIN);
        cellStyle.setWrapText(true);
        return cellStyle;
    }
    private void xuatExcelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_xuatExcelActionPerformed
        try {
            String duongdan = txtDuongDan.getText().trim();
            if (duongdan.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Vui lòng chọn nơi lưu file trước khi xuất!");
                buttonBrowse.requestFocus();
                return;
            }
            XSSFWorkbook workbook = new XSSFWorkbook();
            XSSFSheet spreadsheet = workbook.createSheet("hoadon");
            // register the columns you wish to track and compute the column width

            CreationHelper createHelper = workbook.getCreationHelper();

            XSSFRow row = null;
            Cell cell = null;

            row = spreadsheet.createRow((short) 2);
            row.setHeight((short) 500);
            cell = row.createCell(0, CellType.STRING);
            cell.setCellValue("DANH SÁCH HÓA ĐƠN");

            //Tạo dòng tiêu đều của bảng
            // create CellStyle
            CellStyle cellStyle_Head = DinhdangHeader(spreadsheet);
            row = spreadsheet.createRow((short) 3);
            row.setHeight((short) 500);
            cell = row.createCell(0, CellType.STRING);
            cell.setCellStyle(cellStyle_Head);
            cell.setCellValue("STT");

            cell = row.createCell(1, CellType.STRING);
            cell.setCellStyle(cellStyle_Head);
            cell.setCellValue("Mã hóa đơn");

            cell = row.createCell(2, CellType.STRING);
            cell.setCellStyle(cellStyle_Head);
            cell.setCellValue("Mã khách hàng");

            cell = row.createCell(3, CellType.STRING);
            cell.setCellStyle(cellStyle_Head);
            cell.setCellValue("Mã nhân viên");

            cell = row.createCell(4, CellType.STRING);
            cell.setCellStyle(cellStyle_Head);
            cell.setCellValue("Ngày lập hóa đơn");

            cell = row.createCell(5, CellType.STRING);
            cell.setCellStyle(cellStyle_Head);
            cell.setCellValue("Tổng tiền(KM)");

            cell = row.createCell(6, CellType.STRING);
            cell.setCellStyle(cellStyle_Head);
            cell.setCellValue("Mã KM");
            //Kết nối DB

            Connection con = ConnectDB.KetnoiDB();
            String sql = "select * from hoadon";

            PreparedStatement st = con.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            //Đổ dữ liệu từ rs vào các ô trong excel
            ResultSetMetaData rsmd = rs.getMetaData();
            int tongsocot = rsmd.getColumnCount();

            //Đinh dạng Tạo đường kẻ cho ô chứa dữ liệu
            CellStyle cellStyle_data = spreadsheet.getWorkbook().createCellStyle();
            cellStyle_data.setBorderLeft(BorderStyle.THIN);
            cellStyle_data.setBorderRight(BorderStyle.THIN);
            cellStyle_data.setBorderBottom(BorderStyle.THIN);

            int i = 0;
            while (rs.next()) {
                row = spreadsheet.createRow((short) 4 + i);
                row.setHeight((short) 400);

                cell = row.createCell(0);
                cell.setCellStyle(cellStyle_data);
                cell.setCellValue(i + 1);

                cell = row.createCell(1);
                cell.setCellStyle(cellStyle_data);
                cell.setCellValue(rs.getString("mahd"));

                cell = row.createCell(2);
                cell.setCellStyle(cellStyle_data);
                cell.setCellValue(rs.getString("makh"));

                cell = row.createCell(3);
                cell.setCellStyle(cellStyle_data);
                cell.setCellValue(rs.getString("manv"));

                //Định dạng ngày tháng trong excel
                java.sql.Date bd = new java.sql.Date(rs.getDate("ngaylap").getTime());
                CellStyle cellStyle = workbook.createCellStyle();
                cellStyle.setDataFormat(createHelper.createDataFormat().getFormat("yyyy-MM-dd HH:mm:ss"));
                cellStyle.setBorderLeft(BorderStyle.THIN);
                cellStyle.setBorderRight(BorderStyle.THIN);
                cellStyle.setBorderBottom(BorderStyle.THIN);
                cell = row.createCell(4);
                cell.setCellValue(bd);
                cell.setCellStyle(cellStyle);

                cell = row.createCell(5);
                cell.setCellStyle(cellStyle_data);
                cell.setCellValue(rs.getString("tongtien"));

                cell = row.createCell(6);
                cell.setCellStyle(cellStyle_data);
                cell.setCellValue(rs.getString("makm"));

                i++;
            }
            //Hiệu chỉnh độ rộng của cộttt
            for (int col = 0; col < tongsocot; col++) {
                spreadsheet.autoSizeColumn(col);
                spreadsheet.setColumnWidth(col, spreadsheet.getColumnWidth(col) + 1000); // Tăng thêm 1000 đơn vị
            }
            String filename = JOptionPane.showInputDialog(this, "Nhập tên file để xuất:");
            File f = new File(duongdan + "\\" + filename + ".xlsx");
            FileOutputStream out = new FileOutputStream(f);
            workbook.write(out);
            out.close();
            JOptionPane.showMessageDialog(this, "Xuất thành công, vui lòng kiểm tra trong đường dẫn đã chọn !");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Có lỗi xuất file excel");
            e.printStackTrace();
        }
    }//GEN-LAST:event_xuatExcelActionPerformed

    private void nhapExcelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nhapExcelActionPerformed
        try {
            JFileChooser fc = new JFileChooser();
            int lc = fc.showOpenDialog(this);
            if (lc == JFileChooser.APPROVE_OPTION) {
                File file = fc.getSelectedFile();
                //                txtTenfile.setText(file.getPath());
                String tenfile = file.getName();
                if (tenfile.endsWith(".xlsx")) {    //endsWith chọn file có phần kết thúc ...
                    ReadExcel(file.getPath());
                    JOptionPane.showMessageDialog(this, "Nhập thành công");
                } else {
                    JOptionPane.showMessageDialog(this, "Phải chọn file excel");
                }
            }
        } catch (Exception e) {
        }
    }//GEN-LAST:event_nhapExcelActionPerformed

    private void sapXepActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sapXepActionPerformed
        String tc = sapXep.getSelectedItem().toString();  // Lấy giá trị từ ComboBox
        String txt = txtTimKiem.getText().trim();  // Lấy nội dung tìm kiếm
        try {
            Connection con = ConnectDB.KetnoiDB();
            java.sql.Statement st = con.createStatement();
            String sql;

            // Xây dựng câu truy vấn SQL với điều kiện sắp xếp và tìm kiếm
            if (tc.equals("sắp xếp tăng")) {
                sql = "SELECT hd.mahd, kh.tenkhachhang, nv.tennhanvien, hd.ngaylap, hd.tongtien, hd.makm "
                        + "FROM hoadon hd "
                        + "JOIN khachhang kh ON hd.makh = kh.makh "
                        + "JOIN nhanvien nv ON hd.manv = nv.manv "
                        //                        
                        + "ORDER BY hd.tongtien ASC";  // Sắp xếp tăng dần theo tổng tiền
            } else if (tc.equals("sắp xếp giảm")) {
                sql = "SELECT hd.mahd, kh.tenkhachhang, nv.tennhanvien, hd.ngaylap, hd.tongtien, hd.makm "
                        + "FROM hoadon hd "
                        + "JOIN khachhang kh ON hd.makh = kh.makh "
                        + "JOIN nhanvien nv ON hd.manv = nv.manv "
                        //                       
                        + "ORDER BY hd.tongtien DESC";  // Sắp xếp giảm dần theo tổng tiền
            } else {
                load_hd();  // Nếu không có giá trị sắp xếp hợp lệ, tải dữ liệu bình thường
                return;
            }

            ResultSet rs = st.executeQuery(sql);

            // Cấu trúc bảng hiển thị
            String[] arr = {"Mã hóa đơn", "Tên khách hàng", "Nhân viên lập hóa đơn", "Ngày lập hóa đơn", "Tổng tiền(KM)", "Mã KM"};
            DefaultTableModel model = new DefaultTableModel(arr, 0);

            // Thêm dữ liệu vào bảng
            while (rs.next()) {
                Vector v = new Vector();
                v.add(rs.getString("mahd"));
                v.add(rs.getString("tenkhachhang"));
                v.add(rs.getString("tennhanvien"));
                v.add(rs.getString("ngaylap"));
                v.add(rs.getString("tongtien"));
                v.add(rs.getString("makm"));
                model.addRow(v);
            }
            danhSachHoaDon.setModel(model);  // Thiết lập model cho JTable

            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_sapXepActionPerformed

    private void soMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_soMouseClicked
        int confirm = JOptionPane.showConfirmDialog(this, "Bạn có chắc chắn muốn đăng xuất", "Xác nhận", JOptionPane.YES_NO_OPTION);
        if (confirm == 0) {
            login gg = new login();
            gg.show();
            dispose();
        }
    }//GEN-LAST:event_soMouseClicked

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

    private void butnhanvienMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_butnhanvienMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_butnhanvienMouseClicked

    private void buttonBrowseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonBrowseActionPerformed
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setDialogTitle("Chọn thư mục lưu trữ"); // Đặt tiêu đề hộp thoại
        fileChooser.setApproveButtonText("Chọn thư mục"); // Đổi tên nút xác nhận
        fileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY); // Để chọn thư mục, nếu bạn muốn chọn file thì dùng FILES_ONLY
        int result = fileChooser.showOpenDialog(null);

        if (result == JFileChooser.APPROVE_OPTION) {
            File selectedFile = fileChooser.getSelectedFile();
            txtDuongDan.setText(selectedFile.getAbsolutePath()); // Hiển thị đường dẫn lên JTextPane
            txtDuongDan.setEnabled(false);
        }
    }//GEN-LAST:event_buttonBrowseActionPerformed

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
            java.util.logging.Logger.getLogger(Dashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Dashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Dashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Dashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Dashboard().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel butnhanvien;
    private javax.swing.JButton buttonBrowse;
    private javax.swing.JLabel chucvu;
    private javax.swing.JTable danhSachHoaDon;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JLabel nen;
    private javax.swing.JButton nhapExcel;
    private javax.swing.JComboBox<String> sapXep;
    private javax.swing.JLabel so;
    private javax.swing.JLabel taik;
    private javax.swing.JButton themHoaDon;
    private javax.swing.JButton timKiem;
    private javax.swing.JTextPane txtDuongDan;
    private javax.swing.JTextPane txtTimKiem;
    private javax.swing.JButton xuatExcel;
    // End of variables declaration//GEN-END:variables

    private void themHoaDon(String maHoaDon, String makh, String manv, String ngayLapHoaDon, String tongTienKhuyenMai, String maKhuyenMai, String maSanPhamTach[], String soLuongTach[], String giaTach[]) {
        // Chuyển đổi ngày thành định dạng chuỗi SQL
//        Date ngayLapHoaDon_1 = new Date(ngayLapHoaDon.getTime());

        int maHoaDon_1 = Integer.parseInt(maHoaDon);

        // Chuyển đổi sang java.sql.Timestamp để lưu vào cơ sở dữ liệu
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        LocalDateTime localDateTime = LocalDateTime.parse(ngayLapHoaDon, formatter);
        java.sql.Timestamp sqlTimestamp = java.sql.Timestamp.valueOf(localDateTime);

        double tongTienKhuyenMai_1 = Double.parseDouble(tongTienKhuyenMai);
        try {
            Connection conn = ConnectDB.KetnoiDB();
            String sql = "INSERT into hoadon  Values('" + maHoaDon_1 + "',N'" + sqlTimestamp + "',N'" + makh + "','" + manv + "','" + tongTienKhuyenMai_1 + "','" + maKhuyenMai + "')";

            // Thêm từng chi tiết hóa đơn vào bảng `chitiethoadon`
            String sqlInsertChiTietHD = "INSERT INTO chitiethoadon (mahd, masp, soluong, gia, machitiethd) VALUES (?, ?, ?, ?, ?)";
            PreparedStatement psChiTietHD = conn.prepareStatement(sqlInsertChiTietHD);
            for (int i = 0; i < maSanPhamTach.length; i++) {
                
                String maChiTietHoaDon = "MCHD" + maHoaDon_1 + "" + (i + 1);
                String maSP = maSanPhamTach[i].toString();  // Lấy mã sản phẩm từ cột 0
                int soLuong = Integer.parseInt(soLuongTach[i].toString());  // Lấy số lượng từ cột 2
                double gia = Double.parseDouble(giaTach[i].toString());  // Lấy giá từ cột 3
                System.out.println(gia);
                psChiTietHD.setInt(1, maHoaDon_1);  // Mã hóa đơn
                psChiTietHD.setString(2, maSP);  // Mã sản phẩm
                psChiTietHD.setInt(3, soLuong);  // Số lượng
                psChiTietHD.setDouble(4, gia);  // Giá
                psChiTietHD.setString(5, maChiTietHoaDon);  // Mã chi tiết hóa đơn
                psChiTietHD.addBatch();  // Thêm vào batch
            }
//            psChiTietHD.executeBatch();
            
            java.sql.Statement st = conn.createStatement();
            st.executeUpdate(sql);
            load_hd();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "loi");
        }

        this.load_hd();

    }
    int i = 0;
    String maTonTai = "";

    private void kiemTraMaHoaDon(String maHoaDon) {
        try {
            Connection conn = ConnectDB.KetnoiDB();
            String check = "select mahd from hoadon";
            java.sql.Statement tt = conn.createStatement();
            ResultSet rs = tt.executeQuery(check);
            while (rs.next()) {
                String m = rs.getString("mahd");
                if (m.equals(maHoaDon)) {
                    i = 1;
                    //tbkm.setText("Mã khuyến mãi đã tồn tại");
                    maTonTai = maTonTai + maHoaDon + " + ";
                    System.out.println("Ma ton tai" + maTonTai);
                    return;
                } else {
                    i = 0;
                }
            }
        } catch (Exception e) {
        }

    }

    // Hàm đọc dữ liệu từ ô dưới dạng chuỗi
    private String getCellValueAsString(Cell cell) {
        if (cell == null) {
            return "";
        }

        switch (cell.getCellType()) {
            case STRING:
                return cell.getStringCellValue();
            case NUMERIC:
                if (DateUtil.isCellDateFormatted(cell)) {
                    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
                    return dateFormat.format(cell.getDateCellValue());
                } else {
                    return String.valueOf((int) cell.getNumericCellValue());
                }
            case BOOLEAN:
                return String.valueOf(cell.getBooleanCellValue());
            case BLANK:
                return "";
            default:
                return cell.toString(); // Đọc dưới dạng chuỗi nếu kiểu không xác định
        }
    }

    private void ReadExcel(String tenFilePath) {

        try {
            FileInputStream fis = new FileInputStream(tenFilePath);
            XSSFWorkbook wb = new XSSFWorkbook(fis);
            XSSFSheet sheet = wb.getSheetAt(0);
            Iterator<Row> itr = sheet.iterator();

            if (itr.hasNext()) {
                itr.next(); // Bỏ qua dòng đầu tiên
            }

            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

            while (itr.hasNext()) {
                Row row = itr.next();
                // Đọc mã hóa đơn
                String maHoaDon = getCellValueAsString(row.getCell(0));
                System.out.println(maHoaDon);

                // Đọc mã khách hàng
                String maKhachHang = getCellValueAsString(row.getCell(1));
                System.out.println(maKhachHang);

                // Đọc mã nhân viên
                String maNhanVien = getCellValueAsString(row.getCell(2));
                System.out.println(maNhanVien);

                // Đọc ngày lập hóa đơn
                String ngayLapHoaDonText = getCellValueAsString(row.getCell(3));
                System.out.println("Ngày lập hóa đơn: " + ngayLapHoaDonText);

                // Đọc tổng tiền khuyến mãi
                String tongTienKhuyenMai = getCellValueAsString(row.getCell(4));
                System.out.println(tongTienKhuyenMai);

                // Đọc mã khuyến mãi
                String maKhuyenMai = getCellValueAsString(row.getCell(5));
                System.out.println(maKhuyenMai);

                // Đọc và tách mã sản phẩm
                String maSanPham = getCellValueAsString(row.getCell(6));
                String[] maSanPhamTach = maSanPham.split(",");
                System.out.println(maSanPham);
      

                // Đọc và tách số lượng
                String soLuong = getCellValueAsString(row.getCell(7));
                String[] soLuongTach = soLuong.split(",");
//                System.out.println("Số lượng: " + Arrays.toString(soLuongTach));

                // Đọc và tách giá
                String gia = getCellValueAsString(row.getCell(8));
                String[] giaTach = gia.split(",");
//      
                kiemTraMaHoaDon(maHoaDon);
                if (i == 0) {
                    themHoaDon(maHoaDon, maKhachHang, maNhanVien, ngayLapHoaDonText, tongTienKhuyenMai, maKhuyenMai, maSanPhamTach, soLuongTach, giaTach);
                }
            }

            if (!maTonTai.equals("")) {
                JOptionPane.showMessageDialog(this, "Không thêm được mã hóa đơn: " + maTonTai + " vì mã đã tồn tại trong dữ liệu");
                maTonTai = "";
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
