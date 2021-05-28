import org.junit.jupiter.api.Test;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;

import java.util.concurrent.Future;

/**
 * @author zengsong
 * @date 2021/1/28 16:46
 */
public class TestThreadExecutorPool {
//    @Test
//    public void test3() throws Exception {
//        System.out.println("main函数开始执行");
//        longtime();
//        System.out.println("main函数执行结束");
//    }
//
//    @Async
//    public void longtime() {
//        System.out.println("我在执行一项耗时任务");
//        try {
//            Thread.sleep(5000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//        System.out.println("完成");
//
//    }

    @Test
    public void test4() throws Exception {
        System.out.println("main函数开始执行");
        Future<Integer> future=longtime2();
        System.out.println("main函数执行结束");
        System.out.println("异步执行结果："+future.get());
    }

    @Async
    public Future<Integer> longtime2() {
        System.out.println("我在执行一项耗时任务");
        try {
            Thread.sleep(8000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("完成");
        return new AsyncResult<>(3);
    }
}
