package automation_excercise_utilities;

import java.util.List;

public class CartData {
	
	private List<ProductData> Products;
	private int expectedCartTotal;
	
	public void setProducts(List<ProductData> products) {
		Products = products;
	}
	public void setExpectedCartTotal(int expectedCartTotal) {
		this.expectedCartTotal = expectedCartTotal;
	}
	
	public List<ProductData> getProducts() {
		return Products;
	}
	public int getExpectedCartTotal() {
		return expectedCartTotal;
	}
	
}
