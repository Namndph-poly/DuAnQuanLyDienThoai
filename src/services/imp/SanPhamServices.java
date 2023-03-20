/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package services.imp;

import java.util.List;
import models.SanPham;
import repositorys.ISanPhamRepository;
import repositorys.imp.SanPhamRepositoryimpl;
import services.ISanPhamServices;
import viewmodels.Objecttt;

/**
 *
 * @author vieta
 */
public class SanPhamServices implements ISanPhamServices{
    private ISanPhamRepository sanPhamRepository = new SanPhamRepositoryimpl();
    
         @Override
    public List<SanPham> getAll() {
        return sanPhamRepository.getAll();
    }

    @Override
    public String Add(Objecttt x) {
        SanPham sp = new SanPham(x.getId(), x.getTen());
        int xxx = sanPhamRepository.insert(sp);
        if (xxx == 1) {
            return "Thành công";
        }
        return "Thất bại";
    }

    @Override
    public String Update(Objecttt x, int id) {
        SanPham sp = new SanPham(x.getId(), x.getTen());
        int xxx = sanPhamRepository.update(sp,id);
        if (xxx == 1) {
            return "Thành công";
        }
        return "Thất bại";
    }

    @Override
    public String Delete(int id) {
        if (sanPhamRepository .delete(id) == 1) {
            return "Thành công";
        }
        return "Thất bại";
    }

    @Override
    public SanPham getbyid(int id) {
        return sanPhamRepository.getbyid(id);
    }
}
