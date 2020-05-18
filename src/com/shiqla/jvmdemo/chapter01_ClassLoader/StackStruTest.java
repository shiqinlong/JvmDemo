package com.shiqla.jvmdemo.chapter01_ClassLoader;

import sun.misc.Launcher;

import java.net.URL;

/**
 * Desc
 * Auth c5285333
 * Date 2020-05-17
 */
public class StackStruTest
{


    private static  final Test01 test01 = new Test01("shiqinlong"){

        void init(String name){
            System.out.println("name + " + name);
        }
    };

    private static int num = 10;

    public static void main(String[] args){
        ClassLoader appClassLoader = ClassLoader.getSystemClassLoader();
        System.out.println(appClassLoader);

        ClassLoader extClassLoader = appClassLoader.getParent();
        System.out.println(extClassLoader);

        ClassLoader bootstrapClassLoader = extClassLoader.getParent();
        System.out.println(bootstrapClassLoader);

        System.out.println(StackStruTest.class.getClassLoader());

        System.out.println(String.class.getClassLoader());

        // 获取bootstrap 加载可以加载那些路径下的文件
        URL[] urls = Launcher.getBootstrapClassPath().getURLs();
        for (URL url : urls) {
            System.out.println(url);
        }

    }
}
