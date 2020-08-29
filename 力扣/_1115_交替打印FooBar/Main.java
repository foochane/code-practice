package _1115_交替打印FooBar;

import java.util.concurrent.Semaphore;

/**
 * 我们提供一个类：
 *
 * class FooBar {
 *   public void foo() {
 *     for (int i = 0; i < n; i++) {
 *       print("foo");
 *     }
 *   }
 *
 *   public void bar() {
 *     for (int i = 0; i < n; i++) {
 *       print("bar");
 *     }
 *   }
 * }
 * 两个不同的线程将会共用一个 FooBar 实例。其中一个线程将会调用 foo() 方法，另一个线程将会调用 bar() 方法。
 *
 * 请设计修改程序，以确保 "foobar" 被输出 n 次。
 *
 *  
 *
 * 示例 1:
 *
 * 输入: n = 1
 * 输出: "foobar"
 * 解释: 这里有两个线程被异步启动。其中一个调用 foo() 方法, 另一个调用 bar() 方法，"foobar" 将被输出一次。
 * 示例 2:
 *
 * 输入: n = 2
 * 输出: "foobarfoobar"
 * 解释: "foobar" 将被输出两次。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/print-foobar-alternately
 */
public class Main {


    public static void main(String[] args) {
        FooBar fooBar = new FooBar(10);
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    fooBar.foo(new Runnable() {
                        @Override
                        public void run() {
                            System.out.println("foo.........");
                        }
                    });
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    fooBar.bar(new Runnable() {
                        @Override
                        public void run() {
                            System.out.println("bar.........");
                        }
                    });
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }
}

/**
 * 使用Semaphore，控制foo和bar的可访问线程数一个为0，一个为1
 */
class FooBar {
    private int n;
    private final Semaphore foo = new Semaphore(1); //foo可访问线程数为1
    private final Semaphore bar = new Semaphore(0); //bar可访问线程数为0

    public FooBar(int n) {
        this.n = n;
    }

    public void foo(Runnable printFoo) throws InterruptedException {
        for (int i = 0; i < n; i++) {
            foo.acquire(); //获取foo，foo可访问线程为0
            printFoo.run();
            bar.release(); //bar可访问线程为1
        }
    }

    public void bar(Runnable printBar) throws InterruptedException {
        for (int i = 0; i < n; i++) {
            bar.acquire(); //获取bar，bar可访问线程为0
            printBar.run();
            foo.release(); //foo的可访问线程为1
        }
    }
}