package concurrency.thread.chapter3.reentrantlock;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

/**
 * @Author:xiepei5
 * @Decription:
 * @Dete : 11:26 2019/1/17
 */
public class SemapDemo implements Runnable {
    //允许5个线程进入
    final Semaphore semp = new Semaphore(5);
    @Override
    public void run () {
        try{
            semp.acquire();
            Thread.sleep(2000);
            System.out.println(Thread.currentThread().getName() + ":done!");
            semp.release();
        }catch(InterruptedException e){
            e.printStackTrace();
        }
    }

    public static void main ( String[] args ) {
        ExecutorService exec = Executors.newFixedThreadPool(20);
        final SemapDemo demo  = new SemapDemo();
        for(int i = 0;i<20;i++){
            exec.submit(demo);
        }
    }
}
