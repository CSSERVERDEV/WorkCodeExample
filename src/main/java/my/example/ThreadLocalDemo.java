package my.example;

/**
 * ThreadLocalDemo
 *
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

class Sing{
    private Sing sing=null;

    public Sing instnle(){
        if(sing==null){
            sing=new Sing();
        }
        return sing;
    }
}
