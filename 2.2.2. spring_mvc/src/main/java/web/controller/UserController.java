package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import web.model.User;
import web.service.UserService;

@Controller
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping()
    public String getAll(ModelMap model) {
        model.addAttribute("users", userService.listUsers());
        return "users";
    }

    @GetMapping("/create")
    public String createUserHtml(User user) {
        return "create";
    }

    @PostMapping("/create")
    public String createUser(User user) {
        userService.create(user);
        return "redirect:/";
    }

    @GetMapping("delete/{id}")
    public String deleteUser(@PathVariable("id") Long id) {
        userService.deleteById(id);
        return "redirect:/";
    }
    @GetMapping("/update/{id}")
    public String updateUserHtml(@PathVariable("id") Long id, ModelMap model){
        User usr = userService.findById(id);
        model.addAttribute("user", usr);
        return "update";
    }
    @PostMapping("/update")
    public String updateUser(User user) {
        userService.update(user);
        return "redirect:/";
    }

}
