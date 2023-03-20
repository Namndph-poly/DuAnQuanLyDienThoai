/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package services.imp;

import java.util.List;
import models.BoNho;
import repositorys.IBoNhoRepository;
import repositorys.imp.BoNhoRepositoryimpl;
import services.IBoNhoServices;
import viewmodels.Objecttt;

/**
 *
 * @author vieta
 */
public class BoNhoServices implements IBoNhoServices{
    private IBoNhoRepository boNhoRepository = new BoNhoRepositoryimpl();
    
         @Override
    public List<BoNho> getAll() {
        return boNhoRepository.getAll();
    }

    @Override
    public String Add(Objecttt x) {
        BoNho sp = new BoNho(x.getId(), x.getTen());
        int xxx = boNhoRepository.insert(sp);
        if (xxx == 1) {
            return "Thành công";
        }
        return "Thất bại";
    }

    @Override
    public String Update(Objecttt x, int id) {
        BoNho sp = new BoNho(x.getId(), x.getTen());
        int xxx = boNhoRepository.update(sp,id);
        if (xxx == 1) {
            return "Thành công";
        }
        return "Thất bại";
    }

    @Override
    public String Delete(int id) {
        if (boNhoRepository .delete(id) == 1) {
            return "Thành công";
        }
        return "Thất bại";
    }

    @Override
    public BoNho getbyid(int id) {
        return boNhoRepository.getbyid(id);
    }
}
