package com.hx.implementsRunable;

/**
 * Created  on 2019/05/03.
 */
public class Ticket2 {
    public static void main(String[] args){
        MyThread2 t1=new MyThread2();

        Thread thread1=new Thread(t1,"窗口1");
        Thread thread2=new Thread(t1,"窗口2");
        Thread thread3=new Thread(t1,"窗口3");
        thread1.start();
        thread2.start();
        thread3.start();

    }

}

class MyThread2 implements Runnable{

    private volatile int  ticket=100;
    @Override
    public synchronized void run() {
        while (true){
            if (ticket<=0){
                break;
            }
            System.out.println(Thread.currentThread().getName()+"售票"+ticket);
            ticket --;
        }
    }
}
