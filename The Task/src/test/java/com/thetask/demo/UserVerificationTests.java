package com.thetask.demo;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

public class UserVerificationTests {

	@Test
	public void checkForUserTest() {
		User user = new User("person", "kod");
		ArrayList<User> users = new ArrayList<>();
		users.add(user);
		assertTrue(UserVerification.checkForUser("person", "kod", users));
		assertFalse(UserVerification.checkForUser("gg", "gg", users));
	}
}
