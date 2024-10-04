/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package cafe.quanlikh;

import cafe.baocaoquanli.km;
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
 * @author Acer
 */
public class themkhachhang extends javax.swing.JFrame {

    /**
     * Creates new form kh
     */
    public themkhachhang() {
        initComponents();
        load_quanlybancafe();
    }
    private void load_quanlybancafe(){
    try {
        
        //B1: Kết nối đến DB
        Connection con= ConnectDB.KetnoiDB();
        //B2: Tạo đối tượng Statement để thực hiện câu lệnh truy cập
        String sql = "Select * From khachhang";
        Statement st=con.createStatement();
        ResultSet rs = st.executeQuery(sql);
        String[] tieude={"Mã khách hàng", "Họ tên","Điện thoại","Địa chỉ"};
        DefaultTableModel tb=new DefaultTableModel(tieude,0);
        while(rs.next()){
            Vector v = new Vector();
            v.add(rs.getString("makh"));
            v.add(rs.getString("tenkhachhang"));
            v.add(rs.getString("sodienthoai"));
            v.add(rs.getString("diachi"));
            tb.addRow(v);
        }
        txtqlkh.setModel(tb);
        con.close();
    } catch (Exception e) {
        e.printStackTrace();
    }
}

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTextField1 = new javax.swing.JTextField();
        jButton4 = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtqlkh = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jButton5 = new javax.swing.JButton();
        jScrollPane6 = new javax.swing.JScrollPane();
        txtmkh = new javax.swing.JTextPane();
        jScrollPane7 = new javax.swing.JScrollPane();
        txthoten = new javax.swing.JTextPane();
        jScrollPane8 = new javax.swing.JScrollPane();
        txtdienthoai = new javax.swing.JTextPane();
        jScrollPane9 = new javax.swing.JScrollPane();
        txtdiachi = new javax.swing.JTextPane();
        jPanel2 = new javax.swing.JPanel();
        jButton6 = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
        jButton8 = new javax.swing.JButton();
        jButton9 = new javax.swing.JButton();
        jButton10 = new javax.swing.JButton();
        jButton11 = new javax.swing.JButton();
        jButton12 = new javax.swing.JButton();

        jTextField1.setText("jTextField1");

