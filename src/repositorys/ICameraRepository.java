
package repositorys;

import java.util.List;
import models.Camera;



/**
 *
 * @author vieta
 */
public interface ICameraRepository {
    public List<Camera> getAll();
    
    public int insert(Camera x);
    
    public int update(Camera x,int id);
    
    public int delete(int id);
    
    public Camera getbyid(int id);
}
