package com.thetask.demo;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
public class ListOfToDosController {

    final List<ListOfToDos> listoftodos;
    private final UserController userController;

    public ListOfToDosController(List<ListOfToDos> listoftodos, UserController userController) {
        this.listoftodos = listoftodos;
        this.userController = userController;
    }

    @GetMapping("/home")
    public String getTodoLists(Model model) {
        User loggedInUser = userController.getLoggedInUser();
        if (loggedInUser == null) {
            return "redirect:/login";
        }

        List<ListOfToDos> userLists = getUserTodoLists(loggedInUser);
        model.addAttribute("todoLists", userLists);
        return "homePage";
    }

    @GetMapping("/home/{todoListId}")
    public String getTodoList(@PathVariable Long todoListId, Model model) {
        User loggedInUser = userController.getLoggedInUser();
        if (loggedInUser == null) {
            return "redirect:/";
        }

        ListOfToDos selectedTodoList = findTodoListById(todoListId);
        if (selectedTodoList == null || !selectedTodoList.getUser().equals(loggedInUser)) {

            return "redirect:/home";
        }

        List<ListOfToDos> userLists = getUserTodoLists(loggedInUser);
        model.addAttribute("todoLists", userLists);
        model.addAttribute("selectedTodoList", selectedTodoList);

        return "homePage";
    }

    @PostMapping("/todolists")
    public String addTodoList(@RequestParam String name) {
        User loggedInUser = userController.getLoggedInUser();
        if (loggedInUser == null) {
            return "redirect:/login";
        }

        ListOfToDos listoftodo = new ListOfToDos(name, loggedInUser);
        listoftodos.add(listoftodo);

        return "redirect:/home";
    }

    public List<ListOfToDos> getTodoLists() {
        return listoftodos;
    }

    private List<ListOfToDos> getUserTodoLists(User user) {
        List<ListOfToDos> userLists = new ArrayList<>();
        for (ListOfToDos list : listoftodos) {
            if (list.getUser().equals(user)) {
                userLists.add(list);
            }
        }
        return userLists;
    }

    private ListOfToDos findTodoListById(Long todoListId) {
        for (ListOfToDos listofTodo : listoftodos) {
            if (listofTodo.getId().equals(todoListId)) {
                return listofTodo;
            }
        }
        return null;
    }
}
