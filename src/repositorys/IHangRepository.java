
package repositorys;

import java.util.List;

import models.Hang;

/**
 *
 * @author vieta
 */
public interface IHangRepository {
    public List<Hang> getAll();
    
    public int insert(Hang x);
    
    public int update(Hang x,int id);
    
    public int delete(int id);
    
    public Hang getbyid(int id);
}
