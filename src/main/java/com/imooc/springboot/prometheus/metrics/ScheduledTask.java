package com.imooc.springboot.prometheus.metrics;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class ScheduledTask {
    @Autowired
    MetricsBinder metricsBinder;

    private int count1;
    private int count2;


    @Scheduled(fixedRate = 1000)
    public void increment1() {
        count1++;
        metricsBinder.counter1.increment();
        metricsBinder.map.put("x", Double.valueOf(count1));
        System.out.println("increment 1 count: " + count1);
    }

    @Scheduled(fixedRate = 10000)
    public void increment2() {
        count2++;
        metricsBinder.counter2.increment();
        metricsBinder.map.put("x", Double.valueOf(count2));
        System.out.println("increment 2 count: " + count2);
    }
}
