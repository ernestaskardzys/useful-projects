package info.ernestas.quartzexample.job;

import info.ernestas.quartzexample.service.InternalService;
import lombok.RequiredArgsConstructor;
import org.quartz.DisallowConcurrentExecution;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
@DisallowConcurrentExecution
public class SecondJob implements Job {

    private static final Logger LOGGER = LoggerFactory.getLogger(SecondJob.class);

    private final InternalService internalService;

    @Override
    public void execute(JobExecutionContext context) throws JobExecutionException {
        LOGGER.info("Executing second job");
        internalService.secondService();
    }

}
