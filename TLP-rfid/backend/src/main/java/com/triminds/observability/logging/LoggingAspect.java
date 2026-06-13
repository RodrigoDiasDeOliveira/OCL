package com.triminds.observability.logging;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {

    @Before("execution(* com.triminds..*(..))")
    public void logExecution() {
        System.out.println("[LOG] Executando operação crítica");
    }
}