package com.wordApp.App;

import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ProcessedText {
    private String content;
    public ProcessedText(String s){
        content = process(s);
    }

    private String process(String originalString){
        String[] wordArr = filterOutNonWords(originalString);
        String[] topTwoMostCommonWords = mostCommonWords(wordArr);
        String result = replaceWithFooBar(topTwoMostCommonWords, originalString);
        return result;
    }
    private String[] filterOutNonWords(String s){
        String[] onlyWords = s.split("[^a-zA-Z']+");
        return onlyWords;
    }
    private String replaceWithFooBar(String[] commonWords, String originalString){
        int countMostCommon = Integer.parseInt(commonWords[3]);
        int countSecondMostCommon = Integer.parseInt(commonWords[2]);
        if(countMostCommon == countSecondMostCommon){
            return originalString.replaceAll(commonWords[0], "foo"+commonWords[0]+"bar")
                    .replaceAll(commonWords[1], "foo"+commonWords[1]+"bar");
        }else {
            return originalString.replaceAll(commonWords[1], "foo"+commonWords[1]+"bar");
        }
    }

    private String[] mostCommonWords(String[] wordArr){
        Map<String, Integer> map = new HashMap<String, Integer>();
        int recent;
        for(String word : wordArr) {
            if(map.containsKey(word)){
                recent = map.get(word);
                recent++;
                map.put(word, recent);
            }else{
                map.put(word, 0);
            }
        }
        String[] mostCommonWordsAndAmounts = new String[4];
        int[] amounts = new int[2];
        for (Map.Entry<String,Integer> entry : map.entrySet()) {
            String key = entry.getKey();
            int value = entry.getValue();

            if (value > amounts[0]){
                if(value >= amounts[1]){
                    amounts[0] = amounts[1];
                    mostCommonWordsAndAmounts[0] = mostCommonWordsAndAmounts[1];
                    amounts[1] = value;
                    mostCommonWordsAndAmounts[1] = key;
                }else{
                    amounts[0] = value;
                    mostCommonWordsAndAmounts[0] = key;
                }
            }
        }
        mostCommonWordsAndAmounts[2] = amounts[0]+"";
        mostCommonWordsAndAmounts[3] = amounts[1] +"";
        return mostCommonWordsAndAmounts;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}