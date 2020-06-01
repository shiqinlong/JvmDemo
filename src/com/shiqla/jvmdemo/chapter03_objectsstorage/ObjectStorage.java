package com.shiqla.jvmdemo.chapter03_objectsstorage;

/**
 * Desc ${DESC}
 * Auth c5285333
 * Date 2020-06-01
 */
public class ObjectStorage {

    int num = 100;
    public String name = "siq";
    Object object;

    public static void main(String[] args){
        Object object = new Object();
        System.out.println(new ObjectStorage().name);
    }

    {
        name = "shiqinlong";
    }

    public ObjectStorage(){
        this.name = "caiwenmin";
    }



}
