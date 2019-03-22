package hello;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/usersURL")
    public String showUsers(Model model) {
        model.addAttribute("usersLIST", userService.getUsers());
        return "users";
    }

    @GetMapping("/createUser")
    public String createUser(Model model) {
        return "createUser";
    }

    @PostMapping("/createUser")
    public void addUser(User user) {
        userService.addUser(user);
    }


}
