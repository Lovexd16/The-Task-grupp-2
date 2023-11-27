package com.thetask.demo;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ThetaskApplicationTests {

	@Test
	public void test8() {
		List<String> itemList = new ArrayList<>();

		String testItem = "TestItem";
		itemList.add(testItem);

		assertTrue(itemList.contains(testItem));
	}

	@Test
	public void testAddItem() {

		ItemListTest itemListTest = new ItemListTest();

		itemListTest.addItem("TestItem");

		List<String> itemList = itemListTest.getItemList();
		assertTrue(itemList.contains("TestItem"));
	}

	@Test
	void testIfToDoIsLate() {
		long testTime = 1601097035961L;
		long testTime2 = 1801097035961L;
		assertTrue(testTime < ThetaskApplication.getCurrentTime());
		assertFalse(testTime2 < ThetaskApplication.getCurrentTime());
	}

	@Test
	public void checkForUserTest() {
		ThetaskApplication thetaskApplication = new ThetaskApplication();
		User user = new User("person", "kod");
		ArrayList<User> users = new ArrayList<>();
		users.add(user);
		assertTrue(thetaskApplication.checkForUser("person", "kod", users));
		assertFalse(thetaskApplication.checkForUser("gg", "gg", users));
	}

}
