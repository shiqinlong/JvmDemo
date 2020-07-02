package com.shiqla.jvmdemo.chatper08_juc;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Desc ${DESC}
 * Auth c5285333
 * Date 2020-07-01
 */
public class BlockingQueueDemo {

    public static void main(String[] args) {
        final ShareData shareData = new ShareData();

        new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                shareData.increment();
            }
        }, "aa").start();

        new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                shareData.decrease();
            }
        }, "bb").start();
    }
}

class ShareData{

    private int number = 0;

    private Lock lock =  new ReentrantLock();
    private Condition condition = lock.newCondition();


    public void increment(){

      lock.lock();
      try {
          System.out.println(Thread.currentThread().getName() + " 开始增加货物");
          while(this.number != 0){
              System.out.println(Thread.currentThread().getName() + " 货柜已满，等待拿货");
              this.condition.await();
          }
          this.number++;
          System.out.println(Thread.currentThread().getName() + "货物增加完成，通知拿货");
          this.condition.signal();
      } catch (Exception e) {
          e.printStackTrace();
      } finally {
          lock.unlock();
      }
    }

    public void decrease (){
        lock.lock();
        try {
            System.out.println(Thread.currentThread().getName() + " 开始拿取货物");
            while(this.number == 0){
                System.out.println(Thread.currentThread().getName() + " 货柜为空，等待增加货物");
                this.condition.await();
            }
            this.number --;
            System.out.println(Thread.currentThread().getName() + " 拿货完成，通知增加货物");
            this.condition.signal();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

}