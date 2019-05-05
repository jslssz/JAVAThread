package com.hx.syncblock;

/**
 * Created  on 2019/05/05 : 11:32
 */
public class Ticket4 {
    public static void main(String[] args){
       ThreadTicket5 t1=new ThreadTicket5("窗口1");
       ThreadTicket5 t2=new ThreadTicket5("窗口2");
       ThreadTicket5 t3=new ThreadTicket5("窗口3");
        t1.start();
        t2.start();
        t3.start();
    }

}

class ThreadTicket5 extends Thread{
    private static   int  ticket=100;


    public ThreadTicket5(String name){
        super(name);
    }
    @Override
    public void run() {
        while (true){
            synchronized (Ticket4.class){
                if (ticket<=0){
                    break;
                }
                System.out.println(Thread.currentThread().getName()+"售票"+ticket);
                ticket --;
            }
        }
    }
}
