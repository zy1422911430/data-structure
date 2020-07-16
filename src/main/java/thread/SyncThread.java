package thread;

/**
 * @className: SyncThread
 * @description: TODO
 * @author: zyd
 * @date: 2020/7/15 21:23
 * @version: 1.0
 */
public class SyncThread {

    synchronized public void print2() {
        while (true) {
            System.out.println("卡死了2");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void print1(Object object) {
        synchronized (object) {
            while (true) {
                System.out.println("卡死了1");
                try {
                    Thread.sleep(10000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                return;
            }
        }
    }
}
