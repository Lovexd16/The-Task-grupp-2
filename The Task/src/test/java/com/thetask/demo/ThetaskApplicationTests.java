package com.thetask.demo;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ThetaskApplicationTests {

	@Test
	void contextLoads() {
	}

	@Test
	public void checkForUserTest () {
		ThetaskApplication thetaskApplication = new ThetaskApplication();
		User user = new User("person", "kod");
		ArrayList<User>users = new ArrayList<>();
		users.add(user);
		assertTrue(thetaskApplication.checkForUser("person", "kod", users));
		assertFalse(thetaskApplication.checkForUser("gg", "gg", users));
	}
}
