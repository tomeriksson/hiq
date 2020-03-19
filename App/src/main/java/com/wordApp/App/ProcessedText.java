package com.wordApp.App;

import org.springframework.http.ResponseEntity;

import java.security.Provider;
import java.sql.SQLOutput;
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
        String firstPattern  = "\\b" + commonWords[0]+ "\\b";
        String secondPattern = "\\b" + commonWords[1]+ "\\b";
        String firstReplacement = "foo"+commonWords[0]+"bar";
        String secondReplacement = "foo"+commonWords[1]+"bar";
        if(countMostCommon == countSecondMostCommon){
            return originalString.replaceAll(firstPattern, firstReplacement)
                    .replaceAll(secondPattern, secondReplacement);
        }else {
            return originalString.replaceAll(secondPattern, secondReplacement);
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

    public static void main(String[] args) {
        ProcessedText p = new ProcessedText("       How Many Generic Chickens Can You Fit Into a Generic Pontiac?\n" +
                "\n" +
                "\n" +
                "     A while back, someone asked how many generic chickens would fit \n" +
                "into a generic Pontiac. This question has been on my mind recently, so I \n" +
                "decided to work out this problem, for the benefit of all humanity.\n" +
                "\n" +
                "I. It has been proven succesfully that chickens have a definite   \n" +
                "   wave-like nature. In reproducing Thomas Young's famous double-slit \n" +
                "   experiment of 1801, Sir Kenneth Harbour-Thomas showed that chickens\n" +
                "   not only diffract, but produce interference patterns as well. (This \n" +
                "   experiment is fully documented in Sir Kenneth's famous treatise \n" +
                "   \"Tossing Chickens Through Various Apertures in Modern Architecture\", \n" +
                "   1897)\n" +
                "\n" +
                "II. It is also known, as any farmhand can tell you, that whereas if one \n" +
                "    chicken is placed in an enclosed space, it will be impossible to \n" +
                "    pinpoint the exact location of the chicken at any given time t. This\n" +
                "    was summarized by Helmut Heisenberg (Werner's younger brother) in\n" +
                "    the equation:\n" +
                "          d(chicken) * dt >= b \n" +
                "    (where b is the barnyard constant; 5.2 x10^(-14) domestic fowl * \n" +
                "    seconds)\n" +
                "\n" +
                "III. Whatever our results, they must be consistant with the fundamentals \n" +
                "     of physics, so energy, momentum, and charge must all be conserved.\n" +
                "\n" +
                "     A. Chickens (fortunately) do not carry electric charge. This was  \n" +
                "        discovered by Benjamin Franklin, after repeated experiments with \n" +
                "        chickens, kites, and thunderstorms.\n" +
                "     B. The total energy of a chicken is given by the equation:\n" +
                "                 E = K + V\n" +
                "        Where V is the potential energy of the chicken, and K is the \n" +
                "        kinetic energy of the chicken, given by \n" +
                "                 (.5)mv^2 or (p^2) / (2m).\n" +
                "     C. Since chickens have an associated wavelength, w, we know that \n" +
                "        the momentum of a free-chicken (that is, a chicken not enclosed \n" +
                "        in any sort of Pontiac) is given by: p = b / w.\n" +
                "\n" +
                "IV. With this in mind, it is possible to come up with a wave equation \n" +
                "    for the potential energy of a generic chicken. (A wave equation will \n" +
                "    allow us to calculate the probability of finding any number of \n" +
                "    chickens in automobiles.) The wave equation for a non-relativistic, \n" +
                "    time-independant chicken in a one- dimensional Pontiac is given by:\n" +
                "          [V * P] - [[(b^2) / (2m)] * D^2(P)] = E * P\n" +
                "    P is the wave function, and D^2(P) is its second derivative.\n" +
                "         The wave equation can be used to prove that chickens are in \n" +
                "         fact quantized, and that by using the Perdue Exclusion formula \n" +
                "         we know that no two chickens in any Pontiac can have the same \n" +
                "         set of quantum numbers.\n" +
                "\n" +
                "V. The probability of finding a chicken in the Pontiac is simply the \n" +
                "   integral of P * P * dChicken from 0 to x, where x = the length of the \n" +
                "   Pontiac. Since each chicken will have its own set of quantum numbers\n" +
                "   (when examining the case of the three-dimensional Pontiac) different\n" +
                "   wave functions can be derived for each set of quantum numbers.\n" +
                "        It is important to note that we now know that there is no such\n" +
                "   thing as a generic chicken.  Each chicken influences the position and\n" +
                "   velocity of every other chicken inside the Pontiac, and each chicken\n" +
                "   must be treated individually. \n" +
                "        It has been theorized that chickens do in fact have an intrinsic\n" +
                "   angular momentum, yet no experiment has been yet conducted to prove \n" +
                "   this, as chickens tend to move away from someone trying to spin them.\n" +
                "        Curious sidenote: Whenever possible, any attempt to integrate a \n" +
                "   chicken should be done by parts, as most people will tend to want the \n" +
                "   legs (dark meat), which can lead to innumerable family conflicts \n" +
                "   which are best avoided if at all possible.\n" +
                "\n" +
                "\n" +
                "\n" +
                "\n" +
                "     The Prestidigitator, Drew Physics Major Extraordinary\n" +
                "     24 March 1988\n" +
                "\u001A");
        System.out.println(p.getContent());
    }
}