/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package services;

import java.util.List;
import models.Users;

import viewmodels.UsersViewmodel;

/**
 *
 * @author hungh
 */
public interface IUsersService { 

    boolean updateMK(UsersViewmodel us, String mail);

    String kiemtra(String mail);
    
    Users getUserbytk(String tk);

    String kiemtrasdt(String sdt);

    String kiemtratk(String tk);

}
