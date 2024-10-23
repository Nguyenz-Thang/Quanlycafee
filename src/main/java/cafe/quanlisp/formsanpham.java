/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package cafe.quanlisp;

import cafe.quanlikh.*;
import cafe.baocaoquanli.km;
import cafe.baocaoquanli.themkm;
import cafe.login;
import cafe.quanlihoadon.Dashboard;
import cafe.quanlikh.suakh;
import cafe.quanlisp.sp;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Iterator;
import java.util.Vector;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import org.apache.poi.ss.usermodel.BorderStyle;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.CellType;
import static org.apache.poi.ss.usermodel.CellType.BOOLEAN;
import static org.apache.poi.ss.usermodel.CellType.FORMULA;
import static org.apache.poi.ss.usermodel.CellType.NUMERIC;
import static org.apache.poi.ss.usermodel.CellType.STRING;
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
 * @author gunna666
 */
public class formsanpham extends javax.swing.JFrame {

    /**
     * Creates new form suaxoa
     */
    private themsanpham tspm;
    private suathongtin sttsp;

    public formsanpham() {
        initComponents();
        load_themsanpham();
        themsanpham form = new themsanpham(this);
        suathongtin form1 = new suathongtin(this);
    }

    public void load_themsanpham() {
        try {

            //B1: Kết nối đến DB
            Connection con = ConnectDB.KetnoiDB();
            //B2: Tạo đối tượng Statement để thực hiện câu lệnh truy cập
            String sql = "Select * From sanpham";
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);
            String[] tieude = {"Mã sản phẩm", "Mã loại sản phẩm", "Tên sản phẩm", "Giá bán", "Mô tả", "Trạng thái", "Hình ảnh", "Mã công ty", "Số lượng"};
            DefaultTableModel tb = new DefaultTableModel(tieude, 0);
            while (rs.next()) {
                Vector v = new Vector();
                v.add(rs.getString("masp"));
                v.add(rs.getString("maloai"));
                v.add(rs.getString("tensanpham"));
                v.add(rs.getString("gia"));
                v.add(rs.getString("mota"));
                v.add(rs.getString("trangthai"));

                //chỉ hiển thị tên ảnh 
                String hinhanh = rs.getString("hinhanh");
               // String tenAnh = new File(hinhanh).getName();
                v.add(hinhanh);

                v.add(rs.getString("macongty"));
                v.add(rs.getString("soluong"));

                tb.addRow(v);
            }
            tablehienthitxt.setModel(tb);
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        so = new javax.swing.JLabel();
        buttonsua = new javax.swing.JLabel();
        taik = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        Buttonxoa = new javax.swing.JLabel();
        vaitro = new javax.swing.JLabel();
        nen = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablehienthitxt = new javax.swing.JTable();
        jComboBoxsapxep = new javax.swing.JComboBox<>();
        buttontimkiem = new javax.swing.JButton();
        timkiemtxt = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jButton11 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(160, 140, 119));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

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

