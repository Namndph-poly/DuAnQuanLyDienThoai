/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package services.imp;

import java.util.List;
import models.Camera;
import repositorys.ICameraRepository;
import repositorys.imp.CameraRepositoryimpl;
import services.ICameraServices;
import viewmodels.Objecttt;

/**
 *
 * @author vieta
 */
public class CameraServices implements ICameraServices{
    private ICameraRepository cameraRepository = new CameraRepositoryimpl();
    
         @Override
    public List<Camera> getAll() {
        return cameraRepository.getAll();
    }

    @Override
    public String Add(Objecttt x) {
        Camera sp = new Camera(x.getId(), x.getTen());
        int xxx = cameraRepository.insert(sp);
        if (xxx == 1) {
            return "Thành công";
        }
        return "Thất bại";
    }

    @Override
    public String Update(Objecttt x, int id) {
        Camera sp = new Camera(x.getId(), x.getTen());
        int xxx = cameraRepository.update(sp,id);
        if (xxx == 1) {
            return "Thành công";
        }
        return "Thất bại";
    }

    @Override
    public String Delete(int id) {
        if (cameraRepository .delete(id) == 1) {
            return "Thành công";
        }
        return "Thất bại";
    }

    @Override
    public Camera getbyid(int id) {
        return cameraRepository.getbyid(id);
    }
}
