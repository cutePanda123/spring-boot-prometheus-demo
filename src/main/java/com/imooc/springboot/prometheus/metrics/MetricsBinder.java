package com.imooc.springboot.prometheus.metrics;

import io.micrometer.core.instrument.Counter;
import io.micrometer.core.instrument.Gauge;
import io.micrometer.core.instrument.MeterRegistry;
import io.micrometer.core.instrument.binder.MeterBinder;
import org.springframework.stereotype.Component;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Component
public class MetricsBinder implements MeterBinder {
    public Counter counter1;
    public Counter counter2;
    public Map<String, Double> map;

    public MetricsBinder() {
        map = new ConcurrentHashMap<>();
    }

    @Override
    public void bindTo(MeterRegistry meterRegistry) {
        this.counter1 = Counter.
                builder("PrometheusApplication.demo.counter").
                tags(new String[] {"name", "counter1"}).
                description("This is the first counter").
                register(meterRegistry);

        this.counter2 = Counter.
                builder("PrometheusApplication.demo.counter").
                tags(new String[] {"name", "counter2"}).
                description("This is the second counter").
                register(meterRegistry);

        Gauge.builder("PrometheusApplication.demo.gauge", map, x->x.get("x"))
                .tags("name", "gauge1")
                .description("This is a gauge")
                .register(meterRegistry);
    }
}
