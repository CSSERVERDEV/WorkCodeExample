package my.example;

/**
 * ThreadLocal相对于每一个线程自己使用的本地变量
 * java线程池
 * @author zengsong
 * @version 1.0
 * @description
 * @date 2019/4/28 10:24
 **/
public class ThreadLocalDemo {
        private static ThreadLocal<String> threadLocal = new ThreadLocal<String>(){
            @Override
            protected String initialValue() {
                return "hello";
            }
        };
        static class MyRunnable implements Runnable{
            private int num;
            public MyRunnable(int num){
                this.num = num;
            }
            @Override
            public void run() {
                threadLocal.set(String.valueOf(num));
                System.out.println("threadLocalValue:"+threadLocal.get());
            }
        }

        public static void main(String[] args){
            new Thread(new MyRunnable(1));
            new Thread(new MyRunnable(2));
            new Thread(new MyRunnable(3));
        }
}
/**
 * 父线程生成的变量需要传递到子线程中进行使用
 * InheritableThreadLocal每当新开个线程，创建新的ThreadLocalMap与Entry，遍历原线程Entry[]，直接塞到新entry里（浅拷贝），
 *  key为原ThreadLocal对象（ThreadLocal需要全局唯一），value为原值。
 *  TransmittableThreadLocal，就是为解决线程池内传递变量
 */
class IdThreadLocal extends Thread{
    //方法拦截器这权限休验set数值
    private static  InheritableThreadLocal<Long> idLocal;
    static{
        idLocal = new InheritableThreadLocal<Long>();
    }
//    public static Long getId() {
//        Long id = idLocal.get();
//        return id;
//    }
//
//    public static void setId(Long id) {
//        idLocal.set(id);
//    }

    public static InheritableThreadLocal<String> inheritableThreadLocal=new InheritableThreadLocal<>();
    public void main(String[] arg0)throws Exception{
        inheritableThreadLocal.set("主线程赋值");
        new IdThreadLocal().start();
        Thread.sleep(3000);
    }
    @Override
    public void run(){
        System.out.println(inheritableThreadLocal.get());
    }
}
