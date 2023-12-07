// package com.thetask.demo;

// import java.util.ArrayList;
// import java.util.List;
// import java.util.UUID;

// import org.springframework.stereotype.Controller;
// import org.springframework.ui.Model;
// import org.springframework.web.bind.annotation.GetMapping;
// import org.springframework.web.bind.annotation.ModelAttribute;
// import org.springframework.web.bind.annotation.PathVariable;
// import org.springframework.web.bind.annotation.PostMapping;
// import org.springframework.web.bind.annotation.RequestParam;
// import org.springframework.web.servlet.mvc.support.RedirectAttributes;

// @Controller
// public class TheTaskController {

// // static final List<ListOfToDos> listOfToDo = new ArrayList<>();
// // static final List<ToDo> todoList = new ArrayList<>();
// // static final List<ListOfToDos> toDoLists = new ArrayList<>();
// // User user = new User(null, null);
// // ListOfToDos listoftodos = new ListOfToDos(null, null, null);
// // static private final List<ListOfToDos> listOfToDo = new ArrayList<>();
// // static private final User user = new User(null, null);

// // static {
// // listOfToDo.add(new ListOfToDos(null, "Renovering", UUID.randomUUID()));
// // }

// @GetMapping("/")
// String getStart(Model model) {
// return "loginPage";
// }

// @GetMapping("/home")
// public String home(@ModelAttribute("user") User user, Model model) {
// model.addAttribute("user", user);
// return "homePage";
// }

// private final List<User> users = new ArrayList<>();

// @PostMapping("/adduserList")
// public String addTodoList(@RequestParam("nameOfList") String nameOfList,
// @RequestParam String username,
// Model model) {
// User user = findUser(username);

// if (user != null) {
// UUID id = UUID.randomUUID();
// ListOfToDos newList = new ListOfToDos(new ArrayList<>(), nameOfList, id);
// user.getToDoLists().add(newList);
// model.addAttribute("user", user);
// }

// return "home";
// }

// private User findUser(String username) {
// for (User user : users) {
// if (user.getUsername().equals(username)) {
// return user;
// }
// }
// return null;
// }

// // @GetMapping("/removeList/{listid}")
// // String removeList(@PathVariable UUID listid) {
// // userLists.removeIf(lists -> lists.getId().equals(listid));
// // return "redirect:/home";
// // }

// // @GetMapping("/list/{nameOfList}")
// // String getList(@PathVariable String nameOfList, Model model) {

// // for (ListOfToDos list : TheTaskController.userLists) {
// // if (list.getNameOfList().equals(nameOfList)) {
// // model.addAttribute("lists", new ListOfToDos(list.getListOfToDo(),
// // list.getNameOfList(), list.getId()));
// // return "list";
// // }
// // }
// // return "list";
// // }

// @PostMapping("/newUser")
// String postNewUser(@RequestParam("username2") String username,
// @RequestParam("password2") String password,
// Model model, RedirectAttributes ra) {
// for (User user : ThetaskApplication.userlist.getUserList()) {
// if (user.getUsername().equals(username)) {
// ra.addFlashAttribute("errorMessageForCreatingUser", "Användarnamn upptaget");
// return "redirect:/";
// }
// }

// ThetaskApplication.userlist.getUserList().add(new User(username, password));

// for (User user : ThetaskApplication.userlist.getUserList()) {
// if (user.getUsername().equals(username) &&
// user.getPassword().equals(password)) {
// model.addAttribute("listOfLists", user.getToDoLists());
// // user.addTodoList(new ArrayList<ListOfToDos>());
// return "redirect:/home";
// }
// }
// return "homePage";
// }

// @PostMapping("/loginUser")
// String postLogin(@RequestParam("username1") String username,
// @RequestParam("password1") String password,
// Model model, RedirectAttributes ra) {
// for (User user : ThetaskApplication.userlist.getUserList()) {
// if (user.getUsername().equals(username) &&
// user.getPassword().equals(password)) {
// model.addAttribute("listOfLists", user.getToDoLists());
// return "redirect:/home";
// }
// }
// ra.addFlashAttribute("errorMessageForLogin", "Fel användarnamn eller
// lösenord");
// return "redirect:/";
// }

