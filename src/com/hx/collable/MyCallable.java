package com.hx.collable;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * Created  on 2019/05/05 - 16:11
 */
public class MyCallable {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        Callable1 callable1=new Callable1();
        FutureTask task = new FutureTask(callable1);
        Thread thread=new Thread(task);
        thread.start();
        Object o = task.get();
        System.out.println(o);

    }
}

class Callable1 implements Callable{

    @Override
    public Object call() throws Exception {
        int count=0;
        for (int i = 1; i <= 100; i++) {
            if (i%2 ==0){
                count+=i;
            }
        }
        return count;
    }
}
