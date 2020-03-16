package com.wordApp.App;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@RestController
public class AppController {

    @GetMapping("/index")
    public String greetingForm(Model model) {
        model.addAttribute("text", new Text());
        return "index";
    }

    @PostMapping("/")
    public ProcessedText greetingSubmit(@RequestBody Text text) {
        return new ProcessedText(text.getContent());
    }

}