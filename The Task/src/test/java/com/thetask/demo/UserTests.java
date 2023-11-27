package com.thetask.demo;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

public class UserTests {
    
    @Test
	public void checkForExistingUserTest() {
		
        assertTrue(User.checkIfUserExists("notExistingUser")); //assertTrue på den som ska bli true (när namnen inte matchar)

        assertFalse(User.checkIfUserExists("existingUser")); //assertFalse på den som ska bli false (när namnen matchar)
	}
}
