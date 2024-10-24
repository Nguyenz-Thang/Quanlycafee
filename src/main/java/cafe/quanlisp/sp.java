package cafe.quanlisp;

import cafe.User;
import cafe.baocaoquanli.*;
import cafe.login;
import cafe.nhacungcap.nhacungcap;
import cafe.quanlihoadon.Dashboard;
import cafe.quanlikh.ConnectDB;
import cafe.quanlikh.main;
import cafe.quanlikh.suakh;
import cafe.quanlinhanvien.nv;
import cafe.quanlisp.sp;
import cafe.thongke.thongke;
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
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Iterator;
import java.util.Vector;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.design.JRDesignQuery;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.xml.JRXmlLoader;
import net.sf.jasperreports.view.JasperViewer;
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
 * @author Acer
 */
public class sp extends javax.swing.JFrame {

    /**
     * Creates new form km
     */
    User userzz = new User();
    public void setuser(User user){
        taik.setText(user.getTaikhoan());
        chucvu.setText(user.getChucvu());
        userzz=user;
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
    public sp() {
        initComponents();
        load_sanpham();
        load_loaisanpham();
        ImageIcon logo = new ImageIcon(getClass().getResource("/icon/coffee.png"));
        setIconImage(logo.getImage());
        setTitle("Quản lý sản phẩm");
    }

    private km km1;

    public sp(km km1) {
        this.km1 = km1; // Lưu tham chiếu vào biến
        initComponents();
        this.setLocationRelativeTo(null);
    }

    public void load_sanpham() {
        try {

            //B1: Kết nối đến DB
            Connection con = ConnectDB.KetnoiDB();
            //B2: Tạo đối tượng Statement để thực hiện câu lệnh truy cập
            String sql = "Select * From sanpham";
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);
            String[] tieude = {"Mã sản phẩm", "Mã loại sản phẩm", "Tên sản phẩm", "Giá bán", "Mô tả", "Trạng thái", "Hình ảnh", "Nhà cung cấp", "Số lượng"};
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
                String tenAnh = new File(hinhanh).getName();
                v.add(tenAnh);

                v.add(rs.getString("macongty"));
                v.add(rs.getString("soluong"));
                tb.addRow(v);
            }
            thongtin1.setModel(tb);
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void load_loaisanpham() {
        try {

            //B1: Kết nối đến DB
            Connection con = ConnectDB.KetnoiDB();
            //B2: Tạo đối tượng Statement để thực hiện câu lệnh truy cập
            String sql = "Select * From loaisanpham";
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);
            String[] tieude = {"Mã loại sản phẩm", "Tên loại sản phẩm"};
            DefaultTableModel tb = new DefaultTableModel(tieude, 0);
            while (rs.next()) {
                Vector v = new Vector();
                v.add(rs.getString("maloai"));
                v.add(rs.getString("tenloai"));

                tb.addRow(v);
            }
            thongtinloai.setModel(tb);
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * nhu c This method is called from within the constructor to initialize the
     * form. WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel4 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        thongtinloai = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        loaisanpham = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        sanpham = new javax.swing.JLabel();
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
        thongtin1 = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        jPanel4.setBackground(new java.awt.Color(227, 227, 227));
        jPanel4.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        thongtinloai.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        thongtinloai.setModel(new javax.swing.table.DefaultTableModel(
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
        thongtinloai.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                thongtinloaiMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(thongtinloai);

        jLabel2.setBackground(new java.awt.Color(51, 153, 255));
        jLabel2.setFont(new java.awt.Font("Segoe UI Black", 2, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 0, 51));
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/campaign.png"))); // NOI18N
        jLabel2.setText("Quản lí loại sản phẩm");

        loaisanpham.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        loaisanpham.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        loaisanpham.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/shopping-online.png"))); // NOI18N
        loaisanpham.setText("Loại sản phẩm");
        loaisanpham.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                loaisanphamMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 925, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(loaisanpham, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(117, 117, 117)
                .addComponent(jLabel2)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(loaisanpham))
                .addGap(43, 43, 43)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 265, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel5.setBackground(new java.awt.Color(204, 204, 204));

        jLabel1.setBackground(new java.awt.Color(51, 153, 255));
        jLabel1.setFont(new java.awt.Font("Segoe UI Black", 2, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 51));
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/campaign.png"))); // NOI18N
        jLabel1.setText("Quản lí sản phẩm");

        sanpham.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        sanpham.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        sanpham.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/new-product.png"))); // NOI18N
        sanpham.setText("Sản phẩm");
        sanpham.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                sanphamMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(sanpham, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(135, 135, 135)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addContainerGap(22, Short.MAX_VALUE)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(sanpham))
                .addGap(17, 17, 17))
        );

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
        jPanel1.add(nen, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 210, 840));

        thongtin1.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        thongtin1.setModel(new javax.swing.table.DefaultTableModel(
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
        thongtin1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                thongtin1MouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(thongtin1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane2)
                            .addComponent(jPanel5, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(41, 41, 41)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 263, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(12, 12, 12)
                        .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void thongtinloaiMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_thongtinloaiMouseClicked

        // int selectedRow = tablehienthi.getSelectedRow(); // lay chi so dog duoc chon

    }//GEN-LAST:event_thongtinloaiMouseClicked

    private void sanphamMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_sanphamMouseClicked
        formsanpham s = new formsanpham();
        s.show();
        dispose();
    }//GEN-LAST:event_sanphamMouseClicked

    private void loaisanphamMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_loaisanphamMouseClicked
        // TODO add your handling code here:
        dispose();
        formloaisanpham form = new formloaisanpham();
        form.setVisible(true);
    }//GEN-LAST:event_loaisanphamMouseClicked

    private void thongtin1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_thongtin1MouseClicked
        // TODO add your handling code here:
        int i;
        i = thongtin1.getSelectedRow();
        DefaultTableModel model = (DefaultTableModel) thongtin1.getModel();
        String imagePath = "";
        String ma = model.getValueAt(i, 0).toString();

        try {
            Connection con;
            con = ConnectDB.KetnoiDB();
            Statement st = con.createStatement();
            String sql = "Select hinhanh From sanpham where masp='" + ma + "'";
            ResultSet rs = st.executeQuery(sql);

            if (rs.next()) {
                imagePath = rs.getString("hinhanh");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_thongtin1MouseClicked

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
            java.util.logging.Logger.getLogger(sp.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(sp.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(sp.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(sp.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>


        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new sp().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel butnhanvien;
    private javax.swing.JLabel chucvu;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel loaisanpham;
    private javax.swing.JLabel nen;
    private javax.swing.JLabel sanpham;
    private javax.swing.JLabel so;
    private javax.swing.JLabel taik;
    private javax.swing.JTable thongtin1;
    private javax.swing.JTable thongtinloai;
    // End of variables declaration//GEN-END:variables

}
