package com.hx.uselock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created  on 2019/05/05 : 14:33
 */
public class Ticket8 {
    public static void main(String[] args){
        MyThread thread=new MyThread();
        Thread t1=new Thread(thread,"窗口一");
        Thread t2=new Thread(thread,"窗口二");
        Thread t3=new Thread(thread,"窗口三");
        t1.start();
        t2.start();
        t3.start();
    }
}

class MyThread implements  Runnable{
    private int ticket=100;
    Lock lock=new ReentrantLock();
    @Override
    public void run() {
        while (true){
            try {
                lock.lock();
                if (ticket>0){
                    System.out.println(Thread.currentThread().getName()+"\t卖出"+ticket+"号票");
                    ticket --;
                    try {
                        Thread.sleep(50);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }else {
                    break;
                }
            }finally {
                lock.unlock();
            }
        }
    }
}
