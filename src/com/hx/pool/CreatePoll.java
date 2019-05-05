package com.hx.pool;

import java.util.concurrent.*;

/**
 * Created  on 2019/05/05 - 17:05
 */
public class CreatePoll {
    public static void main(String[] args) {
        //一池五线程
        //ExecutorService servicePoll= Executors.newFixedThreadPool(5);
        //一池一线程
       // ExecutorService servicePoll= Executors.newSingleThreadExecutor();
        //一池n线程，由系统自动调度
        ExecutorService servicePoll= Executors.newCachedThreadPool();
        try{
            for (int i = 1; i < 20; i++) {
                int finalI = i;
                servicePoll.execute(() ->{
                    System.out.println(Thread.currentThread().getName()+"\t"+"处理"+ finalI +"号业务");
                });
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            servicePoll.shutdown();
        }
    }
}
