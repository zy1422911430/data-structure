package io.inputStream;

import io.serializable.TestObj;

import java.io.*;

/**
 * @className: TestInputStream
 * @description: TODO
 * @author: zyd
 * @date: 2020/7/14 20:24
 * @version: 1.0
 */
public class TestInputStream {
    /**
     *文件输入流
     */
    public static byte[] readFile() {
        FileInputStream inputStream = null;
        try {
            inputStream = new FileInputStream(new File("D:\\TestObj.txt"));
            byte[] bytes = new byte[2];
            int b = 0;
            while ((b = inputStream.read(bytes)) != -1) {
                System.out.print(new String(bytes, 0, b));
            }
            return bytes;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
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
        return null;
    }

    /**
     *对象输入流
     */
    public static void readObject() {
        ObjectInputStream inputStream = null;
        try {
            inputStream = new ObjectInputStream(new FileInputStream(new File("D:\\TestObj.txt")));
            TestObj testObj = (TestObj) inputStream.readObject();
            System.out.println(testObj.toString());
        } catch (IOException | ClassNotFoundException e) {
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

    /**
     *数据流转对象流
     */
    public static void readData() {
        DataInputStream inputStream = null;
        ObjectInputStream objectInputStream = null;
        try {
            inputStream = new DataInputStream(new FileInputStream(new File("D:\\\\TestObj.txt")));
            byte[] bytes = new byte[1024];
            inputStream.read(bytes);
            objectInputStream = new ObjectInputStream(new ByteArrayInputStream(bytes));
            TestObj testObj = (TestObj) objectInputStream.readObject();
            System.out.println(testObj.toString());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            if (objectInputStream != null) {
                try {
                    objectInputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /**
     * TODO 缓存流读取
     
     * @return void        
     * @author zyd
     * @date 21:38 2020/7/14
     **/
    public static void bufferedRead() {
        BufferedInputStream inputStream = null;
        try {
            inputStream = new BufferedInputStream(new FileInputStream(new File("D:\\\\TestObj.txt")));
            byte[] bytes = new byte[2];
            int b = 0;
            while ((b = inputStream.read(bytes)) != -1) {
                System.out.print(new String(bytes, 0, b));
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
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

    public static void main(String[] args) {
        //TestInputStream.readFile();
        //TestInputStream.readObject();
        //TestInputStream.readData();
        TestInputStream.bufferedRead();
    }
}
