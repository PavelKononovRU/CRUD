package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import web.model.User;
import web.service.UserServiceImpl;

@Controller
@RequestMapping("/users")
public class UserController {
    private final UserServiceImpl userServiceImpl;

    @Autowired
    public UserController(UserServiceImpl userServiceImpl) {
        this.userServiceImpl = userServiceImpl;
    }

    @GetMapping()
    public String getAllUsers(Model model) {
        model.addAttribute("users", userServiceImpl.findAll());
        return "all";
    }

    @GetMapping("/{id}")
    public String getUser(@PathVariable int id, Model model) {
        model.addAttribute("user", userServiceImpl.findById(id));
        return "USER";
    }

/*    @PutMapping("/{id}")
    public String create(@ModelAttribute User user) {
        userServiceImpl.save(user);
        return "redirect:/users";
    }*/

/*    @PatchMapping("/{id}")
    public String update(@ModelAttribute User user, @PathVariable int id) {
        userServiceImpl.update(id, new User());
        return "redirect:/users";
    }*/

    @DeleteMapping("/{id}")
    public String delete(@PathVariable int id) {
        userServiceImpl.delete(id);
        return "redirect:/users";
    }






    @GetMapping("/{id}/edit")
    public String edit(Model model, @PathVariable int id) {
        model.addAttribute("editUser", userServiceImpl.findById(id));
        return "edit";
    }

    @PatchMapping("/{id}")
    public String updateUser(@ModelAttribute("editUser") User toUpdateUser, @PathVariable("id") int id) {
        userServiceImpl.update(id, toUpdateUser);
        return "redirect:/users";
    }






    @GetMapping("/new")
    public String addNewUser(@ModelAttribute("newUser") User user) {
        return "create";
    }

    @PostMapping()
    public String saveUser(@ModelAttribute("newUser") User user) {
        userServiceImpl.save(user);
        return "redirect:/users";
    }
}
