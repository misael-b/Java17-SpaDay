package org.launchcode.controllers;

import org.launchcode.models.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("user")
public class UserController {
    @GetMapping
    public String displayAddUserForm(){
        return "user/add";
    }

    @PostMapping("/add")
    public String processAddUserForm(Model model, @ModelAttribute User user, String verify) {

        if (user.getPassword().equals(verify)){
            model.addAttribute(user);
            return "user/index";
        }
        model.addAttribute("error", "Passwords did not match!!!");
        model.addAttribute("username", user.getUsername());
        model.addAttribute("email", user.getEmail());
        return"user/add";
    }

}
