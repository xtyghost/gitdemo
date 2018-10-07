/**
 * Copyright (C), 2015-2018, XXX有限公司
 * FileName: GitTest
 * Author:   xutong
 * Date:     2018/10/7 7:09 PM
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.git.test.gitdemo.Demo;

import java.util.Date;

/**
 * 〈一句话功能简述〉<br> 
 * 〈〉
 *
 * @author xutong
 * @create 2018/10/7
 * @since 1.0.0
 */
public class GitTest {
    public static void main(String[] args) {
        System.out.println("demo1");
        System.out.println(new Date());
        Object securityContext = System.getSecurityManager().getSecurityContext();
        System.out.println(securityContext);
    }

}