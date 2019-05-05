package com.hx.extendsThread;

/**
 * Created  on 2019/05/03.
 */
public class Ticket {

    public static void main(String[] args){
        ThreadTicket t1=new ThreadTicket("窗口1");
        ThreadTicket t2=new ThreadTicket("窗口2");
        ThreadTicket t3=new ThreadTicket("窗口3");
        t1.start();
        t2.start();
        t3.start();
    }

}

class ThreadTicket extends Thread{
    private static  int  ticket=100;


   public ThreadTicket(String name){
        super(name);
    }
    @Override
    public void run() {
        while (true){
            if (ticket<=0){
                break;
            }
            System.out.println(Thread.currentThread().getName()+"售票"+ticket);
            ticket --;
        }
    }
}