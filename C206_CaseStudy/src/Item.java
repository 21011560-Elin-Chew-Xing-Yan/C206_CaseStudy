import java.util.Date;

public class Item {
	public Item(String name, String description, double minbidprice, Date auctionstartDate, Date auctionEndDate,
			double bidIncrement) {
		this.name = name;
		this.description = description;
		this.minbidprice = minbidprice;
		this.auctionstartDate = auctionstartDate;
		this.auctionEndDate = auctionEndDate;
		this.bidIncrement = bidIncrement;
	}

	private String name;
	private String description;
	private double minbidprice;
	private Date auctionstartDate;
	private Date auctionEndDate;
	private double bidIncrement;

	public String getName() {
		return name;
	}

	public String getDescription() {
		return description;
	}

	public double getMinbidprice() {
		return minbidprice;
	}

	public Date getAuctionstartDate() {
		return auctionstartDate;
	}

	public Date getAuctionEndDate() {
		return auctionEndDate;
	}

	public double getBidIncrement() {
		return bidIncrement;
	}
}
