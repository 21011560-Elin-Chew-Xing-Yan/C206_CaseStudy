import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class C206_CaseStudy {

	public static void main(String[] args) throws ParseException {
		// TODO Auto-generated method stub
		ArrayList<User> userList = new ArrayList<User>();
		userList.add(new User("Sally", "Pass123", "Sally@gmail.com"));

		ArrayList<Category> categoryList = new ArrayList<Category>();
		categoryList.add(new Category("Electronic"));

		ArrayList<Item> itemList = new ArrayList<Item>();

		SimpleDateFormat DateFor = new SimpleDateFormat("dd/MM/yyyy");
		Date startAuc = DateFor.parse("08/08/2022");
		Date endAuc = DateFor.parse("18/08/2022");
		itemList.add(new Item("iPhone", "iphone 13 (Brand New)", 354.85, startAuc, endAuc, 55.5));

		ArrayList<Bid> bidList = new ArrayList<Bid>();
		bidList.add(new Bid("ST657892F", "James", "James@gmail.com", "Sam@yahoo.com", 56.7));

		ArrayList<Deal> dealList = new ArrayList<Deal>();
		Date endDate = DateFor.parse("26/08/2022");
		dealList.add(new Deal("D3456", "Iphone13", "James@gmail.com", "Sam@yahoo.com", 567.89, endDate));

		int option = 0;

		while (option != 4) {
			C206_CaseStudy.menu();
			option = Helper.readInt("Enter an option > ");

			if (option == 1) {
				C206_CaseStudy.setHeader("VIEW");
				C206_CaseStudy.setHeader("VIEW ITEM");
				System.out.println("1. View User");
				System.out.println("2. View Category");
				System.out.println("3. View Item");
				System.out.println("4. View Bid");
				System.out.println("5. View Deal");

				int viewOption = Helper.readInt("Enter option to view item type > ");

				if (viewOption == 1) {
					C206_CaseStudy.viewAllUser(userList);

				} else if (viewOption == 2) {
					C206_CaseStudy.viewAllCategory(categoryList);

				} else if (viewOption == 3) {
					C206_CaseStudy.viewAllItem(itemList);

				} else if (viewOption == 4) {
					C206_CaseStudy.viewAllBid(bidList);

				} else if (viewOption == 5) {
					C206_CaseStudy.viewAllDeal(dealList);
				}
			} else if (option == 2) {
				C206_CaseStudy.setHeader("ADD");
				C206_CaseStudy.setHeader("SELECT ADD");
				System.out.println("1. Add User");
				System.out.println("2. Add Category");
				System.out.println("3. Add Item");
				System.out.println("4. Add Bid");
				System.out.println("5. Add Deal");

				int addOption = Helper.readInt("Enter option to select item type > ");

				if (addOption == 1) {
					User usr = inputUser();
					C206_CaseStudy.addUser(userList, usr);
					System.out.println("User Added!");
				} else if (addOption == 2) {
					Category c = inputCategory();
					C206_CaseStudy.addCategory(categoryList, c);
					System.out.println("Category added");
				} else if (addOption == 3) {
					Item i = inputItem();
					C206_CaseStudy.addItem(itemList, i);
					System.out.println("Item added!");

				} else if (addOption == 4) {
					Bid bid = inputBid();
					C206_CaseStudy.addBid(bidList, bid);
					System.out.println("Bid added!");

				}
				else if (addOption == 5) {
				// Add Deal (Imran)
					Deal deal  = inputDeal();
					C206_CaseStudy.addDeal(dealList,deal);

				} else if (addOption == 5) {
					Deal deal = inputDeal();
					C206_CaseStudy.addDeal(dealList, deal);

					System.out.println("");

				} else {
					System.out.println("Invalid option...");
				}
			} else if (option == 3) {
				C206_CaseStudy.setHeader("DELETE");
				C206_CaseStudy.setHeader("DELETE ITEM");
				System.out.println("1. Delete User");
				System.out.println("2. Delete Category");
				System.out.println("3. Delete Item");
				System.out.println("4. Delete Bid");
				System.out.println("5. Delete Deal");

				int deleteOption = Helper.readInt("Enter option to delete item > ");
				if (deleteOption == 1) {
					C206_CaseStudy.deleteUser(userList);
				} else if (deleteOption == 2) {
					C206_CaseStudy.deleteCategory(categoryList);

				} else if (deleteOption == 3) {
//					String delItem = Helper.readString("Enter the name of the item to delete > ");
					C206_CaseStudy.doDeleteItem(itemList);

				} else if (deleteOption == 4) {
					C206_CaseStudy.doDeleteBid(bidList);
				} else if (deleteOption == 5) {
					C206_CaseStudy.doDeleteDeal(dealList);

				} else {
					System.out.println("Invalid option...");
				}
			} else if (option == 4) {
				System.out.println("Thank you for using Campus Online Auction Shop (COAS)");
			} else {
				System.out.println("Invalid option...");
			}
		}
	}

		
	


	// ================================= Add User =================================
	public static User inputUser() {
		String user = Helper.readString("Enter user Name > ");
		String password = Helper.readString("Enter user password > ");
		String email = Helper.readString("Enter User Email > ");

		User usr = new User(user, password, email);
		return usr;

	}


	public static void addUser(ArrayList<User> userList, User usr) {
		userList.add(usr);
	}

	// ================================= Display All User
	// =================================
	public static String retrieveAllUsers(ArrayList<User> userList) {
		String output = "";

		for (int i = 0; i < userList.size(); i++) {

			output += String.format("%-20s %-20s %-20s\n", userList.get(i).getUsername(), userList.get(i).getPassword(),
					userList.get(i).getEmail());
		}
		return output;
	}

	public static void viewAllUser(ArrayList<User> userList) {
		C206_CaseStudy.setHeader("USER LIST");
		String output = String.format("%-20s %-20s %-20s\n", "USER NAME", "USER PASSWORD", "USER EMAIL");
		output += retrieveAllUsers(userList);
		System.out.println(output);
	}

	// ================================= Delete User Based On Email
	// =================================
	public static boolean doDeleteUser (ArrayList<User> userList, String email) {
		boolean isDeleted = false;
		
		for(int i = 0; i < userList.size();i++) {
			if(email.equals(userList.get(i).getEmail())) {
				
				userList.remove(i);
				isDeleted = true;
			}
		}
		return isDeleted;	
		
	}
	
	public static void deleteUser(ArrayList<User> userList) {
		String user_del = Helper.readString("Enter user to delete (Email) > ");
		int check = 0;
		for (int x = 0; x < userList.size(); x++) {
			if ((userList.get(x).getEmail()).equalsIgnoreCase(user_del)) {
				userList.remove(x);
				System.out.println("User Successfully Deleted!");
				check = check + 1;
				break;
			}
		}

		if (check < 1) {
			System.out.println("User Does not Exist!");
		}
	}

	// ================================= Add Category
	// =================================
	public static Category inputCategory() {
		String category = Helper.readString("Enter Category Name > ");

		Category c = new Category(category);
		return c;

	}

	public static void addCategory(ArrayList<Category> categoryList, Category c) {

		categoryList.add(c);

	}

	// ================================= Display All Category
	// =================================
	public static String retrieveAllCategory(ArrayList<Category> categoryList) {
		String output = "";

		for (int i = 0; i < categoryList.size(); i++) {

			output += String.format("%s \n", categoryList.get(i).getName());
		}
		return output;
	}

	public static void viewAllCategory(ArrayList<Category> categoryList) {
		C206_CaseStudy.setHeader("CATEGORY LIST");
		String output = String.format("%-10s \n", "CATEGORY NAME");
		output += retrieveAllCategory(categoryList);
		System.out.println(output);
	}

	// ================================= Delete Category Based On Name
	// =================================
	
	public static boolean doDeleteCategory (ArrayList<Category> categoryList, String name) {
		boolean isDeleted = false;
		
		for(int i = 0; i < categoryList.size();i++) {
			if(name.equals(categoryList.get(i).getName())) {
				
				categoryList.remove(i);
				isDeleted = true;
			}
		}
		return isDeleted;	
	}
	
	public static void deleteCategory(ArrayList<Category> categoryList) {
		retrieveAllCategory(categoryList);
		String name = Helper.readString("Enter category to delete (Category) > ");
		Boolean isDeleted = doDeleteCategory(categoryList, name);
		
		
		if (isDeleted == false) {
			System.out.println("Delete Failed! Category does not exist");
		}else {
			System.out.println("Category Successfully Deleted!");
		}
	}

	// ===================================== View Item
	// =====================================
	
	//Code #1
//	private static void viewAllItem(ArrayList<Item> itemList) {
//		C206_CaseStudy.setHeader("View All Item List");
//		String output = String.format("%-10s %-30s %-30s %-30s %-30s %-30s\n", "Name", "Description",
//				"Minimum Bid Price", "Auction Start Date", "Auction End Date", "Bid Increment");
//		output += retrieveAllItem(itemList);
//		System.out.println(output);
//	}
//
//	private static String retrieveAllItem(ArrayList<Item> itemList) {
//		// TODO Auto-generated method stub
//		String output = "";
//
//		for (int i = 0; i < itemList.size(); i++) {
//
//			output += String.format("%-10s %-30s %-30s %-30s %-30s %-30s\n", itemList.get(i).getName(),
//					itemList.get(i).getDescription(), itemList.get(i).getMinbidprice(),
//					itemList.get(i).getAuctionstartDate(), itemList.get(i).getAuctionEndDate(),
//					itemList.get(i).getBidIncrement());
//		}
//		return output;
//	}

	
	//Code #2
//	public static String retrieveAllItem(ArrayList<Item> itemList) {
//		String output = "";
//
//		for (int i = 0; i < itemList.size(); i++) {
//
//			output += String.format("%-10s %-30s %-30s %-30s %-30s %-30s\n", itemList.get(i).getName(),
//					itemList.get(i).getDescription(), itemList.get(i).getMinbidprice(),
//					itemList.get(i).getAuctionstartDate(), itemList.get(i).getAuctionEndDate(),
//					itemList.get(i).getBidIncrement());
//		}
//		return output;
//
//	}
//
//	public static void viewAllItem(ArrayList<Item> itemList) {
//
//		String output = retrieveAllItem(itemList);
//		System.out.println(output);
//	}
	
	//Code #3 (OFFICIAL)
	private static void viewAllItem(ArrayList<Item> itemList) {
		// TODO Auto-generated method stub
		C206_CaseStudy.setHeader("View All Item List");
		String output = String.format("%-10s %-30s %-30s %-30s %-30s %-30s\n", "Name", "Description",
				"Minimum Bid Price", "Auction Start Date", "Auction End Date", "Bid Increment");
		output += retrieveAllItem(itemList);
		System.out.println(output);
	}

	public static String retrieveAllItem(ArrayList<Item> itemList) {
		// TODO Auto-generated method stub
		String output = "";

		for (int i = 0; i < itemList.size(); i++) {

			output += String.format("%-10s %-30s %-30s %-30s %-30s %-30s\n", itemList.get(i).getName(),
					itemList.get(i).getDescription(), itemList.get(i).getMinbidprice(),
					itemList.get(i).getAuctionstartDate(), itemList.get(i).getAuctionEndDate(),
					itemList.get(i).getBidIncrement());
		}
		return output;
	}

//=========================================== Add Item ===========================================
	public static Item inputItem() {
		String name = Helper.readString("Enter Item Name > ");
		String description = Helper.readString("Enter Description > ");
		double minBidPrice = Helper.readDouble("Enter Minimum Bid Price > ");
		Date aucSD = Helper.readDate("Enter Auction Start Date > ");
		Date aucED = Helper.readDate("Enter Auction End Date > ");
		double bidIncr = Helper.readDouble("Enter bid increment > $");

		Item item = new Item(name, description, minBidPrice, aucSD, aucED, bidIncr);
		return item;

	}

	public static void addItem(ArrayList<Item> itemList, Item item) {

		itemList.add(item);

	}

	// ================================= Delete Item Based On Name
	// =================================
	
	//Code #3 (OFFICIAL)
	public static void deleteItem(ArrayList<Item> itemList, Item id) {
		// TODO Auto-generated method stub
		C206_CaseStudy.viewAllItem(itemList);
		itemList.remove(id);

	}

	public static Boolean doDeleteItem(ArrayList<Item> itemList) {
		// TODO Auto-generated method stub
		boolean isDeleted = false;
		String id = Helper.readString("Enter name ID > ");
		for (int i = 0; i < itemList.size(); i++) {
			if (itemList.get(i).getName().contains(id)) {
				itemList.remove(i);

				isDeleted = true;
				System.out.println("Deleted Successfully!");

			} else {
				System.out.println("Incorrect Name ID!");
			}
		}
		return isDeleted;
	}

	// ===================================== Delete Bid
	// =====================================

	public static void deleteBid(ArrayList<Bid> bidList, Bid id) {
		// TODO Auto-generated method stub
		C206_CaseStudy.viewAllBid(bidList);
		bidList.remove(id);

	}

	public static Boolean doDeleteBid(ArrayList<Bid> bidList) {
		// TODO Auto-generated method stub
		boolean isDeleted = false;
		String id = Helper.readString("Enter item ID > ");
		for (int i = 0; i < bidList.size(); i++) {
			if (bidList.get(i).getID().contains(id)) {
				bidList.remove(i);

				isDeleted = true;

			}
		}
		return isDeleted;
	}

	// =========================================== View Bid
	// ===========================================
	private static void viewAllBid(ArrayList<Bid> bidList) {
		// TODO Auto-generated method stub
		C206_CaseStudy.setHeader("View All Bid List");
		String output = String.format("%-10s %-30s %-30s %-30s %-10s\n", "Bid ID", "Item Name", "Buyer Email",
				"Seller Email", "Bid Price");
		output += retrieveAllBid(bidList);
		System.out.println(output);
	}

	public static String retrieveAllBid(ArrayList<Bid> bidList) {
		// TODO Auto-generated method stub
		String output = "";

		for (int i = 0; i < bidList.size(); i++) {

			output += String.format("%-10s %-30s %-30s %-30s %-10.2f\n", bidList.get(i).getID(),
					bidList.get(i).getName(), bidList.get(i).getBuyerEmail(), bidList.get(i).getSellerEmail(),
					bidList.get(i).getPrice());
		}
		return output;
	}

	public static void menu() {
		C206_CaseStudy.setHeader("Campus Online Auction Shop (COAS)");
		System.out.println("1. VIEW");
		System.out.println("2. ADD");
		System.out.println("3. DELETE");
		System.out.println("4. Quit");
		Helper.line(80, "-");

	}

	// =========================================== Add Bid
	// ===========================================
	public static Bid inputBid() {
		String name = Helper.readString("Enter Item Name > ");
		String id = Helper.readString("Enter Bid ID > ");
		String sellerEmail = Helper.readString("Enter Seller Email > ");
		String buyerEmail = Helper.readString("Enter Buyer Email > ");
		double bidPrice = Helper.readDouble("Enter bid price > $");

		Bid bid = new Bid(id, name, sellerEmail, buyerEmail, bidPrice);
		return bid;

	}

	public static void addBid(ArrayList<Bid> bidList, Bid bid) {

		bidList.add(bid);

	}

	public static void setHeader(String header) {
		Helper.line(80, "-");
		System.out.println(header);
		Helper.line(80, "-");
	}




// =========================================== View deal ===========================================
	private static void viewAllDeal(ArrayList<Deal> dealList) {
		// TODO Auto-generated method stub
		C206_CaseStudy.setHeader("View All deal List");
		String output = String.format("%-10s %-30s %-10s %-30s %-30s %-30s\n", "Deal ID", "Item Name", "Deal Price",
				"Buyer Email", "Seller Email", "close date");
		output += retrieveAlldeal(dealList);
		System.out.println(output);
	}

	public static String retrieveAlldeal(ArrayList<Deal> DealList) {
		// TODO Auto-generated method stub
		String output = "";

		for (int i = 0; i < DealList.size(); i++) {

			output += String.format("%-10s %-30s %-10s %-30s %-30s %-30s\n", DealList.get(i).getDealID(),
					DealList.get(i).getItemName(), DealList.get(i).getTransactionPrice(),
					DealList.get(i).getBuyerEmail(), DealList.get(i).getSellerEmail(),DealList.get(i).getCloseDate());
		}
		return output;
	}

// =========================================== Add deal ===========================================
	public static Deal inputDeal() {
		String name = Helper.readString("Enter Item Name > ");
		String id = Helper.readString("Enter Deal ID > ");
		String sellerEmail = Helper.readString("Enter Seller Email > ");
		String buyerEmail = Helper.readString("Enter Buyer Email > ");
		double transactionPrice = Helper.readDouble("Enter transaction Price> ");
		Date closeDate = Helper.readDate("Enter Close Date> ");

		Deal deal = new Deal(name, id, sellerEmail, buyerEmail, transactionPrice, closeDate);
		return deal;

	}

	public static void addDeal(ArrayList<Deal> dealList, Deal deal) {

		dealList.add(deal);

	}

// ===================================== Delete Deal =====================================
	public static void deleteDeal(ArrayList<Deal> dealList, Deal id ) {
		// TODO Auto-generated method stub
		C206_CaseStudy.viewAllDeal(dealList);
		dealList.remove(id);
	}

	

	public static Boolean doDeleteDeal(ArrayList<Deal> dealList) {
		// TODO Auto-generated method stub
		boolean isDeleted = false;

		String id = Helper.readString("Enter item ID > ");
		for (int i = 0; i<dealList.size(); i ++) {
			if(dealList.get(i).getDealID().contains(id)) {
				dealList.remove(i);

				isDeleted = true;

			}
		}
		return isDeleted;
	}

	


}
