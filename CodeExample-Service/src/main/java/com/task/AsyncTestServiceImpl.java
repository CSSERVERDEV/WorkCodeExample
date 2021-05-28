package com.task;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.UUID;

/**
 * @author zengsong
 * @date 2021/1/2817:11
 */
@Service
public class AsyncTestServiceImpl implements  AsyncTestService {
    /**
     * 这里进行标注为异步任务，在执行此方法的时候，会单独开启线程来执行
     */
    @Async("function2")
    public void function1() throws InterruptedException {
        System.out.println("f1 : " + Thread.currentThread().getName() + "   " + UUID.randomUUID().toString());
//        try {
//            Thread.sleep(10000);
//            System.out.println("EEEE");
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }

        //故意等10秒，那么异步线程开起来，这样明显看到 2方法不用等1方法执行完再调用了
        Thread.sleep(10000);
        System.out.println("EEEE");
}

    @Async("function2")
    public void function2() {
        System.out.println("f2 : " + Thread.currentThread().getName() + "   " + UUID.randomUUID().toString());
        try {
            Thread.sleep(1000);
            System.out.println("aaaa");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
