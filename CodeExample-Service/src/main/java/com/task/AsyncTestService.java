package com.task;

/**
 * @author zengsong
 * @date 2021/1/2817:10
 */
public interface AsyncTestService {
    /**
     * 这里将会在impl里标注为异步任务，在执行此方法的时候，会单独开启线程来执行
     */

    void function1() throws InterruptedException;


    void function2();
}
