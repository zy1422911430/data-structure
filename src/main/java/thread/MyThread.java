package thread;

/**
 * @className: MyThread
 * @description: TODO
 * @author: zyd
 * @date: 2020/7/15 15:56
 * @version: 1.0
 */
public class MyThread extends Thread {

    public MyThread() {
        System.out.println("构造 Thread.currentThread().getName():" + Thread.currentThread().getName());
        System.out.println("构造 Thread.currentThread().isAlive():" + Thread.currentThread().isAlive());
        System.out.println("构造 this.getName():" + this.getName());
        System.out.println("构造 this.isAlive():" + this.isAlive());
    }

    @Override
    public void run() {
        super.run();
        System.out.println("run this.getName():" + this.getName());
        System.out.println("run this.isAlive():" + this.isAlive());
        System.out.println("run Thread.currentThread().getName():" + Thread.currentThread().getName());
        System.out.println("run Thread.currentThread().isAlive():" + Thread.currentThread().isAlive());
        System.out.println("this == Thread.currentThread() ? " + (this == Thread.currentThread()));
    }
}
