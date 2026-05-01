package com.restapi.apidemo.ServerSide.Contorller;



import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.restapi.apidemo.ServerSide.user;

import jakarta.validation.Valid;

@Controller
public class Myclass {
    //OPEN FORM
    @GetMapping("/form")
    public String openForm(Model model){
        model.addAttribute("user", new user());
        return "form";
    }

    //HANDLE FORM
    @PostMapping("/process")
    public String processForm(@Valid @ModelAttribute("user") user user, BindingResult result,    Model model){
        if (result.hasErrors()) {
            return "form";
            
        }
       model.addAttribute("msg", "Successfully Registered");
       return "success";
    }


    
}
