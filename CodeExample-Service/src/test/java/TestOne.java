import org.junit.jupiter.api.Test;

import java.util.List;


/**
 * 测试链接
 */
public class TestOne {

    @Test
    public void test1(){
        IChapterInterImpl  ChapterInterImpl = new IChapterInterImpl();
        List<Chapter> chapterList = ChapterInterImpl.getChapter("https://qixs.com/1813225/2320808999/");
        for (Chapter chapter : chapterList) {
            System.out.println(chapter);
        }
    }
    private static final int INIT_DATA=666;
    private static final BaseRequest baseRequest=new BaseRequest();

    public int compute(){
        int a=0;
        int b=2;
        int c=(a+b)*10;
        return c;
    }
    //栈(线程) 线程局部变量,本方法
    /**栈帧,有多个内存，一个方法对应栈帧内存区域
    *操作数栈
     *动态链接
     *方法出口
    * */
    //filo 先进后出 main() compute()
    public static void main(String[] arg0){
        TestOne testOne=new TestOne();
        testOne.compute();
        System.out.println("test");
    }
}

