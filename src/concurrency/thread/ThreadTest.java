package concurrency.thread;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * @Author:xiepei5
 * @Decription:
 * @Dete : 10:36 2019/1/3
 */
public class ThreadTest {

//    public static void main(String[] args) {
//
//        Callable<Integer> myCallable = new MyCallable();    // 创建MyCallable对象
//        FutureTask<Integer> ft = new FutureTask<Integer>(myCallable); //使用FutureTask来包装MyCallable对象
//
//        for (int i = 0; i < 100; i++) {
//            System.out.println(Thread.currentThread().getName() + " " + i);
//            if (i == 30) {
//                Thread thread = new Thread(ft);   //FutureTask对象作为Thread对象的target创建新的线程
//                thread.start();                      //线程进入到就绪状态
//            }
//        }
//
//        System.out.println("主线程for循环执行完毕..");
//
//        try {
//            int sum = ft.get();            //取得新创建的新线程中的call()方法返回的结果
//            System.out.println("sum = " + sum);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        } catch (ExecutionException e) {
//            e.printStackTrace();
//        }
//
//    }

//        public static void main(String[] args) {
//            for (int i = 0; i < 100; i++) {
//                System.out.println(Thread.currentThread().getName() + " " + i);
//                if (i == 30) {
//                    Runnable myRunnable = new MyRunnable();
//                    Thread thread = new MyThread(myRunnable);
//                    thread.start();
//                }
//            }
//        }

//    public static void main ( String[] args ) {
//        for(int i = 0; i < 100; i++){
//            System.out.println(Thread.currentThread().getName() + " " + i);
//            if( i == 30){
//                Thread myThread1 = new MyThread();
//         //       Thread myThread2 = new MyThread();
//                myThread1.start();
//             //   myThread2.start();
//                try{
//                    myThread1.sleep(3000);
//                }catch (Exception e){
//                    e.printStackTrace();
//                }
//            }
//        }
//    }

/**
 *@Author: xiepei5
 *@Date：11:51 2019/1/7
 *@Method:
 *@MethodParam:
 *@MethodReturn:
 *@描述：线程安全典型用例
 */
    public static void main(String[] args) {
        Account account = new Account("123456", 1000);
        DrawMoneyRunnable drawMoneyRunnable = new DrawMoneyRunnable(account, 700);
        Thread myThread1 = new Thread(drawMoneyRunnable);
        Thread myThread2 = new Thread(drawMoneyRunnable);
        myThread1.start();
        myThread2.start();
    }
}
