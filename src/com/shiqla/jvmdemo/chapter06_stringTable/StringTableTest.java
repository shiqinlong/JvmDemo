package com.shiqla.jvmdemo.chapter06_stringTable;

import org.junit.Test;

import java.util.LinkedList;
import java.util.List;

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

    String str1 = "ni hao " + "asdfasdf";


    @Test
    public void test07(){

        for (int i = 0; i< 10000;i++){
            String.valueOf(i).intern();
        }
    }

    public void test06(){
        String s = new String("a") + new String("b");


        String s2 = s.intern(); //把s 对象的地址放入池中，并返回s的地址返回给s2


        System.out.println(s2 == "ab");// true
        System.out.println(s == "ab");//true
    }

    public void test05(){

        String s = new String("1");
        s.intern();

        String s2 = "1";
        System.out.println(s == s2);

        String str1 = new String("ab") + new String("cd");
        System.out.println(str1.hashCode());
        String str2 = str1;
        str1.intern();
        String str3 = "abcd";
        System.out.println(str1.hashCode());
        System.out.println(str1 == str2);

        System.out.println(str1 == str3);

    }


    public void test04() {
        final String a = "sfa";
        final String b = "123sdf";
        String c = "adfasdf";
        String d = a + b;
        String f = c + d;

    }


    public void test02_StringTableSize() {

        System.out.println("tgest");
        try {
            Thread.sleep(1000 * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


    public void test01(String str) {
        System.out.println(this.str.hashCode());
        str = "shi";
        System.out.println(str.hashCode());
    }

    public void test() {
        String str1 = "abc";
        String str2 = "abc";
        str1 = "hello";

        System.out.println(str1 == str2);
        System.out.println(str1);
        System.out.println(str2);
    }

    public static void test03() {
        System.out.println("1");
        System.out.println("2");
        System.out.println("3");
        System.out.println("4");
        System.out.println("5");
        System.out.println("6");
        System.out.println("7");

        System.out.println("1");
        System.out.println("2");
        System.out.println("3");
        System.out.println("4");
        System.out.println("5");
        System.out.println("6");
        System.out.println("7");


        String str = "asdkjf;alsndfai9sdjf;lkasdnjfl;ajsdk;lfnal;sdfl;ajsdfja;fn";
        List list = new LinkedList();

        while (true) {
            list.add(str);
            try {
                Thread.sleep(30);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }

    public static void main(String[] args) {
        StringTableTest.test03();
    }
}
