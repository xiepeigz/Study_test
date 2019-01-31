package concurrency.thread.chapter3.reentrantlock;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Author:xiepei5
 * @Decription:
 * @Dete : 11:25 2019/1/16
 */
public class ReenterLockCondition implements Runnable {
    public static ReentrantLock lock  = new ReentrantLock();
    //通过lock生成一个与之绑定的Condition对象.
    public static Condition condition = lock.newCondition();
    @Override
    public void run () {
        try{
            lock.lock();
            /**
             * await 使当前线程等待，同时释放当前锁！！！，当其他线程中使用signal()或者signalAll()方法时，
             * 线程会重新获得锁并继续执行。或者当线程被中断时，也能跳出等待。
             */
            condition.await();
            System.out.println("Thread is going on ");
        }catch (InterruptedException e){
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }

    public static void main ( String[] args )throws InterruptedException {
        ReenterLockCondition tlc = new ReenterLockCondition();
        Thread t1 = new Thread(tlc);
        t1.start();
        Thread.sleep(2000);
        lock.lock();
        //通知线程可以运行，线程需要重新获取锁
        condition.signal();
        //
        /**
         * unlock配合singal使用，释放锁让线程能够获取锁
         *疑问：当使用signalAll时，如何释放？
         */
       lock.unlock();
    }
}
