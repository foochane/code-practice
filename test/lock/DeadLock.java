package lock;


/**
 *
 * 死锁的条件
 * 1. 互斥使用：当资源被一个线程使用时，其他线程不能使用
 * 2. 不可抢占：资源请求者不可以强制从资源占有者手中抢夺资源
 * 3. 占有且等待：资源请求者请求其他资源同时保存原有资源的占有
 * 4. 循环等待：线程一等待线程儿占有的资源，而线程儿要等待线程儿占有的资源，形成一个环路
 *
 * 如何防止死锁：
 * 死锁只有这四个条件都发生时才会出现，只有破坏其中一个，就可以成功的预防死锁。
 * 一般不会对互斥条件进行破坏，某些资源就只能一个人使用
 * - 破损占有且等待：每个请求者一次性请求所以需要的资源，如果无法一次性申请所以资源，那就进行等待。
 * - 破坏不可抢占：如果一个请求者去请求某个资源时，如果请求不到就主动是否它所占有的全部资源。
 * - 破坏循环等待：给每个资源都标上一个序号，按序申请，先申请资源序号小的，在申请资源序号大的，线性化后申请资源，就不会出现循环等待
 *
 * 使用jstack查看死锁
 * 先jps 查看进程号
 * 然后jstack 进程号 查看死锁情况
 */
public class DeadLock {
    public static void main(String[] agrs){
        Object a = new Object();
        Object b = new Object();

        new Thread(()->{
            synchronized(a){
                System.out.println(Thread.currentThread().getName() + ": i get a");
                try{
                    Thread.sleep(2000);
                }catch(Exception e){
                    e.printStackTrace();
                }

                System.out.println(Thread.currentThread().getName() + ":i want get b");

                synchronized(b){
                    System.out.println(Thread.currentThread().getName() + ":i get b");
                }
            }

        }).start();

        new Thread(()->{
            synchronized(b){
                System.out.println(Thread.currentThread().getName() + ":i get b");
                try{
                    Thread.sleep(2000);
                }catch(InterruptedException e){
                    e.printStackTrace();
                }

                System.out.println(Thread.currentThread().getName() + ":i want get a");

                synchronized(a){
                    System.out.println(Thread.currentThread().getName() + ":i get a");
                }
            }

        }).start();
    }

}
