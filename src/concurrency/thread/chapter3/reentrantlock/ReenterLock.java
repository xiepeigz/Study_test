package concurrency.thread.chapter3.reentrantlock;

import java.util.concurrent.locks.ReentrantLock;

/**
 * @Author:xiepei5
 * @Decription:
 * @Dete : 11:09 2019/1/11
 */
public class ReenterLock implements Runnable {
    public static ReentrantLock lock = new ReentrantLock();
    public static int i = 0;
    @Override
    public void run () {
        for( int j  = 0; j < 10000000; j++){
            /**
             *@Author: xiepei5
             *@Date：11:31 2019/1/11
             *@Method: run
             *@MethodParam: []
             *@MethodReturn:void
             *@描述：使用重入锁保护临界区资源i
             */
            lock.lock();
            //一个线程可以添加多个重入锁，相对应一个就应该释放多次锁。
            lock.lock();
            try {
                i++;
            }finally {
                lock.unlock();
                lock.unlock();
            }
        }
    }

    public static void main ( String[] args ) throws InterruptedException{
        ReenterLock reenterLock = new ReenterLock();
        Thread thread1 = new Thread(reenterLock);
        Thread thread2 = new Thread(reenterLock);
        thread1.start();thread2.start();
        thread1.join();thread2.join();
        System.out.println(i);
    }
}
