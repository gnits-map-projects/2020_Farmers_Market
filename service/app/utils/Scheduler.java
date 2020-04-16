package utils;

import akka.actor.ActorSystem;
import scala.concurrent.ExecutionContext;
import scala.concurrent.duration.Duration;

import javax.inject.Inject;
import java.util.concurrent.TimeUnit;

public class Scheduler {

    private final ActorSystem actorSystem;
    private final ExecutionContext executionContext;

    @Inject
    public Scheduler(ActorSystem actorSystem, ExecutionContext executionContext) {
        this.actorSystem = actorSystem;
        this.executionContext = executionContext;

        this.initialize();
    }

    private void initialize() {
        this.actorSystem
                .scheduler()
                .schedule(
                        Duration.create(10, TimeUnit.SECONDS), // initialDelay
                        Duration.create(10, TimeUnit.MINUTES), // interval
                        () -> repetitiveTask(),
                        this.executionContext);
    }

    private void repetitiveTask() {
        System.out.println("############ TEST SCHEDULER ############");

    }
}