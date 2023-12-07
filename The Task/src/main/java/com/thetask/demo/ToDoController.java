package com.thetask.demo;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDate;
import java.util.List;

@Controller
public class ToDoController {

    private final List<ToDo> todos;
    private final ListOfToDosController listoftodosController;

    public ToDoController(List<ToDo> todos, ListOfToDosController listoftodosController) {
        this.todos = todos;
        this.listoftodosController = listoftodosController;
    }

    @GetMapping("/tasks")
    public String getTasks(Model model) {
        List<ListOfToDos> listoftodos = listoftodosController.getTodoLists();
        model.addAttribute("todos", todos);
        model.addAttribute("listoftodos", listoftodos);
        return "homePage";
    }

    @PostMapping("/tasks")
    public String addTask(@RequestParam String name, @RequestParam LocalDate deadline,
            @RequestParam Long selectedTodoList, Model model) {
        ListOfToDos listoftodos = findTodoListById(selectedTodoList);
        if (listoftodos != null) {
            ToDo todo = new ToDo(name, deadline, listoftodos);
            todos.add(todo);

        }
        model.addAttribute("todos", todos);
        return "redirect:/home";
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
}
