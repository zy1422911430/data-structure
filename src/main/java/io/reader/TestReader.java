package io.reader;

import java.io.*;

/**
 * @className: TestReader
 * @description: TODO
 * @author: zyd
 * @date: 2020/7/14 15:30
 * @version: 1.0
 */
public class TestReader {

    public static void main(String[] args) {
        InputStreamReader reader = null;
        try {
            reader = new InputStreamReader(new FileInputStream(new File("D:\\TestObj.txt")), "utf-8");
            char[] chars = new char[1024];
            reader.read(chars);
            System.out.println(new String(chars).trim());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        FileReader fileReader = null;
        try {
            fileReader = new FileReader(new File("D:\\TestObj.txt"));
            char[] chars = new char[1024];
            fileReader.read(chars);
            System.out.println(new String(chars).trim());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fileReader != null) {
                try {
                    fileReader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
