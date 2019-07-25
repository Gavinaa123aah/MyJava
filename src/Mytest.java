import java.util.LinkedList;

public class Mytest {

    public LinkedList f(){
        LinkedList linkedList = new LinkedList();
        System.out.println(System.currentTimeMillis());
        for (int i=0;i<4000;i++){
            double d = Math.random();
            linkedList.add(d);
        }
        System.out.println(System.currentTimeMillis());
        return linkedList;

    }


    public static void main(String[] args){
        Mytest mytest = new Mytest();
        LinkedList  m;
        while (true){
            try {
                m= mytest.f();
                Thread.sleep(1000);
                for (Object data:m) {
                    System.out.println(data);
                }
            }catch (InterruptedException e){

            }

        }
    }
}
