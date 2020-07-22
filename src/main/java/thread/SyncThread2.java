package thread;

/**
 * @className: SyncThread2
 * @description: TODO
 * @author: zyd
 * @date: 2020/7/16 21:25
 * @version: 1.0
 */
public class SyncThread2 {

    synchronized public void print() {
        while (true) {
            System.out.println("Thread2 卡住了");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
