package com.thetask.demo;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

@Controller
public class ToDoController {
    private final List<ListOfToDos> listoftodos = new ArrayList<>();
    private final UserController usercontroller = new UserController();

    private final List<ToDo> todos;
    private final ListOfToDosController listoftodosController;

    public ToDoController(List<ToDo> todos, ListOfToDosController listoftodosController) {
        this.todos = todos;
        this.listoftodosController = listoftodosController;
    }

    // @GetMapping("/tasks")
    // public String getTasks(Model model) {
    // List<ListOfToDos> listoftodos = listoftodosController.getTodoLists();
    // model.addAttribute("todos", todos);
    // model.addAttribute("listoftodos", listoftodos);
    // return "list";
    // }

    @PostMapping("/addtodo")
public String addTask(@RequestParam String name, @RequestParam LocalDate date, @RequestParam LocalTime time, Model model) {
    
    ToDo todo = new ToDo(name, date, time);
    todos.add(todo);
    System.out.println("Ny uppgift: " + todo.getName());

    model.addAttribute("todos", todos);
    return "list";
}

    private ListOfToDos findTodoListById(Long listoftodosId) {
        List<ListOfToDos> todoLists = listoftodosController.getTodoLists();
        for (ListOfToDos listoftodo : todoLists) {
            if (listoftodo.getId().equals(listoftodosId)) {
                return listoftodo;
            }
        }
        return null;
    }

    @GetMapping("/list/{todolistname}")
    String getList(@PathVariable String todolistname, Model model) {

        List<ListOfToDos> listoftodos = listoftodosController.getTodoLists();
        model.addAttribute("todos", todos);
        model.addAttribute("listoftodos", listoftodos);

        for (ListOfToDos list : listoftodos) {
            if (list.getName().equals(todolistname)) {
                model.addAttribute("list", new ListOfToDos(list.getName(), list.getUser()));
                return "list";
            }
        }
        return "list";
    }

    // private List<ListOfToDos> getUserTodoLists(User user) {
    // List<ListOfToDos> userLists = new ArrayList<>();
    // for (ListOfToDos list : listoftodos) {
    // if (list.getUser().equals(user)) {
    // userLists.add(list);
    // }
    // }
    // return userLists;
    // }
}
