package com.leposava.frequency.domain;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.regex.Pattern;

public class FrequencyLogic {


    public static String theMostFrequentWord(String[] words) {
        HashMap<String, Integer> wordsFrequency = new HashMap<String, Integer>();

        for (int i = 0; i < words.length; i++) {
            if (wordsFrequency.containsKey(words[i])) {
                wordsFrequency.put(words[i], wordsFrequency.get(words[i]) + 1);
            } else {
                wordsFrequency.put(words[i], 1);
            }
        }

        Set<Map.Entry<String, Integer>> wordsFrequencySet = wordsFrequency.entrySet();
        String key = "";
        int value = 0;

        for (Map.Entry<String, Integer> wordsFrequencyEntry : wordsFrequencySet) {
            if (wordsFrequencyEntry.getValue() > value) {
                value = wordsFrequencyEntry.getValue();
                key = wordsFrequencyEntry.getKey();
            }
        }

        return key;
    }


    public static String theMostFrequentWord(Map<String, Integer> mostFrequentWords, String mostFrequentWord) {
        int value = 0;
        String key = "";

        if (mostFrequentWords.containsKey(mostFrequentWord)) {
            mostFrequentWords.put(mostFrequentWord, mostFrequentWords.get(mostFrequentWord) + 1);
        } else {
            mostFrequentWords.put(mostFrequentWord, 1);
        }

        for (Map.Entry<String, Integer> wordsFrequencyEntry : mostFrequentWords.entrySet()) {
            if (wordsFrequencyEntry.getValue() > value) {
                value = wordsFrequencyEntry.getValue();
                key = wordsFrequencyEntry.getKey();
            }
        }

        return key;
    }

    public static String[] getArrayFormTextParagraphs(String text) {

        String newtext = text.replace("<p>", "").replace("</p>", "").replace("\\r", "");
        String[] words = Pattern.compile("\\s++").split(newtext);

        return words;
    }

    public static int avarageParagraphSize(String text) {
        Map<Integer, Integer> paragraphsSizes = new HashMap<>();
        String[] paragraphs = Pattern.compile("</p>\\r").split(text);
        for (int i = 0; i < paragraphs.length; i++) {
            String[] words = Pattern.compile("\\s++").split(paragraphs[i]);
            paragraphsSizes.put(i, words.length);

        }

        int sum = 0;
        for (Map.Entry<Integer, Integer> paragraphSizesEntry : paragraphsSizes.entrySet()) {
            sum += paragraphSizesEntry.getValue();
        }
        int average = sum / paragraphs.length;
        return average;
    }
}
