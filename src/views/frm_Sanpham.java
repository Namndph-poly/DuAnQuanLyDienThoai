/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package views;

import com.barcodelib.barcode.Linear;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;
import java.io.File;
import java.io.IOException;
import java.sql.Date;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Pattern;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import models.BoNho;
import models.Camera;
import models.Hang;
import models.ManHinh;
import models.MauSac;
import models.SanPham;
import services.IBoNhoServices;
import services.ICameraServices;
import services.IHangServices;
import services.IManHinhServices;
import services.IMauSacServices;
import services.ISanPhamServices;
import services.imp.BoNhoServices;
import services.imp.CameraServices;
import services.imp.HangServices;
import services.imp.ManHinhServices;
import services.imp.MauSacServices;
import services.imp.SanPhamServices;
import viewmodels.Objecttt;


/**
 *
 * @author hungh
 */
public class frm_Sanpham extends javax.swing.JPanel {
        private IMauSacServices iMauSacServices;
        private ISanPhamServices iSanPhamServices;
        private IHangServices iHangServices;
         private IBoNhoServices iBoNhoServices;
             private IManHinhServices iManHinhServices;
         private ICameraServices iCameraServices;


    public frm_Sanpham() {
        initComponents();
        jPanel1.setVisible(false);
 iMauSacServices = new MauSacServices();
 iSanPhamServices = new SanPhamServices();
  iHangServices = new HangServices();
  iBoNhoServices = new BoNhoServices();
    iManHinhServices = new ManHinhServices();
  iCameraServices = new CameraServices();
 loadtablemausac();
 loadtablesp();
 loadtablehang();
 loadtablebonho();
 loadtablemh();
 loadtablecam();
 
    }
     //mau sac
    private void loadtablemausac() {
        DefaultTableModel model = (DefaultTableModel) tblMauSac.getModel();
        model.setRowCount(0);
        for (MauSac x : iMauSacServices.getAll()) {
            model.addRow(new Object[]{x.getId(), x.getTen()});
        }
    }
    private Objecttt getdatafrom() {
        Pattern p = Pattern.compile("^[0-9]+$");
        if (txtTenmau.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, " Bạn chưa nhập tên ");
            txtTenmau.requestFocus();
            return null;
        }

        if (txtTenmau.getText().length() > 30) {
            JOptionPane.showMessageDialog(this, "Tên không quá 30 kí tự!");
            txtTenmau.requestFocus();
            return null;
        }
        
