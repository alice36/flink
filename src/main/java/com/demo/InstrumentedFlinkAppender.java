package com.demo;

import ch.qos.logback.classic.Level;
import ch.qos.logback.classic.spi.ILoggingEvent;
import ch.qos.logback.core.UnsynchronizedAppenderBase;
import org.apache.flink.metrics.Counter;
import org.apache.flink.util.Collector;

public class InstrumentedFlinkAppender extends UnsynchronizedAppenderBase<ILoggingEvent> {

    public static final String COUNTER_NAME = "logback_appender_total";
    private final Counter infoCounter;
//    private static final Collector defaultCounter = Counter.build().name(COUNTER_NAME)
//          .help("Logback log statements at various log levels")
//          .labelNames("level")
//          .register();

    public InstrumentedFlinkAppender(Counter infoCounter) {
        this.infoCounter = infoCounter;
    }

    @Override
    public void start() {
        super.start();
    }

    @Override
    protected void append(ILoggingEvent event) {
        switch (event.getLevel().toInt()) {

            case Level.INFO_INT:
                this.infoCounter.inc();
                break;
            default:
                break;
        }
    }
}

