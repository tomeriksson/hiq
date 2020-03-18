package com.wordApp.App;

import com.wordApp.Exceptions.FileNotReadableException;
import com.wordApp.Exceptions.FileTypeNotReadableException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import java.io.*;

@Controller
public class AppController {

    private static final String[] CONTENT_TYPES = {"application/octet-stream", "text/plain"};

    @GetMapping("/")
    public String greetingForm(Model model) {
        model.addAttribute("text", new Text());
        return "/index";
    }

    // @CrossOrigin(origins = "http://localhost:8080")
    @PostMapping("/")
    public @ResponseBody
    ProcessedText greetingSubmit(@RequestBody Text text) {
        return new ProcessedText(text.getContent());
    }

    @PostMapping("/upload")
    public @ResponseBody
    ProcessedText upload(Model model, @RequestParam("file") MultipartFile file) {
        String type = file.getContentType();
        boolean isEmpty = file.isEmpty();
        System.out.println(file.getContentType());
        System.out.println(isEmpty);
        System.out.println(type != CONTENT_TYPES[0] || type != CONTENT_TYPES[1]);

        if (!(type.equals(CONTENT_TYPES[0]) || type.equals(CONTENT_TYPES[1]))) throw new FileTypeNotReadableException();
        if (isEmpty) throw new FileTypeNotReadableException();

        String res = "";
        try (BufferedReader bf = new BufferedReader(new InputStreamReader(file.getInputStream()))) {
            res = WordProcessor.read(bf);
        } catch (IOException e) {
            System.out.println("fel i läsningen.");
            throw new FileNotReadableException();
        }
        return new ProcessedText(res);
    }

    public static void main(String[] args) {
        String[] CONTENT_TYPES = {"application/octet-stream", "text/plain"};
        String type = "text/plain";
        String type2 = "application/octet-stream";
        System.out.println(!(type== CONTENT_TYPES[0] || type == CONTENT_TYPES[1]));
    }
}