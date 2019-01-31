package concurrency.thread.chapter3.reentrantlock;

import java.util.concurrent.locks.ReentrantLock;

/**
 * @Author:xiepei5
 * @Decription:
 * @Dete : 10:13 2019/1/16
 */
public class TimeLock implements Runnable {
    public static ReentrantLock lock = new ReentrantLock();
    @Override
    public void run () {
        try{
            //if( lock.tryLock( 5, TimeUnit.SECONDS)){
            if( lock.tryLock()){
                //第一个获取锁的线程睡眠了6s 故后面进来的线程等待5秒后获取线程失败
                Thread.sleep(6000);
            }else{
                System.out.println("get lock failed");
            }
        }catch ( InterruptedException e){
            e.printStackTrace();
        }
    }

    public static void main ( String[] args ) {
        TimeLock tl = new TimeLock();
        Thread t1 = new Thread(tl);
        Thread t2 = new Thread(tl);
        t1.start();
        t2.start();
    }
}
