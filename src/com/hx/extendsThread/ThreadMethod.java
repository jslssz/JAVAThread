package com.hx.extendsThread;

/**
 * Created  on 2019/05/03.
 */
public class ThreadMethod {
    public static void main(String[] args){

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        Thread4 thread4=new Thread4("t1");
        //thread4.setName("线程一");
        thread4.start();

        for (int i = 0; i < 100; i++) {
            System.out.println(Thread.currentThread().getName()+" "+i);
        }

    }
}


class Thread4 extends Thread{
    /**
     * 构造方法，设置线程名字
     * @param name
     */
    public Thread4(String name){
        super(name);
    }

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            if (i % 2 == 0) {
                System.out.println(Thread.currentThread().getName()+" "+i);
            }
            /*if (i% 20==0){
                //挂起，放弃cpu的执行权
                yield();
            }*/

            if (i ==3){
                try {
                    join();//进入阻塞状态
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}