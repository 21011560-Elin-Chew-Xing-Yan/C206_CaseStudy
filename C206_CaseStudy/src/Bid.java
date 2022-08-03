public class Bid {
	private String ID;
	private String Name;
	private String SellerEmail;
	private String BuyerEmail;
	private double price;

	public Bid(String iD, String name, String sellerEmail, String buyerEmail, double price) {
		this.ID = iD;
		this.Name = name;
		this.SellerEmail = sellerEmail;
		this.BuyerEmail = buyerEmail;
		this.price = price;
	}

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


	public void showDeleted(boolean b) {
		// TODO Auto-generated method stub
		
	}

}
