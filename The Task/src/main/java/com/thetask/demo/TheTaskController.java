package com.thetask.demo;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class TheTaskController {

    @GetMapping("/")
    String getStart() {
        return "loginPage";
    }

    @GetMapping("/home")
    String getLogin() {
        return "homePage";
    }

    @PostMapping("/newUser")
    String postNewUser(@RequestParam("username2") String username, @RequestParam("password2") String password,
            Model model) {
        for (User user : ThetaskApplication.userlist.getUserList() ) {
            if (user.getUsername().equals(username)) {
                model.addAttribute("errorMessage", "Finns redan sådan användare");
                System.out.println("Finns redan sån user");
                return "redirect:/";
            }
        }

        ThetaskApplication.userlist.getUserList().add(new User(username, password));

        for (User user : ThetaskApplication.userlist.getUserList()) {
            if (user.getUsername().equals(username) && user.getPassword().equals(password)) {
                model.addAttribute("listOfLists", user.getToDoLists());
                System.out.println("Lade till ny användare");
                return "redirect:/home";
            }
        }
        return "homePage";
    }

    @PostMapping("/loginUser")
    String postLogin(@RequestParam("username1") String username, @RequestParam("password1") String password,
            Model model) {
        for (User user : ThetaskApplication.userlist.getUserList()) {
            if (user.getUsername().equals(username) && user.getPassword().equals(password)) {
                model.addAttribute("listOfLists", user.getToDoLists());
                System.out.println("loggar in");
                return "redirect:/home";
            }
        }
        System.out.println("hittar inte användare");
        model.addAttribute("errorMessage", "Fel användarnamn eller lösenord");
        return "redirect:/";
    }

    // @PostMapping("/addNewList")
    // String postAddNewList (@RequestParam("username") String username, @RequestParam("newListName") String newListName) {
        
    // }
}
