/**
 * Copyright (C), 2015-2018, XXX有限公司
 * FileName: DeadLock
 * Author:   xutong
 * Date:     2018/9/29 6:31 PM
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.xty.test.test3;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.locks.AbstractQueuedSynchronizer;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 〈一个死锁的demo〉<br>
 * 〈〉
 *
 * @author xutong
 * @create 2018/9/29
 * @since 1.0.0
 */
public class DeadLock {
    public static void main(String[] args) {
        ReentrantLock reentrantLock = new ReentrantLock();
        reentrantLock.lock();
        Condition condition1 = reentrantLock.newCondition();
        Condition condition2 = reentrantLock.newCondition();
condition1.signalAll();
//        AbstractQueuedSynchronizer
//        CountDownLatch
                reentrantLock

    }

}