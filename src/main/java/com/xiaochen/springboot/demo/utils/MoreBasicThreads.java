package com.xiaochen.springboot.demo.utils;

/**
 * @author shkstart
 * @create 04-09 11:19
 */
public class MoreBasicThreads {
    public static void main(String[] args) {
        for (int i = 0; i < 5; i++) {
            new Thread(new LiftOff()).start();
            System.out.println("waiting for LiftOff");
        }
    }
}
