public class MyRunnable implements Runnable{

    private String name;
    public MyRunnable(String name){
        this.name = name;

    }

    @Override
    public synchronized void run() {
        for (int i =0;i<100;i++){
            try {
                Thread.sleep(50);
            }catch (Exception R){

            }

            System.out.println(this.name);
        }
    }

    public static void main(String[] args){
        MyRunnable r1 = new MyRunnable("aaaaa");
        MyRunnable r2 = new MyRunnable("bbbbb");
        MyRunnable r3 = new MyRunnable("ccccc");

        Thread t1 = new Thread(r1);
        Thread t2 = new Thread(r2);
        Thread t3 = new Thread(r3);

        t1.start();
        t2.start();
        t3.start();
    }
}
