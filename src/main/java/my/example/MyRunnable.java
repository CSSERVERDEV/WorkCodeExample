package my.example;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * MyRunnable
 *
 * @author zengsong
 * @version 1.0
 * @description
 * @date 2019/5/21 10:03
 **/
public class MyRunnable implements Runnable{
    @Override
    public void run() {
        for(int i=0 ;i<100;i++){
            System.out.println(Thread.currentThread().getName()+"");
        }
    }
    static class  MyThread extends Thread{
        public MyThread(String in){
            super(in);
        }

        @Override
        public void run() {
            System.out.println(Thread.currentThread().getName());
        }
    }
    public static void main(String[] args) {
        ExecutorService pool3 = Executors.newFixedThreadPool(2);
        pool3.execute(new MyThread("t1"));
        pool3.execute(new MyThread("t2"));
        pool3.execute(new MyThread("t3"));
        pool3.execute(new MyThread("t4"));
        pool3.shutdown();

        ExecutorService pool2 = Executors.newFixedThreadPool(3);
        pool2.submit(new MyRunnable());
        pool2.submit(new MyRunnable());
        pool2.shutdownNow();
    }
}

