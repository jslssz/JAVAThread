package com.hx.syncmethod;

/**
 * Created  on 2019/05/05 : 13:07
 */
public class Ticket7 {

    public static void main(String[] args) {
        ThreadTicket7 t1 = new ThreadTicket7("窗口一");
        ThreadTicket7 t2 = new ThreadTicket7("窗口二");
        ThreadTicket7 t3 = new ThreadTicket7("窗口三");

        t1.start();
        t2.start();
        t3.start();
    }
}


class ThreadTicket7 extends Thread {
    private static int ticket = 100;

    @Override
    public void run() {
       while (true){
           sale();
       }
    }

    public ThreadTicket7(String name){
        super(name);
    }

   // private synchronized void sale() {//默认锁是this  t1，t2，t3
    private static synchronized void sale() {//默认锁是Ticket7.class
        if (ticket > 0) {
            try {
                Thread.sleep(30);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + "售票" + ticket);
            ticket--;
        }
    }

}
