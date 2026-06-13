package com.triminds.tlp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class TlpRfidApplication {

    public static void main(String[] args) {
        SpringApplication.run(TlpRfidApplication.class, args);
    }
}
