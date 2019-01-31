package concurrency.thread;

import java.util.concurrent.Callable;

/**
 * @Author:xiepei5
 * @Decription:
 * @Dete : 11:23 2019/1/3
 */
public class MyCallable implements Callable<Integer> {
    private int i = 0;
    @Override
    public Integer call () {
        int sum = 0;
        for (; i < 100; i++) {
            System.out.println(Thread.currentThread().getName() + " " + i);
            sum += i;
        }
        return sum;
    }
}
