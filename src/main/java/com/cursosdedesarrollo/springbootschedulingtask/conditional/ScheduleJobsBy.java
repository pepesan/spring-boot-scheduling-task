package com.cursosdedesarrollo.springbootschedulingtask.conditional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
public class ScheduleJobsBy {

    private final static Logger LOG = LoggerFactory.getLogger(ScheduleJobsBy.class);

    // sólo cuando se lanza el perfil "prod"
    @Profile("prod")
    @Bean
    public ScheduledJob scheduledJob()
    {
        return new ScheduledJob("@Profile");
    }
}
