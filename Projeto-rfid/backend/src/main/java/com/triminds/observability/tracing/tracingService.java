package com.logicorp.observability.tracing;

import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class TraceService {

    public String createTraceId() {
        return UUID.randomUUID().toString();
    }
}