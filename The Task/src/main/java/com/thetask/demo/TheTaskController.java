package com.thetask.demo;

import java.lang.reflect.Member;
import java.time.LocalDate;
import java.time.LocalTime;
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
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class TheTaskController {

    // static final List<ListOfToDos> userLists = new ArrayList<>();
    // static final List<ToDo> todoList = new ArrayList<>();

    // static {
    //     userLists.add(new ListOfToDos(null, "Renovering", UUID.randomUUID()));
    // }

    User loggedInUser;

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

    @GetMapping ("/list/{nameOfList}")
    String getList (@PathVariable String nameOfList, Model model) {
        for (ListOfToDos list : loggedInUser.getToDoLists()) {
            if (list.getNameOfList().equals(nameOfList)) {
                System.out.println("hamnar rätt");
                model.addAttribute("theNameOfList", list.getNameOfList());
                model.addAttribute("listOfToDos", list.getListOfToDo());
                System.out.println(list.getNameOfList());
                return "list";
            }
        }
        // model.addAttribute("listsOfToDos", loggedInUser.getToDoLists());
        return "list";
    }


    @PostMapping ("/addtodo")
    String addToDo (@RequestParam String listName, @RequestParam LocalDate date, @RequestParam LocalTime time, @RequestParam String name, Model model) {
        for (ListOfToDos list : loggedInUser.getToDoLists()) {
            if (list.getNameOfList().equals(listName)) {
                System.out.println(name + date + time + listName);
                list.getListOfToDo().add(new ToDo(name, date, time, false));
                return "redirect:/home";
            }
        }
        return "homePage";
    }


    // @GetMapping("/removeList/{listid}")
    // String removeList(@PathVariable UUID listid) {
    //     userLists.removeIf(lists -> lists.getId().equals(listid));
    //     return "redirect:/home";
    // }








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
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    

    

//     @GetMapping("/list/{nameOfList}")
//     String getList(@PathVariable String nameOfList, Model model) {

//         for (ListOfToDos list : TheTaskController.userLists) {
//             if (list.getNameOfList().equals(nameOfList)) {
//                 model.addAttribute("lists", new ListOfToDos(list.getListOfToDo(), list.getNameOfList(), list.getId()));
//                 return "list";
//             }
//         }
//         return "list";
//     }

    



//     @PostMapping("/addNewList")
//     String postAddNewList(@RequestParam("username") String username, @RequestParam("newListName") String newListName,
//             Model model) {
//         ThetaskApplication.addNewListForUser(username, newListName);
//         for (User user : ThetaskApplication.userlist.getUserList()) {
//             if (user.getUsername().equals(username)) {
//                 model.addAttribute("listOfLists", user.getToDoLists());
//                 return "redirect:/home";
//             }
//         }

//         return "redirect:/home";
//     }

//     @PostMapping("/addNewToDo")
//     String postAddNewToDo(@RequestParam("username") String username, @RequestParam("listName") String listName,
//             @RequestParam("newToDoName") String newToDoName, @RequestParam("newToDoTime") long newToDoTime,
//             Model model) {
//         ThetaskApplication.addNewToDoForUser(username, listName, newToDoName, newToDoTime);
//         for (User user : ThetaskApplication.userlist.getUserList()) {
//             if (user.getUsername().equals(username)) {
//                 model.addAttribute("listOfLists", user.getToDoLists());
//                 return "redirect:/home";
//             }
//         }
//         return "redirect:/home";
//     }

//     @PostMapping("/removeList")
//     String postRemoveList(@RequestParam("username") String username, @RequestParam("listName") String listName,
//             Model model) {
//         ThetaskApplication.removeListForUser(username, listName);
//         for (User user : ThetaskApplication.userlist.getUserList()) {
//             if (user.getUsername().equals(username)) {
//                 model.addAttribute("listOfLists", user.getToDoLists());
//                 return "redirect:/home";
//             }
//         }
//         return "redirect:/home";
//     }

//     @PostMapping("/removeToDo")
//     String postRemoveToDo(@RequestParam("username") String username, @RequestParam("listName") String listName,
//             @RequestParam("nameOfToDo") String nameOfToDo, Model model) {
//         ListOfToDos.removeToDo(username, nameOfToDo, nameOfToDo);
//         for (User user : ThetaskApplication.userlist.getUserList()) {
//             if (user.getUsername().equals(username)) {
//                 model.addAttribute("listOfLists", user.getToDoLists());
//                 return "redirect:/home";
//             }
//         }
//         return "redirect:/home";
//     }

//     @PostMapping("/setToDoAsDone")
//     String postSetToDoAsDone(@RequestParam("username") String username, @RequestParam("listName") String listName,
//             @RequestParam("nameOfToDo") String nameOfToDo, Model model) {
//         ListOfToDos.setToDoAsDone(username, listName, nameOfToDo);
//         for (User user : ThetaskApplication.userlist.getUserList()) {
//             if (user.getUsername().equals(username)) {
//                 model.addAttribute("listOfLists", user.getToDoLists());
//                 return "redirect:/home";
//             }
//         }
//         return "redirect:/home";
//     }

//     @PostMapping("/editToDoTime")
//     String postEditToDoTime(@RequestParam("username") String username, @RequestParam("listName") String listName,
//             @RequestParam("nameOfToDo") String nameOfToDo,
//             @RequestParam("newTimeOfToDo") long newTimeOfToDo, Model model) {

//         ListOfToDos.editToDoTime(username, listName, nameOfToDo, newTimeOfToDo);
//         for (User user : ThetaskApplication.userlist.getUserList()) {
//             if (user.getUsername().equals(username)) {
//                 model.addAttribute("listOfLists", user.getToDoLists());
//                 return "redirect:/home";
//             }
//         }
//         return "redirect:/home";
//     }

//     @PostMapping("/editToDoName")
//     String postEditToDoName(@RequestParam("username") String username, @RequestParam("listName") String listName,
//             @RequestParam("nameOfToDo") String nameOfToDo,
//             @RequestParam("newNameOfToDo") String newNameOfToDo, Model model) {
//         ListOfToDos.editToDoName(username, listName, nameOfToDo, newNameOfToDo);
//         for (User user : ThetaskApplication.userlist.getUserList()) {
//             if (user.getUsername().equals(username)) {
//                 model.addAttribute("listOfLists", user.getToDoLists());
//                 return "redirect:/home";
//             }
//         }
//         return "redirect:/home";
//     }
// }
