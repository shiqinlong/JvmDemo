package com.shiqla.jvmdemo.chatper08_juc;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

/**
 * Desc
 * <p>
 * 创建线程4种方式
 * extend Thread
 * implements Runnable
 * implements Callable
 * ThreadPoolExecutor
 * Auth c5285333
 * Date 2020-07-02
 */
public class ThreadDemo {


    @Test
    public void test01() {

        List<Future<Integer>> list = new ArrayList();

        ExecutorService executorService = Executors.newFixedThreadPool(1000);


        for (int i = 0; i < 1000; i++) {
           Future<Integer> future = executorService.submit(new Callable<Integer>(){

               @Override
               public Integer call() throws Exception {
                   int number = 0;
                   for (int j = 0;j<1000;j++){
                       Thread.sleep(5);
                       number += j;
                   }
                   return number;
               }
           });
           list.add(future);
        }

        int result = 0;

        for (Future<Integer> futureTask : list) {
                if(futureTask.isDone()){
                    try {
                        result += futureTask.get();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    } catch (ExecutionException e) {
                        e.printStackTrace();
                    }
                    list.remove(futureTask);
                }
        }
        System.out.println("执行结果: " + result);
    }


    public static void main(String[] args) {
        FutureTask<String> futureTask = new FutureTask<>(new Thread02());

        new Thread(futureTask).start();
        try {
            System.out.println(futureTask.get());

        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }

}

class Thread01 implements Runnable {

    @Override
    public void run() {

    }
}


class Thread02 implements Callable<String> {

    @Override
    public String call() throws Exception {
        Thread.sleep(5000);
        return "shiqinlong";
    }
}