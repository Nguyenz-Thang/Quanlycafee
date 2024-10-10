/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package cafe.quanlikh;

import cafe.baocaoquanli.themkm;
import cafe.login;
import cafe.quanlikh.suakh;
import java.io.File;
import java.io.FileOutputStream;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Vector;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import org.apache.poi.ss.usermodel.BorderStyle;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.CreationHelper;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.HorizontalAlignment;
import org.apache.poi.ss.usermodel.IndexedColors;
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
    public main() {
        initComponents();
        load_quanlybancafe();
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
        jPanel1 = new javax.swing.JPanel();
        so = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        taik = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        vaitro = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
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
        jButton1.setText("Thêm");
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

        jLabel9.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/new-product.png"))); // NOI18N
        jLabel9.setText("Sản phẩm");
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 380, 210, -1));

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
        jLabel11.setText("Tạo hóa đơn");
        jPanel1.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 320, 210, -1));

        jLabel12.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/shopping-online.png"))); // NOI18N
        jLabel12.setText("Khuyến mãi");
        jPanel1.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 440, 210, -1));

        jLabel13.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/patient.png"))); // NOI18N
        jLabel13.setText("Khách hàng");
        jPanel1.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 500, 210, -1));

        vaitro.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        vaitro.setForeground(new java.awt.Color(255, 255, 255));
        vaitro.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jPanel1.add(vaitro, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 100, 150, 30));

        jLabel15.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(255, 255, 255));
        jLabel15.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel15.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/report.png"))); // NOI18N
        jLabel15.setText("Báo cáo");
        jPanel1.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 260, 210, -1));

        nen.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/no.png"))); // NOI18N
        jPanel1.add(nen, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 210, 830));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(238, 238, 238)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jButton12, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                            .addComponent(jButton5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(52, 52, 52)
                        .addComponent(timkiem, javax.swing.GroupLayout.PREFERRED_SIZE, 259, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(77, 77, 77)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(432, 432, 432)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(198, 198, 198)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 725, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(202, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(9, 9, 9)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(timkiem))
                .addGap(26, 26, 26)
                .addComponent(jButton12, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(71, 71, 71)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 499, javax.swing.GroupLayout.PREFERRED_SIZE)
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
            File f = new File("C:\\TestJava\\"+filename+".xlsx");
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

    private void soMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_soMouseClicked
        int confirm = JOptionPane.showConfirmDialog(this, "Bạn có chắc chắn muốn đăng xuất", "Xác nhận", JOptionPane.YES_NO_OPTION);
        if (confirm == 0) {
            login gg = new login();
            gg.show();
            dispose();
        }
    }//GEN-LAST:event_soMouseClicked

    private void timkiemmMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_timkiemmMouseClicked
        
    }//GEN-LAST:event_timkiemmMouseClicked

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
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton12;
    private javax.swing.JButton jButton5;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
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
    private javax.swing.JLabel vaitro;
    // End of variables declaration//GEN-END:variables
}
