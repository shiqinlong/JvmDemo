package com.shiqla.jvmdemo.chatper08_juc.juc_day01;

/**
 * Desc ${DESC}
 * Auth c5285333
 * Date 2020-06-19
 */
public class TestVolatile {



    public static void main(String[] args){
        TestDemo testDemo = new TestDemo();

        Thread thread = new Thread(testDemo);
        thread.start();

        while (true) {
            if (testDemo.isFlag()) {
                System.out.println("----------------");
                break;
            }
        }

    }

}
class TestDemo implements Runnable{


    private volatile boolean flag = false;


    @Override
    public void run() {

        try {
            Thread.sleep(200);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        this.flag = true;
        System.out.println("flag = " + this.flag);
    }

    public boolean isFlag(){
        return this.flag;
    }
}