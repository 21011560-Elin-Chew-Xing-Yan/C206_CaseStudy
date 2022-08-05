import static org.junit.Assert.*;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class C206_CaseStudyTest {

	private User u1;
	private User u2;

	private Category c1;
	private Category c2;

	private Item i1;
	private Item i2;

	private Bid b1;
	private Bid b2;

	private Deal d1;
	private Deal d2;

	private ArrayList<User> userList;
	private ArrayList<Category> categoryList;
	private ArrayList<Item> itemList;
	private ArrayList<Bid> bidList;
	private ArrayList<Deal> dealList;

	public C206_CaseStudyTest() {
		super();
	}

	@Before
	public void setUp() throws Exception {
		User u1 = new User("Sally", "Pass123", "Sally@gmail.com");
		User u2 = new User("Dally", "Pass132", "Dally@gmail.com");

		Category c1 = new Category("Electronic");
		Category c2 = new Category("Wellness");

		SimpleDateFormat DateFor = new SimpleDateFormat("dd/MM/yyyy");
		Date startAuc = DateFor.parse("08/08/2022");
		Date endAuc = DateFor.parse("18/08/2022");
		Item I1 = new Item("iPhone", "iphone 13 (Brand New)", 354.85, startAuc, endAuc, 55.5);
		Date startAuc2 = DateFor.parse("18/08/2022");
		Date endAuc2 = DateFor.parse("28/08/2022");
		Item I2 = new Item("XiaoMi", "XiaoMi 13 (Brand New)", 27.85, startAuc2, endAuc2, 5.5);

		Bid b1 = new Bid("ST657892F", "James", "James@gmail.com", "Sam@yahoo.com", 56.7);
		Bid b2 = new Bid("T0444444F", "Jamey", "Jamey@gmail.com", "Sammy@yahoo.com", 77.89);

		Date endDate = DateFor.parse("26/08/2022");
		Deal d1 = new Deal("D3456", "Iphone13", "James@gmail.com", "Sam@yahoo.com", 567.89, endDate);
		Date endDate2 = DateFor.parse("17/12/2022");
		Deal d2 = new Deal("D1111", "XiaoMi13", "Jameson@gmail.com", "Sammy@yahoo.com", 67.04, endDate2);
		
		userList = new ArrayList<User>();
		categoryList = new ArrayList<Category>();
		itemList = new ArrayList<Item>();
		bidList = new ArrayList<Bid>();
		dealList = new ArrayList<Deal>();
	}

	@Test
	public void testAddBid() {
		assertNotNull("Test if there is valid Bid arraylist to add to", bidList);

		// Given an empty list, after adding 1 item, the size of the list is 1
		C206_CaseStudy.addBid(bidList, b1);
		assertEquals("Test if that Bid arraylist size is 1?", 1, bidList.size());

		// The item just added is as same as the first item of the list
		assertSame("Test that Bid is added same as 1st item of the list?", b1, bidList.get(0));

		// Add another item. test The size of the list is 2?
		C206_CaseStudy.addBid(bidList, b2);
		assertEquals("Test that user arraylist size is 2?", 2, bidList.size());
		assertSame("Test that user is added same as 2nd item of the list?", b2, bidList.get(1));
	}

	@Test
	public void testViewBid() {
		// Test if Bid list is not null but empty, so that can add a new item
		assertNotNull("Test if there is valid Bid arraylist to add to", bidList);

		// test if the list of Bid retrieved from the CaseStudy is empty
		String allBid = C206_CaseStudy.retrieveAllBid(bidList);
		String testOutput = "";
		assertEquals("Check that View All Bid List", testOutput, allBid);

		// Given an empty list, after adding 2 items, test if the size of the list is 2
		C206_CaseStudy.addBid(bidList, b1);
		C206_CaseStudy.addBid(bidList, b2);
		assertEquals("Test if that Bid arraylist size is 2?", 2, bidList.size());
	}

	@Test
	// Donavan Incomplete Delete
	public void testDeleteBid() {
		// boundary
		assertNotNull("test if there is valid Bid arraylist to delete from", bidList);

		C206_CaseStudy.addBid(bidList, b1);

		// normal
//		Boolean ok = C206_CaseStudy.doDeleteBid(bidList, "ST657892F");
//		assertTrue("Test if an available item is okay to delete?", ok);
//		assertEquals(bidList.get(0).getName(), "ST657892F");

		// error condition
//		ok = C206_CaseStudy.doDeleteBid(bidList, "ST123456F");
//		assertFalse("Test if an same item is NOT okay to delete again?", ok);
	}
	@Test
	public void testAddUser() {
		assertNotNull("Test if there is valid User arraylist to add to", userList);

		// Given an empty list, after adding 1 item, the size of the list is 1
		C206_CaseStudy.addUser(userList, u1);
		assertEquals("Test if that User arraylist size is 1?", 1, userList.size());

		// The item just added is as same as the first item of the list
		assertSame("Test that User is added same as 1st item of the list?", u1, userList.get(0));

		// Add another item. test The size of the list is 2?
		C206_CaseStudy.addUser(userList, u2);
		assertEquals("Test that User arraylist size is 2?", 2, userList.size());
		assertSame("Test that User is added same as 2nd item of the list?", u2, userList.get(1));
	}
	
	@Test
	public void testViewUser() {
		assertNotNull("Test if there is valid user arraylist to add to", userList);
		
		//test if the list of user retrieved from the SourceCentre is empty
		String allUsers= C206_CaseStudy.retrieveAllUsers(userList);
		String testOutput = "";
		assertEquals("Check that ViewAlluserList", testOutput, allUsers);
						
		//Given an empty list, after adding 2 items, test if the size of the list is 2
		C206_CaseStudy.addUser(userList, u1);
		C206_CaseStudy.addUser(userList, u2);
		assertEquals("Test if that User arraylist size is 2?", 2, userList.size());
				
		//test if the expected output string same as the list of users retrieved from the C206_CaseStudy
		 for (int i = 0; i < userList.size(); i++) {
			 allUsers += String.format("%-20s %-20s %-20s\n", userList.get(i).getUsername(), userList.get(i).getPassword(), userList.get(i).getEmail());
		 }
		

		testOutput = String.format("%-20s %-20s %-20s\n", "Sally" , "Pass123", "Sally@gmail.com");
		testOutput += String.format("%-20s %-20s %-20s\n","Dally" , "Pass132", "Dally@gmail.com");
			
		assertEquals("Check that ViewAllUserList", testOutput, allUsers);
	}
	
	@Test
	public void testDeleteUser() {
		C206_CaseStudy.addUser(userList, u1);
		C206_CaseStudy.addUser(userList, u2);
		assertEquals("Test that item arrayList is 1?", 2, userList.size());
		
		assertSame("Test that item is added same as 1st Category of the list?", u1, userList.get(0));
		
		assertNotNull("Test if there is valid user arrayList to delete from", userList);
		
		C206_CaseStudy.deleteUser(userList);
		assertEquals("Test that user arrayList size is 1? ", 1, userList.size());
		assertSame("Test that 2nd user added is the first user of the list", u2, userList.get(0));
	}

	@After
	public void tearDown() throws Exception {
		u1 = null;
		u2 = null;
		c1 = null;
		c2 = null;
		i1 = null;
		i2 = null;
		b1 = null;
		b2 = null;
		d1 = null;
		d2 = null;
		userList = null;
		categoryList = null;
		itemList = null;
		bidList = null;
		dealList = null;
	}

}
