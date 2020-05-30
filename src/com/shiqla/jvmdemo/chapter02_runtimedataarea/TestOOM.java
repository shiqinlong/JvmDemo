package com.shiqla.jvmdemo.chapter02_runtimedataarea;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * ━━━━━━神兽出没━━━━━━
 * 　　　┏┓　　　┏┓
 * 　　┏┛┻━━━┛┻┓
 * 　　┃　　　　　　　┃
 * 　　┃　　　━　　　┃
 * 　　┃　┳┛　┗┳　┃
 * 　　┃　　　　　　　┃
 * 　　┃　　　┻　　　┃
 * 　　┃　　　　　　　┃
 * 　　┗━┓　　　┏━┛
 * 　　　　┃　　　┃  神兽保佑
 * 　　　　┃　　　┃  代码无bug
 * 　　　　┃　　　┗━━━┓
 * 　　　　┃　　　　　　　┣┓
 * 　　　　┃　　　　　　　┏┛
 * 　　　　┗┓┓┏━┳┓┏┛
 * 　　　　　┃┫┫　┃┫┫
 * 　　　　　┗┻┛　┗┻┛
 * ━━━━━━感觉萌萌哒━━━━━━
 * Desc ${DESC}
 * Auth c5285333
 * Date 2020-05-29
 */
public class TestOOM {

    public static void main(String[] args) throws InterruptedException {
        byte[] buffer;
        byte[]  buffer2;
        List list = new LinkedList();

        for(int i=0;i<1000;i++){
            buffer = new byte[1024*1024*5];
            list.add(buffer);
            Thread.sleep(1000*4);
//            if( i%5 == 0){
//                ((LinkedList) list).removeFirst();
//            }

            if(i == 5){
                buffer2 = new byte[2014*1024*100];
            }
        }
    }
}
