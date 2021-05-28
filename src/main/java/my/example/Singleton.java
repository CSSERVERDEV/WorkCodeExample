package my.example;
/**
 * 单例三种写法,
 *
 * @author zengsong
 * @version 1.0
 * @description
 * @date 2019/5/14 14:54
 **/
public class Singleton {
    /*双重检查加锁模式：
特点：性能又保证线程安全*/
    private static Singleton singleton;
    public Singleton(){}
    public static Singleton getInstance(){
        if(singleton==null){
            synchronized(Singleton.class) {
                if(singleton==null) {
                    singleton = new Singleton();
                }
            }
        }
        return singleton;
    }
}

/*饿汉式单例模式：
优点：线程安全
缺点：浪费内存空间*/
class Singleton1{
    private static final Singleton1 singleton1=new Singleton1();
    public Singleton1(){}
    public static Singleton1 getInstance(){
        return singleton1;
    }
}

/*懒汉式单例模式：
优点：延迟加载
缺点：不加同步的懒汉式是线程不安全的，加了synchronized之后就变成线程安全的了*/
class Singleton2{
    private static Singleton2 singleton2=null;
    public Singleton2(){}
    public static synchronized Singleton2 getInstance(){
        if(singleton2==null){
            singleton2=new    Singleton2();
        }
        return singleton2;
    }
}

