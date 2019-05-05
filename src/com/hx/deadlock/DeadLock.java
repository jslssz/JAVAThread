package com.hx.deadlock;

/**
 * Created  on 2019/05/05 : 14:03
 */
public class DeadLock implements Runnable{
    Aa aa=new Aa();
    Bb bb=new Bb();
    

    public void  init(){
        Thread.currentThread().setName("主线程");
        aa.foo(bb);
        System.out.println("进入主线程");
    }
    @Override
    public void run() {
        Thread.currentThread().setName("副线程");
        // 调用b对象的bar方法
        bb.bar(aa);
        System.out.println("进入了副线程");
    }

    public static void main(String[] args){
        DeadLock dl = new DeadLock();
        new Thread(dl).start();
        dl.init();
    }
}

class Aa{
    public synchronized void foo(Bb bb){//同步监视器：Aa类的对象：aa
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("当前线程的名字："+Thread.currentThread().getName()+"，企图调用bb的last（）方法");
        bb.last();
    }

    public synchronized void last() {//同步监视器：A类的对象：a
        System.out.println("进入了A类的last方法内部");
    }

}

class Bb{
    public synchronized void bar(Aa aa){//同步监视器：Bb类的对象：bb
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("当前线程的名字："+Thread.currentThread().getName()+"，企图调用aa的last（）方法");
        aa.last();
    }
    public synchronized void last() {//同步监视器：bb
        System.out.println("进入了B类的last方法内部");
    }

}
