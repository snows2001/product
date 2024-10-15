package Product;

import java.util.List;

import space.jdbc.memo.Memo;

public interface ProductDao {
	boolean insert(Product product);
	
	List<Product> findAll();
	
	Product findById(long id);
	
	boolean update(Product product);
	
	boolean deleteById(long id);
}
