package com.haozi.demo.algorithm.audition;

/**
 * Created by ASUS on 2017/12/23.
 */
public class ThreadShoudBeInterrupted implements Runnable {
    @Override
    public void run() {
        System.out.println("child thread is running");
        try {
            Thread.sleep(20 * 1000L);
        } catch (InterruptedException e) {
            System.out.println("child thread is interrupted");
            System.out.println(Thread.interrupted());
//            return;
        }
        System.out.println("child thread finished");
    }

    public static void main(String[] args) throws Exception {
        Thread child = new Thread(new ThreadShoudBeInterrupted());
        child.start();
        System.out.println("main thread is running");
        Thread.sleep(2 * 1000L);
        child.interrupt();
        System.out.println("main thread finished");
    }
}
