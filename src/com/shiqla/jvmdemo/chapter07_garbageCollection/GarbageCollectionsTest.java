package com.shiqla.jvmdemo.chapter07_garbageCollection;

import org.junit.Test;

import javax.sound.midi.Soundbank;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Desc ${DESC}
 * Auth c5285333
 * Date 2020-06-07
 */
public class GarbageCollectionsTest {

    GarbageCollectionsTest garbageCollectionsTest ;


    private byte[] bytes = new byte[20*1024*1024];

    public void finalzation_test_01(){

        garbageCollectionsTest = new GarbageCollectionsTest();

//        garbageCollectionsTest = null;

//        System.gc();

    }

    @Override
    protected void finalize() throws Throwable {

        System.out.println("对象被收回");
        super.finalize();
    }

    @Test
    public void threadPoolTest(){

        ExecutorService executors = Executors.newFixedThreadPool(100);

        for (int i=0;i<100;i++){
            executors.submit(new Runnable() {
                @Override
                public void run() {
                    try {
                        Thread.sleep(1000*500);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            });
        }

        System.out.println("test");


    }
}
