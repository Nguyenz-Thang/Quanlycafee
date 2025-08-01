package cafe.baocaoquanli;

import cafe.User;
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
import java.awt.event.MouseListener;
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
import javax.swing.UIManager;
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
 * @author Acer
 */
public class km extends javax.swing.JFrame {

    /**
     * Creates new form km
     */
    public km() {
        initComponents();
        load_km();
        this.setLocationRelativeTo(null);
        txtDuongDan.setEnabled(false);
        ImageIcon logo = new ImageIcon(getClass().getResource("/icon/coffee.png"));
        setIconImage(logo.getImage());
        setTitle("Quản lý khuyến mãi");
    }
//    public void setUser(User user) {
//        this.user = user;
//        
//        // Sử dụng thông tin từ đối tượng User
//        String chucvu = user.getChucvu();
//        String taikhoan = user.getTaikhoan();
//        
//    }

    public void user(String tk, String vaitroo) {

    }

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

    public void load_km() {
        try {
            Connection con;
            con = ConnectDB.KetnoiDB();
            Statement st = con.createStatement();
            String sql = "Select * From khuyenmai";
            ResultSet rs = st.executeQuery(sql);
            //   tbLoaiSach.removeAll();
            String[] arr = {"Mã Km", "Tên Km", "Phần trăm giảm", "Ngày bắt đầu", "Ngày kết thúc", "Mô tả"};
            DefaultTableModel model = new DefaultTableModel(arr, 0);
            while (rs.next()) {
                Vector v = new Vector();
                v.add(rs.getString("makm"));
                v.add(rs.getString("tenkhuyenmai"));
                v.add(rs.getString("phantramgiam"));
                v.add(rs.getString("ngaybatdau"));
                v.add(rs.getString("ngayketthuc"));
                v.add(rs.getString("mota"));
                model.addRow(v);

            }

            TableKhuyenMai.setModel(model);
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

        jScrollBar1 = new javax.swing.JScrollBar();
        jPanel1 = new javax.swing.JPanel();
        butnhanvien = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        so = new javax.swing.JLabel();
        taik = new javax.swing.JLabel();
        chucvu = new javax.swing.JLabel();
        nen = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        MainContent = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        ButtonThemKhuyenMai = new javax.swing.JButton();
        jScrollPane5 = new javax.swing.JScrollPane();
        txtTimKiem = new javax.swing.JTextPane();
        ButtonTimKiem = new javax.swing.JButton();
        comBoBoxSapXep = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        TableKhuyenMai = new javax.swing.JTable();
        ButtonNhapExcel = new javax.swing.JButton();
        ButtonXuatBaoCao = new javax.swing.JButton();
        ButtonXuatExcel = new javax.swing.JButton();
        buttonBrowse = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtDuongDan = new javax.swing.JTextPane();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

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

        chucvu.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        chucvu.setForeground(new java.awt.Color(255, 255, 255));
        chucvu.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jPanel1.add(chucvu, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 100, 150, 30));

        nen.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/no.png"))); // NOI18N
        jPanel1.add(nen, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, -10, 210, 840));

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 130, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 70, Short.MAX_VALUE)
        );

        jPanel1.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 10, 130, 70));

        jPanel5.setBackground(new java.awt.Color(204, 204, 204));

        jLabel1.setBackground(new java.awt.Color(51, 153, 255));
        jLabel1.setFont(new java.awt.Font("Segoe UI Black", 2, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 51));
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/campaign.png"))); // NOI18N
        jLabel1.setText("Quản lí khuyến mãi");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(341, 341, 341)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addContainerGap(36, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(32, 32, 32))
        );

        jPanel4.setBackground(new java.awt.Color(227, 227, 227));
        jPanel4.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));

        ButtonThemKhuyenMai.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        ButtonThemKhuyenMai.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/add.png"))); // NOI18N
        ButtonThemKhuyenMai.setText("Thêm khuyến mãi");
        ButtonThemKhuyenMai.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButtonThemKhuyenMaiActionPerformed(evt);
            }
        });

        txtTimKiem.setToolTipText("");
        txtTimKiem.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtTimKiemMouseClicked(evt);
            }
        });
        txtTimKiem.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtTimKiemKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtTimKiemKeyTyped(evt);
            }
        });
        jScrollPane5.setViewportView(txtTimKiem);

        ButtonTimKiem.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        ButtonTimKiem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/search.png"))); // NOI18N
        ButtonTimKiem.setText("Tìm kiếm");
        ButtonTimKiem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButtonTimKiemActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(ButtonThemKhuyenMai)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane5, javax.swing.GroupLayout.DEFAULT_SIZE, 529, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(ButtonTimKiem)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(ButtonThemKhuyenMai)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(ButtonTimKiem, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane5))
                .addContainerGap())
        );

        comBoBoxSapXep.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "---Sắp xếp---", "Sắp xếp tăng", "Sắp xếp giảm" }));
        comBoBoxSapXep.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comBoBoxSapXepActionPerformed(evt);
            }
        });

        TableKhuyenMai.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        TableKhuyenMai.setModel(new javax.swing.table.DefaultTableModel(
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
        TableKhuyenMai.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TableKhuyenMaiMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(TableKhuyenMai);

        ButtonNhapExcel.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        ButtonNhapExcel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/xls.png"))); // NOI18N
        ButtonNhapExcel.setText("Nhập File excel");
        ButtonNhapExcel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButtonNhapExcelActionPerformed(evt);
            }
        });

        ButtonXuatBaoCao.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/report.png"))); // NOI18N
        ButtonXuatBaoCao.setText("Xuất báo cáo");
        ButtonXuatBaoCao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButtonXuatBaoCaoActionPerformed(evt);
            }
        });

        ButtonXuatExcel.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        ButtonXuatExcel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/excel.jpg"))); // NOI18N
        ButtonXuatExcel.setText("Xuất excel");
        ButtonXuatExcel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButtonXuatExcelActionPerformed(evt);
            }
        });

        buttonBrowse.setText("Browse");
        buttonBrowse.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonBrowseActionPerformed(evt);
            }
        });

        jScrollPane2.setViewportView(txtDuongDan);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(jPanel4Layout.createSequentialGroup()
                            .addComponent(ButtonNhapExcel)
                            .addGap(18, 18, 18)
                            .addComponent(ButtonXuatBaoCao)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 267, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(buttonBrowse)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(ButtonXuatExcel))
                        .addComponent(jScrollPane1)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(313, 313, 313)
                        .addComponent(comBoBoxSapXep, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(37, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(comBoBoxSapXep, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 467, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(46, 46, 46)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(ButtonNhapExcel)
                            .addComponent(ButtonXuatExcel)
                            .addComponent(ButtonXuatBaoCao))
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(buttonBrowse)))
                .addGap(50, 50, 50))
        );

        javax.swing.GroupLayout MainContentLayout = new javax.swing.GroupLayout(MainContent);
        MainContent.setLayout(MainContentLayout);
        MainContentLayout.setHorizontalGroup(
            MainContentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(MainContentLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(MainContentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, MainContentLayout.createSequentialGroup()
                        .addGap(0, 13, Short.MAX_VALUE)
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(12, 12, 12)))
                .addContainerGap())
        );
        MainContentLayout.setVerticalGroup(
            MainContentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, MainContentLayout.createSequentialGroup()
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(MainContent, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(MainContent, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents
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

    private void Themkm(String kmm, String tkm, String motaa, int phtram, java.util.Date bdau, java.util.Date kett) {
//        Date bd = new Date();
//        Date kt = new Date();
        // Chuyển đổi ngày thành định dạng chuỗi SQL
        Date sqlbd = new Date(bdau.getTime());
        Date sqlkt = new Date(kett.getTime());
        try {
            Connection conn = ConnectDB.KetnoiDB();
            String sql = "INSERT into khuyenmai Values('" + kmm + "',N'" + tkm + "',N'" + motaa + "','" + phtram + "','" + sqlbd + "','" + sqlkt + "')";

            Statement st = conn.createStatement();
            st.executeUpdate(sql);
            JOptionPane.showMessageDialog(this, "Nhập thành công");
            load_km();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "loi");
        }
    }
    int i = 0;
    String matontai = "";

    private void ktmakm(String kmm) {
        try {
            Connection conn = ConnectDB.KetnoiDB();
            String check = "select makm from khuyenmai";
            Statement tt = conn.createStatement();
            ResultSet rs = tt.executeQuery(check);
            while (rs.next()) {
                String m = rs.getString("makm");
                if (m.equals(kmm)) {
                    i = 1;
                    //tbkm.setText("Mã khuyến mãi đã tồn tại");
                    matontai = matontai + kmm + " + ";
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
                String kmm = row.getCell(0).getStringCellValue();
                String tkm = row.getCell(1).getStringCellValue();
                String motaa = getCellValueAsString(row.getCell(2));
                int phtram = (int) row.getCell(3).getNumericCellValue();

                java.util.Date bd = row.getCell(4).getDateCellValue(); // Ngày bắt đầu
                java.util.Date kt = row.getCell(5).getDateCellValue(); // Ngày kết thúc

                ktmakm(kmm);
                if (i == 0) {
                    Themkm(kmm, tkm, motaa, phtram, bd, kt);
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
    private void soMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_soMouseClicked
        int confirm = JOptionPane.showConfirmDialog(this, "Bạn có chắc chắn muốn đăng xuất", "Xác nhận", JOptionPane.YES_NO_OPTION);
        if (confirm == 0) {
            login gg = new login();
            gg.show();
            dispose();
        }
    }//GEN-LAST:event_soMouseClicked

    private void ButtonXuatExcelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonXuatExcelActionPerformed
        try {
            String duongdan = txtDuongDan.getText().trim();
            if (duongdan.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Vui lòng chọn nơi lưu file trước khi xuất!");
                buttonBrowse.requestFocus();
                return;
            }
            XSSFWorkbook workbook = new XSSFWorkbook();
            XSSFSheet spreadsheet = workbook.createSheet("tacgia");
            // register the columns you wish to track and compute the column width

            CreationHelper createHelper = workbook.getCreationHelper();

            XSSFRow row = null;
            Cell cell = null;

            row = spreadsheet.createRow((short) 2);
            row.setHeight((short) 500);
            cell = row.createCell(0, CellType.STRING);
            cell.setCellValue("DANH SÁCH KHUYẾN MÃI");

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
            cell.setCellValue("Mã Km");

            cell = row.createCell(2, CellType.STRING);
            cell.setCellStyle(cellStyle_Head);
            cell.setCellValue("Tên khuyến mãi");

            cell = row.createCell(3, CellType.STRING);
            cell.setCellStyle(cellStyle_Head);
            cell.setCellValue("Phần trăm giảm");

            cell = row.createCell(4, CellType.STRING);
            cell.setCellStyle(cellStyle_Head);
            cell.setCellValue("Ngày bắt đầu");

            cell = row.createCell(5, CellType.STRING);
            cell.setCellStyle(cellStyle_Head);
            cell.setCellValue("Ngày kết thúc");

            cell = row.createCell(6, CellType.STRING);
            cell.setCellStyle(cellStyle_Head);
            cell.setCellValue("Mô tả");
            //Kết nối DB

            Connection con = ConnectDB.KetnoiDB();
            String sql = "";
            String tc = comBoBoxSapXep.getSelectedItem().toString();
            String txt = txtTimKiem.getText().trim();
            if (tc == "Sắp xếp tăng") {
                sql = "Select * from khuyenmai where makm like '%" + txt + "%' or tenkhuyenmai like N'%" + txt + "%' or phantramgiam like '%" + txt + "%' or mota like N'%" + txt + "%'  order by phantramgiam";
            } else if (tc == "Sắp xếp giảm") {
                sql = "Select * from khuyenmai where makm like '%" + txt + "%' or tenkhuyenmai like N'%" + txt + "%' or phantramgiam like '%" + txt + "%' or mota like N'%" + txt + "%'  order by phantramgiam desc";
            } else {
                sql = "Select * from khuyenmai where makm like '%" + txt + "%' or tenkhuyenmai like N'%" + txt + "%' or phantramgiam like '%" + txt + "%' or mota like N'%" + txt + "%'";
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
                cell.setCellValue(rs.getString("makm"));

                cell = row.createCell(2);
                cell.setCellStyle(cellStyle_data);
                cell.setCellValue(rs.getString("tenkhuyenmai"));

                cell = row.createCell(3);
                cell.setCellStyle(cellStyle_data);
                cell.setCellValue(rs.getString("phantramgiam"));

                //Định dạng ngày tháng trong excel
                java.sql.Date bd = new java.sql.Date(rs.getDate("ngaybatdau").getTime());
                CellStyle cellStyle = workbook.createCellStyle();
                cellStyle.setDataFormat(createHelper.createDataFormat().getFormat("yyyy-MM-dd"));
                cellStyle.setBorderLeft(BorderStyle.THIN);
                cellStyle.setBorderRight(BorderStyle.THIN);
                cellStyle.setBorderBottom(BorderStyle.THIN);
                cell = row.createCell(4);
                cell.setCellValue(bd);
                cell.setCellStyle(cellStyle);

                java.sql.Date kt = new java.sql.Date(rs.getDate("ngayketthuc").getTime());
                CellStyle cellStyle1 = workbook.createCellStyle();
                cellStyle.setDataFormat(createHelper.createDataFormat().getFormat("yyyy-MM-dd"));
                cellStyle.setBorderLeft(BorderStyle.THIN);
                cellStyle.setBorderRight(BorderStyle.THIN);
                cellStyle.setBorderBottom(BorderStyle.THIN);
                cell = row.createCell(5);
                cell.setCellValue(kt);
                cell.setCellStyle(cellStyle);

                cell = row.createCell(6);
                cell.setCellStyle(cellStyle_data);
                cell.setCellValue(rs.getString("mota"));

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
    }//GEN-LAST:event_ButtonXuatExcelActionPerformed

    private void ButtonXuatBaoCaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonXuatBaoCaoActionPerformed
        String tc = comBoBoxSapXep.getSelectedItem().toString();
        String txt = txtTimKiem.getText().trim();
        try {
            Connection con = ConnectDB.KetnoiDB();
            Statement st = con.createStatement();
            String sql;
            if (tc == "Sắp xếp tăng") {
                sql = "Select * from khuyenmai where makm like '%" + txt + "%' or tenkhuyenmai like N'%" + txt + "%' or phantramgiam like '%" + txt + "%' or mota like N'%" + txt + "%'  order by phantramgiam";
            } else if (tc == "Sắp xếp giảm") {
                sql = "Select * from khuyenmai where makm like '%" + txt + "%' or tenkhuyenmai like N'%" + txt + "%' or phantramgiam like '%" + txt + "%' or mota like N'%" + txt + "%'  order by phantramgiam desc";
            } else {
                sql = "Select * from khuyenmai";
            }

            JasperDesign jdesign = JRXmlLoader.load("C:\\Users\\Acer\\Documents\\NetBeansProjects\\Quanlycafee\\src\\main\\java\\cafe\\baocaoquanli\\kmm.jrxml");

            JRDesignQuery updateQuery = new JRDesignQuery();
            updateQuery.setText(sql);

            jdesign.setQuery(updateQuery);
            JasperReport jreport = JasperCompileManager.compileReport(jdesign);
            JasperPrint jprint = JasperFillManager.fillReport(jreport, null, con);
            JasperViewer.viewReport(jprint);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_ButtonXuatBaoCaoActionPerformed

//    private String getCellValueAsString(Cell cell) {
//        switch (cell.getCellType()) {
//            case STRING:
//                System.out.println("String");
//                return cell.getStringCellValue();
//                
//            case NUMERIC:
//                System.out.println("NUMeric");
//                if (DateUtil.isCellDateFormatted(cell)) {
//                    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
//                    return sdf.format(cell.getDateCellValue());
//                } else {
//                    return String.valueOf(cell.getNumericCellValue());
//                }
//            case BOOLEAN:
//                System.out.println("boll");
//                return String.valueOf(cell.getBooleanCellValue());
//            case FORMULA:
//                
//                return cell.getCellFormula();
//            default:
//                return "";
//        }
//    }
    private void ButtonNhapExcelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonNhapExcelActionPerformed
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
    }//GEN-LAST:event_ButtonNhapExcelActionPerformed

    private void TableKhuyenMaiMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TableKhuyenMaiMouseClicked
        //        them.setEnabled(false);
        //        sua.setEnabled(true);
        //        xoa.setEnabled(true);
        //        int i = km.getSelectedRow();
        //        DefaultTableModel tb = (DefaultTableModel)km.getModel();
        //        makm.setText(tb.getValueAt(i, 0).toString());
        //        makm.setEnabled(false);
        //        tenkm.setText(tb.getValueAt(i, 1).toString());
        //        phantg.setText(tb.getValueAt(i, 2).toString());
        //        String ngay = tb.getValueAt(i, 3).toString();
        //        java.util.Date bd;
        //        try {
        //            bd = new SimpleDateFormat("yyyy-MM-dd").parse(ngay);
        //            ngaybd.setDate(bd);
        //        } catch (Exception e) {
        //            e.printStackTrace();
        //        }
        //        String ngay2 = tb.getValueAt(i, 4).toString();
        //        java.util.Date kt;
        //        try {
        //            kt = new SimpleDateFormat("yyyy-MM-dd").parse(ngay2);
        //            ngaykt.setDate(kt);
        //        } catch (Exception e) {
        //            e.printStackTrace();
        //        }
        //        mota.setText(tb.getValueAt(i, 5).toString());

        int i;
        i = TableKhuyenMai.getSelectedRow();
        DefaultTableModel model = (DefaultTableModel) TableKhuyenMai.getModel();
        //
        String ma = model.getValueAt(i, 0).toString();
        String ten = model.getValueAt(i, 1).toString();
        String bd = model.getValueAt(i, 3).toString();
        String kt = model.getValueAt(i, 4).toString();
        String phantram = model.getValueAt(i, 2).toString();
        String mot = model.getValueAt(i, 5).toString();

        suakm tk = new suakm(this);
        tk.setData(ma, ten, bd, kt, phantram, mot);
        tk.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        tk.setVisible(true);
        //        tk.addWindowListener(new java.awt.event.WindowAdapter() {
        //            @Override
        //            public void windowClosing(java.awt.event.WindowEvent windowEvent) {
        //                load_km(); // Gọi hàm load_km() khi suakm đóng
        //            }
        //        });
        // Hiển thị form suakm

        //        try {
        //            String ma = model.getValueAt(i, 0).toString();
        //            int confirm = JOptionPane.showConfirmDialog(this, "Bạn có chắc chắn muốn xóa?", "Xác nhận", JOptionPane.YES_NO_OPTION);
        //            if (confirm == 0) {
        //                Connection con = ConnectDB.KetnoiDB();
        //                String sql = "Delete from khuyenmai where makm='" + ma + "' ";
        //                Statement st = con.createStatement();
        //                st.executeUpdate(sql);
        //                con.close();
        //                JOptionPane.showMessageDialog(this, "Xóa thành công");
        //                load_km();
        //            }
        //        } catch (Exception e) {
        //            e.printStackTrace();
        //        }
    }//GEN-LAST:event_TableKhuyenMaiMouseClicked

    private void comBoBoxSapXepActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comBoBoxSapXepActionPerformed
        String tc = comBoBoxSapXep.getSelectedItem().toString();
        String txt = txtTimKiem.getText().trim();
        try {
            Connection con = ConnectDB.KetnoiDB();
            Statement st = con.createStatement();
            String sql;
            if (tc == "Sắp xếp tăng") {
                sql = "Select * from khuyenmai where makm like '%" + txt + "%' or tenkhuyenmai like N'%" + txt + "%' or phantramgiam like '%" + txt + "%' or mota like N'%" + txt + "%'  order by phantramgiam";
            } else if (tc == "Sắp xếp giảm") {
                sql = "Select * from khuyenmai where makm like '%" + txt + "%' or tenkhuyenmai like N'%" + txt + "%' or phantramgiam like '%" + txt + "%' or mota like N'%" + txt + "%'  order by phantramgiam desc";
            } else {
                load_km();
                return;
            }

            ResultSet rs = st.executeQuery(sql);
            //   tbLoaiSach.removeAll();
            String[] arr = {"Mã Km", "Tên Km", "Phần trăm giảm", "Ngày bắt đầu", "Ngày kết thúc", "Mô tả"};
            DefaultTableModel model = new DefaultTableModel(arr, 0);
            while (rs.next()) {
                Vector v = new Vector();
                v.add(rs.getString("makm"));
                v.add(rs.getString("tenkhuyenmai"));
                v.add(rs.getString("phantramgiam"));
                v.add(rs.getString("ngaybatdau"));
                v.add(rs.getString("ngayketthuc"));
                v.add(rs.getString("mota"));
                model.addRow(v);
            }
            TableKhuyenMai.setModel(model);
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_comBoBoxSapXepActionPerformed

    private void ButtonTimKiemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonTimKiemActionPerformed
        String txt = txtTimKiem.getText().trim();
        try {
            Connection con = ConnectDB.KetnoiDB();
            Statement st = con.createStatement();
            String sql = "Select * from khuyenmai where makm like '%" + txt + "%' or tenkhuyenmai like N'%" + txt + "%' or phantramgiam like '%" + txt + "%' or mota like N'%" + txt + "%'";
            ResultSet rs = st.executeQuery(sql);
            //   tbLoaiSach.removeAll();
            String[] arr = {"Mã Km", "Tên Km", "Phần trăm giảm", "Ngày bắt đầu", "Ngày kết thúc", "Mô tả"};
            DefaultTableModel model = new DefaultTableModel(arr, 0);
            int i = 0;
            while (rs.next()) {
                i = 1;
                Vector v = new Vector();
                v.add(rs.getString("makm"));
                v.add(rs.getString("tenkhuyenmai"));
                v.add(rs.getString("phantramgiam"));
                v.add(rs.getString("ngaybatdau"));
                v.add(rs.getString("ngayketthuc"));
                v.add(rs.getString("mota"));
                model.addRow(v);
            }
            if (i == 0) {
                Vector v = new Vector();
                v.add("Không có dữ liệuuuuuuu");
                model.addRow(v);
            }
            TableKhuyenMai.setModel(model);
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_ButtonTimKiemActionPerformed

    private void txtTimKiemKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTimKiemKeyTyped

    }//GEN-LAST:event_txtTimKiemKeyTyped

    private void txtTimKiemKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTimKiemKeyPressed

    }//GEN-LAST:event_txtTimKiemKeyPressed

    private void txtTimKiemMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtTimKiemMouseClicked

    }//GEN-LAST:event_txtTimKiemMouseClicked

    private void ButtonThemKhuyenMaiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonThemKhuyenMaiActionPerformed
        themkm kk = new themkm(this);
        kk.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        kk.show();
    }//GEN-LAST:event_ButtonThemKhuyenMaiActionPerformed

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
            java.util.logging.Logger.getLogger(km.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(km.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(km.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(km.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
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
                new km().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton ButtonNhapExcel;
    private javax.swing.JButton ButtonThemKhuyenMai;
    private javax.swing.JButton ButtonTimKiem;
    private javax.swing.JButton ButtonXuatBaoCao;
    private javax.swing.JButton ButtonXuatExcel;
    private javax.swing.JPanel MainContent;
    private javax.swing.JTable TableKhuyenMai;
    private javax.swing.JLabel butnhanvien;
    private javax.swing.JButton buttonBrowse;
    private javax.swing.JLabel chucvu;
    private javax.swing.JComboBox<String> comBoBoxSapXep;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollBar jScrollBar1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JLabel nen;
    private javax.swing.JLabel so;
    private javax.swing.JLabel taik;
    private javax.swing.JTextPane txtDuongDan;
    private javax.swing.JTextPane txtTimKiem;
    // End of variables declaration//GEN-END:variables

}
