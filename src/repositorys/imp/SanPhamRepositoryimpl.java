/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repositorys.imp;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import models.SanPham;
import repositorys.ISanPhamRepository;
import utilconnext.DBConnection;

/**
 *
 * @author vieta
 */
public class SanPhamRepositoryimpl implements ISanPhamRepository{
    final String SQL_SELECT_ALL = "SELECT Id,Ten FROM dbo.SanPham";
    final String SQL_SELECT_BY_ID = "SELECT Id,Ten FROM dbo.SanPham WHERE Id = ?";
    final String SQL_INSERT = "INSERT INTO dbo.SanPham(Ten) VALUES(?)";
    final String SQL_UPDATE = "UPDATE dbo.SanPham SET Ten = ? WHERE Id = ?";
    final String SQL_DELETE = "DELETE dbo.SanPham WHERE Id = ?";

    @Override
    public List<SanPham> getAll() {

        return getdataquery(SQL_SELECT_ALL);

    }

    @Override
    public int insert(SanPham x) {

        return DBConnection.ExcuteQuery(SQL_INSERT, x.getTen());

    }

    @Override
    public int update(SanPham x, int id) {
        return DBConnection.ExcuteQuery(SQL_UPDATE, x.getTen(), id);
    }

    @Override
    public int delete(int id) {
        return DBConnection.ExcuteQuery(SQL_DELETE, id);
    }

    @Override
    public SanPham getbyid(int id) {
        if (id == 0) {
            return new SanPham();
        }  
        return getdataquery(SQL_SELECT_BY_ID, id).get(0);
    }

    private List<SanPham> getdataquery(String SQL, Object... arvg) {
        List<SanPham> lst = new ArrayList<>();
        try {
            ResultSet rl = DBConnection.getDataFromQuery(SQL, arvg);
            while (rl.next()) {
                lst.add(new SanPham((int) rl.getObject(1), (String) rl.getObject(2)));
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return lst;

    }
}
