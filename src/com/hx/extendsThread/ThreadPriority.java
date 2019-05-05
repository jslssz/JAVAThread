package com.hx.extendsThread;

/**
 * Created  on 2019/05/03.
 */
public class ThreadPriority {
    public static void main(String[] args){

        Thread5 thread5=new Thread5();
        thread5.setPriority(Thread.MIN_PRIORITY);
        thread5.start();

        Thread.currentThread().setPriority(Thread.MAX_PRIORITY);
        System.out.println(Thread.currentThread().getPriority());
    }
}


class Thread5 extends  Thread{
    @Override
    public void run() {
        System.out.println("hello");
    }
}