package io.serializable;

import java.io.*;

/**
 * @className: TestSerializable
 * @description: TODO
 * @author: zyd
 * @date: 2020/7/14 11:05
 * @version: 1.0
 */
public class TestSerializable {

    public static void main(String[] args) {
        TestObj testObj = null;
        ObjectOutputStream outputStream = null;
        try {

            outputStream = new ObjectOutputStream(new FileOutputStream(new File("D:\\TestObj.txt")));
            testObj = new TestObj();
            testObj.setCode("C12345");
            testObj.setName("Test");
            outputStream.writeObject(testObj);
            outputStream.flush();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (outputStream != null) {
                try {
                    outputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        TestObj inputObj = null;
        ObjectInputStream inputStream = null;
        try {
            inputStream = new ObjectInputStream(new FileInputStream(new File("D:\\TestObj.txt")));
            inputObj = (TestObj) inputStream.readObject();
            System.out.println(inputObj.toString());
            System.out.println(inputObj == testObj);

        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
