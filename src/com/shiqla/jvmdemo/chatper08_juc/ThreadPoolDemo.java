package com.shiqla.jvmdemo.chatper08_juc;

import java.util.concurrent.*;

/**
 * Desc ${DESC}
 * Auth c5285333
 * Date 2020-07-02
 */
public class ThreadPoolDemo {
    public static void main(String[] args){

        ExecutorService executorService = new ThreadPoolExecutor(10, 10, 0L, TimeUnit.SECONDS,
                new LinkedBlockingQueue<>(1000),
                Executors.defaultThreadFactory(),
                new ThreadPoolExecutor.CallerRunsPolicy());

        try {

            for (int i=0;i< 3000;i++){
                final int j = i;
                executorService.submit(()->{
                    try {
                        Thread.sleep(10000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(Thread.currentThread().getId() + "  " + j);
                });
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            executorService.shutdown();
        }

    }
}
