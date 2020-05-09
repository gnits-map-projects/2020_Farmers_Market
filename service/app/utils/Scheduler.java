package utils;

import akka.actor.ActorSystem;
import controllers.CropController;
import scala.concurrent.ExecutionContext;
import scala.concurrent.duration.Duration;

import javax.inject.Inject;
import java.util.concurrent.TimeUnit;

public class Scheduler {

    private final ActorSystem actorSystem;
    private final ExecutionContext executionContext;

    private final CropController cropController;

    @Inject
    public Scheduler(ActorSystem actorSystem, ExecutionContext executionContext, CropController cropController) {
        this.actorSystem = actorSystem;
        this.executionContext = executionContext;

        this.initialize();

        this.cropController = cropController;
    }

    private void initialize() {
        this.actorSystem
                .scheduler()
                .schedule(
                        Duration.create(10, TimeUnit.SECONDS), // initialDelay
                        Duration.create(1, TimeUnit.DAYS), // interval
                        () -> repetitiveTask(),
                        this.executionContext);
    }

    private void repetitiveTask() {
        cropController.remind(); //5 days before crop end date
        System.out.println("############ TEST SCHEDULER ############");

    }
}