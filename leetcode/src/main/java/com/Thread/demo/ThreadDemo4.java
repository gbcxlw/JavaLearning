package com.Thread.demo;

import java.util.concurrent.*;

public class ThreadDemo4 implements Callable<Boolean> {
    public Boolean call() throws Exception {
        System.out.println("collable创建线程");
        return true;
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ThreadDemo4 threadDemo4 = new ThreadDemo4();
        //创建执行服务
        ExecutorService executorService = Executors.newFixedThreadPool(1);
        //提交执行，使用future保存结果
        Future<Boolean> res = executorService.submit(threadDemo4);

        boolean isTrue = res.get();
        //关闭
        executorService.shutdown();
    }
}
