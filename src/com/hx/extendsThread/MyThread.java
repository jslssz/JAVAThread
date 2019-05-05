package com.hx.extendsThread;

/**
 * Created  on 2019/05/03.
 */
public class MyThread extends Thread {

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            if (i % 2 == 0) {
                System.out.println(i);
            }
        }
    }

    public static void main(String[] args) {
        MyThread myThread = new MyThread();
        //正确调用方式
        myThread.start();
        //错误调用方式,只是调用方法而已，还是main线程
        // myThread.run();
    }
}
