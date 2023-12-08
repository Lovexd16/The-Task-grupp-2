package com.thetask.demo;

// import static org.junit.jupiter.api.Assertions.assertFalse;
// import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;

public class UserTests {

    @Test
    public void checkForExistingUserTest() {

        List<String> currentUsers = Arrays.asList("Love", "Bajram", "Viktor"); // Hårdkodade användate som finns i
                                                                               // listan

        // Två Constructors med namnet User() i User

        // User user = new User(currentUsers);

        // Testar namnen som finns i listan, som ska bli true
        // assertTrue(user.usernameInUse("Love"));
        // assertTrue(user.usernameInUse("Bajram"));
        // assertTrue(user.usernameInUse("Viktor"));

        // // Testar namn som inte finns i listan, som ska bli false
        // assertFalse(user.usernameInUse("Jacob"));
        // assertFalse(user.usernameInUse("Christopher"));

    }
}