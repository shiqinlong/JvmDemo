package com.shiqla.jvmdemo.chapter06_stringtable;

import org.junit.Test;
import sun.jvm.hotspot.memory.StringTable;

/**
 * ━━━━━━神兽出没━━━━━━
 * 　　　┏┓　　　┏┓
 * 　　┏┛┻━━━┛┻┓
 * 　　┃　　　　　　 ┃
 * 　　┃　　　━　　　┃
 * 　　┃　┳┛　┗┳　  ┃
 * 　　┃　　　　　　 ┃
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
 * Date 2020-06-03
 */
public class StringTableTest {

    String str = "good";


    @Test
    public void test02_StringTableSize(){

        System.out.println("tgest");
        try {
            Thread.sleep(1000*1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


    public void test01(String str){
        System.out.println(this.str.hashCode());
        str = "shi";
        System.out.println(str.hashCode());
    }

    public void test(){
        String str1 = "abc";
        String str2 = "abc";
        str1 = "hello";

        System.out.println(str1 == str2);
        System.out.println(str1);
        System.out.println(str2);
    }
}