        jButton4.setText("jButton4");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 178, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        txtqlkh.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Tên", "Số điện thoại", "Địa chỉ"
            }
        ));
        txtqlkh.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtqlkhMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(txtqlkh);

        jButton1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jButton1.setText("Thêm");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jButton2.setText("Sửa");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jButton3.setText("Xoá");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jLabel1.setBackground(new java.awt.Color(0, 0, 0));
        jLabel1.setFont(new java.awt.Font("Segoe UI", 2, 24)); // NOI18N
        jLabel1.setText("Quản lý khách hàng");

        jLabel2.setBackground(new java.awt.Color(255, 255, 255));
        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(51, 51, 255));
        jLabel2.setText("Mã khách hàng");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(153, 102, 0));
        jLabel3.setText("Họ tên");

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 51, 51));
        jLabel4.setText("Số điện thoại");

        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 204, 204));
        jLabel5.setText("Địa chỉ");

        jButton5.setText("Tìm kiếm");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jScrollPane6.setViewportView(txtmkh);

        jScrollPane7.setViewportView(txthoten);

        jScrollPane8.setViewportView(txtdienthoai);

        jScrollPane9.setViewportView(txtdiachi);

        jPanel2.setBackground(new java.awt.Color(160, 140, 119));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jButton6.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jButton6.setText("Đăng xuất");
        jPanel2.add(jButton6, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 550, 210, -1));

        jButton7.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jButton7.setText("Tạo hóa đơn");
        jPanel2.add(jButton7, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 310, 210, -1));

        jButton8.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jButton8.setText("Sản phẩm");
        jPanel2.add(jButton8, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 370, 210, -1));

        jButton9.setBackground(new java.awt.Color(204, 255, 255));
        jButton9.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jButton9.setText("Khách hàng");
        jButton9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton9ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton9, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 490, 210, -1));

        jButton10.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jButton10.setText("Báo cáo");
        jButton10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton10ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton10, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 250, 210, -1));

        jButton11.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jButton11.setText("Khuyến mãi");
        jButton11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton11ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton11, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 430, 210, -1));

        jButton12.setText("Xuất Excel");
        jButton12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton12ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(120, 120, 120)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jScrollPane9, javax.swing.GroupLayout.PREFERRED_SIZE, 259, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jScrollPane8, javax.swing.GroupLayout.PREFERRED_SIZE, 259, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 259, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addGap(49, 49, 49)
                                .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 259, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(138, 138, 138)
                        .addComponent(jButton12)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 307, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 606, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(44, 44, 44))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel1)
                                        .addGap(95, 95, 95))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(76, 76, 76)))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(94, 94, 94))))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jButton3)
                        .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(52, 52, 52)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(49, 49, 49)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4))
                        .addGap(67, 67, 67)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jButton12, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 22, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 423, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(19, 19, 19))
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents


    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        try {
            
            String mkh= txtmkh.getText();
            String sql = "Delete from khachhang Where makh='"+mkh+"' ";
            Connection con = ConnectDB.KetnoiDB() ;
            Statement st =con.createStatement();
            st.executeUpdate(sql);
            con.close();
            load_quanlybancafe();
            JOptionPane.showMessageDialog(this, "Xóa thành công!");
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        String mkh = txtmkh.getText().trim();
        String ht = txthoten.getText().trim();
        
       
        String dt = txtdienthoai.getText().trim();
        String dc = txtdiachi.getText().trim();
              
        try { 
        Connection con = ConnectDB.KetnoiDB();
            
        String sql = "Insert into khachhang values('"+ mkh +"', N'"+ ht +"', '"+ dt +"', N'"+ dc +"')";
            
            Statement st = con.createStatement();
            st.executeUpdate(sql);
            con.close();
            load_quanlybancafe();
            JOptionPane.showMessageDialog(this, "Thêm mới thành công");
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        String mkh = txtmkh.getText().trim();
        String ht = txthoten.getText().trim();
        String dt = txtdienthoai.getText().trim();
        String dc = txtdiachi.getText().trim();
        try {
            Connection con = ConnectDB.KetnoiDB();
            Statement st = con.createStatement();
            String sql = "Select * from khachhang where makh like '%"+mkh+"%' and tenkhachhang like N'%" + ht + "%' and sodienthoai like '%"+dt+"%' and diachi like N'%"+dc+"%'";
            ResultSet rs = st.executeQuery(sql);
         //   tbLoaiSach.removeAll();
            String[] arr={"Mã khách hàng ","Họ tên", "Điện thoại" , "Địa chỉ"};
            DefaultTableModel model = new DefaultTableModel(arr,0);
            while(rs.next()){
                Vector v = new Vector();
                v.add(rs.getString("makh"));
                v.add(rs.getString("tenkhachhang"));
                v.add(rs.getString("sodienthoai"));
                v.add(rs.getString("diachi"));
  
                model.addRow(v);
            }
            txtqlkh.setModel(model);
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        try {
            
            String mkh= txtmkh.getText();
            String ht= txthoten.getText();
            String dt= txtdienthoai.getText();
            String dc = txtdiachi.getText();
            String sql = "Update khachhang Set tenkhachhang=N'"+ht+"', sodienthoai='"+dt+"', diachi=N'"+dc+"' Where makh='"+mkh+"' ";
            Connection con = ConnectDB.KetnoiDB() ;
            Statement st =con.createStatement();
            st.executeUpdate(sql);
            con.close();
            load_quanlybancafe();
            JOptionPane.showMessageDialog(this, "Sửa thành công!");
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void txtqlkhMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtqlkhMouseClicked
        int i=txtqlkh.getSelectedRow();
        DefaultTableModel tb=(DefaultTableModel)txtqlkh.getModel();
        txtmkh.setText(tb.getValueAt(i, 0).toString());
        txthoten.setText(tb.getValueAt(i, 1).toString());
        txtdienthoai.setText(tb.getValueAt(i, 2).toString());
        txtdiachi.setText(tb.getValueAt(i, 3).toString());
        
    }//GEN-LAST:event_txtqlkhMouseClicked

    private void jButton9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton9ActionPerformed
         
    }//GEN-LAST:event_jButton9ActionPerformed

    private void jButton10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton10ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton10ActionPerformed

    private void jButton11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton11ActionPerformed
        km k = new km();
        k.show();
        dispose();
    }//GEN-LAST:event_jButton11ActionPerformed

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
            cell.setCellValue("Số điện thoại");

            cell = row.createCell(4, CellType.STRING);
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
                
                cell = row.createCell(3);
                cell.setCellStyle(cellStyle_data);
                cell.setCellValue(rs.getString("sodienthoai"));

                cell = row.createCell(4);
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
            java.util.logging.Logger.getLogger(themkhachhang.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(themkhachhang.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(themkhachhang.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(themkhachhang.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new themkhachhang().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton10;
    private javax.swing.JButton jButton11;
    private javax.swing.JButton jButton12;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JButton jButton9;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JScrollPane jScrollPane8;
    private javax.swing.JScrollPane jScrollPane9;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextPane txtdiachi;
    private javax.swing.JTextPane txtdienthoai;
    private javax.swing.JTextPane txthoten;
    private javax.swing.JTextPane txtmkh;
    private javax.swing.JTable txtqlkh;
    // End of variables declaration//GEN-END:variables
}
