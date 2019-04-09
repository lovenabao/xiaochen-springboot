package com.xiaochen.springboot.demo.utils;

import java.util.Timer;
import java.util.concurrent.*;

/**
 * @author shkstart
 * @create 04-09 11:31
 */
public class CachedThreadPool {
    public static void main(String[] args) {
        //创建定时器对象
        Timer t=new Timer();
        //在3秒后执行MyTask类中的run方法,后面每10秒跑一次
        t.schedule(new BsicThreads(), 3000,10000);
    }
}
