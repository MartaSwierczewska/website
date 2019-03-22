package hello;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
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

    @PostMapping("/deleteUser{id}")
    public void deleteUser(@PathVariable("id") Long id) { userService.deleteUser(id); }


    @GetMapping("/createUser")
    public String createUser(Model model) { return "createUser"; }

    @PostMapping("/createUser")
    public void addUser(User user) {
        userService.addUser(user);
    }
}