package com.example.login.and.Registration.controller;

import javax.validation.Valid;

import com.example.login.and.Registration.controller.dto.UserRegistrationDto;
import com.example.login.and.Registration.model.User;
import com.example.login.and.Registration.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/registration")
public class UserRegistrationController {

    @Autowired
    private UserService userService;

    @ModelAttribute("user")
    public UserRegistrationDto userRegistrationDto(){
        return new UserRegistrationDto();
    }

    @GetMapping
    public String showRegistrationForm(Model model){
        return "registration";
    }
    
    @PostMapping
    public String registerUserAccount(
        @ModelAttribute("user")
        @Valid UserRegistrationDto userDto,
        BindingResult result){

            User existing = userService.findByEmail(userDto.getEmail());
            if(existing!=null){
                result.rejectValue("email", null,
                "There is already an account registred with that email");
            }
            System.out.print("result.hasErrors():"+result.hasErrors());
            if(result.hasErrors()){
                return "registration";
            }

            userService.save(userDto);

            return "redirect:/registration?success";
        }
}