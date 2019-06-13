package hello;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/users")
    public String showUsers(Model model) {
        model.addAttribute("users", userService.getUsers());
        return "users";
    }

    @PostMapping("/deleteUser/{id}")
    public String deleteUser(@PathVariable("id") Long id, Model model) {
        userService.deleteUser(id);
        model.addAttribute("users", userService.getUsers());
        return "users";
    }

    @GetMapping("/editUser/{id}")
    public String editUser(@PathVariable("id") Long id, Model model) {
        User user = userService.getUserByID(id);
        model.addAttribute("user", user);
        return "editUser";
    }

    @PostMapping("/editUser")
    public String editUser(Model model, User user) {
        userService.editUser(user);
        model.addAttribute("users", userService.getUsers());
        return "users";
    }

    @GetMapping("/createUser")
    public String createUser(Model model) {
        return "createUser";
    }

    @PostMapping("/createUser")
    public String addUser(Model model, User user) {
        userService.addUser(user);
        model.addAttribute("users", userService.getUsers());
        return "users";
    }

}