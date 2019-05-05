package com.hx.implementsRunable;

/**
 * Created  on 2019/05/03.
 */
public class Thread1{

    public static void main(String[] args){
        MyThread t1=new MyThread();
        Thread thread1=new Thread(t1);
        Thread thread2=new Thread(t1);
        thread1.start();
        thread2.start();

    }

}

class MyThread  implements  Runnable{

    @Override
    public void run() {
        System.out.println("hello");
    }
}

