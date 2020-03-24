package com.wordApp.App;

import com.wordApp.Exceptions.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import java.io.*;
import java.nio.charset.StandardCharsets;

@Controller
public class AppController {

    @GetMapping("/")
    public String greetingForm(Model model) {
        model.addAttribute("text", new Text());
        return "/index";
    }

    @RequestMapping(value = "/process", consumes = MediaType.MULTIPART_FORM_DATA_VALUE, method = {RequestMethod.POST})
    public @ResponseBody ProcessedText uploadFile(Model model, @RequestParam("file") MultipartFile file) throws IOException {
        handleErrors(file);
        String res = new String(file.getBytes(), StandardCharsets.UTF_8);
        if (res == null || res == "") throw new FileNotReadableException();
        return new ProcessedText(res);
    }

    @RequestMapping(value = "/process", consumes = MediaType.APPLICATION_JSON_VALUE, method = {RequestMethod.POST})
    public @ResponseBody ProcessedText uploadJson(@RequestBody Text text) {
        if (text == null || text.getContent().isEmpty()) throw new ContentEmptyException();
        return new ProcessedText(text.getContent());
    }

    private static void handleErrors(MultipartFile file) throws IOException {
        final String[] CONTENT_TYPES = {"application/octet-stream", "text/plain", "text/rtf"};
        final long MAX_FILE_SIZE = 10485760;
        String type = file.getContentType();
        long fileSize = file.getSize();
        boolean isEmpty = file.isEmpty();
        if (!(type.equals(CONTENT_TYPES[0]) || type.equals(CONTENT_TYPES[1]) || type.equals(CONTENT_TYPES[2]))) throw new FileTypeNotReadableException();
        if (isEmpty) throw new FileEmptyException();
        if (fileSize > MAX_FILE_SIZE) throw new FileSizeToBigException();
    }
}