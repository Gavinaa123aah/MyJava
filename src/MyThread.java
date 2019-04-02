public class MyThread extends Thread {
    private String name;
    public MyThread(String name){

        this.name = name;

    }
    @Override
    public void run() {
        for (int i =0;i<10;i++) {
            try {
                sleep((int) Math.random() * 10);
            }catch (InterruptedException e){
                System.out.println(e.getStackTrace());
            }

            System.out.println(this.name);
        }
    }

    public static void main(String[] args){
        MyThread t1 = new MyThread("1111111");
        MyThread t2 = new MyThread("222222");
        MyThread t3 = new MyThread("3333333");

        t1.start();
        t2.start();
        t3.start();
    }
}
