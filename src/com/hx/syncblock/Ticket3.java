package com.hx.syncblock;

/**
 * Created  on 2019/05/05 : 11:09
 */

/**
 * 采用同步代码块的方式来解决implements Runnable线程安全问题，但是所对象要唯一
 */
public class Ticket3 {
    public static void main(String[] args){
        ThreadTicket1 threadTicket1=new ThreadTicket1();
        Thread t1=new Thread(threadTicket1,"窗口一");
        Thread t2=new Thread(threadTicket1,"窗口二");
        Thread t3=new Thread(threadTicket1,"窗口三");
        t1.start();
        t2.start();
        t3.start();
    }
}


class ThreadTicket1 implements Runnable{
    private int  ticket=100;

    @Override
    public void run() {
        while (true){
            synchronized (ThreadTicket1.class){
                if (ticket<=0){
                    break;
                }
                System.out.println(Thread.currentThread().getName()+"售票"+ticket);
                ticket --;
            }
        }
    }
}
