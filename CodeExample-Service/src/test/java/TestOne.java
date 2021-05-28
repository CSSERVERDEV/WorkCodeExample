import com.task.AsyncTestService;
import com.task.AsyncTestServiceImpl;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Optional;


/**
 * 测试链接
 */
public class TestOne {

    @Test
    public void test1(){
        IChapterInterImpl  ChapterInterImpl = new IChapterInterImpl();
        List<Chapter> chapterList = ChapterInterImpl.getChapter("http://www.biqiuge8.com/book/24276/");
        for (Chapter chapter : chapterList) {
            System.out.println(chapter);
            Optional.ofNullable(chapter).orElse(chapter);
            Optional.ofNullable(chapter).get();
            if(Optional.ofNullable(chapter).isPresent()){

            }
            Optional.ofNullable(chapter).ifPresent(p -> System.out.println("年龄"+p.getTitle()));
            Optional.ofNullable(chapter).filter(p -> p.getTitle()=="");
            String optTitle= Optional.ofNullable(chapter).map(p -> chapter.getTitle()).orElse("title为空");
            System.out.println(optTitle);
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
    @Test
    public void test() throws InterruptedException {
//        for (int i = 0; i < 10; i++) {
//            asyncTestService.function1(); // 执行异步任务
//            asyncTestService.function2();
//        }
        AsyncTestService asyncTestService=new AsyncTestServiceImpl();
        asyncTestService.function1(); // 执行异步任务
        asyncTestService.function2();

    }
}

