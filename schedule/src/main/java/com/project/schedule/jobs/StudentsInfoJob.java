package com.project.schedule.jobs;

import org.quartz.Job;
import org.quartz.JobDataMap;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.stereotype.Component;

@Component
public class StudentsInfoJob implements Job {

    @Override
    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        JobDataMap dataMap = jobExecutionContext.getJobDetail().getJobDataMap();
        String studentsAmountOnTopology = dataMap.getString("studentsAmountOnTopology");
        System.out.println("Amount of students on Topology is:" + studentsAmountOnTopology);
    }
}
