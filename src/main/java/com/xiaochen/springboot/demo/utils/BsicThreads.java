package com.xiaochen.springboot.demo.utils;

import java.util.TimerTask;

/**
 * @author shkstart
 * @create 04-09 11:15
 */
public class BsicThreads extends TimerTask {

    @Override
    public void run() {
        System.out.println("hello-world!!");
    }

}
