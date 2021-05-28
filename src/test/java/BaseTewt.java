import java.util.Arrays;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.UUID;

/**
 *
 * @author zengsong
 * @date 2021/2/17 14:54
 */
public class BaseTewt {
    private static void ffd(){
        String s1 = "abc"; //s1 -> #1 Constants pool
        String s2 = new String("abc");//s2 -> #2 new String( #1)
        s2.intern(); //s2 引用没有变化，s2.intern()返回已经存在的#1
        System.out.println(s1 == s2);
    }
    public static void main(String[] arg0){
//        ffd();
//        System.out.println(Thread.currentThread().getName() + "   " + UUID.randomUUID().toString());
        try{
            throwNPE();
        }catch (RuntimeException e ){
            System.out.println(e.getMessage());
        }
//        for (;;) {
//            System.out.println("1111111111111111");
//        }
        System.out.println(Integer.MAX_VALUE);
    }
    private static void  throwNPE(){
//        Arrays.sort()
//        String 覆盖了equals（）方法和hashcode,而Stringbuffer,将java集合当对象存储会有问题,
        throw new NullPointerException("Throw");
    }
}
