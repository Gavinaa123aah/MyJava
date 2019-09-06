package com.MyThreads;



public class PrintABC implements Runnable{
    private String name;
    private Object prev;
    private Object self;

    public PrintABC(String name,Object prev,Object self){
        this.name=name;
        this.prev = prev;
        this.self = self;
    }

    @Override
    public void run() {
        int count = 3;
        while (count > 0) {
            synchronized (prev) {
                synchronized (self) {
                    System.out.print(name);
                    count--;

                    self.notify();// 走完本次synchronized后释放锁，
                }
                try {
                    prev.wait();// 线程在这个地方停住,等待唤醒;1000是防止最后死锁
                } catch (InterruptedException e) {
                    e.printStackTrace();
                    System.out.println("已捕获");
                }
            }

        }

    }

    public static void main(String[] args) throws Exception{

        Object a = new Object();
        Object b = new Object();
        Object c = new Object();

        Thread thread1 = new Thread(new PrintABC("A", c, a));

        Thread thread2 = new Thread(new PrintABC("B", a, b));

        Thread thread3 = new Thread(new PrintABC("C", b, c));

        thread1.start();
        Thread.sleep(10);
        thread2.start();
        Thread.sleep(10);
        thread3.start();
        Thread.sleep(10);

        thread2.interrupt();
        thread3.interrupt();
    }
}
