package com.leposava.frequency.service;

import com.leposava.frequency.entity.Analytics;

import java.util.List;

public interface AnalyticsService {
    List<Analytics> getAnalytics();
    Analytics storeAnalytics(int avarageParagraphSize, long avarageSumOfTimes, String theMostFrequentWord, long total);
}
