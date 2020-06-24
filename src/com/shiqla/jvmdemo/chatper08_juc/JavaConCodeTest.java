package com.shiqla.jvmdemo.chatper08_juc;

import org.junit.Test;

import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Desc ${DESC}
 * Auth c5285333
 * Date 2020-06-19
 */
public class JavaConCodeTest {

    public ReentrantLock reentrantLock = new ReentrantLock();


    @Test
    public void print_test(){
        Lock lock = new ReentrantLock(true);

        Thread threadA = new Thread(new PrintThread(lock),"A");
        Thread threadB = new Thread(new PrintThread(lock),"B");
        Thread threadC = new Thread(new PrintThread(lock),"C");
        threadA.start();
        threadB.start();
        threadC.start();

    }

    public void threadPool_test(){
        ExecutorService executorService = Executors.newFixedThreadPool(20);
        executorService.submit(new Runnable() {
            @Override
            public void run() {

            }
        });
    }


    public void testCallableThread(){
        FutureTask<String> futureTask = new FutureTask<>(new CallableThread());

        try {
            System.out.println("main thread id: " + Thread.currentThread().getId());

            new Thread(futureTask,"shiqla").start();

            System.out.println("results: " + futureTask.get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

    }


    public void concurrentHashMap_Test01() {
        reentrantLock.lock();
        System.out.println("test");
        test001();
        reentrantLock.unlock();
    }


    public synchronized void test001(){
        System.out.println("test");
    }


    public void TestVolatile(){
        TestVolatile testVolatile = new TestVolatile();
        Thread thread = new Thread(testVolatile);
        thread.start();

        while(true){
            if(testVolatile.isFlag()){
                System.out.println("----------");
                break;
            }
        }


        Thread t1 = new Thread(new TestVolatile(){
            public void run(){
                System.out.println("nihao");
            }
        });

        t1.start();
    }
}

class TestVolatile implements Runnable{

    private volatile boolean flag = false;

    private volatile AtomicInteger num = new AtomicInteger(0);

    @Override
    public void run() {

        num.incrementAndGet();
        num.addAndGet(1024);
        this.flag = true;

        System.out.println("flag = " + this.flag);
    }

    public boolean isFlag(){
        return this.flag;
    }

}

class CallableThread implements Callable<String> {

    @Override
    public String call() throws Exception {

//        Thread.sleep(50*1000);
        return "thread name : " + Thread.currentThread().getName() ;
    }
}

class PrintThread implements Runnable{


    private Lock lock;

    public PrintThread(Lock lock) {
        this.lock = lock;
    }

    @Override
    public void run() {
        for (int i = 0;i<5;i++){
            try {
                lock.lock();
                System.out.println(Thread.currentThread().getName());
            }finally {
                lock.unlock();
            }

        }

    }
}



