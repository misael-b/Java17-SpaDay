package org.launchcode.controllers;

import jakarta.validation.Valid;
import org.launchcode.models.User;
import org.springframework.boot.Banner;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("user")
public class UserController {

    @GetMapping("/add")
    public String displayAddUserForm(Model model) {
        model.addAttribute("user", new User());
        return "user/add";
    }

    @PostMapping
    public String processAddUserForm(Model model, @ModelAttribute @Valid User user, Errors errors, String verify) {
        model.addAttribute("user", user);
        if(errors.hasErrors()){
            return "user/add";
        }else{
//            if (user.getPassword().equals(verify)) {
//                return "user/index";
//            }
//            else {
//                model.addAttribute("error", "Passwords do not match");
//                return "user/add";
//            }
            return "user/index";
        }


    }


}