        buttonsua.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        buttonsua.setForeground(new java.awt.Color(255, 255, 255));
        buttonsua.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        buttonsua.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/new-product.png"))); // NOI18N
        buttonsua.setText("Sửa sản phẩm");
        buttonsua.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                buttonsuaMouseClicked(evt);
            }
        });
        jPanel1.add(buttonsua, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 260, 200, -1));

        taik.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        taik.setForeground(new java.awt.Color(255, 255, 255));
        taik.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        taik.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/profile.png"))); // NOI18N
        taik.setText("  ");
        jPanel1.add(taik, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 70, 180, -1));

        jLabel11.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/bill.png"))); // NOI18N
        jLabel11.setText("Thêm sản phẩm");
        jLabel11.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel11MouseClicked(evt);
            }
        });
        jPanel1.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 210, 210, -1));

        Buttonxoa.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        Buttonxoa.setForeground(new java.awt.Color(255, 255, 255));
        Buttonxoa.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Buttonxoa.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/shopping-online.png"))); // NOI18N
        Buttonxoa.setText("Xóa sản phẩm");
        Buttonxoa.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ButtonxoaMouseClicked(evt);
            }
        });
        jPanel1.add(Buttonxoa, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 310, 200, -1));

        vaitro.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        vaitro.setForeground(new java.awt.Color(255, 255, 255));
        vaitro.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jPanel1.add(vaitro, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 110, 150, 30));

        nen.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/no.png"))); // NOI18N
        jPanel1.add(nen, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 210, 830));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 3, 24)); // NOI18N
        jLabel1.setText("Thông tin sản phẩm");

        tablehienthitxt.setModel(new javax.swing.table.DefaultTableModel(
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
        tablehienthitxt.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablehienthitxtMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tablehienthitxt);

        jComboBoxsapxep.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "--Sắp xếp--", "Sắp xếp tăng", "Sắp xếp giảm" }));
        jComboBoxsapxep.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxsapxepActionPerformed(evt);
            }
        });

        buttontimkiem.setBackground(new java.awt.Color(153, 204, 255));
        buttontimkiem.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        buttontimkiem.setText("Tìm kiếm");
        buttontimkiem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttontimkiemActionPerformed(evt);
            }
        });

        jButton1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/xls.png"))); // NOI18N
        jButton1.setText("Nhập File excel");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton11.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jButton11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/excel.jpg"))); // NOI18N
        jButton11.setText("Xuất excel");
        jButton11.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton11MouseClicked(evt);
            }
        });
        jButton11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton11ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 234, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(234, 234, 234))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addComponent(buttontimkiem, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(29, 29, 29)
                        .addComponent(timkiemtxt)
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1)
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton1)
                        .addGap(94, 94, 94)
                        .addComponent(jButton11, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(132, 132, 132)
                        .addComponent(jComboBoxsapxep, 0, 121, Short.MAX_VALUE)
                        .addGap(149, 149, 149))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(jLabel1)
                .addGap(13, 13, 13)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(timkiemtxt)
                    .addComponent(buttontimkiem, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 42, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton11)
                    .addComponent(jComboBoxsapxep, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 629, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents


    private void soMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_soMouseClicked
        dispose();
        sp so1 = new sp();
        so1.setVisible(true);
    }//GEN-LAST:event_soMouseClicked


    private void jLabel11MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel11MouseClicked
        dispose();
        themsanpham themsp = new themsanpham(this);
        themsp.setVisible(true);

    }//GEN-LAST:event_jLabel11MouseClicked


    private void buttonsuaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_buttonsuaMouseClicked
        
        //tìm sản phẩm với mã sản phẩm được chọn
        int selectRow = tablehienthitxt.getSelectedRow();
        String masp = tablehienthitxt.getValueAt(selectRow, 0).toString();
        String maloai = tablehienthitxt.getValueAt(selectRow, 1).toString();
        String tensp = tablehienthitxt.getValueAt(selectRow, 2).toString();
        String gia = tablehienthitxt.getValueAt(selectRow, 3).toString();
        String mota = tablehienthitxt.getValueAt(selectRow, 4).toString();
        String trangthai = tablehienthitxt.getValueAt(selectRow, 5).toString();
        String hinhanh = tablehienthitxt.getValueAt(selectRow, 6).toString();
        String macongty = tablehienthitxt.getValueAt(selectRow, 7).toString();
        String soluong = tablehienthitxt.getValueAt(selectRow, 8).toString();

        this.dispose();
        suathongtin stt = new suathongtin(this, masp, maloai, tensp, gia, mota, hinhanh, trangthai, macongty, soluong);
        stt.setVisible(true);

    }//GEN-LAST:event_buttonsuaMouseClicked


    private void ButtonxoaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ButtonxoaMouseClicked
