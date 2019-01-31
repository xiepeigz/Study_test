package concurrency.thread.chapter3.reentrantlock;

import java.util.concurrent.locks.ReentrantLock;

/**
 * @Author:xiepei5
 * @Decription:
 * @Dete : 10:33 2019/1/14
 * 重入锁：响应中断实现死锁效果
 */
public class IntLock implements Runnable{
    //重入锁ReentrantLock
    public static ReentrantLock lock1 = new ReentrantLock();
    public static ReentrantLock lock2 = new ReentrantLock();

    int lock;
    /**
     *@Author: xiepei5
     *@Date：10:36 2019/1/14
     *@Method:
     *@MethodParam:lock
     *@MethodReturn:
     *@描述：控制加锁顺序，方便构造死锁
     */
    public IntLock(int lock){
        this.lock = lock;
    }

    @Override
    public void run() {
        // TODO Auto-generated method stub
        try {
            if(lock==1){
                //lockInterruptibly 对锁的请求
                lock1.lockInterruptibly();
                Thread.sleep(500);
                System.out.println("lock1 do something at here");
                lock2.lockInterruptibly();
            }else{
                lock2.lockInterruptibly();
                Thread.sleep(500);
                System.out.println("lock2 do something at here");
                lock1.lockInterruptibly();
            }
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }finally{
            if(lock1.isHeldByCurrentThread()){
                lock1.unlock();//释放锁
            }
            if(lock2.isHeldByCurrentThread()){
                lock2.unlock();
            }
            System.out.println(Thread.currentThread().getId()+"：线程退出");
        }

    }
    public static void main(String[] args) throws InterruptedException {
        /**
         *@Author: xiepei5
         *@Date：10:58 2019/1/14
         *@Method: main
         *@MethodParam: [args]
         *@MethodReturn:void
         *@描述：
         * r1先占用lock1，再占用lock2;r2先占用lock2，再请求lock1。
         */
        IntLock r1 = new IntLock(1);
        IntLock r2 = new IntLock(2);
        Thread t1 = new Thread(r1);
        Thread t2 = new Thread(r2);
        t1.start();
        t2.start();
        Thread.sleep(1000);
        //t2线程被中断，放弃锁申请，释放已获得的lock2，这个操作使得t1线程顺利获得lock2继续执行下去；
        //若没有此段代码，t2线程没有中断，那么会出现t1获取lock1，请求lock2，而t2获取lock2，请求lock1的相互等待死锁情况
        t2.interrupt();
    }

}
