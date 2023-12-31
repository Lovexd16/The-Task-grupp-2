package com.thetask.demo;

import java.util.ArrayList;
import java.util.List;

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

}
