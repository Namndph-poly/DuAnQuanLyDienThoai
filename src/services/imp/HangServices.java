/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package services.imp;

import java.util.List;
import models.Hang;
import repositorys.IHangRepository;
import repositorys.imp.HangRepositoryimpl;
import services.IHangServices;
import viewmodels.Objecttt;

/**
 *
 * @author vieta
 */
public class HangServices implements IHangServices{
    private IHangRepository hangRepository = new HangRepositoryimpl();
    
         @Override
    public List<Hang> getAll() {
        return hangRepository.getAll();
    }

    @Override
    public String Add(Objecttt x) {
        Hang sp = new Hang(x.getId(), x.getTen());
        int xxx = hangRepository.insert(sp);
        if (xxx == 1) {
            return "Thành công";
        }
        return "Thất bại";
    }

    @Override
    public String Update(Objecttt x, int id) {
        Hang sp = new Hang(x.getId(), x.getTen());
        int xxx = hangRepository.update(sp,id);
        if (xxx == 1) {
            return "Thành công";
        }
        return "Thất bại";
    }

    @Override
    public String Delete(int id) {
        if (hangRepository .delete(id) == 1) {
            return "Thành công";
        }
        return "Thất bại";
    }

    @Override
    public Hang getbyid(int id) {
        return hangRepository.getbyid(id);
    }
}
