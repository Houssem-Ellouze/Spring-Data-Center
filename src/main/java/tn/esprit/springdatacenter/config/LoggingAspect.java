package tn.esprit.springdatacenter.config;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class LoggingAspect {
    private static final Logger log = LoggerFactory.getLogger(LoggingAspect.class);

    @After ("execution(public * tn.esprit.springdatacenter.service.ServiceImpl.*(..))")
    public void logAspectBefore(JoinPoint joinPoint) {
        log.info("fin execution");
    }

}
