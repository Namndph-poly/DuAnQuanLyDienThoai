/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package services.imp;

import java.util.List;
import repositorys.SanPhamRepository;
import services.SanPhamService;
import viewmodels.HangViewModel;
import viewmodels.SanPhamViewModel;

/**
 *
 * @author HieuIT
 */
public class SanPhamImpl implements SanPhamService {

    private SanPhamRepository SanPhamRepository = new SanPhamRepository();

    @Override
    public List<SanPhamViewModel> getAll() {
        return SanPhamRepository.getAll();
    }

    @Override
    public List<HangViewModel> getID() {
        return SanPhamRepository.getAllHang();
    }
    

}
