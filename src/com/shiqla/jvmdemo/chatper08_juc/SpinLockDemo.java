package com.shiqla.jvmdemo.chatper08_juc;

import java.sql.SQLOutput;
import java.util.concurrent.atomic.AtomicReference;

/**
 * Desc ${DESC}
 * Auth c5285333
 * Date 2020-07-01
 */
public class SpinLockDemo {

    // 原子包装类，底层采用voliate 和 原语来实现线程安全
    private AtomicReference<Thread> atomicReference = new AtomicReference<>(null);

    // get lock
    public void lock(){
        Thread thread = Thread.currentThread();
        while(!atomicReference.compareAndSet(null,thread)){

        }
    }


    //释放锁
    public void unlock(){
        atomicReference.compareAndSet(Thread.currentThread(),null);
    }
    
    
    public static void main(String[] args){
        SpinLockDemo spinLockDemo = new SpinLockDemo();


        new Thread(()->{
            spinLockDemo.lock();
            System.out.println(Thread.currentThread().getName() + " got a lock and sleep 5s");
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + " release a lock ");
            spinLockDemo.unlock();

        },"aa").start();

        new Thread(()->{
            spinLockDemo.lock();
            System.out.println(Thread.currentThread().getName() + " got a lock and sleep 5s");
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + " release a lock ");
            spinLockDemo.unlock();

        },"bb").start();

    }


}
