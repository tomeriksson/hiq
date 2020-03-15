package com.wordApp.App;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class AppController {

    @GetMapping("/index")
    public String greetingForm(Model model) {
        model.addAttribute("text", new Text());
        return "index";
    }

    @PostMapping("/index")
    public String greetingSubmit(@ModelAttribute Text text) {
        return "index";
    }

}