package ru.izec.sportproject.controllers;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/first")
public class FirstController {

    @GetMapping("/hello")
    public String helloPage(@RequestParam(value = "name", required = false) String name,
                            @RequestParam(value = "surname", required = false) String surname,
                            Model model) {


        //System.out.println("Hello, " + name + " " + surname + "!");
        model.addAttribute("message", "Hello, " + name + " " + surname + "!");
        return "first/hello";
    }

    @GetMapping("/goodbye")
    public String goodByePage() {
        return "first/goodbye";
    }

    @GetMapping("/calculator")
    public String compute(@RequestParam(value = "a", required = false) int a,
                          @RequestParam(value = "b", required = false) int b,
                          @RequestParam(value = "action", required = false) String action,
                          Model model) {
        double result = 0;
        if (action.equals("multiplication")) {
            result = a * b;
        } else if (action.equals("addition")) {
            result = a + b;
        } else if (action.equals("subtraction")) {
            result = a - b;
        } else if (action.equals("division")) {
            result = a / (double) b;
        }
        model.addAttribute("result", result);
        return "first/calculator";
    }
}
