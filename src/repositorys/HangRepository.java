/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repositorys;

import java.util.List;
import viewmodels.HangViewModel;
import java.sql.*;
import java.util.ArrayList;
import utilconnext.ConnectDB;
import utilconnext.DBConnection;

/**
 *
 * @author HieuIT
 */
public class HangRepository {

    public List<HangViewModel> getAll() {
        String query = "SELECT [ID]\n"
                + "      ,[MaHangSP]\n"
                + "      ,[TenHangSP]\n"
                + "  FROM [dbo].[HangSanPham]";
        try ( Connection con = ConnectDB.getConnection();  PreparedStatement ps = con.prepareStatement(query);) {
            ResultSet rs = ps.executeQuery();
            List<HangViewModel> list = new ArrayList<>();
            while (rs.next()) {
                list.add(new HangViewModel(rs.getInt(1), rs.getString(2), rs.getString(3)));
            }
            return list;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public boolean add(HangViewModel h) {
        String query = "INSERT INTO [dbo].[HangSanPham]\n"
                + "           ([MaHangSP]\n"
                + "           ,[TenHangSP])\n"
                + "     VALUES\n"
                + "           (?,?)";
        int check = 0;
        try ( Connection con = ConnectDB.getConnection();  PreparedStatement ps = con.prepareStatement(query);) {
            ps.setObject(1, h.getMaHang());
            ps.setObject(2, h.getTenHang());
            check = ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return check > 0;
    }

    public boolean sua(String maHang, HangViewModel h) {
        String query = "UPDATE [dbo].[HangSanPham]\n"
                + "   SET [MaHangSP] = ?\n"
                + "      ,[TenHangSP] = ?\n"
                + " WHERE MaHangSP = ?";
        int check = 0;
        try ( Connection con = ConnectDB.getConnection();  PreparedStatement ps = con.prepareStatement(query);) {
            ps.setObject(1, h.getMaHang());
            ps.setObject(2, h.getTenHang());
            ps.setObject(3, maHang);
            check = ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return check > 0;
    }
}
