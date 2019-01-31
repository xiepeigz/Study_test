package concurrency.thread.chapter3.reentrantlock;

import java.util.concurrent.locks.ReentrantLock;

/**
 * @Author:xiepei5
 * @Decription:采用了非常容易死锁的加锁顺序。也就是先让t1获得lock1,再让t2获得lock2,接着反向请求。
 * 使用trylock()后，可以改善该情况
 * @Dete : 10:38 2019/1/16
 */
public class TryLock implements  Runnable{
    public ReentrantLock lock1 = new ReentrantLock();
    public ReentrantLock lock2 = new ReentrantLock();
    int lock;
    public TryLock( int lock){
        this.lock = lock;
    }

    @Override
    public void run () {
        if(lock == 1){
            while (true){
                if(lock1.tryLock()){
                    try{
                        try{
                            Thread.sleep(500);
                        }catch ( InterruptedException e ){

                        }
                        if(lock2.tryLock()){
                            try{
                                System.out.println(Thread.currentThread().getId() + ":My job done");
                                return;
                            }finally {
                                lock2.unlock();
                            }
                        }
                    }finally {
                        lock1.unlock();
                    }

                }
            }
        }else{
            while(true){
                if(lock2.tryLock()){
                    try{
                        try{
                            Thread.sleep(500);
                        }catch (InterruptedException e){

                        }
                    if(lock1.tryLock()){
                        try{
                            System.out.println(Thread.currentThread().getId() + ":My job done");
                            return;
                        }finally {
                            lock1.unlock();
                        }
                    }
                    }finally {
                        lock2.unlock();
                    }
                }
            }
        }
    }

    public static void main ( String[] args ) {
        TryLock  r1 = new TryLock(1);
        TryLock r2 = new TryLock(2);
        Thread t1 = new Thread(r1);
        Thread t2 = new Thread(r2);
        t1.start();
        t2.start();

    }
}
