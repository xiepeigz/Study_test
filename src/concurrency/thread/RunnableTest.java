package concurrency.thread;

/**
 * @Author:xiepei5
 * @Decription:
 * @Dete : 10:47 2019/1/3
 */
public class RunnableTest {
    public static void main ( String[] args ) {
        for(int i = 0; i < 100; i++){
            System.out.println(Thread.currentThread().getName() + " " + i);
            if( i == 30){
                Runnable myRunnable = new MyRunnable();
                Thread myThread1 = new Thread(myRunnable);
                Thread myThread2 = new Thread(myRunnable);
                myThread1.start();
                myThread2.start();
            }
        }
    }

}
