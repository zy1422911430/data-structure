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

    /**
     * TODO 字符输入流

     * @return void
     * @author zyd
     * @date 11:21 2020/7/15
     **/
    public static void inputStreamReader() {
        InputStreamReader reader = null;
        try {
            Long start = System.currentTimeMillis();
            reader = new InputStreamReader(new FileInputStream(new File("D:\\TestObj.txt")), "utf-8");
            char[] chars = new char[2];
            int c = 0;
            while ((c = reader.read(chars)) != -1) {
                //System.out.print(new String(chars, 0 , c));
            }
            Long end = System.currentTimeMillis();
            System.out.println(end - start);
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
    }

    /**
     * TODO 文件输入流

     * @return void
     * @author zyd
     * @date 11:21 2020/7/15
     **/
    public static void fileReader() {
        FileReader fileReader = null;
        try {
            Long start = System.currentTimeMillis();
            fileReader = new FileReader(new File("D:\\TestObj.txt"));
            char[] chars = new char[2];
            int c = 0;
            while ((c = fileReader.read(chars)) != -1) {
                //System.out.print(new String(chars, 0, c));
            }
            Long end = System.currentTimeMillis();
            System.out.println(end - start);
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

    /**
     * TODO 缓冲字符输入流

     * @return void
     * @author zyd
     * @date 11:23 2020/7/15
     **/
    public static void bufferedReader() {
        BufferedReader bufferedReader = null;
        try {
            Long start = System.currentTimeMillis();
            bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(new File("D:\\TestObj.txt"))));
            char[] chars = new char[2];
            int b = 0;
            while ((b = bufferedReader.read(chars)) != -1) {
                //System.out.print(new String(chars, 0, b));
            }
            Long end = System.currentTimeMillis();
            System.out.println(end - start);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (bufferedReader != null) {
                try {
                    bufferedReader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void main(String[] args) {
        /**
         * 经过多次对比，得出结论缓存输入流速度快于输入流和文件输入流
         **/
        TestReader.inputStreamReader();
        TestReader.fileReader();
        TestReader.bufferedReader();
    }
}
