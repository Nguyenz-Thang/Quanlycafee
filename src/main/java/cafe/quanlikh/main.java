/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package cafe.quanlikh;

import cafe.User;
import cafe.baocaoquanli.km;
import cafe.baocaoquanli.themkm;
import cafe.login;
import cafe.nhacungcap.nhacungcap;
import cafe.quanlihoadon.Dashboard;
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
public class main extends javax.swing.JFrame {

    /**
     * Creates new form suaxoa
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
    public main() {
        initComponents();
        load_quanlybancafe();
        this.setLocationRelativeTo(null);
        ImageIcon logo = new ImageIcon(getClass().getResource("/icon/coffee.png"));
        setIconImage(logo.getImage());
        setTitle("Khách hàng");
    }
    
    public void load_quanlybancafe() {
        try {
            Connection con;
            con = ConnectDB.KetnoiDB();
            Statement st = con.createStatement();
            String sql = "Select * From khachhang";
            ResultSet rs = st.executeQuery(sql);
            //   tbLoaiSach.removeAll();
            String[] arr = {"Mã khách hàng", "Họ tên", "Năm sinh", "Giới tính", "Số điện thoại", "Địa chỉ"};
            DefaultTableModel model = new DefaultTableModel(arr, 0);
            while (rs.next()) {
                Vector v = new Vector();
                v.add(rs.getString("makh"));
                v.add(rs.getString("tenkhachhang"));
                v.add(rs.getString("ngaysinh"));
                v.add(rs.getString("gioitinh"));
                v.add(rs.getString("sodienthoai"));
                v.add(rs.getString("diachi"));
                model.addRow(v);
            }
            txtqlkh.setModel(model);
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton5 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtqlkh = new javax.swing.JTable();
        timkiem = new javax.swing.JScrollPane();
        timkiemm = new javax.swing.JTextPane();
        jButton1 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jButton12 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        butnhanvien = new javax.swing.JLabel();
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

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jButton5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/search.png"))); // NOI18N
        jButton5.setText("Tìm kiếm");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        txtqlkh.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Mã khách hàng", "Họ tên", "Năm sinh", "Giới tính", "Số điện thoại", "Địa chỉ"
            }
        ));
        txtqlkh.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtqlkhMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(txtqlkh);

        timkiemm.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                timkiemmMouseClicked(evt);
            }
        });
        timkiem.setViewportView(timkiemm);

        jButton1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/add-user.png"))); // NOI18N
        jButton1.setText("Thêm k.hàng");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel1.setBackground(new java.awt.Color(0, 0, 0));
        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/guest-list.png"))); // NOI18N
        jLabel1.setText("Quản lý khách hàng");

        jButton12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/excel.jpg"))); // NOI18N
        jButton12.setText("Xuất Excel");
        jButton12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton12ActionPerformed(evt);
            }
        });

        jButton2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/xls.png"))); // NOI18N
        jButton2.setText("Nhập file Excel");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
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
        jPanel1.add(nen, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 210, 850));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(180, 180, 180)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(timkiem, javax.swing.GroupLayout.PREFERRED_SIZE, 348, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(jButton5))
                                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 725, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jButton2)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jButton12, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(417, 417, 417)
                        .addComponent(jLabel1)))
                .addContainerGap(226, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(21, 21, 21)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButton5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(timkiem))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 499, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(33, 33, 33)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton2)
                    .addComponent(jButton12))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtqlkhMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtqlkhMouseClicked
//        int i=txtqlkh.getSelectedRow();
//        DefaultTableModel tb=(DefaultTableModel)txtqlkh.getModel();
//        txtmkh.setText(tb.getValueAt(i, 0).toString());
//        txthoten.setText(tb.getValueAt(i, 1).toString());
//        String ngay=tb.getValueAt(i, 2).toString();
//        java.util.Date ngs;
//        try {
//            ngs = new SimpleDateFormat("yyyy-MM-dd").parse(ngay);
//            txtns.setDate(ngs);
//        } catch (Exception ex) {
//            ex.printStackTrace();
//        }
//        txtgioitinh.setSelectedItem(tb.getValueAt(i, 3).toString());
//        txtsdt.setText(tb.getValueAt(i, 4).toString());
//        txtdiachi.setText(tb.getValueAt(i, 5).toString());
        int i;
        i = txtqlkh.getSelectedRow();
        DefaultTableModel model = (DefaultTableModel) txtqlkh.getModel();

        String makh = model.getValueAt(i, 0).toString();
        String ten = model.getValueAt(i, 1).toString();
        String ns = model.getValueAt(i, 2).toString();
        String gt = model.getValueAt(i, 3).toString().trim();
        String sdt = model.getValueAt(i, 4).toString();
        String diachi = model.getValueAt(i, 5).toString();

        suakh tk = new suakh(this);
        tk.setData(makh, ten, ns, gt, sdt, diachi);
//        tk.setVisible(true);
        //       tk.show();
        tk.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        tk.addWindowListener(new java.awt.event.WindowAdapter() {
            @Override
            public void windowClosing(java.awt.event.WindowEvent windowEvent) {
                load_quanlybancafe(); // Gọi hàm load_km() khi suakm đóng
            }
        });
// Hiển thị form suakm
        tk.setVisible(true);


    }//GEN-LAST:event_txtqlkhMouseClicked
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


    private void jButton12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton12ActionPerformed
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
            cell.setCellValue("DANH SÁCH KHÁCH HÀNG");

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
            cell.setCellValue("Mã khách hàng");

            cell = row.createCell(2, CellType.STRING);
            cell.setCellStyle(cellStyle_Head);
            cell.setCellValue("Họ tên");

            cell = row.createCell(3, CellType.STRING);
            cell.setCellStyle(cellStyle_Head);
            cell.setCellValue("Năm sinh");

            cell = row.createCell(4, CellType.STRING);
            cell.setCellStyle(cellStyle_Head);
            cell.setCellValue("Giới tính");

            cell = row.createCell(5, CellType.STRING);
            cell.setCellStyle(cellStyle_Head);
            cell.setCellValue("Số điện thoại");

            cell = row.createCell(6, CellType.STRING);
            cell.setCellStyle(cellStyle_Head);
            cell.setCellValue("Địa chỉ");

            //Kết nối DB
            Connection con = ConnectDB.KetnoiDB();
            String sql = "Select * From khachhang";
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
                cell.setCellValue(rs.getString("makh"));

                cell = row.createCell(2);
                cell.setCellStyle(cellStyle_data);
                cell.setCellValue(rs.getString("tenkhachhang"));

                java.sql.Date bd = new java.sql.Date(rs.getDate("ngaysinh").getTime());
                CellStyle cellStyle = workbook.createCellStyle();
                cellStyle.setDataFormat(createHelper.createDataFormat().getFormat("dd/MM/yyyy"));
                cellStyle.setBorderLeft(BorderStyle.THIN);
                cellStyle.setBorderRight(BorderStyle.THIN);
                cellStyle.setBorderBottom(BorderStyle.THIN);
                cell = row.createCell(3);
                cell.setCellValue(bd);
                cell.setCellStyle(cellStyle);

                cell = row.createCell(4);
                cell.setCellStyle(cellStyle_data);
                cell.setCellValue(rs.getString("gioitinh"));

                cell = row.createCell(5);
                cell.setCellStyle(cellStyle_data);
                cell.setCellValue(rs.getString("sodienthoai"));

                cell = row.createCell(6);
                cell.setCellStyle(cellStyle_data);
                cell.setCellValue(rs.getString("diachi"));

                i++;
            }
            //Hiệu chỉnh độ rộng của cộttt
            for (int col = 0; col < tongsocot; col++) {
                spreadsheet.autoSizeColumn(col);
                spreadsheet.setColumnWidth(col, spreadsheet.getColumnWidth(col) + 1000); // Tăng thêm 1000 đơn vị
            }
            String filename = JOptionPane.showInputDialog(this, "Nhập tên file để xuất:");
            File f = new File("C:\\TestJava\\" + filename + ".xlsx");
            FileOutputStream out = new FileOutputStream(f);
            workbook.write(out);
            out.close();
            JOptionPane.showMessageDialog(this, "Xuất thành công, vui lòng kiểm tra desktop");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Có lỗi xuất file excel");
            e.printStackTrace();
        }
    }//GEN-LAST:event_jButton12ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        String tk = timkiemm.getText().trim();

        try {
            Connection con = ConnectDB.KetnoiDB();
            Statement st = con.createStatement();
            String sql = "Select * from khachhang where makh like '%" + tk + "%' or tenkhachhang like N'%" + tk + "%' or gioitinh like '%" + tk + "%' or sodienthoai like '%" + tk + "%' or diachi like N'%" + tk + "%'";
            ResultSet rs = st.executeQuery(sql);

            // Khởi tạo mô hình bảng
            String[] arr = {"Mã khách hàng", "Họ tên", "Năm sinh", "Giới tính", "Điện thoại", "Địa chỉ"};
            DefaultTableModel model = new DefaultTableModel(arr, 0);

            // Kiểm tra nếu ResultSet rỗng
            if (!rs.isBeforeFirst()) { // Kiểm tra xem ResultSet có bất kỳ hàng nào không
                // Hiển thị thông báo khi không có kết quả
                JOptionPane.showMessageDialog(null, "Không có đối tượng bạn muốn tìm kiếm", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
            } else {
                // Thêm dữ liệu vào bảng nếu có kết quả
                while (rs.next()) {
                    Vector v = new Vector();
                    v.add(rs.getString("makh"));
                    v.add(rs.getString("tenkhachhang"));
                    v.add(rs.getString("ngaysinh"));
                    v.add(rs.getString("gioitinh"));
                    v.add(rs.getString("sodienthoai"));
                    v.add(rs.getString("diachi"));
                    model.addRow(v);
                }
                txtqlkh.setModel(model);
            }

            // Đóng kết nối
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        themkh kk = new themkh(this);
        kk.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        kk.show();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void timkiemmMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_timkiemmMouseClicked

    }//GEN-LAST:event_timkiemmMouseClicked
    int i = 0;
    String matontai = "";

    private void ktmkh(String mkh) {
        try {
            Connection conn = ConnectDB.KetnoiDB();
            String check = "select makh from khachhang";
            Statement tt = conn.createStatement();
            ResultSet rs = tt.executeQuery(check);
            while (rs.next()) {
                String m = rs.getString("makh");
                if (m.equals(mkh)) {
                    i = 1;
                    //tbkm.setText("Mã khuyến mãi đã tồn tại");
                    
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

            XSSFWorkbook wb = new XSSFWorkbook(fis);
            XSSFSheet sheet = wb.getSheetAt(0); //Lấy sheet đầu tiên của file

            Iterator<Row> itr = sheet.iterator();
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

            if (itr.hasNext()) {
                itr.next(); // Bỏ qua dòng đầu tiên
            }
            while (itr.hasNext()) {//Lặp đến hết các dòng trong excel
                Row row = itr.next();//Lấy dòng tiếp theo

                // Thay đổi các tên phần tử ở đây:
                String mkh, ht, dc, gt;
                java.util.Date ns;
                int dt;

                // Gán giá trị từ từng ô trong Excel
                mkh = row.getCell(0).getStringCellValue(); // Mã khách hàng

                ht = row.getCell(1).getStringCellValue();// Họ tên
                ns = row.getCell(2).getDateCellValue();// Ngày sinh (kiểu Date)

                Cell gtCell = row.getCell(3);
                gt = gtCell.getStringCellValue(); // Giới tính
                dt = (int) row.getCell(4).getNumericCellValue();  // Số điện thoại
                dc = row.getCell(5).getStringCellValue();  // Địa chỉ

                // In ra giá trị đọc được
                // Gọi hàm xử lý thêm khách hàng (hoặc hàm khác tuỳ vào yêu cầu)
                ktmkh(mkh);
                if (i == 0) {
                    themkh(mkh, ht, dt, dc, gt, ns);
                }else{
                    matontai = matontai + mkh + " + ";
                    System.out.println("Ma ton tai" + matontai);
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

    private void themkh(String mkh, String ht, int dt, String dc, String gt, java.util.Date ns) {
//        Date bd = new Date();
//        Date kt = new Date();
        // Chuyển đổi ngày thành định dạng chuỗi SQL
        Date sqlns = new Date(ns.getTime());

        try {
            Connection conn = ConnectDB.KetnoiDB();
            String sql = "INSERT into khachhang Values('" + mkh + "',N'" + ht + "',N'" + dt + "','" + dc + "','" + gt + "','" + sqlns + "')";

            Statement st = conn.createStatement();
            st.executeUpdate(sql);
          //  JOptionPane.showMessageDialog(this, "Nhập thành công");
            load_quanlybancafe();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "loi");
        }
    }
    
    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
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
    }//GEN-LAST:event_jButton2ActionPerformed

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
            java.util.logging.Logger.getLogger(main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new main().setVisible(true);
            }
        });
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel butnhanvien;
    private javax.swing.JLabel chucvu;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton12;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton5;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel nen;
    private javax.swing.JLabel so;
    private javax.swing.JLabel taik;
    private javax.swing.JScrollPane timkiem;
    private javax.swing.JTextPane timkiemm;
    private javax.swing.JTable txtqlkh;
    // End of variables declaration//GEN-END:variables
}
