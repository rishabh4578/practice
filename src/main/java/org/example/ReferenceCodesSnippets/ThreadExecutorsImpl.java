package org.example.ReferenceCodesSnippets;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class ThreadExecutorsImpl {

    static final ExecutorService threadPool = Executors.newFixedThreadPool(10);
    static final ScheduledExecutorService scheduledExecutor = Executors.newSingleThreadScheduledExecutor();

    public static void main(String[] args) {
        threadPool.execute(() ->
                System.out.println("Fixed thread pool service")
        );

        scheduledExecutor.scheduleAtFixedRate(() ->
                        System.out.println("Fixed thread pool service"),
                100,
                50,
                TimeUnit.SECONDS);
    }


}
