package com.leposava.frequency.service;

import com.leposava.frequency.entity.Analytics;
import com.leposava.frequency.repository.AnalyticsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AnalyticsServiceImp implements AnalyticsService {
    @Autowired
    private AnalyticsRepository analyticsRepository;


    public List<Analytics> getAnalytics() {
        return analyticsRepository.findAll();
    }

    public Analytics storeAnalytics(int avarageParagraphSize, long avarageSumOfTimes, String theMostFrequentWord, long total){

        Analytics analytics = new Analytics();
        analytics.setAvg_paragraph_size(avarageParagraphSize);
        analytics.setAvg_paragraph_processing_time(avarageSumOfTimes);
        analytics.setFreq_word(theMostFrequentWord);
        analytics.setTotal_processing_time(total);

        analyticsRepository.saveAndFlush(analytics);

        return analytics;

    }
}
