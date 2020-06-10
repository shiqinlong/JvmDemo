package com.shiqla.jvmdemo.chapter07_garbageCollection;

import org.junit.Test;

/**
 * Desc ${DESC}
 * Auth c5285333
 * Date 2020-06-07
 */
public class GarbageCollectionsTest {

    GarbageCollectionsTest garbageCollectionsTest ;


    private byte[] bytes = new byte[20*1024*1024];

    @Test
    public void finalzation_test_01(){

        garbageCollectionsTest = new GarbageCollectionsTest();

//        garbageCollectionsTest = null;

//        System.gc();

    }

    @Override
    protected void finalize() throws Throwable {

        System.out.println("对象被收回");
        super.finalize();
    }
}
