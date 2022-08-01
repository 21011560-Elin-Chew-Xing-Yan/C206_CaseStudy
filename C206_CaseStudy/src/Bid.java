public class Bid {

	public Bid(String iD, String name, String sellerEmail, String buyerEmail, double price) {
		ID = iD;
		Name = name;
		SellerEmail = sellerEmail;
		BuyerEmail = buyerEmail;
		this.price = price;
	}

	private String ID;
	private String Name;
	private String SellerEmail;
	private String BuyerEmail;
	private double price;

	public String getID() {
		return ID;
	}

	public String getName() {
		return Name;
	}

	public String getSellerEmail() {
		return SellerEmail;
	}

	public String getBuyerEmail() {
		return BuyerEmail;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

}