// @PostMapping("/addNewList")
// String postAddNewList(@RequestParam("username") String username,
// @RequestParam("newListName") String newListName,
// Model model) {
// ThetaskApplication.addNewListForUser(username, newListName);
// for (User user : ThetaskApplication.userlist.getUserList()) {
// if (user.getUsername().equals(username)) {
// model.addAttribute("listOfLists", user.getToDoLists());
// return "redirect:/home";
// }
// }

// return "redirect:/home";
// }

// @PostMapping("/addNewToDo")
// String postAddNewToDo(@RequestParam("username") String username,
// @RequestParam("listName") String listName,
// @RequestParam("newToDoName") String newToDoName, @RequestParam("newToDoTime")
// long newToDoTime,
// Model model) {
// ThetaskApplication.addNewToDoForUser(username, listName, newToDoName,
// newToDoTime);
// for (User user : ThetaskApplication.userlist.getUserList()) {
// if (user.getUsername().equals(username)) {
// model.addAttribute("listOfLists", user.getToDoLists());
// return "redirect:/home";
// }
// }
// return "redirect:/home";
// }

// @PostMapping("/removeList")
// String postRemoveList(@RequestParam("username") String username,
// @RequestParam("listName") String listName,
// Model model) {
// ThetaskApplication.removeListForUser(username, listName);
// for (User user : ThetaskApplication.userlist.getUserList()) {
// if (user.getUsername().equals(username)) {
// model.addAttribute("listOfLists", user.getToDoLists());
// return "redirect:/home";
// }
// }
// return "redirect:/home";
// }

// @PostMapping("/removeToDo")
// String postRemoveToDo(@RequestParam("username") String username,
// @RequestParam("listName") String listName,
// @RequestParam("nameOfToDo") String nameOfToDo, Model model) {
// ListOfToDos.removeToDo(username, nameOfToDo, nameOfToDo);
// for (User user : ThetaskApplication.userlist.getUserList()) {
// if (user.getUsername().equals(username)) {
// model.addAttribute("listOfLists", user.getToDoLists());
// return "redirect:/home";
// }
// }
// return "redirect:/home";
// }

// @PostMapping("/setToDoAsDone")
// String postSetToDoAsDone(@RequestParam("username") String username,
// @RequestParam("listName") String listName,
// @RequestParam("nameOfToDo") String nameOfToDo, Model model) {
// ListOfToDos.setToDoAsDone(username, listName, nameOfToDo);
// for (User user : ThetaskApplication.userlist.getUserList()) {
// if (user.getUsername().equals(username)) {
// model.addAttribute("listOfLists", user.getToDoLists());
// return "redirect:/home";
// }
// }
// return "redirect:/home";
// }

// @PostMapping("/editToDoTime")
// String postEditToDoTime(@RequestParam("username") String username,
// @RequestParam("listName") String listName,
// @RequestParam("nameOfToDo") String nameOfToDo,
// @RequestParam("newTimeOfToDo") long newTimeOfToDo, Model model) {

// ListOfToDos.editToDoTime(username, listName, nameOfToDo, newTimeOfToDo);
// for (User user : ThetaskApplication.userlist.getUserList()) {
// if (user.getUsername().equals(username)) {
// model.addAttribute("listOfLists", user.getToDoLists());
// return "redirect:/home";
// }
// }
// return "redirect:/home";
// }

// @PostMapping("/editToDoName")
// String postEditToDoName(@RequestParam("username") String username,
// @RequestParam("listName") String listName,
// @RequestParam("nameOfToDo") String nameOfToDo,
// @RequestParam("newNameOfToDo") String newNameOfToDo, Model model) {
// ListOfToDos.editToDoName(username, listName, nameOfToDo, newNameOfToDo);
// for (User user : ThetaskApplication.userlist.getUserList()) {
// if (user.getUsername().equals(username)) {
// model.addAttribute("listOfLists", user.getToDoLists());
// return "redirect:/home";
// }
// }
// return "redirect:/home";
// }
// }
