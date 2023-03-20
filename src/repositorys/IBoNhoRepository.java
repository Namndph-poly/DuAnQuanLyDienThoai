
package repositorys;

import java.util.List;

import models.BoNho;

/**
 *
 * @author vieta
 */
public interface IBoNhoRepository {
    public List<BoNho> getAll();
    
    public int insert(BoNho x);
    
    public int update(BoNho x,int id);
    
    public int delete(int id);
    
    public BoNho getbyid(int id);
}
