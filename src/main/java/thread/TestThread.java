package thread;

/**
 * @className: TestThread
 * @description: TODO
 * @author: zyd
 * @date: 2020/7/15 16:16
 * @version: 1.0
 */
public class TestThread {

    public static void main(String[] args) {
       /*MyThread myThread = new MyThread();
        myThread.setName("myThread");
        myThread.start();*/
        //构造 Thread.currentThread().getName():main      //main 执行当前实例化的线程是main线程
        //构造 Thread.currentThread().isAlive():true
        //构造 this.getName():Thread-0                    //Thread-0 线程初始化时，会默认赋值一个"Thread-" + nextThreadNum()
        //构造 this.isAlive():false                       //false 当前线程还未启动
        //run Thread.currentThread().getName():myThread   //myThread 当前线程是myThread自己启动的，所以currentThread为自己
        //run Thread.currentThread().isAlive():true
        //run this.getName():myThread                     //myThread 代表当前线程
        //run this.isAlive():true
        //this == Thread.currentThread() ? true


        /*MyThread myThread = new MyThread();
        myThread.setName("myThread");
        Thread thread = new Thread(myThread);
        thread.setName("newThread");
        thread.start();*/
        //构造 Thread.currentThread().getName():main
        //构造 Thread.currentThread().isAlive():true
        //构造 this.getName():Thread-0
        //构造 this.isAlive():false
        //run Thread.currentThread().getName():newThread    启动当前线程的线程为newThread
        //run Thread.currentThread().isAlive():true
        //run this.getName():myThread
        //run this.isAlive():false
        //this == Thread.currentThread() ? false

        /*InterruptThread interruptThread = new InterruptThread();
        interruptThread.start();
        try {
            Thread.sleep(200);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        interruptThread.interrupt();*/

        SyncThread syncThread = new SyncThread();
        SyncThread2 syncThread2 = new SyncThread2();
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                syncThread.print1(syncThread2);
            }
        });
        thread.start();

        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                syncThread2.print();
            }
        });
        thread1.start();
    }
}
