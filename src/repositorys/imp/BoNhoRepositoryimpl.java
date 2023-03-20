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
import models.BoNho;
import repositorys.IBoNhoRepository;
import utilconnext.DBConnection;

/**
 *
 * @author vieta
 */
public class BoNhoRepositoryimpl implements IBoNhoRepository{
    final String SQL_SELECT_ALL = "SELECT Id,Ten FROM dbo.BoNho";
    final String SQL_SELECT_BY_ID = "SELECT Id,Ten FROM dbo.BoNho WHERE Id = ?";
    final String SQL_INSERT = "INSERT INTO dbo.BoNho(Ten) VALUES(?)";
    final String SQL_UPDATE = "UPDATE dbo.BoNho SET Ten = ? WHERE Id = ?";
    final String SQL_DELETE = "DELETE dbo.BoNho WHERE Id = ?";

    @Override
    public List<BoNho> getAll() {

        return getdataquery(SQL_SELECT_ALL);

    }

    @Override
    public int insert(BoNho x) {

        return DBConnection.ExcuteQuery(SQL_INSERT, x.getTen());

    }

    @Override
    public int update(BoNho x, int id) {
        return DBConnection.ExcuteQuery(SQL_UPDATE, x.getTen(), id);
    }

    @Override
    public int delete(int id) {
        return DBConnection.ExcuteQuery(SQL_DELETE, id);
    }

    @Override
    public BoNho getbyid(int id) {
        if (id == 0) {
            return new BoNho();
        }  
        return getdataquery(SQL_SELECT_BY_ID, id).get(0);
    }

    private List<BoNho> getdataquery(String SQL, Object... arvg) {
        List<BoNho> lst = new ArrayList<>();
        try {
            ResultSet rl = DBConnection.getDataFromQuery(SQL, arvg);
            while (rl.next()) {
                lst.add(new BoNho((int) rl.getObject(1), (String) rl.getObject(2)));
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return lst;

    }
}
