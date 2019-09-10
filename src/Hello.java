import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * @ClassName Hello
 * @Author Gavin
 * @Date 2019/6/9 下午12:54
 **/
class Hello {

    public static int cut(int[] p,int n){
        if(n==0) return 0;
        int r = Integer.MIN_VALUE;
        for(int i=1;i<=n;i++){
            r = Math.max(r,p[i-1]+cut(p,n-i));
        }
        return r;
    }

    public static void main(String args[]){
     int[] p = {1,5,8,9,10};
     int ret = cut(p,4);
     System.out.println(ret);
        Map<String,String> map = new HashMap<>();

        for (Map.Entry entry:map.entrySet()){

        }
    }
}
