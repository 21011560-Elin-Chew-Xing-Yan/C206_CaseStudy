import java.util.Date;

public class Deal {
	public Deal(String dealID, String itemName, String sellerEmail, String buyerEmail, double transactionPrice,
			Date closeDate) {
		this.dealID = dealID;
		this.itemName = itemName;
		this.sellerEmail = sellerEmail;
		this.buyerEmail = buyerEmail;
		this.transactionPrice = transactionPrice;
		this.closeDate = closeDate;
	}

	private String dealID;
	private String itemName;
	private String sellerEmail;
	private String buyerEmail;
	private double transactionPrice;
	private Date closeDate;

	public String getDealID() {
		return dealID;
	}

	public String getItemName() {
		return itemName;
	}

	public String getSellerEmail() {
		return sellerEmail;
	}

	public String getBuyerEmail() {
		return buyerEmail;
	}

	public double getTransactionPrice() {
		return transactionPrice;
	}

	public Date getCloseDate() {
		return closeDate;
	}
}
