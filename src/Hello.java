import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;

class Hello {

    public static void main(String[] args) {

        Map<Integer,String>  map = new ConcurrentHashMap<>();
        map.put(5,"ccc");
        map.put(2,"fff");
        map.put(8,"aaa");
        map.put(1,"www");

        Map<Integer,Integer> map1 = map.entrySet().stream().collect(Collectors.toMap(p->p.getKey(),p->p.getKey()+1));
        for (Map.Entry entry:map1.entrySet()){
            System.out.println(entry.toString());
        }
    }

    interface MathOperation {
        int operation(int a, int b);
    }

    interface GreetingService {
        void sayMessage(String message);
    }

    private int operate(int a, int b, MathOperation mathOperation){
        return mathOperation.operation(a, b);
    }

}
