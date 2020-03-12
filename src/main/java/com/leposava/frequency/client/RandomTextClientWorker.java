package com.leposava.frequency.client;

import com.leposava.frequency.domain.FrequencyManager;
import com.leposava.frequency.entity.AnalyticsMiddleResults;
import com.leposava.frequency.entity.RandomText;

import java.util.concurrent.Callable;


public class RandomTextClientWorker implements Callable<AnalyticsMiddleResults> {
    private final int id;
    private RandomTextClient client;
    private int numbOfParagraphs;
    private int minWords;
    private int maxWords;

    public RandomTextClientWorker(int id, RandomTextClient client, int numbOfParagraphs, int minWords, int maxWords) {
        this.id = id;
        this.client = client;
        this.numbOfParagraphs = numbOfParagraphs;
        this.minWords = minWords;
        this.maxWords = maxWords;
    }

    @Override
    public AnalyticsMiddleResults call() throws Exception {

        RandomText randomText = client.getRandomText(numbOfParagraphs, minWords, maxWords);

        long paragraphStart = System.nanoTime();
        String theMostFrequentWord = FrequencyManager.theMostFrequentWord(FrequencyManager.getArrayFormTextParagraphs(randomText.getText_out()));
        int avarageParagraphSize = FrequencyManager.avarageParagraphSize(randomText.getText_out());
        long paragraphEnd = System.nanoTime() - paragraphStart;

        AnalyticsMiddleResults analyticsMiddleResults = new AnalyticsMiddleResults();
        analyticsMiddleResults.setTheMostFrequentWord(theMostFrequentWord);
        analyticsMiddleResults.setParagraphTimeProcessing(paragraphEnd);
        analyticsMiddleResults.setAvarageParagraphSize(avarageParagraphSize);

        return analyticsMiddleResults;
    }


}



