/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package services.imp;

import java.util.List;
import repositorys.HangRepository;
import services.HangService;
import viewmodels.HangViewModel;

/**
 *
 * @author HieuIT
 */
public class HangImpl implements HangService{
    private HangRepository HangRepository = new HangRepository();
    @Override
    public List<HangViewModel> getAll() {
        return HangRepository.getAll();
    }

    @Override
    public String add(HangViewModel h) {
        boolean add = HangRepository.add(h);
        if (add) {
            return "Thêm thành công";
        } else {
            return "Thêm thất bại";
        }
    }

    @Override
    public String sua(String maHang, HangViewModel h) {
        boolean sua = HangRepository.sua(maHang, h);
        if (sua) {
            return "Sửa thành công";
        } else {
            return "Sửa thất bại";
        }
    }
    
}
