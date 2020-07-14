package io.outputStream;

import io.inputStream.TestInputStream;
import io.serializable.TestObj;

import java.io.*;

/**
 * @className: TestOutputStream
 * @description: TODO
 * @author: zyd
 * @date: 2020/7/14 20:41
 * @version: 1.0
 */
public class TestOutputStream {

    /**
     * 文件流，传说中的节点流
     * */
    public static void writeFile() {
        FileOutputStream outputStream = null;
        try {
            outputStream = new FileOutputStream(new File("D:\\TestObj.txt"));
            outputStream.write("很高兴认识你".getBytes());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
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
    }

    /**
     * 对象流，序列化，传说中的处理流
     * */
    public static void writeObject() {
        ObjectOutputStream outputStream1 = null;
        try {
            outputStream1 = new ObjectOutputStream(new FileOutputStream(new File("D:\\TestObj.txt")));
            TestObj testObj = new TestObj();
            testObj.setCode("C12345");
            testObj.setName("Test");
            outputStream1.writeObject(testObj);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (outputStream1 != null) {
                try {
                    outputStream1.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /**
     * 字节数组输出流转对象输出流
     * */
    public static void writeByteArray(byte[] bytes) {
        ObjectOutputStream outputStream1 = null;
        ByteArrayOutputStream outputStream = null;
        try {
            outputStream = new ByteArrayOutputStream();
            outputStream1 = new ObjectOutputStream(outputStream);
            outputStream.write(bytes);
            outputStream1.write(outputStream.toByteArray());
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (outputStream1 != null) {
                try {
                    outputStream1.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void main(String[] args) {
        /*TestOutputStream.writeFile();
        TestOutputStream.writeObject();*/
        TestOutputStream.writeByteArray(TestInputStream.readFile());
    }
}
