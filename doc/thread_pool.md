# 1. newCachedThreadPool
```java
public class MyNewCacheThreadPool {

    public static void main(String[] args){
        /**
         *  1. 创建一个可缓存线程池，如果线程池长度超过处理需要,可灵活回收空闲线程，若无可回收，则新建线程。
         *  2. 线程池为无限大，当执行第二个任务时第一个任务已经完成，会复用执行第一个任务的线程，而不用每次新建线程。
         */

        ExecutorService cachedThreadPool = Executors.newCachedThreadPool();

        for (int i=0;i<1000;i++){
            final int index = i;
            cachedThreadPool.execute(new Runnable() {
                @Override
                public void run() {
                    System.out.println(index);
                    System.out.println(Thread.currentThread().getName());
                }
            });
        }
        
    }

}
```

# 2. newFixedThreadPool
```java
public class MyNewFixedThreadPool {

    public static void main(String[] args){
        // 创建一个定长线程池，可控制线程最大并发数，超出的线程会在队列中等待。
        ExecutorService threadPool1 = Executors.newFixedThreadPool(3);

        for (int i=0;i<1000;i++){
            final int index = i;

            threadPool1.execute(() -> {
                System.out.println(index);
                System.out.println(Thread.currentThread().getName());
            });
        }

    }
}

``` 

# 3.newScheduledThreadPool
```java
public class MyNewScheduledThreadPool {
    public static void main(String[] args){
        /**
         * 创建一个定长线程池，支持定时及周期性任务执行
         */
        ScheduledExecutorService executorService = Executors.newScheduledThreadPool(5);

        for (int i=0;i<4;i++){
            // 定时
            executorService.schedule(new Runnable() {

                @Override
                public void run() {
                    System.out.println("delay 3 seconds");
                }
            }, 3, TimeUnit.SECONDS);
        }

        // 周期性
        executorService.scheduleAtFixedRate(new Runnable() {

            @Override
            public void run() {
                System.out.println("delay 1 seconds, and excute every 3 seconds");
            }
        }, 1, 3, TimeUnit.SECONDS);


    }
}
```

# 4. newSingleThreadExecutor
```java
  public class MyNewSingleThreadExecutor {
    /**
     * 创建一个单线程化的线程池，它只会用唯一的工作线程来执行任务，保证所有任务按照指定顺序(FIFO, LIFO, 优先级)执行。
     */

    public static void main(String[] args){
        ExecutorService singleThreadExecutor = Executors.newSingleThreadExecutor();

        for (int i = 0; i < 10; i++) {
            final int index = i;
            singleThreadExecutor.execute(new Runnable() {

                @Override
                public void run() {
                        System.out.println(index);

                }
            });


        }
    }

}
```