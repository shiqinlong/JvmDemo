package com.shiqla.jvmdemo.chapter07_garbageCollection;

import org.junit.Test;

import javax.sound.midi.Soundbank;
import java.lang.ref.SoftReference;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Desc ${DESC}
 * Auth c5285333
 * Date 2020-06-07
 */
public class GarbageCollectionsTest {

    GarbageCollectionsTest garbageCollectionsTest ;


//    private byte[] bytes = new byte[20*1024*1024];


    @Test
    public void softReference_test_02() throws InterruptedException {


//        // create a new soft reference object;
//        SoftReference<char[]> softReference = new SoftReference<>(new char[1024*1024*20]);
//
//        System.out.println(softReference.get().length);
//        char[] buff = new char[1024*1024*20];
////        System.gc();
//        System.out.println(softReference.get().length);
        System.out.println(GarbageCollectionsTest.class.getClassLoader());
        System.out.println(String.class.getClassLoader());

        System.out.println(Runtime.getRuntime().maxMemory()/1024/1024/1024);

        Thread.sleep(1000*10000);
    }



    public void finalzation_test_01(){

        garbageCollectionsTest = new GarbageCollectionsTest();

//        garbageCollectionsTest = null;

//        System.gc();

        try {
            Class clzz = GarbageCollectionsTest.class.getClassLoader().loadClass("java.lang.String");
            try {
               String str = (String) clzz.newInstance();
                str = "nihao";
                System.out.println(str);

            } catch (InstantiationException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

    }

    @Override
    protected void finalize() throws Throwable {

        System.out.println("对象被收回");
        super.finalize();
    }

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
