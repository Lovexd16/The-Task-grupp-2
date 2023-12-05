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
        for (User user : ThetaskApplication.userlist.getUserList()) {
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


    @PostMapping("/addNewList")
    String postAddNewList (@RequestParam("username") String username, @RequestParam("newListName") String newListName, Model model) {
        ThetaskApplication.addNewListForUser(username, newListName);
        for (User user : ThetaskApplication.userlist.getUserList()) {
            if (user.getUsername().equals(username)) {
                model.addAttribute("listOfLists", user.getToDoLists()); 
                return "redirect:/home";
            }
        }

        return "redirect:/home";
    }

    @PostMapping("/addNewToDo")
    String postAddNewToDo (@RequestParam("username") String username, @RequestParam("listName") String listName, @RequestParam("newToDoName") String newToDoName, @RequestParam("newToDoTime") long newToDoTime, Model model) {
        ThetaskApplication.addNewToDoForUser(username, listName, newToDoName, newToDoTime);
        for (User user : ThetaskApplication.userlist.getUserList()) {
            if (user.getUsername().equals(username)) {
                model.addAttribute("listOfLists", user.getToDoLists()); 
                return "redirect:/home";
            }
        }
        return "redirect:/home";
    }   


    @PostMapping("/removeList")
    String postRemoveList (@RequestParam("username") String username, @RequestParam("listName") String listName, Model model) {
        ThetaskApplication.removeListForUser(username, listName);
        for (User user : ThetaskApplication.userlist.getUserList()) {
            if (user.getUsername().equals(username)) {
                model.addAttribute("listOfLists", user.getToDoLists()); 
                return "redirect:/home";
            }
        }
        return "redirect:/home";
    }

    @PostMapping("/removeToDo")
    String postRemoveToDo (@RequestParam("username") String username, @RequestParam("listName") String listName, @RequestParam("nameOfToDo") String nameOfToDo, Model model) {
        ListOfToDos.removeToDo(username, nameOfToDo, nameOfToDo);
        for (User user : ThetaskApplication.userlist.getUserList()) {
            if (user.getUsername().equals(username)) {
                model.addAttribute("listOfLists", user.getToDoLists()); 
                return "redirect:/home";
            }
        }
        return "redirect:/home";
    }

    @PostMapping("/setToDoAsDone")
    String postSetToDoAsDone (@RequestParam("username") String username, @RequestParam("listName") String listName, @RequestParam("nameOfToDo") String nameOfToDo, Model model) {
        ListOfToDos.setToDoAsDone(username, listName, nameOfToDo);
        for (User user : ThetaskApplication.userlist.getUserList()) {
            if (user.getUsername().equals(username)) {
                model.addAttribute("listOfLists", user.getToDoLists()); 
                return "redirect:/home";
            }
        }
        return "redirect:/home";
    }

    @PostMapping("/editToDoTime") 
    String postEditToDoTime (@RequestParam("username") String username, @RequestParam("listName") String listName,
     @RequestParam("nameOfToDo") String nameOfToDo,
     @RequestParam ("newTimeOfToDo") long newTimeOfToDo, Model model) {

        ListOfToDos.editToDoTime(username, listName, nameOfToDo, newTimeOfToDo);
        for (User user : ThetaskApplication.userlist.getUserList()) {
            if (user.getUsername().equals(username)) {
                model.addAttribute("listOfLists", user.getToDoLists()); 
                return "redirect:/home";
            }
        }
        return "redirect:/home";
    }

    @PostMapping("/editToDoName") 
    String postEditToDoName (@RequestParam("username") String username, @RequestParam("listName") String listName,
     @RequestParam("nameOfToDo") String nameOfToDo,
     @RequestParam ("newNameOfToDo") String newNameOfToDo, Model model) {
        ListOfToDos.editToDoName(username, listName, nameOfToDo, newNameOfToDo);
        for (User user : ThetaskApplication.userlist.getUserList()) {
            if (user.getUsername().equals(username)) {
                model.addAttribute("listOfLists", user.getToDoLists()); 
                return "redirect:/home";
            }
        }
        return "redirect:/home";
    }
}
