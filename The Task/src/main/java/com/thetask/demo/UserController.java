package com.thetask.demo;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.ArrayList;
import java.util.List;

@Controller
public class UserController {
    private final List<User> users = new ArrayList<>();
    private User loggedInUser;

    @GetMapping("/")
    public String getUsers(Model model) {
        model.addAttribute("users", users);
        return "loginPage";
    }

    @PostMapping("/users")
    public String addUser(@RequestParam String username, @RequestParam String password,
            Model model) {
        if (isUsernameTaken(username)) {
            // Användarnamnet är redan taget
            return "usernameTaken";
        }

        User user = new User(username, password);
        users.add(user);
        model.addAttribute("users", users);
        return "loginPage";
    }

    @PostMapping("/users/login")
    public String login(@RequestParam String username, @RequestParam String password, Model model,
            RedirectAttributes redirectAttributes) {
        User user = findUserByUsername(username);

        if (user != null && user.getPassword().equals(password)) {
            // Inloggning lyckades
            model.addAttribute("user", user);
            redirectAttributes.addFlashAttribute("loggedInUser", user);
            loggedInUser = user;
            System.out.println("Inloggad som: " + user.getUsername());
            return "redirect:/home";
        }

        return "homePage";
    }

    private boolean isUsernameTaken(String username) {
        for (User existingUser : users) {
            if (existingUser.getUsername().equals(username)) {
                return true;
            }
        }
        return false;
    }

    private User findUserByUsername(String username) {
        for (User user : users) {
            if (user.getUsername().equals(username)) {
                return user;
            }
        }
        return null;
    }

    public User getLoggedInUser() {
        return loggedInUser;
    }
}