package info.ernestas.quartzexample.config;

import info.ernestas.quartzexample.job.FirstJob;
import info.ernestas.quartzexample.job.SecondJob;
import org.quartz.JobBuilder;
import org.quartz.JobDetail;
import org.quartz.Trigger;
import org.quartz.TriggerBuilder;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import static org.quartz.SimpleScheduleBuilder.simpleSchedule;

@Configuration
public class SchedulingConfiguration {

    @Bean
    public JobDetail firstJobDetail() {
        return JobBuilder.newJob().ofType(FirstJob.class)
                .storeDurably()
                .withIdentity("FirstJob_Detail")
                .withDescription("Invoking First Job")
                .build();
    }

    @Bean
    public Trigger firstTrigger(@Qualifier("firstJobDetail") JobDetail job) {
        return TriggerBuilder.newTrigger().forJob(job)
                .withIdentity("FirstJob_Trigger")
                .withDescription("First Job trigger")
                .withSchedule(simpleSchedule().repeatForever().withIntervalInSeconds(10))
                .build();
    }

    @Bean
    public JobDetail secondJobDetail() {
        return JobBuilder.newJob().ofType(SecondJob.class)
                .storeDurably()
                .withIdentity("SecondJob_Detail")
                .withDescription("Invoking Second Job")
                .build();
    }

    @Bean
    public Trigger trigger(@Qualifier("secondJobDetail") JobDetail job) {
        return TriggerBuilder.newTrigger().forJob(job)
                .withIdentity("SecondJob_Trigger")
                .withDescription("Second Job trigger")
                .withSchedule(simpleSchedule().repeatForever().withIntervalInSeconds(30))
                .build();
    }

}
