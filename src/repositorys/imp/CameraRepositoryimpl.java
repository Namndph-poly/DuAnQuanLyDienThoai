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
import models.Camera;
import utilconnext.DBConnection;
import repositorys.ICameraRepository;

/**
 *
 * @author vieta
 */
public class CameraRepositoryimpl implements ICameraRepository{
    final String SQL_SELECT_ALL = "SELECT Id,Ten FROM dbo.Camera";
    final String SQL_SELECT_BY_ID = "SELECT Id,Ten FROM dbo.Camera WHERE Id = ?";
    final String SQL_INSERT = "INSERT INTO dbo.Camera(Ten) VALUES(?)";
    final String SQL_UPDATE = "UPDATE dbo.Camera SET Ten = ? WHERE Id = ?";
    final String SQL_DELETE = "DELETE dbo.Camera WHERE Id = ?";

    @Override
    public List<Camera> getAll() {

        return getdataquery(SQL_SELECT_ALL);

    }

    @Override
    public int insert(Camera x) {

        return DBConnection.ExcuteQuery(SQL_INSERT, x.getTen());

    }

    @Override
    public int update(Camera x, int id) {
        return DBConnection.ExcuteQuery(SQL_UPDATE, x.getTen(), id);
    }

    @Override
    public int delete(int id) {
        return DBConnection.ExcuteQuery(SQL_DELETE, id);
    }

    @Override
    public Camera getbyid(int id) {
        if (id == 0) {
            return new Camera();
        }  
        return getdataquery(SQL_SELECT_BY_ID, id).get(0);
    }

    private List<Camera> getdataquery(String SQL, Object... arvg) {
        List<Camera> lst = new ArrayList<>();
        try {
            ResultSet rl = DBConnection.getDataFromQuery(SQL, arvg);
            while (rl.next()) {
                lst.add(new Camera((int) rl.getObject(1), (String) rl.getObject(2)));
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return lst;

    }
}
