package com.shiqla.jvmdemo.chatper08_juc;

import java.util.HashMap;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * Desc ${DESC}
 * Auth c5285333
 * Date 2020-07-01
 */
public class ReadAndWriterLockDemo {


    public static void main(String[] args){

        CacheDemo cacheDemo = new CacheDemo();
        ReentrantReadWriteLock reentrantReadWriteLock = new ReentrantReadWriteLock();

        for (int i=0;i<5;i++){
            final int tempvalue = i;
            new Thread(()->{
                reentrantReadWriteLock.writeLock().lock();
                try {
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(Thread.currentThread().getName() + " 写入值 " + tempvalue);
                    cacheDemo.put(tempvalue + "", tempvalue + "");
                    System.out.println(Thread.currentThread().getName() + " 写入完成");
                } finally {
                    reentrantReadWriteLock.writeLock().unlock();
                }
            },tempvalue+"").start();
        }

        for (int i = 0; i < 5; i++) {
            final int tempvalue = i;
            new Thread(() -> {
                reentrantReadWriteLock.readLock().lock();
                try {
                    try {
                        Thread.sleep(110);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(Thread.currentThread().getName() + " 读取值 " + cacheDemo.get(tempvalue + ""));
                } finally {
                    reentrantReadWriteLock.readLock().unlock();
                }
            }, tempvalue + "").start();
        }

        new Thread(()->{
            reentrantReadWriteLock.writeLock().lock();
            try {
                System.out.println(Thread.currentThread().getName() + " clear cache start");
                cacheDemo.clear();
                System.out.println(Thread.currentThread().getName() + " clear cache end");
            }finally {
                reentrantReadWriteLock.writeLock().unlock();
            }

        },"aa").start();
    }

}

class CacheDemo {
    private HashMap<String, String> cache = new HashMap<>();

    public String get(String key) {
        return cache.get(key);
    }

    public void put(String key, String value) {
        cache.put(key, value);
    }

    public void clear(){
        cache.clear();
    }
}