//        if (selectMasp == null) {
//            JOptionPane.showMessageDialog(this, "Vui lòng chọn sản phẩm.");
//            return;
//        }

        //tìm sản phẩm với mã sản phẩm được chọn
        int selectRow = tablehienthitxt.getSelectedRow();
        String masp = tablehienthitxt.getValueAt(selectRow, 0).toString();
        String maloai = tablehienthitxt.getValueAt(selectRow, 1).toString();
        String tensp = tablehienthitxt.getValueAt(selectRow, 2).toString();
        String gia = tablehienthitxt.getValueAt(selectRow, 3).toString();
        String mota = tablehienthitxt.getValueAt(selectRow, 4).toString();
        String trangthai = tablehienthitxt.getValueAt(selectRow, 5).toString();
        String hinhanh = tablehienthitxt.getValueAt(selectRow, 6).toString();
        String macongty = tablehienthitxt.getValueAt(selectRow, 7).toString();
        String soluong = tablehienthitxt.getValueAt(selectRow, 8).toString();

        this.dispose();
        xoathongtin xtt = new xoathongtin(this, masp, maloai, tensp, gia, mota, hinhanh, trangthai, macongty, soluong);
        xtt.setVisible(true);
    }//GEN-LAST:event_ButtonxoaMouseClicked


    private String selectMasp;


    private void tablehienthitxtMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablehienthitxtMouseClicked
        // TODO add your handling code here:
        int selectedRow = tablehienthitxt.getSelectedRow();
        int selectedColumn = tablehienthitxt.getSelectedColumn();

        // Kiểm tra nếu không có dòng hoặc cột nào được chọn
        if (selectedRow < 0 || selectedColumn < 0) {
            JOptionPane.showMessageDialog(this, "Không có dữ liệu được chọn.");
            return;
        }

        Object maloaivalue = tablehienthitxt.getValueAt(selectedRow, 0); // Lấy giá trị ô được chọn

        // Kiểm tra giá trị null trước khi gọi toString
        if (maloaivalue != null) {
            String maloai1 = maloaivalue.toString(); // Chuyển giá trị thành chuỗi
//           suathongtin form22 = new suathongtin(this);
//           form22.setVisible(true);

        } else {
            JOptionPane.showMessageDialog(this, "Ô bạn chọn không có dữ liệu.");
        }

        if (selectedRow != -1) {
            //lấy dữ liệu từ dòng được chọn
            String masp = (String) tablehienthitxt.getValueAt(selectedRow, 0).toString();
            String ml = (String) tablehienthitxt.getValueAt(selectedRow, 1).toString();
            String tensp = (String) tablehienthitxt.getValueAt(selectedRow, 2).toString();
            String gia = (String) tablehienthitxt.getValueAt(selectedRow, 3).toString();
            String mota = (String) tablehienthitxt.getValueAt(selectedRow, 4).toString();
            String ha = (String) tablehienthitxt.getValueAt(selectedRow, 5).toString();
            String tt = (String) tablehienthitxt.getValueAt(selectedRow, 6).toString();
            String mct = (String) tablehienthitxt.getValueAt(selectedRow, 7).toString();
            String sl = (String) tablehienthitxt.getValueAt(selectedRow, 8).toString();

            //gán dữ liệu vào form sửa sản phẩm
//            setSanphamInfo(masp,tensp,ml,gia,mota,ha,tt,mct,sl);
            selectMasp = tablehienthitxt.getValueAt(selectedRow, 0).toString();
//            this.dispose();
//            suathongtin stt = new suathongtin(this, masp, ml, tensp, gia, mota, ha, tt, mct, sl);
//            stt.setVisible(true);
//            

        }
    }//GEN-LAST:event_tablehienthitxtMouseClicked

    private void buttontimkiemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttontimkiemActionPerformed
        // TODO add your handling code here:

        String txt = timkiemtxt.getText().trim();
        try {
            Connection con = ConnectDB.KetnoiDB();
            Statement st = con.createStatement();
            String sql = "Select * from sanpham where masp like '%" + txt + "%' or tensanpham like N'%" + txt + "%' or maloai like '%" + txt + "%' or mota like N'%" + txt + "%'";
            ResultSet rs = st.executeQuery(sql);
            //   tbLoaiSach.removeAll();
            String[] arr = {"Mã sản phẩm", "Tên sản phẩm", "Mã loại", "Giá", "Mô tả", "Hình ảnh", "Trạng thái", "Mã công ty", "Số lượng"};
            DefaultTableModel model = new DefaultTableModel(arr, 0);
            int i = 0;
            while (rs.next()) {
                i = 1;
                Vector v = new Vector();
                v.add(rs.getString("masp"));
                v.add(rs.getString("tensanpham"));
                v.add(rs.getString("maloai"));
                v.add(rs.getString("gia"));
                v.add(rs.getString("mota"));
                v.add(rs.getString("hinhanh"));
                v.add(rs.getString("trangthai"));
                v.add(rs.getString("macongty"));
                v.add(rs.getString("soluong"));
                model.addRow(v);
            }
            if (i == 0) {
                Vector v = new Vector();
                v.add("Không có dữ liệuuuuuuu");
                model.addRow(v);
            }
            tablehienthitxt.setModel(model);
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_buttontimkiemActionPerformed

    private void jComboBoxsapxepActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxsapxepActionPerformed
        // TODO add your handling code here:
        String tc = jComboBoxsapxep.getSelectedItem().toString();
        String txt = timkiemtxt.getText().trim();
        try {
            Connection con = ConnectDB.KetnoiDB();
            Statement st = con.createStatement();
            String sql;
            if (tc.equals("Sắp xếp tăng")) {
                sql = "Select * from sanpham where masp like '%" + txt + "%' or tensanpham like N'%" + txt + "%' or maloai like '%" + txt + "%' or gia like N'%" + txt + "%'  or mota like N '%" + txt + "%' or hinhanh like'%" + txt + "%'or trangthai like N'%" + txt + "%' or macongty like N'%" + txt + " order by soluong ASC";
            } else if (tc.equals("Sắp xếp giảm")) {
                sql = "Select * from sanpham where masp like '%" + txt + "%' or tensanpham like N'%" + txt + "%' or maloai like '%" + txt + "%' or gia like N'%" + txt + "%'  or mota like N '%" + txt + "%' or hinhanh like'%" + txt + "%'or trangthai like N'%" + txt + "%' or macongty like N'%" + txt + " order by soluong DESC";
            } else {
                load_themsanpham();
                return;
            }

            ResultSet rs = st.executeQuery(sql);
            //   tbLoaiSach.removeAll();
            String[] arr = {"Mã sản phẩm", "Tên Sản Phẩm", "Mã Loại", "Giá", "Mô tả", "Hình Ảnh", "Trạng Thái","Mã công ty","Số lượng"};
            DefaultTableModel model = new DefaultTableModel(arr, 0);
            while (rs.next()) {
                Vector v = new Vector();
                v.add(rs.getString("masp"));
                v.add(rs.getString("tensp"));
                v.add(rs.getString("maloai"));
                v.add(rs.getString("gia"));
                v.add(rs.getString("mota"));
                v.add(rs.getString("hinhanh"));
                v.add(rs.getString("trangthai"));
                v.add(rs.getString("macongty"));
                v.add(rs.getString("soluong"));
                model.addRow(v);
            }
            tablehienthitxt.setModel(model);
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_jComboBoxsapxepActionPerformed
    private void Themkm(String masp, String tensp, String maloai, String gia, String mota, String hinhanh, String trangthai, String macongty, String soluong) {

        // Chuyển đổi ngày thành định dạng chuỗi SQL
        try {
            Connection conn = ConnectDB.KetnoiDB();
            String sql = "INSERT into sanpham Values('" + masp + "',N'" + tensp + "',N'" + maloai + "','" + gia + "','" + mota + "','" + hinhanh + "','" + trangthai + "','" + macongty + "','" + soluong + "')";
            Statement st = conn.createStatement();
            st.executeUpdate(sql);
            JOptionPane.showMessageDialog(this, "Nhập thành công");
            load_themsanpham();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    int i = 0;
    String matontai = "";

    private void ktmasp(String kmsp) {
        try {
            Connection conn = ConnectDB.KetnoiDB();
            String check = "select masp from sanpham";
            Statement tt = conn.createStatement();
            ResultSet rs = tt.executeQuery(check);
            while (rs.next()) {
                String m = rs.getString("masp");
                if (m.equals(kmsp)) {
                    i = 1;
                    //tbkm.setText("Mã khuyến mãi đã tồn tại");
                    matontai = matontai + kmsp + " + ";
                    System.out.println("Ma ton tai" + matontai);
                    return;
                } else {
                    i = 0;
                }
            }
        } catch (Exception e) {
        }

    }
    private void ReadExcel(String tenfilepath) {

        try {
            FileInputStream fis = new FileInputStream(tenfilepath);
            // Tạo đối tượng Excel
            XSSFWorkbook wb = new XSSFWorkbook(fis);
            XSSFSheet sheet = wb.getSheetAt(0); // Lấy sheet đầu tiên của file
            // Lấy ra các dòng trong bảng
            Iterator<Row> itr = sheet.iterator();
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

            // Đọc dữ liệu
            if (itr.hasNext()) {
                itr.next(); // Bỏ qua dòng đầu tiên
            }

            while (itr.hasNext()) {
                Row row = itr.next(); // Lấy dòng tiếp theo
                String masp = getCellValueAsString(row.getCell(0));
                String tensp = getCellValueAsString(row.getCell(1));
                String maloai = getCellValueAsString(row.getCell(2));
                String gia = getCellValueAsString(row.getCell(3));
                String mota = getCellValueAsString(row.getCell(4));
                String hinhanh = getCellValueAsString(row.getCell(5));
                String trangthai = getCellValueAsString(row.getCell(6));
                String macongty = getCellValueAsString(row.getCell(7));
                String soluong = getCellValueAsString(row.getCell(8));

                ktmasp(masp);
                if (i == 0) {
                    Themkm(masp, tensp, maloai, gia, mota, hinhanh, trangthai, macongty, soluong);
                }

            }
            if (!matontai.equals("")) {
                JOptionPane.showMessageDialog(this, "Không thêm được mã km : " + matontai + "vì mã đã tồn tại trong dữ liệu");
                matontai = "";
                return;
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private String getCellValueAsString(Cell cell) {
        switch (cell.getCellType()) {
            case STRING:
                return cell.getStringCellValue();
            case NUMERIC:
                if (DateUtil.isCellDateFormatted(cell)) {
                    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                    return sdf.format(cell.getDateCellValue());
                } else {
                    return String.valueOf(cell.getNumericCellValue());
                }
            case BOOLEAN:
                return String.valueOf(cell.getBooleanCellValue());
            case FORMULA:
                return cell.getCellFormula();
            default:
                return "";
        }
    }

    

    

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

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
         try {
            JFileChooser fc = new JFileChooser();
            int lc = fc.showOpenDialog(this);
            if (lc == JFileChooser.APPROVE_OPTION) {
                File file = fc.getSelectedFile();
                //                txtTenfile.setText(file.getPath());
                String tenfile = file.getName();
                if (tenfile.endsWith(".xlsx")) {    //endsWith chọn file có phần kết thúc ...
                    ReadExcel(file.getPath());

                } else {
                    JOptionPane.showMessageDialog(this, "Phải chọn file excel");
                }

            }
        } catch (Exception e) {
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton11ActionPerformed
        // TODO add your handling code here:
        
    }//GEN-LAST:event_jButton11ActionPerformed

    private void jButton11MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton11MouseClicked
        // TODO add your handling code here:
           // TODO add your handling code here:
          try {

            XSSFWorkbook workbook = new XSSFWorkbook();
            XSSFSheet spreadsheet = workbook.createSheet("tacgia");
            // register the columns you wish to track and compute the column width

            CreationHelper createHelper = workbook.getCreationHelper();

            XSSFRow row = null;
            Cell cell = null;

            row = spreadsheet.createRow((short) 2);
            row.setHeight((short) 500);
            cell = row.createCell(0, CellType.STRING);
            cell.setCellValue("DANH SÁCH SẢN PHẨM");

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
            cell.setCellValue("Mã Sản Phẩm");

            cell = row.createCell(2, CellType.STRING);
            cell.setCellStyle(cellStyle_Head);
            cell.setCellValue("Tên sản phẩm");

            cell = row.createCell(3, CellType.STRING);
            cell.setCellStyle(cellStyle_Head);
            cell.setCellValue("Mã loại");

            cell = row.createCell(4, CellType.STRING);
            cell.setCellStyle(cellStyle_Head);
            cell.setCellValue("Giá");

            cell = row.createCell(5, CellType.STRING);
            cell.setCellStyle(cellStyle_Head);
            cell.setCellValue("Mô tả");

            cell = row.createCell(6, CellType.STRING);
            cell.setCellStyle(cellStyle_Head);
            cell.setCellValue("Hình ảnh");

            cell = row.createCell(7, CellType.STRING);
            cell.setCellStyle(cellStyle_Head);
            cell.setCellValue("Trạng thái");
            //Kết nối DB

            cell = row.createCell(8, CellType.STRING);
            cell.setCellStyle(cellStyle_Head);
            cell.setCellValue("Mã công ty");

            cell = row.createCell(9, CellType.STRING);
            cell.setCellStyle(cellStyle_Head);
            cell.setCellValue("Số lượng");

            Connection con = ConnectDB.KetnoiDB();
            String sql = "";
            String tc = jComboBoxsapxep.getSelectedItem().toString();
            String txt = timkiemtxt.getText().trim();
            if (tc == "Sắp xếp tăng") {
                sql = "Select * from sanpham where masp like '%" + txt + "%' or tensanpham like N'%" + txt + "%' or maloai like '%" + txt + "%' or gia like '%" + txt + "%'  or mota like N'%" + txt + "%' or trangthai N'%" + txt + "%' or macongty like N'%" + txt + "%' order by soluong";
            } else if (tc == "Sắp xếp giảm") {
                sql = "Select * from sanpham where masp like '%" + txt + "%' or tensanpham like N'%" + txt + "%' or maloai like '%" + txt + "%' or gia like '%" + txt + "%'  or mota like N'%" + txt + "%' or trangthai N'%" + txt + "%' or macongty like N'%" + txt + "%' order by soluong desc";
            } else {
                sql = "Select * from sanpham where masp like '%" + txt + "%' or tensanpham like N'%" + txt + "%' or maloai like '%" + txt + "%' or gia like '%" + txt + "%'  or mota like N'%" + txt + "%' or macongty like N'%" + txt + "%' order by soluong";

            }
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
                cell.setCellValue(rs.getString("masp"));

                cell = row.createCell(2);
                cell.setCellStyle(cellStyle_data);
                cell.setCellValue(rs.getString("tensanpham"));

                cell = row.createCell(3);
                cell.setCellStyle(cellStyle_data);
                cell.setCellValue(rs.getString("maloai"));

                cell = row.createCell(4);
                cell.setCellStyle(cellStyle_data);
                cell.setCellValue(rs.getString("gia"));

                cell = row.createCell(5);
                cell.setCellStyle(cellStyle_data);
                cell.setCellValue(rs.getString("mota"));

                cell = row.createCell(6);
                cell.setCellStyle(cellStyle_data);
                cell.setCellValue(rs.getString("hinhanh"));

                cell = row.createCell(7);
                cell.setCellStyle(cellStyle_data);
                cell.setCellValue(rs.getString("trangthai"));

                cell = row.createCell(8);
                cell.setCellStyle(cellStyle_data);
                cell.setCellValue(rs.getString("macongty"));

                cell = row.createCell(9);
                cell.setCellStyle(cellStyle_data);
                cell.setCellValue(rs.getString("soluong"));

                i++;
            }
            //Hiệu chỉnh độ rộng của cộttt
            for (int col = 0; col < tongsocot; col++) {
                spreadsheet.autoSizeColumn(col);
                spreadsheet.setColumnWidth(col, spreadsheet.getColumnWidth(col) + 1000); // Tăng thêm 1000 đơn vị
            }
            String filename = JOptionPane.showInputDialog(this, "Nhập tên file để xuất:");
            File f = new File("E:\\filesanphamxuatbaocao\\nhapfile\\" + filename + ".xlsx");
            //File f = new File("C:\\\\Users\\\\Acer\\\\Desktop\\\\" + filename + ".xlsx");
            if (!f.getParentFile().exists()) {
                JOptionPane.showMessageDialog(this, "Thư mục không tồn tại");
                return;
            }
            
            FileOutputStream out = new FileOutputStream(f);
            workbook.write(out);
            out.close();
            JOptionPane.showMessageDialog(this, "Xuất thành công, vui lòng kiểm tra desktop");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Có lỗi xuất file excel");
            e.printStackTrace();
        }
    }//GEN-LAST:event_jButton11MouseClicked

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
            java.util.logging.Logger.getLogger(formsanpham.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(formsanpham.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(formsanpham.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(formsanpham.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
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
                new formsanpham().setVisible(true);
            }
        });
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Buttonxoa;
    private javax.swing.JLabel buttonsua;
    private javax.swing.JButton buttontimkiem;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton11;
    private javax.swing.JComboBox<String> jComboBoxsapxep;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel nen;
    private javax.swing.JLabel so;
    private javax.swing.JTable tablehienthitxt;
    private javax.swing.JLabel taik;
    private javax.swing.JTextField timkiemtxt;
    private javax.swing.JLabel vaitro;
    // End of variables declaration//GEN-END:variables
}
