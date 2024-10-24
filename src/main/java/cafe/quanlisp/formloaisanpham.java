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
public class formloaisanpham extends javax.swing.JFrame {

    /**
     * Creates new form suaxoa
     */
    private themloaisanpham tspm;
    private sualoaisanpham sttsp;

    public formloaisanpham() {
        initComponents();
        load_themloaisanpham();
        themloaisanpham form = new themloaisanpham();
        sualoaisanpham form1 = new sualoaisanpham(this);
    }

    public void load_themloaisanpham() {
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
        themloaispbutton = new javax.swing.JLabel();
        Buttonxoa = new javax.swing.JLabel();
        vaitro = new javax.swing.JLabel();
        nen = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablehienthitxt = new javax.swing.JTable();
        buttontimkiem = new javax.swing.JButton();
        timkiemtxt = new javax.swing.JTextField();

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
        buttonsua.setText("Sửa loại sản phẩm");
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

        themloaispbutton.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        themloaispbutton.setForeground(new java.awt.Color(255, 255, 255));
        themloaispbutton.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        themloaispbutton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/bill.png"))); // NOI18N
        themloaispbutton.setText("Thêm loại sản phẩm");
        themloaispbutton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                themloaispbuttonMouseClicked(evt);
            }
        });
        jPanel1.add(themloaispbutton, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 210, 210, -1));

        Buttonxoa.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        Buttonxoa.setForeground(new java.awt.Color(255, 255, 255));
        Buttonxoa.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Buttonxoa.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/shopping-online.png"))); // NOI18N
        Buttonxoa.setText("Xóa loại sản phẩm");
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
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/add-product.png"))); // NOI18N
        jLabel1.setText("Thông tin loại sản phẩm");

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

        buttontimkiem.setBackground(new java.awt.Color(153, 204, 255));
        buttontimkiem.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        buttontimkiem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/search.png"))); // NOI18N
        buttontimkiem.setText("Tìm kiếm");
        buttontimkiem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttontimkiemActionPerformed(evt);
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
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 760, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addComponent(buttontimkiem, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(timkiemtxt)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel1)
                        .addGap(234, 234, 234))))
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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 31, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 629, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents


    private void soMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_soMouseClicked
        dispose();
        sp so1 = new sp();
        so1.setVisible(true);
    }//GEN-LAST:event_soMouseClicked


    private void themloaispbuttonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_themloaispbuttonMouseClicked
        dispose();
        themloaisanpham themloai = new themloaisanpham();
        themloai.setVisible(true);

    }//GEN-LAST:event_themloaispbuttonMouseClicked


    private void buttonsuaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_buttonsuaMouseClicked
//        if (selectMasp == null) {
//            JOptionPane.showMessageDialog(this, "Vui lòng chọn loại sản phẩm cần sửa.");
//            return;
//        }

        //tìm sản phẩm với mã sản phẩm được chọn
        int selectRow = tablehienthitxt.getSelectedRow();
        String maloai = tablehienthitxt.getValueAt(selectRow, 0).toString();
        String tenloai = tablehienthitxt.getValueAt(selectRow, 1).toString();

        this.dispose();
        sualoaisanpham stt = new sualoaisanpham(this,maloai,tenloai);
        stt.setVisible(true);

    }//GEN-LAST:event_buttonsuaMouseClicked


    private void ButtonxoaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ButtonxoaMouseClicked
//        if (selectMasp == null) {
//            JOptionPane.showMessageDialog(this, "Vui lòng chọn sản phẩm.");
//            return;
//        }

        //tìm sản phẩm với mã sản phẩm được chọn
        int selectRow = tablehienthitxt.getSelectedRow();

        String maloai = tablehienthitxt.getValueAt(selectRow, 0).toString();
        String tenloai = tablehienthitxt.getValueAt(selectRow, 1).toString();

        this.dispose();
        xoaloaisanpham xtt = new xoaloaisanpham(this,maloai,tenloai);
        xtt.setVisible(true);
    }//GEN-LAST:event_ButtonxoaMouseClicked

    private String selectMasp;
    
    private int selectedRow = -1; // Lưu lại chỉ số dòng đã chọn


    private void tablehienthitxtMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablehienthitxtMouseClicked
        // TODO add your handling code here:
        selectedRow = tablehienthitxt.getSelectedRow();
        int selectedColumn = tablehienthitxt.getSelectedColumn();

        // Kiểm tra nếu không có dòng hoặc cột nào được chọn
        if (selectedRow < 0 || selectedColumn < 0) {
            JOptionPane.showMessageDialog(this, "Không có dữ liệu được chọn.");
            return;
        }

        Object maloaivalue = tablehienthitxt.getValueAt(selectedRow, selectedColumn); // Lấy giá trị ô được chọn

        // Kiểm tra giá trị null trước khi gọi toString
        if (maloaivalue != null) {
            String maloai1 = maloaivalue.toString(); // Chuyển giá trị thành chuỗi

        } else {
            JOptionPane.showMessageDialog(this, "Ô bạn chọn không có dữ liệu.");
        }

        if (selectedRow == -1) {
            JOptionPane.showMessageDialog(this, "Vui lòng chọn một dòng có dữ liệu.");
            return;
        }
        String ml = (String) tablehienthitxt.getValueAt(selectedRow, 0).toString();
        String tenloai = (String) tablehienthitxt.getValueAt(selectedRow, 1).toString();

//        sualoaisanpham suaForm = new sualoaisanpham(this, true); // 'this' là tham chiếu đến formloaisanpham
//        suaForm.setLoaiSanPhamInfo(ml, tenloai); // Gọi phương thức để điền thông tin vào form sửa
//        suaForm.setVisible(true); // Hiển thị form sửa
    }//GEN-LAST:event_tablehienthitxtMouseClicked

    private void buttontimkiemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttontimkiemActionPerformed
        // TODO add your handling code here:

        String txt = timkiemtxt.getText().trim();
        try {
            Connection con = ConnectDB.KetnoiDB();
            Statement st = con.createStatement();
            String sql = "Select * from loaisanpham where maloai like '%" + txt + "%' or tenloai like N'%";
            ResultSet rs = st.executeQuery(sql);
            //   tbLoaiSach.removeAll();
            String[] arr = {"Mã loại sản phẩm", "Tên loại sản phẩm"};
            DefaultTableModel model = new DefaultTableModel(arr, 0);
            int i = 0;
            while (rs.next()) {
                i = 1;
                Vector v = new Vector();
                v.add(rs.getString("maloai"));
                v.add(rs.getString("tenloai"));

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
            java.util.logging.Logger.getLogger(formloaisanpham.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(formloaisanpham.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(formloaisanpham.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(formloaisanpham.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
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
                new formloaisanpham().setVisible(true);
            }
        });
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Buttonxoa;
    private javax.swing.JLabel buttonsua;
    private javax.swing.JButton buttontimkiem;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel nen;
    private javax.swing.JLabel so;
    private javax.swing.JTable tablehienthitxt;
    private javax.swing.JLabel taik;
    private javax.swing.JLabel themloaispbutton;
    private javax.swing.JTextField timkiemtxt;
    private javax.swing.JLabel vaitro;
    // End of variables declaration//GEN-END:variables
}
