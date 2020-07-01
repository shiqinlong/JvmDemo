package com.shiqla.jvmdemo.chatper08_juc;

import java.util.concurrent.CountDownLatch;

/**
 * Desc ${DESC}
 * Auth c5285333
 * Date 2020-07-01
 */
public class CountDownLatchDemo {


    public static void main(String[] args){
        CountDownLatch countDownLatch = new CountDownLatch(6);

       for (int i=0;i<6;i++){
           final int num = i;
           new Thread(()->{
               try {
                   Thread.sleep(200);
               } catch (InterruptedException e) {
                   e.printStackTrace();
               }
               System.out.println( Counter.getCounter(Integer.valueOf(Thread.currentThread().getName())).getMessage() +"被灭了");
               countDownLatch.countDown();
           },String.valueOf(num)).start();
       }

        try {
            countDownLatch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("统一全国");
    }
}

enum Counter{
    QI(0,"齐国"),
    CHU(1,"楚国"),
    YAN(2,"燕国"),
    ZHAO(3,"赵国"),
    WEI(4,"魏国"),
    HAN(5,"韩国");

    private int code;
    private String message;

    Counter(int code,String message){
        this.code = code;
        this.message = message;
    }

    public static Counter getCounter(int code){

        for (Counter value : Counter.values()) {

            if(value.code == code){
                return value;
            }
        }
        return null;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
