package main.java.task4.scheduler;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;

/**
 * PlannedTaskExecutor class
 * used to plan and start {@link SendSMSWithTemperatureTask}
 */
public class PlannedTaskExecutor {

    private static final Logger LOG = Logger.getLogger(PlannedTaskExecutor.class.getName());
    private static final Integer INITIAL_DELAY_IN_MINUTES = 0;
    private static final Integer PERIOD_OF_EXECUTION_IN_MINUTES = 10;
    private static final Integer ONE_HUNDRED_MINUTES_IN_MILLIS = 6000000;

    /**
     * executePlannedTask method
     * method functionality is to repeat 10 times
     * {@link SendSMSWithTemperatureTask} with 10 minutes interval
     * and then to finish scheduler execution
     */
    public static void executePlannedTask() {
        ScheduledExecutorService executorService = Executors.newScheduledThreadPool(1);
        executorService.scheduleAtFixedRate(
                new SendSMSWithTemperatureTask(),
                INITIAL_DELAY_IN_MINUTES,
                PERIOD_OF_EXECUTION_IN_MINUTES,
                TimeUnit.MINUTES);
        LOG.info("Executor service started");
        long start = System.currentTimeMillis();
        long end = start + ONE_HUNDRED_MINUTES_IN_MILLIS;
        while (System.currentTimeMillis() < end) ;
        executorService.shutdown();
        LOG.info("Executor has been terminated");
    }
}
