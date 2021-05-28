package my.example;

/**
 * 有A,B,C三个线程, A线程输出A, B线程输出B, C线程输出C，要求, 同时启动三个线程, 按顺序输出ABC, 循环10次。
 * 要按顺序输出ABC, 循环10次，就要控制三个线程同步工作，也就是说要让三个线程轮流输出，直到10个ABC全部输出则结束线程。这里用一个Lock对象来控制三个线程的同步。
 * 用一个int型变量COUNT标识由那个线程输出。
 * @author zengsong
 * @date 2021/4/8 12:04
 */
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class PrintABC {
  private static int cnd=0;
  private static final int condition=30;
  public static void main(String[] agr0){
      Lock lock=new ReentrantLock();
      Thread threadA=new Thread(new Runnable(){
          public void run(){
              while (true) {
                  lock.lock();
                  if(cnd>=condition){
                      lock.unlock();
                      return;
                  }else if(cnd%3==0){
                      System.out.println("A");
                      cnd++;
                  }
                  lock.unlock();
              }
          }
      });
      Thread threadB=new Thread(new Runnable(){
          public void run(){
              while (true){
                  lock.lock();
                  if(cnd>=condition){
                      lock.unlock();
                      return;
                  }else if(cnd%3==1){
                      System.out.println("B");
                      cnd++;
                  }
                  lock.unlock();
              }
          }
      });
      Thread threadC=new Thread(new Runnable() {
          @Override
          public void run() {
              while (true){
                  lock.lock();
                  if(cnd>=condition){
                      lock.unlock();
                      return;
                  }else if(cnd%3==2){
                      System.out.println("C");
                      cnd++;
                  }
                  lock.unlock();
              }
          }
      });
      threadA.start();
      threadB.start();
      threadC.start();
  }
}
