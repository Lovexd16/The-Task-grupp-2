package com.thetask.demo;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class TheTaskController {

    @GetMapping("/")
    String getStart () {
        return "homePage";
    }

    @GetMapping("/login")
    String getLogin() {
        return "loginPage";
    }

    @PostMapping("/home")
    String postNewUser(@RequestParam("username2") String username, @RequestParam("password2") String password, Model model) {
        for (User user : UserList.userList){
            if (user.getUsername().equals(username)) {
                model.addAttribute("errorMessage", "Finns redan sådan användare");
                System.out.println("Finns redan sån user");
                return "loginPage";
            }
        }

        UserList.userList.add(new User(username, password));

        for (User user : UserList.userList) {
            if (user.getUsername().equals(username) && user.getPassword().equals(password)) {
                model.addAttribute("listOfLists", user.getToDoLists());
                System.out.println("Lade till ny användare");
                return "homePage";
            }
        }
        return "homePage";
    }


    @PostMapping("/myToDos")
    String postLogin (@RequestParam("username1") String username, @RequestParam("password1") String password, Model model) {
        for (User user : UserList.userList) {
            if (user.getUsername().equals(username) && user.getPassword().equals(password)) {
                model.addAttribute("listOfLists", user.getToDoLists());
                System.out.println("loggar in");
                return "homePage";
            } 
        }
        System.out.println("hittar inte användare");
        model.addAttribute("errorMessage", "Fel användarnamn eller lösenord");
        return "loginPage";
    }
}


