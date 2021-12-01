package com.project.schedule.Aspects;

import com.project.schedule.ScheduleApplication;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.Marker;
import org.apache.logging.log4j.MarkerManager;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Aspect
@Component
public class Aspects {

    private static final Logger logger = LogManager.getLogger(ScheduleApplication.class);
    private static final Marker MARKER = MarkerManager.getMarker("marker");


    @Around("@annotation(com.project.schedule.Aspects.LogTime)")
    public Object methodTime(ProceedingJoinPoint point) throws Throwable {

        long startTime = System.currentTimeMillis();
        Object result = point.proceed();
        long finishTime = System.currentTimeMillis();

        logger.warn(MARKER,"[ASPECT_LOGGING] Method: {}() had been working for {} ms",
                point.getSignature().getName(),
                (finishTime-startTime));

        return result;
    }


    @Around("@annotation(com.project.schedule.Aspects.LogParams)")
    public Object methodParams(ProceedingJoinPoint point) throws Throwable {

        Object result = point.proceed();

        logger.warn(MARKER,"[ASPECT_LOGGING] Method: {}() Arguments = {}, Result = {}",
                point.getSignature().getName(),
                Arrays.toString(point.getArgs()),
                result);

        return result;
    }
}