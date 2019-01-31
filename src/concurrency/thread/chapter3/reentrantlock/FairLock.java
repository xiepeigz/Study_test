package concurrency.thread.chapter3.reentrantlock;

import java.util.concurrent.locks.ReentrantLock;

/**
 * @Author:xiepei5
 * @Decription:
 * @Dete : 11:00 2019/1/16
 */
public class FairLock implements Runnable{
    public static ReentrantLock fairLock = new ReentrantLock(false);
    @Override
    public void run () {
        while(true){
            try{
                fairLock.lock();
                System.out.println(Thread.currentThread().getName() + "获得锁");
            }finally {
                fairLock.unlock();
            }
        }
    }

    public static void main ( String[] args ) throws InterruptedException{
        FairLock r1 = new FairLock();
        Thread t1 = new Thread(r1,"Thread_t1");
        Thread t2 = new Thread(r1,"Thread_t2");
        t1.start();t2.start();

    }
}
