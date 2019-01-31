package concurrency.thread;

/**
 * @Author:xiepei5
 * @Decription:
 * @Dete : 10:46 2019/1/3
 */
public class MyRunnable implements Runnable{
    int i = 0;
    @Override
    public void run () {
        for( i =0; i < 100; i++){
            System.out.println(Thread.currentThread().getName() + " " + i);
        }
    }
}
