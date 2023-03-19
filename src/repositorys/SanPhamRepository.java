/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repositorys;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import utilconnext.ConnectDB;
import viewmodels.HangViewModel;
import viewmodels.SanPhamViewModel;

/**
 *
 * @author HieuIT
 */
public class SanPhamRepository {

    public List<SanPhamViewModel> getAll() {
        String query = "SELECT [ID]\n"
                + "      ,[IDHang]\n"
                + "      ,[MaSP]\n"
                + "      ,[TenSp]\n"
                + "  FROM [dbo].[SanPham]";
        try ( Connection con = ConnectDB.getConnection();  PreparedStatement ps = con.prepareStatement(query);) {
            ResultSet rs = ps.executeQuery();
            List<SanPhamViewModel> list = new ArrayList<>();
            while (rs.next()) {
                list.add(new SanPhamViewModel(rs.getInt(1), rs.getInt(2), rs.getString(3), rs.getString(4)));
            }
            return list;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    public List<HangViewModel> getAllHang() {
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
}
