package com.xmg.io;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;

public class NIO02 {

    public static void main(String[] args) throws IOException {
        mappedDemo();
    }

    public static void mappedDemo() throws IOException {
        int length = 1024*1024*10;
        MappedByteBuffer out = new RandomAccessFile("D:/a.txt","rw")
                .getChannel().map(FileChannel.MapMode.READ_WRITE,0,length);

        for(int i=0;i<length;i++){
            out.put((byte)'a');
        }

        for(int i=0;i<10;i++){
            System.out.println((char)out.get(i));
        }

    }
}
