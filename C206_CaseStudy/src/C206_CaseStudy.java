import java.util.ArrayList;

public class C206_CaseStudy {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<User> userList = new ArrayList<User>();
		ArrayList<Category> categoryList = new ArrayList<Category>();
		ArrayList<Item> itemList = new ArrayList<Item>();
		ArrayList<Bid> bidList = new ArrayList<Bid>();
		ArrayList<Deal> dealList = new ArrayList<Deal>();

		int option = 0;

		while (option != 5) {
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
//				C206_CaseStudy.viewAllUser(); Jing En
					
				}else if (viewOption == 2) {
				C206_CaseStudy.displayAllCategory(categoryList);
				
				}else if (viewOption == 3) {
//				C206_CaseStudy.viewAllItem(); Shaun
					
				}else if (viewOption == 4) {
				C206_CaseStudy.viewAllBid(bidList);
				
				}else if (viewOption == 5) {
//				C206_CaseStudy.viewAllDeal(); Imran
				}
			}
			else if (option == 2) {
				C206_CaseStudy.setHeader("ADD");			
				C206_CaseStudy.setHeader("SELECT ADD");
				System.out.println("1. Add User");
				System.out.println("2. Add Category");
				System.out.println("3. Add Item");
				System.out.println("4. Add Bid");
				System.out.println("5. Add Deal");
				
				
				int addOption = Helper.readInt("Enter option to select item type > ");
				
				if (addOption == 1) {
				// Add User (Jing En)
					
				}
				else if (addOption == 2) {
				// Add Category (Elin)
			    Category c = inputCategory();
			    C206_CaseStudy.addCategory(categoryList, c);
			    System.out.println("Category added");	
				}
				else if (addOption == 3) {
				// Add Item (Shaun)
					
				}
				else if (addOption == 4) {
				// Add Bid ()
					Bid bid  = inputBid();
					C206_CaseStudy.addBid(bidList, bid);
					System.out.println("Bid added!");
				}
				else if (addOption == 5) {
				// Add Deal (Imran)
					
				}
				else {
					System.out.println("Invalid option...");
				}
			}
			else if (option == 3) {
				C206_CaseStudy.setHeader("DELETE");			
				C206_CaseStudy.setHeader("DELETE ITEM");
				System.out.println("1. Delete User");
				System.out.println("2. Delete Category");
				System.out.println("3. Delete Item");
				System.out.println("4. Delete Bid");
				System.out.println("5. Delete Deal");
				
				int deleteOption = Helper.readInt("Enter option to delete item > ");
				if (deleteOption == 1) {
				// Delete User (Jing En)
					
				}
				else if (deleteOption == 2) {
				// Delete Category (Elin)
				C206_CaseStudy.deleteCategory(categoryList);
					
				}
				else if (deleteOption == 3) {
				// Delete Item (Shaun)
					
				}
				else if (deleteOption == 4) {
				// Delete Bid ()
				C206_CaseStudy.deleteBid(bidList);
				}
				else if (deleteOption == 5) {
				// Delete Deal (Imran)
					
				}
				else {
					System.out.println("Invalid option...");
				}
			}
		}
	}
	
	
	//================================= Add Category =================================
	public static Category inputCategory() {
		String category = Helper.readString("Enter Category Name > ");

		Category c= new Category(category);
		return c;
		
	}
	public static void addCategory(ArrayList<Category> categoryList, Category c) {
		
		categoryList.add(c);
		
	}
	
	//================================= Display All Category =================================
	public static String retrieveAllCategory(ArrayList<Category> categoryList) {
		String output = "";

		for (int i = 0; i < categoryList.size(); i++) {

			output += String.format("%s \n", categoryList.get(i).getName());
		}
		return output;
	}
	public static void displayAllCategory(ArrayList<Category> categoryList) {
		C206_CaseStudy.setHeader("CATEGORY LIST");
		String output = String.format("%-10s \n", "CATEGORY NAME");
		 output += retrieveAllCategory(categoryList);	
		System.out.println(output);
	}

	//================================= Delete Category Based On Name =================================
	public static void deleteCategory(ArrayList<Category> categoryList) {
		String category = Helper.readString("Enter Category Name to delete > ");
		
		for (int i = 0; i < categoryList.size(); i++) {
			
			if (categoryList.get(i).getName().equals(category)){
				categoryList.remove(i);
				
				
			} else {
				System.out.println("Category does not exist");
				break;
			}
		}	
	}
	
	
	// ===================================== Delete Bid =====================================
	private static void deleteBid(ArrayList<Bid> bidList) {
		// TODO Auto-generated method stub
		C206_CaseStudy.viewAllBid(bidList);
		String id = Helper.readString("Enter item ID > ");

		Boolean delete =doDeleteBid(bidList, id);
		if (delete == false) {
			System.out.println("Invalid ID!");
		} else {
			System.out.println("Item " + id + " successfully deleted!");
		}
	}

	private static Boolean doDeleteBid(ArrayList<Bid> bidList, String id) {
		// TODO Auto-generated method stub	
		boolean isDeleted = false;

		for (int i = 0; i < bidList.size(); i++) {
			if (id.equalsIgnoreCase(bidList.get(i).getID())) {
				bidList.get(i).setPrice(0);;
				
				isDeleted = true;
				
			}
		}
		return isDeleted;
	}
	// =========================================== View Bid ===========================================
	private static void viewAllBid(ArrayList<Bid> bidList) {
		// TODO Auto-generated method stub
		C206_CaseStudy.setHeader("View All Bid List");
		String output = String.format("%-10s %-30s %-10s %-30s %-30s\n", "Item ID", "Item Name", "Bid Price", "Buyer Email", "Seller Email");
		output += retrieveAllBid(bidList);
		System.out.println(output);
	}

	private static String retrieveAllBid(ArrayList<Bid> bidList) {
		// TODO Auto-generated method stub
		String output = "";

		for (int i = 0; i < bidList.size(); i++) {

			output += String.format("%-10s %-30s %-10s %-30s %-30s\n", bidList.get(i).getID(), bidList.get(i).getName(),
					bidList.get(i).getPrice(), bidList.get(i).getBuyerEmail(), bidList.get(i).getSellerEmail());
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

	// =========================================== Add Bid ===========================================
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
}
