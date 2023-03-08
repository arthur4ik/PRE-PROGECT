package ru.vakulchuk.springBootCRUD.controllers;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import ru.vakulchuk.springBootCRUD.models.User;
import ru.vakulchuk.springBootCRUD.service.UserService;


@Qualifier("userService")
@Controller
@RequestMapping("/users")
public class UsersController {

    private final UserService userService;

    public UsersController(UserService userService) {
        this.userService = userService;

    }

    @GetMapping()
    public String getAllUsers(Model model) {
        model.addAttribute("users", userService.getAllUsers());
        return "index";
    }

    @GetMapping("/new")
    public String getViewForCreateUsers(@ModelAttribute("user") User user) {
        return "new";
    }

    @PostMapping()
    public String createUser(@ModelAttribute("user") @Valid User user,
                             BindingResult bindingResult) {
        if (bindingResult.hasErrors())
            return "new";
        userService.saveUser(user);
        return "redirect:/users";
    }

    @GetMapping("/id")
    public String userInfo(@RequestParam("id") int id, Model model) {
        model.addAttribute("user", userService.userInfo(id));
        return "show";
    }

    @GetMapping("/edit")
    public String getViewForEditUser(Model model, @RequestParam("edit") int id) {
        model.addAttribute("user", userService.userInfo(id));
        return "edit";
    }

    @PatchMapping("/edit")
    public String updateUser(@ModelAttribute("user") @Valid User user, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "edit";
        }
        userService.updateUser(user);
        return "redirect:/users";
    }

    @DeleteMapping("/delete")
    public String deleteUser(@RequestParam("delete") int id) {
        userService.deleteUser(id);
        return "redirect:/users";
    }


}