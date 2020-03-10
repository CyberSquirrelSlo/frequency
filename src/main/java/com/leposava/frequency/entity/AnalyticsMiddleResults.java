package com.leposava.frequency.entity;

public class AnalyticsMiddleResults {

    RandomText randomText;
    long paragraphTimeProcessing;
    int avarageParagraphSize;
    String theMostFrequentWord;

    public RandomText getRandomText() {
        return randomText;
    }

    public void setRandomText(RandomText randomText) {
        this.randomText = randomText;
    }

    public long getParagraphTimeProcessing() {
        return paragraphTimeProcessing;
    }

    public void setParagraphTimeProcessing(long paragraphTimeProcessing) {
        this.paragraphTimeProcessing = paragraphTimeProcessing;
    }

    public int getAvarageParagraphSize() {
        return avarageParagraphSize;
    }

    public void setAvarageParagraphSize(int avarageParagraphSize) {
        this.avarageParagraphSize = avarageParagraphSize;
    }

    public String getTheMostFrequentWord() {
        return theMostFrequentWord;
    }

    public void setTheMostFrequentWord(String theMostFrequentWord) {
        this.theMostFrequentWord = theMostFrequentWord;
    }
}
