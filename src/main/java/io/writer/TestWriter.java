package io.writer;

import io.serializable.TestObj;

import java.io.*;

/**
 * @className: TestWriter
 * @description: TODO
 * @author: zyd
 * @date: 2020/7/14 15:34
 * @version: 1.0
 */
public class TestWriter {

    public static void writer() {
        OutputStreamWriter writer = null;
        try {
            //处理流，将字节流转为字符流
            writer = new OutputStreamWriter(new FileOutputStream(new File("D:\\TestObj.txt")));
            writer.write("123456");
            writer.flush();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (writer != null) {
                try {
                    writer.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void bufferedWriter() {
        BufferedWriter writer = null;
        try {
            writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(new File("D:\\TestObj.txt"))));
            writer.write("123456");
            writer.flush();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (writer != null) {
                try {
                    writer.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void main(String[] args) {

    }
}
