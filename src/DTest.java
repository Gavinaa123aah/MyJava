/**
 * 多线程-笔试题目
 */
public class DTest {
    public static void main(String[] args) {
        MajusculeABC maj = new MajusculeABC();
        Thread t_a = new Thread(new Thread_ABC(maj , 'A'));
        Thread t_b = new Thread(new Thread_ABC(maj , 'B'));
        Thread t_c = new Thread(new Thread_ABC(maj , 'C'));
        t_a.start();
        t_b.start();
        t_c.start();
    }
}

class MajusculeABC {
 char s;

}

class Thread_ABC implements Runnable {

    MajusculeABC maj;
    char s;
    static int maxNum=30;
    static char flag = 'A';
    static int count = 0;


    public Thread_ABC(MajusculeABC maj, char s){
        this.maj = maj;
        this.s = s;
    }

    public void run(){
        while(true) {
            synchronized (this) {
                if (count>=maxNum){
                    break;
                }
                if(flag==this.s ) {
                    System.out.println(this.s);
                    count++;
                    if (flag=='A') flag='B';
                    else if (flag=='B') flag='C';
                    else if (flag=='C') flag='A';
                }

            }
        }
    }
}

