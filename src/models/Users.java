/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;

import java.sql.Date;
import models.Chucvu;




/**
 *
 * @author hungh
 */
public class Users {
private String id;
    private String ma;
    private String hoTen;
    private String ngaySinh;
    private String diaChi;
    private Integer gioitinh;
    private String sdt;
    private String email;
    private String tk;
    private String mk;
    private Chucvu ChucVu;
    private Integer TT;

    public Users() {
    }

    public Users(String id, String ma, String hoTen, String ngaySinh, String diaChi, Integer gioitinh, String sdt, String email, String tk, String mk, Chucvu ChucVu, Integer TT) {
        this.id = id;
        this.ma = ma;
        this.hoTen = hoTen;
        this.ngaySinh = ngaySinh;
        this.diaChi = diaChi;
        this.gioitinh = gioitinh;
        this.sdt = sdt;
        this.email = email;
        this.tk = tk;
        this.mk = mk;
        this.ChucVu = ChucVu;
        this.TT = TT;
    }
        public Users( String ma, String hoTen, String ngaySinh, String diaChi, Integer gioitinh, String sdt, String email, String tk, String mk, Chucvu ChucVu, Integer TT) {
        this.ma = ma;
        this.hoTen = hoTen;
        this.ngaySinh = ngaySinh;
        this.diaChi = diaChi;
        this.gioitinh = gioitinh;
        this.sdt = sdt;
        this.email = email;
        this.tk = tk;
        this.mk = mk;
        this.ChucVu = ChucVu;
        this.TT = TT;
    }

      public Users(String mk) {
        this.mk = mk;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getMa() {
        return ma;
    }

    public void setMa(String ma) {
        this.ma = ma;
    }

    public String getHoTen() {
        return hoTen;
    }

    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }

    public String getNgaySinh() {
        return ngaySinh;
    }

    public void setNgaySinh(String ngaySinh) {
        this.ngaySinh = ngaySinh;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    public Integer getGioitinh() {
        return gioitinh;
    }

    public void setGioitinh(Integer gioitinh) {
        this.gioitinh = gioitinh;
    }

    public String getSdt() {
        return sdt;
    }

    public void setSdt(String sdt) {
        this.sdt = sdt;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTk() {
        return tk;
    }

    public void setTk(String tk) {
        this.tk = tk;
    }

    public String getMk() {
        return mk;
    }

    public void setMk(String mk) {
        this.mk = mk;
    }

    public Chucvu getChucVu() {
        return ChucVu;
    }

    public void setChucVu(Chucvu ChucVu) {
        this.ChucVu = ChucVu;
    }

    public Integer getTT() {
        return TT;
    }

    public void setTT(Integer TT) {
        this.TT = TT;
    }
}
