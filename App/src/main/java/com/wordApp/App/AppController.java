package com.wordApp.App;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class AppController {

    @GetMapping("/")
    public String greetingForm(Model model) {
        model.addAttribute("text", new Text());
        return "index";
    }

   // @CrossOrigin(origins = "http://localhost:8080")
    @PostMapping("/")
    public @ResponseBody ProcessedText greetingSubmit(@RequestBody Text text) {
        return new ProcessedText(text.getContent());
    }

}