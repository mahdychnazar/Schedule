package com.project.schedule.jobs;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.Marker;
import org.apache.logging.log4j.MarkerManager;
import org.quartz.Job;
import org.quartz.JobDataMap;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.stereotype.Component;

@Component
public class DBToLoggerJob implements Job {

    private static final Marker ADMIN_USER = MarkerManager.getMarker("ADMIN");
    private static final Logger logger = LogManager.getLogger(DBToLoggerJob.class);

    @Override
    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        JobDataMap dataMap = jobExecutionContext.getJobDetail().getJobDataMap();
        String studentData = dataMap.getString("studentService");
        String courseData = dataMap.getString("courseService");
        logger.info(ADMIN_USER,studentData);
        logger.info(ADMIN_USER,courseData);
        System.out.println("Data successfully written in logger.");
    }
}
