package ch11.sec01.exam02;

public class Product {
	private int num;
	private String company;
	private String product;
	private int sale;
	
	public Product(int num, String company, String product, int sale) {
		this.num = num;
		this.company = company;
		this.product = product;
		this.sale = sale;
	}
	
	@Override
	public boolean equals(Object obj) {
		if(obj instanceof Product) {
			Product m = (Product) obj;
			if(num == m.num && product.equals(m.product)) {
				return true;
			} else {
				return false;
			} 
		} else {
			return false;
		}
	}
	
	@Override
	public int hashCode() {
		return product.hashCode();
	}

}
