package com.restapi.SmartContactManager;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class Thymeleafcontroller {

    // @RequestMapping(value = "/home", method = RequestMethod.GET)
    // public String home(Model model) {
    //     model.addAttribute("message", "Thymeleaf working");
    //     model.addAttribute("name", "My name is Aryan Prajapati ");
    //     LocalDate now = LocalDate.now();
    //     model.addAttribute("currentDate", now.toString());
    //     return "home";
    // }


// ITERATION IN THYMELEAF

    // @GetMapping("/home")
    // public String Home(Model m){
    //     //create a list of string
    //     List<String>names = List.of("Aryan", "Ram", "Lakhan");
    //     m.addAttribute("names", names);
    //     return "home";
    // }

    // CONDITIONAL STATEMENT IN THYMELEAF
    // @GetMapping("/condition")
    // public String Conditionalstatement(Model m){
    //     System.out.println("conditional statement executed");
    //     //ELVIS OPERATOR
    //     m.addAttribute("isActive",true);
    //     //IF OPEARTOR
    //     m.addAttribute("gender","M");
    //     //SWITCH CASE
    //     List<Integer>list = List.of(121,111,321,904);
    //     m.addAttribute("myList",list);
    //     //m.addAttribute()
    //     return "condition";

    //INCLUDING THYMELEAF TEMPLATE

    // @GetMapping("/service")
    // public String serviceHandler(Model m){
    //     return "service";
    // }


    //ITERATING THYMELEAF TEMPLATE
    @GetMapping("/aboutt")
    public String about() {
        return "aboutt";   // parent layout page
    }

    @GetMapping("/help")
    public String help() {
        return "help";    // child page
    }

    }
