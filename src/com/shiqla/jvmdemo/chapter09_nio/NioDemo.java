package com.shiqla.jvmdemo.chapter09_nio;

import sun.nio.ch.FileChannelImpl;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.ShortBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Desc
 * Auth c5285333
 * Date 2020-07-08
 */
public class NioDemo
{
    public static void main (String[] args) throws IOException
    {

        ExecutorService executorService = Executors.newFixedThreadPool(30);

        ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();

        serverSocketChannel.configureBlocking(false);

        serverSocketChannel.bind(new InetSocketAddress(9898));

        Selector selector = Selector.open();

        serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);

        while (selector.select() > 0) {
            Iterator<SelectionKey> iterator = selector.selectedKeys().iterator();
            while (iterator.hasNext()) {
                SelectionKey selectionKey = iterator.next();

                if (selectionKey.isAcceptable()) {
                    SocketChannel socketChannel = serverSocketChannel.accept();
                    socketChannel.configureBlocking(false);
                    socketChannel.register(selector, SelectionKey.OP_READ);
                }
                else if (selectionKey.isReadable()) {
                    SocketChannel socketChannel = (SocketChannel)selectionKey.channel();

                    //采用多线程执行IO操作，主线程避免阻塞
                    executorService.submit(()->{
                       ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
                       while(true){
                           try {
                               if (!(socketChannel.read(byteBuffer) > 0))
                                   break;
                           }
                           catch (IOException e) {
                               e.printStackTrace();
                           }

                       }

                    });
                }
                iterator.remove();
            }
        }

    }

}
