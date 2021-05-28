package my.example;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author zengsong
 * @date 2021/4/811:14
 */
public class ABCThread {
    private int cond=0;
    private Lock lock=new ReentrantLock();
    //condition其实是等待队列的一个管理者，condition确保阻塞的对象按顺序被唤醒。
    private Condition condition=lock.newCondition();

    public static void main(String[] agro){
        ABCThread abcThread=new ABCThread();
        A a=abcThread.new A();
        B b=abcThread.new B();
        C c=abcThread.new C();
        ExecutorService executor= Executors.newFixedThreadPool(3);
        for(int i=0;i<3;i++){
            executor.execute(a);
            executor.execute(b);
            executor.execute(c);
        }
        executor.shutdown();
    }
    class A implements Runnable{
        public void run(){
            lock.lock();
            try{
                while (true){
                    if(cond%3==0){
                        System.out.println(cond+"A");
                        cond++;
                        condition.signalAll();
                        break;
                    }else{
                        try{
                        condition.await();
                        } catch (InterruptedException e) {
                            e.printStackTrace();

                        }
                    }
                }
            }finally {
                lock.unlock();
            }
        }
    }
    class B implements Runnable{
        public void run(){
            lock.lock();
            try {
            while (true){
                if(cond%3==1){
                    System.out.println(cond+"B");
                    cond++;
                    condition.signalAll();
                    break;
                }else{
                    try{
                    condition.await();
                    } catch (InterruptedException e) {
                        e.printStackTrace();

                    }
                }
            }
            }finally {
                lock.unlock();
            }
        }
    }
    class C implements Runnable{
        public void run(){
            lock.lock();
            try {
                while (true) {
                    if (cond % 3 == 2) {
                        System.out.println(cond + "C");
                        cond++;
                        //唤醒所有线程
                        condition.signalAll();
                        break;
                    } else {
                        //释放锁
                         try{
                            condition.await();
                        } catch (InterruptedException e) {
                            e.printStackTrace();

                        }
                    }
                }
            }finally {
                lock.unlock();
            }
        }
    }

}
