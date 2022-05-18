package com.xmg.io;

import java.io.*;

public class IO01 {
    //IO 测试类
    public static void main(String[] args) throws IOException {
//        File file = new File("D:/a.txt");
//        FileInputStream fileInputStream = new FileInputStream("D:/a.txt");
//        OutputStream outputStream = new FileOutputStream("D:/b.txt");
//        InputStream inputStream = null;
//
//        inputStream = fileInputStream;
//        int length = 0;
//        try {
//            length = inputStream.available();
//            byte[] buffer = new byte[length];
//            inputStream.read(buffer);
//            outputStream.write(buffer);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }

//        testInAndRe();
//        testDirect();

        redirectIn();
    }

    //输入输出设备与重定向
    private static void testInAndRe() {
        BufferedReader br = new BufferedReader(
                new InputStreamReader(System.in)
        );
        String read = null;
        System.out.println("input is:");
        try {
            read = br.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("output is:" + read);
    }

    private static void testDirect() throws FileNotFoundException {
        BufferedReader br = new BufferedReader(
                new InputStreamReader(System.in)
        );
        String read = null;
        System.out.println("input is:");
        try {
            read = br.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("output is:" + read);
        //将输出的内容写到文件中
        FileOutputStream fileOutputStream = new FileOutputStream("D:/a.txt");
        //bout对象包含了缓存向外写的内容
        BufferedOutputStream outputStream = new BufferedOutputStream(fileOutputStream);
        PrintStream ps = null;
        ps = new PrintStream(outputStream);
        //设置重定向
        System.setOut(ps);
        System.out.println("redirect to txt" + read);
        //需要加flush才会成功将内容输出到文件中
        ps.flush();
    }

    private static void redirectIn() throws IOException {
        FileInputStream fileInputStream = new FileInputStream("D:/a.txt");
        BufferedInputStream in = new BufferedInputStream(fileInputStream);
        System.setIn(in);
        DataInputStream ds = new DataInputStream(System.in);
        String s;
        while ((s = ds.readLine())!=null) {
            System.out.println(s);
        }
    }
}
