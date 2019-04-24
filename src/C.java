public class C implements Runnable{
    static int flag=1;
    static int count = 0;
    int num;
    public C(int num){
        this.num=num;
    }
    public void run() {
        synchronized(this) {
        while(C.count <99) {
                if(this.num % 2 == 1&& C.flag==1) {
                    System.out.println(Thread.currentThread().getName()+":"+ (this.num));
                    this.num=this.num+2;
                    C.flag = 2;
                    C.count++;

                }else if(this.num % 2 == 0&& C.flag==2){
                    System.out.println(Thread.currentThread().getName()+":"+ (this.num));
                    this.num=this.num+2;
                    C.flag = 1;
                    C.count++;
                }
            }
        }
    }

    public static void main(String[] args) {
        C m1 = new C(1);
        C m2 = new C(2);
        Thread thread1 = new Thread(m1);
        Thread thread2 = new Thread(m2);
        thread1.setName("线程1");
        thread2.setName("线程2");
        thread1.start();
        thread2.start();
    }
}
