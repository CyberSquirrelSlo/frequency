package com.leposava.frequency.controller;

import com.leposava.frequency.client.RandomTextClient;
import com.leposava.frequency.client.RandomTextClientWorker;
import com.leposava.frequency.domain.FrequencyLogic;
import com.leposava.frequency.entity.Analytics;
import com.leposava.frequency.entity.AnalyticsMiddleResults;
import com.leposava.frequency.repository.AnalyticsRepository;
import com.leposava.frequency.service.AnalyticsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.*;

@RestController
@RequestMapping("/betvictor")
public class FrequencyController {

    private AnalyticsService analyticsService;

    @Autowired
    public void setAnalyticsService(AnalyticsService analyticsService) {
        this.analyticsService = analyticsService;
    }


    @Autowired
    public AnalyticsRepository analyticsRepository;

    @GetMapping(value = "/text", produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<Analytics> getAnalytics(@RequestParam("p_start") int pStart,
                                                    @RequestParam("p_end") int pEnd,
                                                    @RequestParam("w_count_min") int wCountMin,
                                                    @RequestParam("w_count_max") int wCountMax) {
        long start = System.nanoTime();
        ExecutorService executor = Executors.newCachedThreadPool();
        RandomTextClient client = new RandomTextClient();
        List<Future<AnalyticsMiddleResults>> list = new ArrayList<Future<AnalyticsMiddleResults>>();
        for (int i = pStart; i <= pEnd; i++) {
            Callable<AnalyticsMiddleResults> callable = new RandomTextClientWorker(i, client, i, wCountMin, wCountMax);
            Future<AnalyticsMiddleResults> future = executor.submit(callable);
            list.add(future);
        }


        long sumOfTimes = 0;
        int sumAvarParagraphSize = 0;

        Map<String, Integer> mostFrequentWords = new HashMap<>();
        String theMostFrequentWord = "";
        for (Future<AnalyticsMiddleResults> fut : list) {
            try {

                sumOfTimes += fut.get().getParagraphTimeProcessing();
                sumAvarParagraphSize += fut.get().getAvarageParagraphSize();

                theMostFrequentWord = FrequencyLogic.theMostFrequentWord(mostFrequentWords, fut.get().getTheMostFrequentWord());

            } catch (InterruptedException | ExecutionException e) {

                //this is not for the production.. instead I would user logger
                e.printStackTrace();
            }
        }
        executor.shutdown();

        long avarageSumOfTimes = sumOfTimes / list.size();
        int avarageParagraphSize = sumAvarParagraphSize / list.size();

        long total = System.nanoTime() - start;

        Analytics analytics = analyticsService.storeAnalytics(avarageParagraphSize, avarageSumOfTimes, theMostFrequentWord, total);

        return new ResponseEntity<>(analytics, HttpStatus.OK);
    }

    @GetMapping(value = "/history", produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<List<Analytics>> getHistory() {
        List<Analytics> list = analyticsService.getAnalytics();
        return new ResponseEntity<List<Analytics>>(list, HttpStatus.OK);
    }


}
