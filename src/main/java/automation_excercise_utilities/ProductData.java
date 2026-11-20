package automation_excercise_utilities;

public class ProductData {
	
	private String productName;
    private int expectedPrice;
    private int expectedQuantity;
	
	public void setProductName(String productName) {
		this.productName = productName;
	}

	public void setExpectedPrice(int expectedPrice) {
		this.expectedPrice = expectedPrice;
	}

	public void setExpectedQuantity(int expectedQuantity) {
		this.expectedQuantity = expectedQuantity;
	}
    
	public String getProductName() {
		return productName;
	}
	
	public int getExpectedPrice() {
		return expectedPrice;
	}
	
	public int getExpectedQuantity() {
		return expectedQuantity;
	}

}
