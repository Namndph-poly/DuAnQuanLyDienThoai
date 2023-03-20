
package repositorys;

import repositorys.*;
import java.util.List;

import models.ManHinh;

/**
 *
 * @author vieta
 */
public interface IManHinhRepository {
    public List<ManHinh> getAll();
    
    public int insert(ManHinh x);
    
    public int update(ManHinh x,int id);
    
    public int delete(int id);
    
    public ManHinh getbyid(int id);
}
