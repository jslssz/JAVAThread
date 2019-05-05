package com.hx.communication;

/**
 * Created  on 2019/05/05 - 15:15
 *
 * 交替打印数字
 */
public class Communication {
   public static void main(String[] args) {
       NumberThread thread = new NumberThread();
       Thread t1 = new Thread(thread, "线程甲");
       Thread t2 = new Thread(thread, "线程乙");
       t1.start();
       t2.start();
   }

}

class NumberThread implements Runnable{

    private int num=1;

    @Override
    public void run() {
        while (true){
            synchronized (this){
                notify();//唤醒其他线程
                if (num<=100){
                    System.out.println(Thread.currentThread().getName()+"\t"+num);
                    num++;
                }else {
                    break;
                }
                try {
                    wait();//挂起自己
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
