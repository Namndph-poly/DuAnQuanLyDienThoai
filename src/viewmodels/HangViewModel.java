/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package viewmodels;

/**
 *
 * @author HieuIT
 */
public class HangViewModel {

    int id;
    private String maHang;
    private String tenHang;

    public HangViewModel() {
    }

    public HangViewModel(String maHang, String tenHang) {
        this.maHang = maHang;
        this.tenHang = tenHang;
    }

    public HangViewModel(int id, String maHang, String tenHang) {
        this.id = id;
        this.maHang = maHang;
        this.tenHang = tenHang;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMaHang() {
        return maHang;
    }

    public void setMaHang(String maHang) {
        this.maHang = maHang;
    }

    public String getTenHang() {
        return tenHang;
    }

    public void setTenHang(String tenHang) {
        this.tenHang = tenHang;
    }

    public Object[] toRowData() {
        return new Object[]{id, maHang, tenHang};
    }
}
