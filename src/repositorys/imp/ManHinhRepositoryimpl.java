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
import models.ManHinh;
import repositorys.IManHinhRepository;
import utilconnext.DBConnection;

/**
 *
 * @author vieta
 */
public class ManHinhRepositoryimpl implements IManHinhRepository{
    final String SQL_SELECT_ALL = "SELECT Id,Ten FROM dbo.ManHinh";
    final String SQL_SELECT_BY_ID = "SELECT Id,Ten FROM dbo.ManHinh WHERE Id = ?";
    final String SQL_INSERT = "INSERT INTO dbo.ManHinh(Ten) VALUES(?)";
    final String SQL_UPDATE = "UPDATE dbo.ManHinh SET Ten = ? WHERE Id = ?";
    final String SQL_DELETE = "DELETE dbo.ManHinh WHERE Id = ?";

    @Override
    public List<ManHinh> getAll() {

        return getdataquery(SQL_SELECT_ALL);

    }

    @Override
    public int insert(ManHinh x) {

        return DBConnection.ExcuteQuery(SQL_INSERT, x.getTen());

    }

    @Override
    public int update(ManHinh x, int id) {
        return DBConnection.ExcuteQuery(SQL_UPDATE, x.getTen(), id);
    }

    @Override
    public int delete(int id) {
        return DBConnection.ExcuteQuery(SQL_DELETE, id);
    }

    @Override
    public ManHinh getbyid(int id) {
        if (id == 0) {
            return new ManHinh();
        }  
        return getdataquery(SQL_SELECT_BY_ID, id).get(0);
    }

    private List<ManHinh> getdataquery(String SQL, Object... arvg) {
        List<ManHinh> lst = new ArrayList<>();
        try {
            ResultSet rl = DBConnection.getDataFromQuery(SQL, arvg);
            while (rl.next()) {
                lst.add(new ManHinh((int) rl.getObject(1), (String) rl.getObject(2)));
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return lst;

    }
}
