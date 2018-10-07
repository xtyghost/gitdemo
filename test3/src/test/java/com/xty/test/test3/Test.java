/**
 * Copyright (C), 2015-2018, XXX有限公司
 * FileName: Test
 * Author:   xutong
 * Date:     2018/9/29 5:27 PM
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.xty.test.test3;

import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * 〈一句话功能简述〉<br>
 * 〈〉
 *
 * @author xutong
 * @create 2018/9/29
 * @since 1.0.0
 */
public class Test {
    private static ReentrantLock Lock = new ReentrantLock();
    private static Condition condition1 = Lock.newCondition();
    private static Condition condition2 = Lock.newCondition();
    private static String constants="   : ";

    public static void main(String[] args) throws InterruptedException {
        AtomicInteger x=new AtomicInteger(1);

//       condition.signal();
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(10, 20, 1, TimeUnit.SECONDS, new LinkedBlockingDeque<>());
        threadPoolExecutor.execute(() -> {
            for (int i = 0; i < 100; i++) {

                try {
                    Lock.lock();
                    condition1.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }finally {
                    Lock.unlock();
                }
                System.out.println(System.getenv());
                System.out.println(Thread.currentThread().getName()+constants+x.incrementAndGet());
                condition1.signalAll();

            }
        });
        threadPoolExecutor.execute(() -> {
            for (int i = 0; i < 100; i++) {
                try {
                    condition2.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(System.getenv());
                System.out.println(Thread.currentThread().getName()+constants+x.incrementAndGet());
                condition2.signalAll();

            }
        });

    }

    private static void threadExecutor(AtomicInteger x, ThreadPoolExecutor threadPoolExecutor) {

    }
}