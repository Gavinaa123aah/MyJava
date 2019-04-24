

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

class IP{
    String ip;
    int flag;
    public IP(String ip, int flag){
        this.ip=ip;
        this.flag=flag;
         }
    }

public class B extends Thread{
    static ConcurrentHashMap<Integer,IP> m = new ConcurrentHashMap<>();
    public void run(){
        for (int i=0;i<10;i++){
            IP ip = null;
            Random random = new Random();
            int random_temp = random.nextInt(8);
            ip=m.get(random_temp);
            while (ip.flag==1){
                random_temp = random.nextInt(8);
                ip=m.get(random_temp);
            }
            ip.flag=1;
            m.put(random_temp,ip);
            try {
                Thread.sleep(100);
            }catch (InterruptedException e){
                e.printStackTrace();
            }
            System.out.println("线程ID:"+Thread.currentThread().getId()+"--使用ip"+ip.ip);
            ip.flag=0;
            m.put(random_temp,ip);
        }
    }
    public static void main(String[] args){
        m.put(0,new IP("202.205.101.9",0));
        m.put(1,new IP("202.205.101.10",0));
        m.put(2,new IP("202.205.101.11",0));
        m.put(3,new IP("202.205.101.12",0));
        m.put(4,new IP("202.205.101.13",0));
        m.put(5,new IP("202.205.101.14",0));
        m.put(6,new IP("202.205.101.15",0));
        m.put(7,new IP("202.205.101.16",0));
        for (int i=0;i<50;i++){
            B temp = new B();
            temp.start();
        }

        }
    }

