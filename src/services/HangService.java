/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package services;

import java.util.List;
import viewmodels.HangViewModel;

/**
 *
 * @author HieuIT
 */
public interface HangService {

    List<HangViewModel> getAll();

    String add(HangViewModel h);
    String sua(String maHang, HangViewModel h);
    
    
}
