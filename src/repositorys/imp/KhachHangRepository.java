/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repositorys.imp;

import java.util.List;
import models.KhachHang;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import utilconnext.DBConnection;

/**
 *
 * @author Admin
 */
public class KhachHangRepository {

    private Connection con;

    public KhachHangRepository() {
        this.con = DBConnection.openDbConnection();
    }

    public List<KhachHang> getList() {
        String query = "SELECT [MaKH]\n"
                + "      ,[HoVaTen]\n"
                + "      ,[SoDienThoai]\n"
                + "      ,[GioiTinh]\n"
                + "  FROM [dbo].[KhachHang]";
        List<KhachHang> list = new ArrayList<>();
        try {
            PreparedStatement ps = con.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                KhachHang kh = new KhachHang(rs.getString(1), rs.getString(2), rs.getString(3), rs.getBoolean(4));
                list.add(kh);
            }
            return list;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public boolean insert(KhachHang kh) {
        String query = "INSERT INTO [dbo].[KhachHang]\n"
                + "           ([MaKH]\n"
                + "           ,[HoVaTen]\n"
                + "           ,[SoDienThoai]\n"
                + "           ,[GioiTinh])\n"
                + "     VALUES\n"
                + "           (?,?,?,?)";
        int check = 0;
        try {
            PreparedStatement ps = con.prepareStatement(query);
            ps.setObject(1, kh.getMa());
            ps.setObject(2, kh.getHoTen());
            ps.setObject(3, kh.getSdt());
            ps.setObject(4, kh.isGioiTinh());
            check = ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return check > 0;

    }

    public boolean update(KhachHang kh, String ma) {
        String query = "UPDATE [dbo].[KhachHang]\n"
                + "   SET [MaKH] = ?\n"
                + "      ,[HoVaTen] = ?\n"
                + "      ,[SoDienThoai] = ?\n"
                + "      ,[GioiTinh] = ?\n"
                + " WHERE MaKH=?";
        int check = 0;
        try {
            PreparedStatement ps = con.prepareStatement(query);
            ps.setObject(1, kh.getMa());
            ps.setObject(2, kh.getHoTen());
            ps.setObject(3, kh.getSdt());
            ps.setObject(4, kh.isGioiTinh());
            ps.setObject(5, ma);
            check = ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return check > 0;
    }

    public List<KhachHang> search(String ma) {
         String query = "SELECT [MaKH]\n"
                + "      ,[HoVaTen]\n"
                + "      ,[SoDienThoai]\n"
                + "      ,[GioiTinh]\n"
                + "  FROM [dbo].[KhachHang] where MaKH=?"
                 ;
        List<KhachHang> list = new ArrayList<>();
        try {
            PreparedStatement ps = con.prepareStatement(query);
            ps.setObject(1, ma);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                KhachHang kh = new KhachHang(rs.getString(1), rs.getString(2), rs.getString(3), rs.getBoolean(4));
                list.add(kh);
            }
            return list;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
