package Product;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class JdbcProductDao implements ProductDao {

	@Override
	public boolean insert(Product product) {
		boolean result = false;
		
		try(Connection connection = DataSource.getDataSource();
				PreparedStatement pStatement 
					= connection.prepareStatement("INSERT INTO PRODUCT1 (ID,NAME,PRICE,CONTENT) VALUES (?,?,?,?)")){
			
			pStatement.setLong(1, product.getId());
			pStatement.setString(2, product.getName());
			pStatement.setString(3, product.getPrice());
			pStatement.setString(4, product.getContent());
			
			int rows = pStatement.executeUpdate();
			
			if(rows > 0) {
				result = true;
			}
			
		}	catch(SQLException e) {
			e.printStackTrace();
		}
		
		return result;
	}

	@Override
	public List<Product> findAll() {
		List<Product> products = new ArrayList<Product>();
		
		try (Connection connection = DataSource.getDataSource();
		PreparedStatement pStatement = connection.prepareStatement("SELECT * FROM PRODUCT1 ORDER BY ID DESC");
		ResultSet rs = pStatement.executeQuery()) {
		
		while(rs.next()) {
			Product product = new Product();
				
			product.setId(rs.getInt("id"));
			product.setName(rs.getString("name"));
			product.setPrice(rs.getString("price"));
			product.setContent(rs.getString("content"));
				
			products.add(product);
		}
		
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return products;
	}

	@Override
	public Product findById(long id) {
		Product product = null;
		
		try (Connection connection = DataSource.getDataSource();
		PreparedStatement pStatement = connection.prepareStatement("SELECT * FROM PRODUCT1 WHERE ID = ?")
		) {
		
		pStatement.setLong(1, id);	
		ResultSet rs = pStatement.executeQuery();
		
		if(rs.next()) {
			product = new Product();
				
			product.setId(rs.getLong("id"));
			product.setName(rs.getString("name"));
			product.setPrice(rs.getString("price"));
			product.setContent(rs.getString("content"));
		}
		
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return product;
	}

	@Override
	public boolean update(Product product) {
		boolean result = false;
		
		try(Connection connection = DataSource.getDataSource();
				PreparedStatement pStatement
					= connection.prepareStatement("UPDATE PRODUCT1 SET content = ? WHERE id = ?")){
			
			pStatement.setString(1, product.getContent());
			pStatement.setLong(2, product.getId());
			
			int rows = pStatement.executeUpdate();
			
			if(rows>0) {
				result = true;
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public boolean deleteById(long id) {
		boolean result = false;
		
		try(Connection connection = DataSource.getDataSource();
				PreparedStatement pStatement
					= connection.prepareStatement("DELETE FROM PRODUCT1 WHERE id = ?")){
			
			pStatement.setLong(1, id);
			
			int rows = pStatement.executeUpdate();
			
			if(rows>0) {
				result = true;
			}
	}catch(Exception e) {
		e.printStackTrace();
	}
		return result;
	}
}
