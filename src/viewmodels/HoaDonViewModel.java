/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package viewmodels;

/**
 *
 * @author HieuIT
 */
public class HoaDonViewModel {

    private int id;
    private int idKH;
    private int idNV;
    private int idHTTT;
    private String maHD;
    private String ngayTao;
    private String ngayThanhToan;
    private long tongTien;
    private long tienKhachCanTra;
    private int trangThai;
    private String moTa;

    public HoaDonViewModel() {
    }

    public HoaDonViewModel(int id, int idKH, int idNV, int idHTTT, String maHD, String ngayTao, String ngayThanhToan, long tongTien, long tienKhachCanTra, int trangThai, String moTa) {
        this.id = id;
        this.idKH = idKH;
        this.idNV = idNV;
        this.idHTTT = idHTTT;
        this.maHD = maHD;
        this.ngayTao = ngayTao;
        this.ngayThanhToan = ngayThanhToan;
        this.tongTien = tongTien;
        this.tienKhachCanTra = tienKhachCanTra;
        this.trangThai = trangThai;
        this.moTa = moTa;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdKH() {
        return idKH;
    }

    public void setIdKH(int idKH) {
        this.idKH = idKH;
    }

    public int getIdNV() {
        return idNV;
    }

    public void setIdNV(int idNV) {
        this.idNV = idNV;
    }

    public int getIdHTTT() {
        return idHTTT;
    }

    public void setIdHTTT(int idHTTT) {
        this.idHTTT = idHTTT;
    }

    public String getMaHD() {
        return maHD;
    }

    public void setMaHD(String maHD) {
        this.maHD = maHD;
    }

    public String getNgayTao() {
        return ngayTao;
    }

    public void setNgayTao(String ngayTao) {
        this.ngayTao = ngayTao;
    }

    public String getNgayThanhToan() {
        return ngayThanhToan;
    }

    public void setNgayThanhToan(String ngayThanhToan) {
        this.ngayThanhToan = ngayThanhToan;
    }

    public long getTongTien() {
        return tongTien;
    }

    public void setTongTien(long tongTien) {
        this.tongTien = tongTien;
    }

    public long getTienKhachCanTra() {
        return tienKhachCanTra;
    }

    public void setTienKhachCanTra(long tienKhachCanTra) {
        this.tienKhachCanTra = tienKhachCanTra;
    }

    public int getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(int trangThai) {
        this.trangThai = trangThai;
    }

    public String getMoTa() {
        return moTa;
    }

    public void setMoTa(String moTa) {
        this.moTa = moTa;
    }

    public Object[] toDataRow() {
        return new Object[]{id, maHD, ngayTao, trangThai};
    }
}
