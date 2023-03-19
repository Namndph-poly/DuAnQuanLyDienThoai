/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package services.imp;

import java.util.List;
import models.KhachHang;
import repositorys.imp.KhachHangRepository;
import services.KhachHangService;

/**
 *
 * @author Admin
 */
public class KhachHangImp implements KhachHangService {

    private KhachHangRepository khRepo = new KhachHangRepository();

    @Override
    public List<KhachHang> getList() {
        return this.khRepo.getList();
    }

    @Override
    public String insert(KhachHang kh) {
        boolean insert = khRepo.insert(kh);
        if (insert) {
            return "Them thanh cong";
        } else {
            return "Them that bai";
        }
    }

    @Override
    public String update(KhachHang kh, String ma) {
        boolean update = khRepo.update(kh, ma);
        if (update) {
            return "Sua thanh cong";
        } else {
            return "Sua that bai";
        }
    }

    @Override
    public List<KhachHang> search( String ma) {
        return this.khRepo.search(ma);
    }

}
