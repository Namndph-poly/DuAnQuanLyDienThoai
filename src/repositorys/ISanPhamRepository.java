
package repositorys;

import java.util.List;

import models.SanPham;

/**
 *
 * @author vieta
 */
public interface ISanPhamRepository {
    public List<SanPham> getAll();
    
    public int insert(SanPham x);
    
    public int update(SanPham x,int id);
    
    public int delete(int id);
    
    public SanPham getbyid(int id);
}
