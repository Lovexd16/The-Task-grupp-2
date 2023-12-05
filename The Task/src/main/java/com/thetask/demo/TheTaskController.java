package com.thetask.demo;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class TheTaskController {

    static final List<ListOfToDos> userLists = new ArrayList<>();
    static final List<ToDo> todoList = new ArrayList<>();

    static {
        userLists.add(new ListOfToDos(null, "Renovering", UUID.randomUUID()));
    }

    @GetMapping("/")
    String getStart() {
        return "loginPage";
    }

    @GetMapping("/home")
    String getLogin(Model model) {
        model.addAttribute("userLists", userLists);
        model.addAttribute("newList", new ListOfToDos(null, null, UUID.randomUUID()));
        return "homePage";
    }

    @PostMapping("/adduserList")
    String newUserList(@RequestParam("nameOfList") String nameOfList) {
        userLists.add(new ListOfToDos(new ArrayList<ToDo>(), nameOfList, UUID.randomUUID()));

        return "redirect:/home";
    }

    @GetMapping("/removeList/{listid}")
    String removeList(@PathVariable UUID listid) {
        userLists.removeIf(lists -> lists.getId() == listid);
        return "redirect:/home";
    }

    @GetMapping("/list/{nameOfList}")
    String getList(@PathVariable String nameOfList, Model model) {

        for (ListOfToDos list : TheTaskController.userLists) {
            if (list.getNameOfList().equals(nameOfList)) {
                model.addAttribute("lists", new ListOfToDos(list.getListOfToDo(), list.getNameOfList(), list.getId()));
                return "list";
            }
        }
        return "list";
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

    // @PostMapping("/removeToDo")
    // ListOfToDos removeToDo(@RequestParam("removeToDo") String toDo) {
    // // return "rdirect:/home";

    // }

    // @PostMapping("/addNewList")
    // String postAddNewList (@RequestParam("username") String username,
    // @RequestParam("newListName") String newListName) {

    // }
}
