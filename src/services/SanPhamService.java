/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package services;

import java.util.List;
import viewmodels.HangViewModel;
import viewmodels.SanPhamViewModel;

/**
 *
 * @author HieuIT
 */
public interface SanPhamService {

    List<SanPhamViewModel> getAll();
    
    List<HangViewModel> getID();
}
