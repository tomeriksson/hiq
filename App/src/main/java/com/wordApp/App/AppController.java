package com.wordApp.App;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;

@Controller
public class AppController {

    @GetMapping("/")
    public String greetingForm(Model model) {
        model.addAttribute("text", new Text());
        return "/index";
    }

   // @CrossOrigin(origins = "http://localhost:8080")
    @PostMapping("/")
    public @ResponseBody ProcessedText greetingSubmit(@RequestBody Text text) {
        return new ProcessedText(text.getContent());
    }

    @PostMapping("/upload")
    public @ResponseBody ProcessedText upload(Model model,@RequestParam("file") MultipartFile file) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(file.getInputStream()));
        String res = "";
        String input;
        do {
            input = br.readLine();
            System.out.println(input);
            res += input;
        }while(input != null);
            return new ProcessedText(res);
        /*StringBuilder fileNames = new StringBuilder();
        for (MultipartFile file : files) {
            Path fileNameAndPath = Paths.get(uploadDirectory, file.getOriginalFilename());
            fileNames.append(file.getOriginalFilename()+" ");
            try {
                Files.write(fileNameAndPath, file.getBytes());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }*/

    }
    }