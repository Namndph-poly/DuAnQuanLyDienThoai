/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package services.imp;

import java.util.ArrayList;
import java.util.List;
import models.Users;
import repositorys.imp.UsersReposytory;
import viewmodels.UsersViewmodel;
import repositorys.IUsersReposytory;
import services.IUsersService;

/**
 *
 * @author hungh
 */
public class UsersService implements IUsersService {

    List<UsersViewmodel> lstuser;
    private IUsersReposytory usersReposytory;

    public UsersService() {
        lstuser = new ArrayList<>();
        usersReposytory = new UsersReposytory();
    }
    
    @Override
    public boolean updateMK(UsersViewmodel us, String mail) {
        return usersReposytory.updateMK(new Users(us.getMk()), mail);
    }

    @Override
    public String kiemtra(String mail) {
        return usersReposytory.kiemtra(mail);
    }

    @Override
    public Users getUserbytk(String tk) {
        return usersReposytory.getUserbytk(tk);
    }

    @Override
    public String kiemtrasdt(String sdt) {
        return usersReposytory.kiemtrasdt(sdt);
    }

    @Override
    public String kiemtratk(String tk) {
        return usersReposytory.kiemtratk(tk);
    }
}
