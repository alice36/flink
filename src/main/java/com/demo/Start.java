package com.demo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Start {

    private static final Logger log = LoggerFactory.getLogger(Start.class);

    public static void main(String[] args) throws InterruptedException {
        log.info("flink starts");
        System.out.println("my flink starts");
        long start = System.currentTimeMillis();
        Thread.sleep(20000);
        System.out.println("Sleep time in ms = "+(System.currentTimeMillis()-start));
        log.info("flink ends");
    }

}
