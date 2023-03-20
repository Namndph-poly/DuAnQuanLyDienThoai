/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package services;

import java.util.List;
import models.ManHinh;
import viewmodels.Objecttt;

/**
 *
 * @author vieta
 */
public interface IManHinhServices {
    List<ManHinh> getAll();
    
    String Add(Objecttt x);
    
    String Update(Objecttt x,int id);
    
    String Delete(int id);
    
    ManHinh getbyid(int id);
}
