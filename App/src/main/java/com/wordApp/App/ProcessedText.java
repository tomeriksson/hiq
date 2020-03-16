package com.wordApp.App;

public class ProcessedText {
    private String content;
    public ProcessedText(String s){
        content = s.toUpperCase();
    }
    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}