        if (p.matcher(txtTenmau.getText()).find() == true) {
            JOptionPane.showMessageDialog(this, "Tên phải là chữ!");
            txtTenmau.requestFocus();
            return null;
        }
        return new Objecttt(0, txtTenmau.getText());

    }
    private Objecttt getdatdtb(int row) {
        if (row == -1) {
            return null;
        }
        int id = (int) tblMauSac.getValueAt(row, 0);
        String ten = (String) tblMauSac.getValueAt(row, 1);
        return new Objecttt(id, ten);
    }
    //sanpham
    private void loadtablesp() {
        DefaultTableModel model = (DefaultTableModel) tblSanPham.getModel();
        model.setRowCount(0);
        for (SanPham x : iSanPhamServices.getAll()) {
            model.addRow(new Object[]{x.getId(), x.getTen()});
        }
    }
    private Objecttt getdatafromsp() {
        Pattern p = Pattern.compile("^[0-9]+$");
        if (txtTenSP.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, " Bạn chưa nhập tên ");
            txtTenSP.requestFocus();
            return null;
        }

        if (txtTenSP.getText().length() > 30) {
            JOptionPane.showMessageDialog(this, "Tên không quá 30 kí tự!");
            txtTenSP.requestFocus();
            return null;
        }
        
        if (p.matcher(txtTenSP.getText()).find() == true) {
            JOptionPane.showMessageDialog(this, "Tên phải là chữ!");
            txtTenSP.requestFocus();
            return null;
        }
        return new Objecttt(0, txtTenSP.getText());

    }
    private Objecttt getdatdtbsp(int row) {
        if (row == -1) {
            return null;
        }
        int id = (int) tblSanPham.getValueAt(row, 0);
        String ten = (String) tblSanPham.getValueAt(row, 1);
        return new Objecttt(id, ten);
    }
    //hang
        private void loadtablehang() {
        DefaultTableModel model = (DefaultTableModel) tblHang.getModel();
        model.setRowCount(0);
        for (Hang x : iHangServices.getAll()) {
            model.addRow(new Object[]{x.getId(), x.getTen()});
        }
    }
    private Objecttt getdatafromhang() {
        Pattern p = Pattern.compile("^[0-9]+$");
        if (txtTenHang.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, " Bạn chưa nhập tên ");
            txtTenHang.requestFocus();
            return null;
        }

        if (txtTenHang.getText().length() > 30) {
            JOptionPane.showMessageDialog(this, "Tên không quá 30 kí tự!");
            txtTenHang.requestFocus();
            return null;
        }
        
        if (p.matcher(txtTenHang.getText()).find() == true) {
            JOptionPane.showMessageDialog(this, "Tên phải là chữ!");
            txtTenHang.requestFocus();
            return null;
        }
        return new Objecttt(0, txtTenHang.getText());

    }
    private Objecttt getdatdtbhang(int row) {
        if (row == -1) {
            return null;
        }
        int id = (int) tblHang.getValueAt(row, 0);
        String ten = (String) tblHang.getValueAt(row, 1);
        return new Objecttt(id, ten);
    }
        //bonho
        private void loadtablebonho() {
        DefaultTableModel model = (DefaultTableModel) tblBoNho.getModel();
        model.setRowCount(0);
        for (BoNho x : iBoNhoServices.getAll()) {
            model.addRow(new Object[]{x.getId(), x.getTen()});
        }
    }
    private Objecttt getdatafrombonho() {
        Pattern p = Pattern.compile("^[0-9]+$");
        if (txtTenBoNho.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, " Bạn chưa nhập tên ");
            txtTenBoNho.requestFocus();
            return null;
        }

        if (txtTenBoNho.getText().length() > 30) {
            JOptionPane.showMessageDialog(this, "Tên không quá 30 kí tự!");
            txtTenBoNho.requestFocus();
            return null;
        }
        
        if (p.matcher(txtTenBoNho.getText()).find() == true) {
            JOptionPane.showMessageDialog(this, "Tên phải là chữ!");
            txtTenBoNho.requestFocus();
            return null;
        }
        return new Objecttt(0, txtTenBoNho.getText());

    }
    private Objecttt getdatdtbbonho(int row) {
        if (row == -1) {
            return null;
        }
        int id = (int) tblBoNho.getValueAt(row, 0);
        String ten = (String) tblBoNho.getValueAt(row, 1);
        return new Objecttt(id, ten);
    }
            /////////////////////////////////////////////////////////manhinh
        private void loadtablemh() {
        DefaultTableModel model = (DefaultTableModel) tblManhinh.getModel();
        model.setRowCount(0);
        for (ManHinh x : iManHinhServices.getAll()) {
            model.addRow(new Object[]{x.getId(), x.getTen()});
        }
    }
    private Objecttt getdatafrommh() {
        Pattern p = Pattern.compile("^[0-9]+$");
        if (txtTenMan.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, " Bạn chưa nhập tên ");
            txtTenMan.requestFocus();
            return null;
        }

        if (txtTenMan.getText().length() > 30) {
            JOptionPane.showMessageDialog(this, "Tên không quá 30 kí tự!");
            txtTenMan.requestFocus();
            return null;
        }
        
        if (p.matcher(txtTenMan.getText()).find() == true) {
            JOptionPane.showMessageDialog(this, "Tên phải là chữ!");
            txtTenMan.requestFocus();
            return null;
        }
        return new Objecttt(0, txtTenMan.getText());

    }
    private Objecttt getdatdtbmh(int row) {
        if (row == -1) {
            return null;
        }
        int id = (int) tblManhinh.getValueAt(row, 0);
        String ten = (String) tblManhinh.getValueAt(row, 1);
        return new Objecttt(id, ten);
    }
        /////////////////////////////////////////////////////////////////////////camera
        private void loadtablecam() {
        DefaultTableModel model = (DefaultTableModel) tblCamera.getModel();
        model.setRowCount(0);
        for (Camera x : iCameraServices.getAll()) {
            model.addRow(new Object[]{x.getId(), x.getTen()});
        }
    }
    private Objecttt getdatafromcam() {
        Pattern p = Pattern.compile("^[0-9]+$");
        if (txtTenCmr.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, " Bạn chưa nhập tên ");
            txtTenCmr.requestFocus();
            return null;
        }

        if (txtTenCmr.getText().length() > 30) {
            JOptionPane.showMessageDialog(this, "Tên không quá 30 kí tự!");
            txtTenCmr.requestFocus();
            return null;
        }
        
        if (p.matcher(txtTenCmr.getText()).find() == true) {
            JOptionPane.showMessageDialog(this, "Tên phải là chữ!");
            txtTenCmr.requestFocus();
            return null;
        }
        return new Objecttt(0, txtTenCmr.getText());

    }
    private Objecttt getdatdtbbocam(int row) {
        if (row == -1) {
            return null;
        }
        int id = (int) tblCamera.getValueAt(row, 0);
        String ten = (String) tblCamera.getValueAt(row, 1);
        return new Objecttt(id, ten);
    }
   

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelGradiente1 = new swing.PanelGradiente();
        jTabbedPane3 = new javax.swing.JTabbedPane();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txtIDSP = new swing.MyTextField();
        jLabel2 = new javax.swing.JLabel();
        txtTenSP = new swing.MyTextField();
        jScrollPane3 = new javax.swing.JScrollPane();
        tblSanPham = new javax.swing.JTable();
        btnThemSP = new swing.MyButton();
        btnCapNhatSP = new swing.MyButton();
        btnLamMoiSP = new swing.MyButton();
        jPanel5 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        txtidHang = new swing.MyTextField();
        jLabel8 = new javax.swing.JLabel();
        txtTenHang = new swing.MyTextField();
        jScrollPane4 = new javax.swing.JScrollPane();
        tblHang = new javax.swing.JTable();
        btnThemHang = new swing.MyButton();
        btnCapNhatHang = new swing.MyButton();
        btnLamMoiHang = new swing.MyButton();
        jPanel3 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        txtIdMau = new swing.MyTextField();
        jLabel7 = new javax.swing.JLabel();
        txtTenmau = new swing.MyTextField();
        jScrollPane7 = new javax.swing.JScrollPane();
        tblMauSac = new javax.swing.JTable();
        btnThemSP1 = new swing.MyButton();
        btnCapNhatSP1 = new swing.MyButton();
        btnLamMoiSP1 = new swing.MyButton();
        jPanel4 = new javax.swing.JPanel();
        jLabel15 = new javax.swing.JLabel();
        txtIdbonho = new swing.MyTextField();
        jLabel16 = new javax.swing.JLabel();
        txtTenBoNho = new swing.MyTextField();
        jScrollPane8 = new javax.swing.JScrollPane();
        tblBoNho = new javax.swing.JTable();
        btnThemSP2 = new swing.MyButton();
        btnCapNhatSP2 = new swing.MyButton();
        btnLamMoiSP2 = new swing.MyButton();
        jPanel8 = new javax.swing.JPanel();
        jLabel19 = new javax.swing.JLabel();
        txtIdMan = new swing.MyTextField();
        jLabel20 = new javax.swing.JLabel();
        txtTenMan = new swing.MyTextField();
        jScrollPane9 = new javax.swing.JScrollPane();
        tblManhinh = new javax.swing.JTable();
        btnThemSP3 = new swing.MyButton();
        btnCapNhatSP3 = new swing.MyButton();
        btnLamMoiSP3 = new swing.MyButton();
        jPanel9 = new javax.swing.JPanel();
        jLabel23 = new javax.swing.JLabel();
        txtIdCmr = new swing.MyTextField();
        jLabel24 = new javax.swing.JLabel();
        txtTenCmr = new swing.MyTextField();
        jScrollPane10 = new javax.swing.JScrollPane();
        tblCamera = new javax.swing.JTable();
        btnThemSP4 = new swing.MyButton();
        btnCapNhatSP4 = new swing.MyButton();
        btnLamMoiSP4 = new swing.MyButton();
        jPanel10 = new javax.swing.JPanel();
        jLabel27 = new javax.swing.JLabel();
        txtidImei = new swing.MyTextField();
        jLabel28 = new javax.swing.JLabel();
        txtMaImei = new swing.MyTextField();
        jScrollPane11 = new javax.swing.JScrollPane();
        tblImei = new javax.swing.JTable();
        btnThemSP5 = new swing.MyButton();
        btnCapNhatSP5 = new swing.MyButton();
        btnLamMoiSP5 = new swing.MyButton();
        jComboBox1 = new javax.swing.JComboBox<>();
        jLabel35 = new javax.swing.JLabel();
        jPanel11 = new javax.swing.JPanel();
        jLabel31 = new javax.swing.JLabel();
        txtIDCT = new swing.MyTextField();
        jLabel32 = new javax.swing.JLabel();
        jLabel33 = new javax.swing.JLabel();
        jLabel34 = new javax.swing.JLabel();
        cboTenSP = new javax.swing.JComboBox<>();
        jScrollPane12 = new javax.swing.JScrollPane();
        tblSanPham6 = new javax.swing.JTable();
        btnThemSP6 = new swing.MyButton();
        btnCapNhatSP6 = new swing.MyButton();
        btnLamMoiSP6 = new swing.MyButton();
        jLabel36 = new javax.swing.JLabel();
        cboBoNho = new javax.swing.JComboBox<>();
        cboCam = new javax.swing.JComboBox<>();
        cboMan = new javax.swing.JComboBox<>();
        jLabel37 = new javax.swing.JLabel();
        cboMau = new javax.swing.JComboBox<>();
        jLabel38 = new javax.swing.JLabel();
        cboHang = new javax.swing.JComboBox<>();
        txtGiaNhap = new swing.MyTextField();
        txtGiaBan = new swing.MyTextField();
        jLabel39 = new javax.swing.JLabel();
        jLabel40 = new javax.swing.JLabel();
        jLabel41 = new javax.swing.JLabel();
        txtImeiCTSP = new swing.MyTextField();
        btnAddImei = new swing.MyButton();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane13 = new javax.swing.JScrollPane();
        tblImeiview = new javax.swing.JTable();
        panelBorder2 = new swing.PanelBorder();
        lbl_search = new javax.swing.JLabel();
        searchtxt = new swing.SearchText();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));
        setMinimumSize(new java.awt.Dimension(1010, 640));

        panelGradiente1.setColorPrimario(new java.awt.Color(204, 255, 255));
        panelGradiente1.setColorSecundario(new java.awt.Color(255, 204, 255));

        jTabbedPane3.setBackground(new java.awt.Color(204, 204, 255));

        jPanel2.setBackground(new java.awt.Color(204, 204, 255));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel1.setText("Tên");

        txtIDSP.setEditable(false);

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel2.setText("ID Sản Phẩm");

        tblSanPham.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "ID", "Tên sản phẩm"
            }
        ));
        tblSanPham.setGridColor(new java.awt.Color(255, 255, 255));
        tblSanPham.setRowHeight(25);
        tblSanPham.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblSanPhamMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(tblSanPham);

        btnThemSP.setBackground(new java.awt.Color(125, 224, 237));
        btnThemSP.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/add.png"))); // NOI18N
        btnThemSP.setText("Thêm");
        btnThemSP.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnThemSP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemSPActionPerformed(evt);
            }
        });

        btnCapNhatSP.setBackground(new java.awt.Color(125, 224, 237));
        btnCapNhatSP.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/floppy-disk.png"))); // NOI18N
        btnCapNhatSP.setText("Cập nhật");
        btnCapNhatSP.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnCapNhatSP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCapNhatSPActionPerformed(evt);
            }
        });

        btnLamMoiSP.setBackground(new java.awt.Color(125, 224, 237));
        btnLamMoiSP.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/refresh.png"))); // NOI18N
        btnLamMoiSP.setText("Làm Mới");
        btnLamMoiSP.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnLamMoiSP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLamMoiSPActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(138, 138, 138)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnThemSP, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtIDSP, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtTenSP, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(202, 202, 202))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(39, 39, 39)
                        .addComponent(btnCapNhatSP, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(40, 40, 40)
                        .addComponent(btnLamMoiSP, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(32, Short.MAX_VALUE)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 926, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(62, 62, 62)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtIDSP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtTenSP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(86, 86, 86)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnThemSP, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCapNhatSP, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnLamMoiSP, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(34, 34, 34)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 257, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(131, Short.MAX_VALUE))
        );

        jTabbedPane3.addTab("Sản phẩm", jPanel2);

        jPanel5.setBackground(new java.awt.Color(204, 204, 255));

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel5.setText("Tên Hãng");

        txtidHang.setEditable(false);

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel8.setText("ID Hãng");

        tblHang.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID ", "Tên Hãng"
            }
        ));
        tblHang.setGridColor(new java.awt.Color(255, 255, 255));
        tblHang.setRowHeight(25);
        tblHang.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblHangMouseClicked(evt);
            }
        });
        jScrollPane4.setViewportView(tblHang);

        btnThemHang.setBackground(new java.awt.Color(125, 224, 237));
        btnThemHang.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/add.png"))); // NOI18N
        btnThemHang.setText("Thêm");
        btnThemHang.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnThemHang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemHangActionPerformed(evt);
            }
        });

        btnCapNhatHang.setBackground(new java.awt.Color(125, 224, 237));
        btnCapNhatHang.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/floppy-disk.png"))); // NOI18N
        btnCapNhatHang.setText("Cập nhật");
        btnCapNhatHang.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnCapNhatHang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCapNhatHangActionPerformed(evt);
            }
        });

        btnLamMoiHang.setBackground(new java.awt.Color(125, 224, 237));
        btnLamMoiHang.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/refresh.png"))); // NOI18N
        btnLamMoiHang.setText("Làm Mới");
        btnLamMoiHang.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnLamMoiHang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLamMoiHangActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(138, 138, 138)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtidHang, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnThemHang, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(163, 163, 163)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtTenHang, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(41, 41, 41)
                        .addComponent(btnCapNhatHang, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(38, 38, 38)
                        .addComponent(btnLamMoiHang, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(264, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 926, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(54, 54, 54)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtTenHang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtidHang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(84, 84, 84)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnThemHang, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCapNhatHang, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnLamMoiHang, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(43, 43, 43)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 257, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(124, Short.MAX_VALUE))
        );

        jTabbedPane3.addTab("Hãng", jPanel5);

        jPanel3.setBackground(new java.awt.Color(204, 204, 255));

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel6.setText("Tên");

        txtIdMau.setEditable(false);

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel7.setText("ID Màu Sắc");

        tblMauSac.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "ID", "Màu"
            }
        ));
        tblMauSac.setGridColor(new java.awt.Color(255, 255, 255));
        tblMauSac.setRowHeight(25);
        tblMauSac.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblMauSacMouseClicked(evt);
            }
        });
        jScrollPane7.setViewportView(tblMauSac);

        btnThemSP1.setBackground(new java.awt.Color(125, 224, 237));
        btnThemSP1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/add.png"))); // NOI18N
        btnThemSP1.setText("Thêm");
        btnThemSP1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnThemSP1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemSP1ActionPerformed(evt);
            }
        });

        btnCapNhatSP1.setBackground(new java.awt.Color(125, 224, 237));
        btnCapNhatSP1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/floppy-disk.png"))); // NOI18N
        btnCapNhatSP1.setText("Cập nhật");
        btnCapNhatSP1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnCapNhatSP1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCapNhatSP1ActionPerformed(evt);
            }
        });

        btnLamMoiSP1.setBackground(new java.awt.Color(125, 224, 237));
        btnLamMoiSP1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/refresh.png"))); // NOI18N
        btnLamMoiSP1.setText("Làm Mới");
        btnLamMoiSP1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnLamMoiSP1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLamMoiSP1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(138, 138, 138)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(txtIdMau, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(btnThemSP1, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(20, 20, 20)))
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(158, 158, 158)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtTenmau, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(22, 22, 22)
                                .addComponent(btnCapNhatSP1, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(36, 36, 36)
                                .addComponent(btnLamMoiSP1, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 926, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(34, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(54, 54, 54)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtIdMau, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtTenmau, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(62, 62, 62)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnThemSP1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCapNhatSP1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnLamMoiSP1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(32, 32, 32)
                .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 257, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(157, Short.MAX_VALUE))
        );

        jTabbedPane3.addTab("Màu Sắc", jPanel3);

        jPanel4.setBackground(new java.awt.Color(204, 204, 255));

        jLabel15.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel15.setText("Dung lượng ");

        txtIdbonho.setEditable(false);

        jLabel16.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel16.setText("ID Bộ Nhớ");

        tblBoNho.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "ID", "Dung lượng"
            }
        ));
        tblBoNho.setGridColor(new java.awt.Color(255, 255, 255));
        tblBoNho.setRowHeight(25);
        tblBoNho.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblBoNhoMouseClicked(evt);
            }
        });
        jScrollPane8.setViewportView(tblBoNho);

        btnThemSP2.setBackground(new java.awt.Color(125, 224, 237));
        btnThemSP2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/add.png"))); // NOI18N
        btnThemSP2.setText("Thêm");
        btnThemSP2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnThemSP2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemSP2ActionPerformed(evt);
            }
        });

        btnCapNhatSP2.setBackground(new java.awt.Color(125, 224, 237));
        btnCapNhatSP2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/floppy-disk.png"))); // NOI18N
        btnCapNhatSP2.setText("Cập nhật");
        btnCapNhatSP2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnCapNhatSP2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCapNhatSP2ActionPerformed(evt);
            }
        });

        btnLamMoiSP2.setBackground(new java.awt.Color(125, 224, 237));
        btnLamMoiSP2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/refresh.png"))); // NOI18N
        btnLamMoiSP2.setText("Làm Mới");
        btnLamMoiSP2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnLamMoiSP2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLamMoiSP2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(138, 138, 138)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(txtIdbonho, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnThemSP2, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addGap(153, 153, 153)
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtTenBoNho, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addGap(36, 36, 36)
                                .addComponent(btnCapNhatSP2, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(31, 31, 31)
                                .addComponent(btnLamMoiSP2, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addComponent(jScrollPane8, javax.swing.GroupLayout.PREFERRED_SIZE, 926, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(32, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(54, 54, 54)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtIdbonho, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtTenBoNho, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(86, 86, 86)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnThemSP2, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCapNhatSP2, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnLamMoiSP2, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(28, 28, 28)
                .addComponent(jScrollPane8, javax.swing.GroupLayout.PREFERRED_SIZE, 257, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(137, Short.MAX_VALUE))
        );

        jTabbedPane3.addTab("Bộ nhớ", jPanel4);

        jPanel8.setBackground(new java.awt.Color(204, 204, 255));

        jLabel19.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel19.setText("Tên");

        txtIdMan.setEditable(false);

        jLabel20.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel20.setText("ID ");

        tblManhinh.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "ID", "Tên màn"
            }
        ));
        tblManhinh.setGridColor(new java.awt.Color(255, 255, 255));
        tblManhinh.setRowHeight(25);
        tblManhinh.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblManhinhMouseClicked(evt);
            }
        });
        jScrollPane9.setViewportView(tblManhinh);

        btnThemSP3.setBackground(new java.awt.Color(125, 224, 237));
        btnThemSP3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/add.png"))); // NOI18N
        btnThemSP3.setText("Thêm");
        btnThemSP3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnThemSP3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemSP3ActionPerformed(evt);
            }
        });

        btnCapNhatSP3.setBackground(new java.awt.Color(125, 224, 237));
        btnCapNhatSP3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/floppy-disk.png"))); // NOI18N
        btnCapNhatSP3.setText("Cập nhật");
        btnCapNhatSP3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnCapNhatSP3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCapNhatSP3ActionPerformed(evt);
            }
        });

        btnLamMoiSP3.setBackground(new java.awt.Color(125, 224, 237));
        btnLamMoiSP3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/refresh.png"))); // NOI18N
        btnLamMoiSP3.setText("Làm Mới");
        btnLamMoiSP3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnLamMoiSP3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLamMoiSP3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGap(138, 138, 138)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnThemSP3, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtIdMan, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel20, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 177, Short.MAX_VALUE)
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtTenMan, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(250, 250, 250))
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addGap(37, 37, 37)
                        .addComponent(btnCapNhatSP3, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(35, 35, 35)
                        .addComponent(btnLamMoiSP3, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(jScrollPane9, javax.swing.GroupLayout.PREFERRED_SIZE, 926, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGap(54, 54, 54)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel20, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtIdMan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtTenMan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(57, 57, 57)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnThemSP3, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCapNhatSP3, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnLamMoiSP3, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(33, 33, 33)
                .addComponent(jScrollPane9, javax.swing.GroupLayout.PREFERRED_SIZE, 257, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(161, Short.MAX_VALUE))
        );

        jTabbedPane3.addTab("Màn hình", jPanel8);

        jPanel9.setBackground(new java.awt.Color(204, 204, 255));

        jLabel23.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel23.setText("Tên");

        txtIdCmr.setEditable(false);

        jLabel24.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel24.setText("ID");

        tblCamera.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "ID", "MP"
            }
        ));
        tblCamera.setGridColor(new java.awt.Color(255, 255, 255));
        tblCamera.setRowHeight(25);
        tblCamera.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblCameraMouseClicked(evt);
            }
        });
        jScrollPane10.setViewportView(tblCamera);

        btnThemSP4.setBackground(new java.awt.Color(125, 224, 237));
        btnThemSP4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/add.png"))); // NOI18N
        btnThemSP4.setText("Thêm");
        btnThemSP4.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnThemSP4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemSP4ActionPerformed(evt);
            }
        });

        btnCapNhatSP4.setBackground(new java.awt.Color(125, 224, 237));
        btnCapNhatSP4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/floppy-disk.png"))); // NOI18N
        btnCapNhatSP4.setText("Cập nhật");
        btnCapNhatSP4.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnCapNhatSP4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCapNhatSP4ActionPerformed(evt);
            }
        });

        btnLamMoiSP4.setBackground(new java.awt.Color(125, 224, 237));
        btnLamMoiSP4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/refresh.png"))); // NOI18N
        btnLamMoiSP4.setText("Làm Mới");
        btnLamMoiSP4.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnLamMoiSP4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLamMoiSP4ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addGap(138, 138, 138)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnThemSP4, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtIdCmr, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel24, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 177, Short.MAX_VALUE)
                        .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtTenCmr, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel23, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(250, 250, 250))
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addGap(39, 39, 39)
                        .addComponent(btnCapNhatSP4, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(37, 37, 37)
                        .addComponent(btnLamMoiSP4, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(jScrollPane10, javax.swing.GroupLayout.PREFERRED_SIZE, 926, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addGap(54, 54, 54)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel24, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel23, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtIdCmr, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtTenCmr, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(84, 84, 84)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnThemSP4, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCapNhatSP4, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnLamMoiSP4, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27)
                .addComponent(jScrollPane10, javax.swing.GroupLayout.PREFERRED_SIZE, 257, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(140, Short.MAX_VALUE))
        );

        jTabbedPane3.addTab("Camera", jPanel9);

        jPanel10.setBackground(new java.awt.Color(204, 204, 255));

        jLabel27.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel27.setText("Mã Imei");

        txtidImei.setEditable(false);

        jLabel28.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel28.setText("ID ");

        tblImei.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "ID", "Mã", "Trạng thái"
            }
        ));
        tblImei.setGridColor(new java.awt.Color(255, 255, 255));
        tblImei.setRowHeight(25);
        tblImei.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblImeiMouseClicked(evt);
            }
        });
        jScrollPane11.setViewportView(tblImei);

        btnThemSP5.setBackground(new java.awt.Color(125, 224, 237));
        btnThemSP5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/add.png"))); // NOI18N
        btnThemSP5.setText("Thêm");
        btnThemSP5.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnThemSP5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemSP5ActionPerformed(evt);
            }
        });

        btnCapNhatSP5.setBackground(new java.awt.Color(125, 224, 237));
        btnCapNhatSP5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/floppy-disk.png"))); // NOI18N
        btnCapNhatSP5.setText("Cập nhật");
        btnCapNhatSP5.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnCapNhatSP5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCapNhatSP5ActionPerformed(evt);
            }
        });

        btnLamMoiSP5.setBackground(new java.awt.Color(125, 224, 237));
        btnLamMoiSP5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/refresh.png"))); // NOI18N
        btnLamMoiSP5.setText("Làm Mới");
        btnLamMoiSP5.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnLamMoiSP5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLamMoiSP5ActionPerformed(evt);
            }
        });

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Chưa dùng", "Đã bán", "Còn Hàng", " " }));

        jLabel35.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel35.setText("Trạng thái");

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel10Layout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addComponent(jScrollPane11, javax.swing.GroupLayout.PREFERRED_SIZE, 926, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel10Layout.createSequentialGroup()
                        .addGap(220, 220, 220)
                        .addComponent(btnThemSP5, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(40, 40, 40)
                        .addComponent(btnCapNhatSP5, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(40, 40, 40)
                        .addComponent(btnLamMoiSP5, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(31, Short.MAX_VALUE))
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addGap(138, 138, 138)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel10Layout.createSequentialGroup()
                        .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel10Layout.createSequentialGroup()
                        .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel35, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtidImei, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel28, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtMaImei, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel27, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(250, 250, 250))))
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addGap(54, 54, 54)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel28, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel27, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtidImei, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtMaImei, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addComponent(jLabel35, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(38, 38, 38)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnThemSP5, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCapNhatSP5, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnLamMoiSP5, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 52, Short.MAX_VALUE)
                .addComponent(jScrollPane11, javax.swing.GroupLayout.PREFERRED_SIZE, 257, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(68, 68, 68))
        );

        jTabbedPane3.addTab("Imei", jPanel10);

        jPanel11.setBackground(new java.awt.Color(204, 204, 255));

        jLabel31.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel31.setText("Camera");

        txtIDCT.setEditable(false);

        jLabel32.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel32.setText("ID ");

        jLabel33.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel33.setText("Màn Hình");

        jLabel34.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel34.setText("Tên Sản Phẩm");

        cboTenSP.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        tblSanPham6.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "ID", "Mã", "Tên sản phẩm", "Hãng"
            }
        ));
        tblSanPham6.setGridColor(new java.awt.Color(255, 255, 255));
        tblSanPham6.setRowHeight(25);
        tblSanPham6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblSanPham6MouseClicked(evt);
            }
        });
        jScrollPane12.setViewportView(tblSanPham6);
        if (tblSanPham6.getColumnModel().getColumnCount() > 0) {
            tblSanPham6.getColumnModel().getColumn(0).setResizable(false);
            tblSanPham6.getColumnModel().getColumn(0).setHeaderValue("ID");
            tblSanPham6.getColumnModel().getColumn(1).setResizable(false);
            tblSanPham6.getColumnModel().getColumn(1).setHeaderValue("Mã");
            tblSanPham6.getColumnModel().getColumn(2).setHeaderValue("Tên sản phẩm");
            tblSanPham6.getColumnModel().getColumn(3).setResizable(false);
            tblSanPham6.getColumnModel().getColumn(3).setHeaderValue("Hãng");
        }

        btnThemSP6.setBackground(new java.awt.Color(125, 224, 237));
        btnThemSP6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/add.png"))); // NOI18N
        btnThemSP6.setText("Thêm");
        btnThemSP6.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnThemSP6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemSP6ActionPerformed(evt);
            }
        });

        btnCapNhatSP6.setBackground(new java.awt.Color(125, 224, 237));
        btnCapNhatSP6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/floppy-disk.png"))); // NOI18N
        btnCapNhatSP6.setText("Cập nhật");
        btnCapNhatSP6.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnCapNhatSP6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCapNhatSP6ActionPerformed(evt);
            }
        });

        btnLamMoiSP6.setBackground(new java.awt.Color(125, 224, 237));
        btnLamMoiSP6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/refresh.png"))); // NOI18N
        btnLamMoiSP6.setText("Làm Mới");
        btnLamMoiSP6.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnLamMoiSP6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLamMoiSP6ActionPerformed(evt);
            }
        });

        jLabel36.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel36.setText("Bộ Nhớ");

        cboBoNho.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        cboCam.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        cboMan.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel37.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel37.setText("Màu Sắc");

        cboMau.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel38.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel38.setText("Hãng");

        cboHang.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        txtGiaNhap.setEditable(false);

        txtGiaBan.setEditable(false);

        jLabel39.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel39.setText("Giá Nhập");

        jLabel40.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel40.setText("Giá Bán");

        jLabel41.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel41.setText("Imei");

        txtImeiCTSP.setEditable(false);

        btnAddImei.setBackground(new java.awt.Color(125, 224, 237));
        btnAddImei.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/new-page.png"))); // NOI18N
        btnAddImei.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnAddImei.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddImeiActionPerformed(evt);
            }
        });

        tblImeiview.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "STT", "Imei"
            }
        ));
        tblImeiview.setGridColor(new java.awt.Color(255, 255, 255));
        tblImeiview.setRowHeight(25);
        tblImeiview.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblImeiviewMouseClicked(evt);
            }
        });
        jScrollPane13.setViewportView(tblImeiview);

        panelBorder2.setBackground(new java.awt.Color(255, 255, 255));

        lbl_search.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/search_24px.png"))); // NOI18N
        lbl_search.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbl_searchMouseClicked(evt);
            }
        });
        panelBorder2.add(lbl_search);
        lbl_search.setBounds(140, 0, 40, 40);

        searchtxt.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                searchtxtCaretUpdate(evt);
            }
        });
        searchtxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchtxtActionPerformed(evt);
            }
        });
        panelBorder2.add(searchtxt);
        searchtxt.setBounds(10, 10, 111, 26);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane13, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(panelBorder2, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(33, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(panelBorder2, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane13, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel3.setText("Sản phẩm hết Hàng");

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/hide.png"))); // NOI18N

        javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel11Layout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel11Layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel4))
                            .addComponent(jScrollPane12, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 930, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel11Layout.createSequentialGroup()
                        .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel11Layout.createSequentialGroup()
                                .addGap(48, 48, 48)
                                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel32, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtIDCT, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel11Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(cboTenSP, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel34, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel36, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(cboBoNho, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(btnThemSP6, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel11Layout.createSequentialGroup()
                                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel31, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(cboCam, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(cboMan, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(btnCapNhatSP6, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(cboMau, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel11Layout.createSequentialGroup()
                                        .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(txtGiaNhap, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(btnLamMoiSP6, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(48, 48, 48)
                                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel11Layout.createSequentialGroup()
                                        .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel38, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(cboHang, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(jPanel11Layout.createSequentialGroup()
                                                .addGap(11, 11, 11)
                                                .addComponent(txtImeiCTSP, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(btnAddImei, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addComponent(jLabel41, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                            .addGroup(jPanel11Layout.createSequentialGroup()
                                .addComponent(jLabel33, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel39, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel11Layout.createSequentialGroup()
                                .addComponent(jLabel37, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel40, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtGiaBan, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                .addContainerGap(27, Short.MAX_VALUE))
        );
        jPanel11Layout.setVerticalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addGap(54, 54, 54)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel32, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel31, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel38, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel41, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(5, 5, 5)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtIDCT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(cboCam, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(cboHang, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtImeiCTSP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(btnAddImei, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel11Layout.createSequentialGroup()
                        .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel11Layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(jLabel39, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel11Layout.createSequentialGroup()
                                .addGap(9, 9, 9)
                                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel34, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel33, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(cboTenSP, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(cboMan, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtGiaNhap, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel36, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel37, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel40, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtGiaBan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cboMau, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cboBoNho, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 19, Short.MAX_VALUE)
                        .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnCapNhatSP6, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnLamMoiSP6, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnThemSP6, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4))
                        .addGap(13, 13, 13))
                    .addGroup(jPanel11Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addComponent(jScrollPane12, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(84, 84, 84))
        );

        jTabbedPane3.addTab("Chi Tiết Sản Phẩm", jPanel11);

        panelGradiente1.add(jTabbedPane3);
        jTabbedPane3.setBounds(0, 0, 990, 700);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(panelGradiente1, javax.swing.GroupLayout.PREFERRED_SIZE, 1055, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(panelGradiente1, javax.swing.GroupLayout.PREFERRED_SIZE, 698, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnLamMoiHangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLamMoiHangActionPerformed
      
    }//GEN-LAST:event_btnLamMoiHangActionPerformed

    private void btnCapNhatHangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCapNhatHangActionPerformed
       
    }//GEN-LAST:event_btnCapNhatHangActionPerformed

    private void btnThemHangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemHangActionPerformed
      
    }//GEN-LAST:event_btnThemHangActionPerformed

    private void tblHangMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblHangMouseClicked
        
    }//GEN-LAST:event_tblHangMouseClicked

    private void btnLamMoiSPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLamMoiSPActionPerformed
      
    }//GEN-LAST:event_btnLamMoiSPActionPerformed

    private void btnCapNhatSPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCapNhatSPActionPerformed

    }//GEN-LAST:event_btnCapNhatSPActionPerformed

    private void btnThemSPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemSPActionPerformed

    }//GEN-LAST:event_btnThemSPActionPerformed

    private void tblSanPhamMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblSanPhamMouseClicked
        
    }//GEN-LAST:event_tblSanPhamMouseClicked

    private void tblMauSacMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblMauSacMouseClicked
       int row = tblMauSac.getSelectedRow();
        if (row == -1) {
            return;
        }
        Objecttt x = getdatdtb(row);
         txtIdMau.setText(x.getId()+"");
        txtTenmau.setText(x.getTen());
    }//GEN-LAST:event_tblMauSacMouseClicked

    private void btnThemSP1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemSP1ActionPerformed
            if (getdatafrom() == null) {

            return;
        }
        JOptionPane.showMessageDialog(this, iMauSacServices.Add(getdatafrom()));
            loadtablemausac();
    }//GEN-LAST:event_btnThemSP1ActionPerformed

    private void btnCapNhatSP1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCapNhatSP1ActionPerformed
               int row = tblMauSac.getSelectedRow();
        if (row == -1) {
            JOptionPane.showMessageDialog(this, "Bạn cần chọn 1 dòng để sửa");
            return;
        }
        if (JOptionPane.showConfirmDialog(this, "Bạn có chắc chắn muốn sửa không")!= JOptionPane.YES_OPTION) {
            return;
        }
        int id = (int) tblMauSac.getValueAt(row, 0);
         JOptionPane.showMessageDialog(this, iMauSacServices.Update(getdatafrom(), id));
            loadtablemausac();
    }//GEN-LAST:event_btnCapNhatSP1ActionPerformed

    private void btnLamMoiSP1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLamMoiSP1ActionPerformed
        txtTenmau.setText("");
        txtIdMau.setText("");
    }//GEN-LAST:event_btnLamMoiSP1ActionPerformed

    private void tblBoNhoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblBoNhoMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_tblBoNhoMouseClicked

    private void btnThemSP2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemSP2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnThemSP2ActionPerformed

    private void btnCapNhatSP2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCapNhatSP2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnCapNhatSP2ActionPerformed

    private void btnLamMoiSP2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLamMoiSP2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnLamMoiSP2ActionPerformed

    private void tblManhinhMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblManhinhMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_tblManhinhMouseClicked

    private void btnThemSP3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemSP3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnThemSP3ActionPerformed

    private void btnCapNhatSP3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCapNhatSP3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnCapNhatSP3ActionPerformed

    private void btnLamMoiSP3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLamMoiSP3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnLamMoiSP3ActionPerformed

    private void tblCameraMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblCameraMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_tblCameraMouseClicked

    private void btnThemSP4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemSP4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnThemSP4ActionPerformed

    private void btnCapNhatSP4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCapNhatSP4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnCapNhatSP4ActionPerformed

    private void btnLamMoiSP4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLamMoiSP4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnLamMoiSP4ActionPerformed

    private void tblImeiMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblImeiMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_tblImeiMouseClicked

    private void btnThemSP5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemSP5ActionPerformed
            JOptionPane.showMessageDialog(this, iMauSacServices.Add(getdatafrom()));
            loadtablemausac();
    }//GEN-LAST:event_btnThemSP5ActionPerformed

    private void btnCapNhatSP5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCapNhatSP5ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnCapNhatSP5ActionPerformed

    private void btnLamMoiSP5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLamMoiSP5ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnLamMoiSP5ActionPerformed

    private void tblSanPham6MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblSanPham6MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_tblSanPham6MouseClicked

    private void btnThemSP6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemSP6ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnThemSP6ActionPerformed

    private void btnCapNhatSP6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCapNhatSP6ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnCapNhatSP6ActionPerformed

    private void btnLamMoiSP6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLamMoiSP6ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnLamMoiSP6ActionPerformed

    private void btnAddImeiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddImeiActionPerformed
      jPanel1.setVisible(true);
    }//GEN-LAST:event_btnAddImeiActionPerformed

    private void tblImeiviewMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblImeiviewMouseClicked
              jPanel1.setVisible(false);

    }//GEN-LAST:event_tblImeiviewMouseClicked

    private void searchtxtCaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_searchtxtCaretUpdate

    }//GEN-LAST:event_searchtxtCaretUpdate

    private void lbl_searchMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_searchMouseClicked
        // TODO add your handling code here:

    }//GEN-LAST:event_lbl_searchMouseClicked

    private void searchtxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchtxtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_searchtxtActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private swing.MyButton btnAddImei;
    private swing.MyButton btnCapNhatHang;
    private swing.MyButton btnCapNhatSP;
    private swing.MyButton btnCapNhatSP1;
    private swing.MyButton btnCapNhatSP2;
    private swing.MyButton btnCapNhatSP3;
    private swing.MyButton btnCapNhatSP4;
    private swing.MyButton btnCapNhatSP5;
    private swing.MyButton btnCapNhatSP6;
    private swing.MyButton btnLamMoiHang;
    private swing.MyButton btnLamMoiSP;
    private swing.MyButton btnLamMoiSP1;
    private swing.MyButton btnLamMoiSP2;
    private swing.MyButton btnLamMoiSP3;
    private swing.MyButton btnLamMoiSP4;
    private swing.MyButton btnLamMoiSP5;
    private swing.MyButton btnLamMoiSP6;
    private swing.MyButton btnThemHang;
    private swing.MyButton btnThemSP;
    private swing.MyButton btnThemSP1;
    private swing.MyButton btnThemSP2;
    private swing.MyButton btnThemSP3;
    private swing.MyButton btnThemSP4;
    private swing.MyButton btnThemSP5;
    private swing.MyButton btnThemSP6;
    private javax.swing.JComboBox<String> cboBoNho;
    private javax.swing.JComboBox<String> cboCam;
    private javax.swing.JComboBox<String> cboHang;
    private javax.swing.JComboBox<String> cboMan;
    private javax.swing.JComboBox<String> cboMau;
    private javax.swing.JComboBox<String> cboTenSP;
    private javax.swing.JLabel hideshow;
    private javax.swing.JLabel hideshow1;
    private javax.swing.JLabel hideshow2;
    private javax.swing.JLabel hideshow3;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel39;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel40;
    private javax.swing.JLabel jLabel41;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane10;
    private javax.swing.JScrollPane jScrollPane11;
    private javax.swing.JScrollPane jScrollPane12;
    private javax.swing.JScrollPane jScrollPane13;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JScrollPane jScrollPane8;
    private javax.swing.JScrollPane jScrollPane9;
    private javax.swing.JTabbedPane jTabbedPane3;
    private javax.swing.JLabel lbl_search;
    private swing.PanelBorder panelBorder2;
    private swing.PanelGradiente panelGradiente1;
    private swing.SearchText searchtxt;
    private javax.swing.JTable tblBoNho;
    private javax.swing.JTable tblCamera;
    private javax.swing.JTable tblHang;
    private javax.swing.JTable tblImei;
    private javax.swing.JTable tblImeiview;
    private javax.swing.JTable tblManhinh;
    private javax.swing.JTable tblMauSac;
    private javax.swing.JTable tblSanPham;
    private javax.swing.JTable tblSanPham6;
    private swing.MyTextField txtGiaBan;
    private swing.MyTextField txtGiaNhap;
    private swing.MyTextField txtIDCT;
    private swing.MyTextField txtIDSP;
    private swing.MyTextField txtIdCmr;
    private swing.MyTextField txtIdMan;
    private swing.MyTextField txtIdMau;
    private swing.MyTextField txtIdbonho;
    private swing.MyTextField txtImeiCTSP;
    private swing.MyTextField txtMaImei;
    private swing.MyTextField txtTenBoNho;
    private swing.MyTextField txtTenCmr;
    private swing.MyTextField txtTenHang;
    private swing.MyTextField txtTenMan;
    private swing.MyTextField txtTenSP;
    private swing.MyTextField txtTenmau;
    private swing.MyTextField txtidHang;
    private swing.MyTextField txtidImei;
    // End of variables declaration//GEN-END:variables

}
