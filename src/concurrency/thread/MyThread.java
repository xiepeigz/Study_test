package concurrency.thread;

/**
 * @Author:xiepei5
 * @Decription:
 * @Dete : 10:32 2019/1/3
 */
public class MyThread  extends Thread{
    private int i = 0;
//    public  MyThread(Runnable runnable){
//        super(runnable);
//    }
    @Override
    public void run () {
        for( i =0; i < 100; i++){
            System.out.println(Thread.currentThread().getName() + " " + i);
        }
    }
}
