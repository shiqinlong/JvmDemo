package com.shiqla.jvmdemo.chatper08_juc;

import org.junit.Test;
import sun.misc.Unsafe;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * Desc ${DESC}
 * Auth c5285333
 * Date 2020-06-29
 */
public class SingletonTest {



    @Test
    public void test_03(){

        try {
            long valueoffest =  Unsafe.getUnsafe().objectFieldOffset(AtomicInteger.class.getDeclaredField("value"));
            System.out.println(valueoffest);
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        }
    }



    private static SingletonTest instance = null;

    private SingletonTest(){
        System.out.println( Thread.currentThread().getName() +"  create singleton object");
    }

    public static SingletonTest getInstance(){
       if(instance == null){
           synchronized ("lock"){
               if(instance == null){
                   instance = new SingletonTest();
               }
           }
       }
       return instance;
    }

    static class InstanceInner{
        private static SingletonTest instance = new SingletonTest();
    }

    public void test_01(){

        for(int i=0;i<200;i++){
            new Thread(()->{
                SingletonTest.getInstance();
            },i+"").start();
        }
    }

}
