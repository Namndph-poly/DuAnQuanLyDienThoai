/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repositorys.imp;

import java.util.ArrayList;
import java.util.List;
import models.Users;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import models.Chucvu;
import utilconnext.DBConnection;
import repositorys.IUsersReposytory;

/**
 *
 * @author hungh
 */
public class UsersReposytory implements IUsersReposytory {

    final String SQL_SELECT_BY_TK = "SELECT USERs.ID,MaNV,HoVaTen,NgaySinh,DiaChi,GioiTinh,SDT,Email,TaiKhoan,MatKhau,ChucVu.ID,ChucVu.Ten,USERs.TrangThai  FROM Users join ChucVu on ChucVu.Id = Users.IdCV where Taikhoan = ?";

    @Override
    public boolean updateMK(Users us, String mail) {
        String sql = "UPDATE Users SET MatKhau = ? WHERE TaiKhoan = ?";
        try {
            Connection conn = DBConnection.openDbConnection();
            PreparedStatement pstm = conn.prepareStatement(sql);
            pstm.setString(1, us.getMk());
            pstm.setString(2, mail);
            pstm.executeUpdate();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }

    }

    @Override
    public String kiemtra(String mail) {
        String sql = "SELECT EMAIL FROM Users WHERE EMAIL = ?";
        String box = null;
        try {
            Connection conn = DBConnection.openDbConnection();
            PreparedStatement pstm = conn.prepareStatement(sql);
            pstm.setString(1, mail);
            ResultSet rs = pstm.executeQuery();
            while (rs.next()) {
                box = rs.getString(1);
            }
            return box;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public Users getUserbytk(String tk) {
        Users x = new Users();
        try {
            x = getdataQuery(SQL_SELECT_BY_TK, tk).get(0);
        } catch (Exception e) {
            x = new Users();
        }
        return x;
    }

    private List<Users> getdataQuery(String SQL, Object... arvg) {
        List<Users> lst = new ArrayList<>();

        try {
            ResultSet rs = DBConnection.getDataFromQuery(SQL, arvg);
            while (rs.next()) {
                Chucvu cvv = new Chucvu(rs.getString(11), rs.getString(12));
                String id = rs.getString(1);
                String MaNV = rs.getString(2);
                String HoVaTen = rs.getString(3);               
                String ngaysinh = rs.getString(4);
                String DiaChi = rs.getString(5);
                Integer gioitinh = rs.getInt(6);
                String SDT = rs.getString(7);
                String Email = rs.getString(8);
                String TaiKhoan = rs.getString(9);
                String MatKhau = rs.getString(10);                                
                Integer tt = rs.getInt(13);

                lst.add(new Users(id, MaNV, HoVaTen, ngaysinh, Email, gioitinh, SDT, Email, TaiKhoan, MatKhau, cvv, tt));
            }
        } catch (SQLException ex) {
            Logger.getLogger(UsersReposytory.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lst;
    }

    @Override
    public String kiemtrasdt(String sdt) {
        String sql = "SELECT SDT FROM Users WHERE SDT = ?";
        String box = null;
        try {
            Connection conn = DBConnection.openDbConnection();
            PreparedStatement pstm = conn.prepareStatement(sql);
            pstm.setString(1, sdt);
            ResultSet rs = pstm.executeQuery();
            while (rs.next()) {
                box = rs.getString(1);
            }
            return box;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public String kiemtratk(String tk) {
        String sql = "SELECT TAIKHOAN FROM Users WHERE TAIKHOAN = ?";
        String box = null;
        try {
            Connection conn = DBConnection.openDbConnection();
            PreparedStatement pstm = conn.prepareStatement(sql);
            pstm.setString(1, tk);
            ResultSet rs = pstm.executeQuery();
            while (rs.next()) {
                box = rs.getString(1);
            }
            return box;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
