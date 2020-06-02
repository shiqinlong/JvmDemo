package com.shiqla.jvmdemo.chapter04_directMemory;

import java.nio.ByteBuffer;
import java.util.ArrayList;
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
 * Date 2020-06-01
 */
public class DirectMemoryTest {

    public static final int size = 1024*1024*100;

    public static void main(String[] args){
        DirectMemoryTest.directMemoryTest();
    }


    /**
     * the direct memory area will be throws a oom exception
     * java.lang.OutOfMemoryError: Direct buffer memory
     */
    public static void directMemoryTest() {

        List list = new ArrayList<>();
        int count = 0;
        try {
            while (true) {

                ByteBuffer byteBuffer = ByteBuffer.allocateDirect(size);
                count++;
                list.add(byteBuffer);
                try {
                    Thread.sleep(50);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        } finally {
            System.out.println(count);
        }
    }
}
