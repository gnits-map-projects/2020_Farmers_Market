package utils;

import com.google.inject.AbstractModule;

public class SchedulerModule extends AbstractModule {

    @Override
    protected void configure() {
        bind(Scheduler.class).asEagerSingleton();
    }
}