package org.yourotherleft.fortunetwitter.task;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.yourotherleft.fortunetwitter.service.FortuneService;
import org.yourotherleft.fortunetwitter.service.type.Fortune;

@Component
public class FortuneHeartbeatScheduledTask implements Runnable {

    private final static Logger logger = LoggerFactory.getLogger(FortuneHeartbeatScheduledTask.class);

    private final FortuneService fortuneService;

    @Autowired
    public FortuneHeartbeatScheduledTask(@Qualifier("fortuneShell") final FortuneService fortuneService) {
        this.fortuneService = fortuneService;
    }

    @Override
    @Scheduled(cron = "${fortune.heartbeat.task.cron.expression}")
    public void run() {
        final Fortune fortune = fortuneService.getFortune();
        logger.info("finished heartbeat task, generated fortune {}", fortune);
    }

}
