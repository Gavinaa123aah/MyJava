

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

class IP{
    String ip;

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public int getFlag() {
        return flag;
    }

    public void setFlag(int flag) {
        this.flag = flag;
    }

    int flag;
    public IP(String ip, int flag){
        this.ip=ip;
        this.flag=flag;
         }
    }

public class B{

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int zushu = in.nextInt();
        int n = in.nextInt();// 点数
        int m = in.nextInt();// 边数

        for(int i=0;i<zushu;i++){

            byte[][] arr = new byte[n][n];

            for(int j=0;j<m;j++){
                int out = in.nextInt();
                int inin = in.nextInt();
                arr[out-1][inin-1] = 1;
            }
            if (arr[0][n-1]==1){
                System.out.print("POSSIBLE");
                return;
            }


            for(int p=0;p<n;p++){
                if(arr[p][n-1]==1 && arr[0][p]==1){
                    System.out.print("POSSIBLE");
                    return;
                }
            }

        }

        System.out.print("IMPOSSIBLE");
    }
    }

