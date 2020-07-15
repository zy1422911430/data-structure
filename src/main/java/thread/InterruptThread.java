package thread;

/**
 * @className: InterruptThread
 * @description: TODO
 * @author: zyd
 * @date: 2020/7/15 17:15
 * @version: 1.0
 */
public class InterruptThread extends Thread {

    @Override
    public void run() {
        super.run();
        //this.interrupt();
        /*System.out.println("run interrupt status1:" + Thread.interrupted());
        System.out.println("run interrupt status2:" + Thread.interrupted());*/
        int i = 0;
        while (i < 50000) {
            if (Thread.interrupted())
                break;
            System.out.println(i);
            i++;
        }
        System.out.println("退出啦！！！");
    }
}
