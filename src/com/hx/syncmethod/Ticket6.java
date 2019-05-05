package com.hx.syncmethod;


/**
 * Created  on 2019/05/05 : 11:52
 */
public class Ticket6 {

    public static void main(String[] args) {
        ThreadTicket6 ticket6 = new ThreadTicket6();
        Thread t1 = new Thread(ticket6, "窗口1");
        Thread t2 = new Thread(ticket6, "窗口2");
        Thread t3 = new Thread(ticket6, "窗口3");
        t1.start();
        t2.start();
        t3.start();
    }

}

class ThreadTicket6 implements Runnable {
    private int ticket = 100;

    @Override
    public void run() {
        while (true) {
            sale();
        }
    }


    private synchronized void sale() {
        if (ticket > 0) {
            System.out.println(Thread.currentThread().getName() + "售票" + ticket);
            ticket--;
        }
    }
}
