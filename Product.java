package Product;

public class Product {
	private long id;
	private String name;
	private String price;
	private String content;
	
	Product(){}
	
	public Product(long id,String name,String price,String content) {
		this.id = id;
		this.name = name;
		this.price = price;
		this.content = content;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	@Override
	public String toString() {
		return "Product [id=" + id + ", name=" + name + ", price=" + price + ", content=" + content + "]";
	}
	
	
}
