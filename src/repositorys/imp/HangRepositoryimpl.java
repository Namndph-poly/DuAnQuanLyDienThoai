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
import models.Hang;
import repositorys.IHangRepository;
import utilconnext.DBConnection;

/**
 *
 * @author vieta
 */
public class HangRepositoryimpl implements IHangRepository{
    final String SQL_SELECT_ALL = "SELECT Id,Ten FROM dbo.HangSanPham";
    final String SQL_SELECT_BY_ID = "SELECT Id,Ten FROM dbo.HangSanPham WHERE Id = ?";
    final String SQL_INSERT = "INSERT INTO dbo.HangSanPham(Ten) VALUES(?)";
    final String SQL_UPDATE = "UPDATE dbo.HangSanPham SET Ten = ? WHERE Id = ?";
    final String SQL_DELETE = "DELETE dbo.HangSanPham WHERE Id = ?";

    @Override
    public List<Hang> getAll() {

        return getdataquery(SQL_SELECT_ALL);

    }

    @Override
    public int insert(Hang x) {

        return DBConnection.ExcuteQuery(SQL_INSERT, x.getTen());

    }

    @Override
    public int update(Hang x, int id) {
        return DBConnection.ExcuteQuery(SQL_UPDATE, x.getTen(), id);
    }

    @Override
    public int delete(int id) {
        return DBConnection.ExcuteQuery(SQL_DELETE, id);
    }

    @Override
    public Hang getbyid(int id) {
        if (id == 0) {
            return new Hang();
        }  
        return getdataquery(SQL_SELECT_BY_ID, id).get(0);
    }

    private List<Hang> getdataquery(String SQL, Object... arvg) {
        List<Hang> lst = new ArrayList<>();
        try {
            ResultSet rl = DBConnection.getDataFromQuery(SQL, arvg);
            while (rl.next()) {
                lst.add(new Hang((int) rl.getObject(1), (String) rl.getObject(2)));
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return lst;

    }
}
