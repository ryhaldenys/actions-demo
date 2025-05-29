package com.jobservice.util;

import com.jobservice.entity.Job;
import lombok.experimental.UtilityClass;

@UtilityClass
public class EntityUtil {
    public static Job getJob(){
        var job = new Job();
        job.setCompany("company");
        job.setSkills("java");
        job.setSalary(1000);
        job.setRemote(false);
        job.setDescription("description");
        return job;
    }
}
