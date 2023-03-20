/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package services.imp;

import java.util.List;
import models.ManHinh;
import repositorys.IManHinhRepository;
import repositorys.imp.ManHinhRepositoryimpl;
import services.IManHinhServices;
import viewmodels.Objecttt;

/**
 *
 * @author vieta
 */
public class ManHinhServices implements IManHinhServices{
    private IManHinhRepository manHinhRepository = new ManHinhRepositoryimpl();
    
         @Override
    public List<ManHinh> getAll() {
        return manHinhRepository.getAll();
    }

    @Override
    public String Add(Objecttt x) {
        ManHinh sp = new ManHinh(x.getId(), x.getTen());
        int xxx = manHinhRepository.insert(sp);
        if (xxx == 1) {
            return "Thành công";
        }
        return "Thất bại";
    }

    @Override
    public String Update(Objecttt x, int id) {
        ManHinh sp = new ManHinh(x.getId(), x.getTen());
        int xxx = manHinhRepository.update(sp,id);
        if (xxx == 1) {
            return "Thành công";
        }
        return "Thất bại";
    }

    @Override
    public String Delete(int id) {
        if (manHinhRepository .delete(id) == 1) {
            return "Thành công";
        }
        return "Thất bại";
    }

    @Override
    public ManHinh getbyid(int id) {
        return manHinhRepository.getbyid(id);
    }
}
