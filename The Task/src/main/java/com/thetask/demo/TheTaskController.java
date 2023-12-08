package com.thetask.demo;

import java.time.LocalDate;
import java.time.LocalTime;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class TheTaskController {

    User loggedInUser;
    
    ListOfToDos currentList;

    @GetMapping("/")
    String getStart(Model model) {
        return "loginPage";
    }

    @GetMapping("/home")
    String getLogin(Model model) {
        model.addAttribute("listOfLists", loggedInUser.getToDoLists());
        model.addAttribute("user", loggedInUser);
        return "homePage";
    }

     @PostMapping("/loginUser")
    String postLogin(@RequestParam("username1") String username, @RequestParam("password1") String password,
            Model model, RedirectAttributes ra) {
        for (User user : UserList.getUserList()) {
            if (user.getUsername().equals(username) && user.getPassword().equals(password)) {
                loggedInUser = findUserByUsername(username);
                return "redirect:/home";
            }
        }
        ra.addFlashAttribute("errorMessageForLogin", "Fel användarnamn eller lösenord");
        return "redirect:/";
    }
    

    @PostMapping("/newUser")
    String postNewUser(@RequestParam("username2") String username, @RequestParam("password2") String password, RedirectAttributes ra) {
        for (User user : UserList.getUserList()) {
            if (user.getUsername().equals(username)) {
                ra.addFlashAttribute("errorMessageForCreatingUser", "Användarnamn upptaget");
                return "redirect:/";
            }
        }

        UserList.getUserList().add(new User(username, password));


        for (User user : UserList.getUserList()) {
            if (user.getUsername().equals(username) && user.getPassword().equals(password)) {
                ra.addFlashAttribute("successMessage", "Användare skapad!");
                return "redirect:/";
            }
        }
        return "homePage";
    }
    
    @PostMapping("/addToDoList")
    String newUserList(@RequestParam("nameOfList") String nameOfList) {
        loggedInUser.getToDoLists().add(new ListOfToDos(null, nameOfList));
        return "redirect:/home";
    }

    @GetMapping ("/list/delete/{nameOfList}")
    String getDelete (@PathVariable String nameOfList) {
        System.out.println("tog bort");
        for (ListOfToDos list : loggedInUser.getToDoLists()) {
            if (list.getNameOfList().equals(nameOfList)) {
                System.out.println(nameOfList);
                loggedInUser.getToDoLists().remove(list);
                return "redirect:/home";
            }
        }
        return "redirect:/home";
    }

    @GetMapping("/list") 
    String getListPage (Model model) {
        model.addAttribute("theNameOfList", currentList.getNameOfList());
        model.addAttribute("listOfToDos", currentList.getListOfToDo());
        return "list";
    }

    @GetMapping ("/list/{nameOfList}")
    String getList (@PathVariable String nameOfList, Model model) {

        for (ListOfToDos list : loggedInUser.getToDoLists()) {
            if (list.getNameOfList().equals(nameOfList)) {
                currentList = list;
                return "redirect:/list";
            }
        }
        return "list";
    }


    @PostMapping ("/addtodo")
    String addToDo (@RequestParam String listName, @RequestParam LocalDate date, @RequestParam LocalTime time, @RequestParam String name, Model model) {
        for (ListOfToDos list : loggedInUser.getToDoLists()) {
            if (list.getNameOfList().equals(listName)) {
                System.out.println(name + date + time + listName);
                list.getListOfToDo().add(new ToDo(name, date, time, false));
                return "redirect:/list";
            }
        }
        return "homePage";
    }

    
    public static User findUserByUsername (String username) {
        for (User user : UserList.getUserList()) {
            if (user.getUsername().equals(username)) {
                return user;
            }
        }
        return null;
    }

    public static User findUserByUsernameToCreateUser (String username, String password) {
         UserList.getUserList().add(new User(username, password));


        for (User user : UserList.getUserList()) {
            if (user.getUsername().equals(username) && user.getPassword().equals(password)) {
                return user;
            }
        }
        return null;
    }
    
}