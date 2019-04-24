import java.util.HashMap;
public class A extends Thread{
    Animal animal;
    public static Zoo zoo = new Zoo();
    public A(Animal animal){
        this.animal=animal;
    }
    public void run(){
        for (int i=0;i<10;i++){
            A.zoo.addAnimalNum(animal,10);
            A.zoo.removeAnimalNum(animal,5);
        }

    }

    /**
     * 测试
     * 两个动物；cat和dog
     * 每个动物有三个线程取执行并发
     * 每个线程执行10次循环对动物数量进行修改（执行加10，和减5操作）
     * 最终两个动物的数量应该维持在150
     * @param args
     */
    public static void main(String[] args) {
        Animal dog = new Animal();
        dog.setName("dog");
        Animal cat = new Animal();
        cat.setName("cat");

        for (int i=0;i<3;i++){
            A t1 = new A(dog);
            A t2 = new A(cat);
            t1.start();
            t2.start();
            try {
                t1.join();
                t2.join();
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        }
        System.out.println(Thread.currentThread().getName()+"---"+ dog.getName()+"---"+A.zoo.getAnimalNum(dog));
        System.out.println(Thread.currentThread().getName()+"---"+ cat.getName()+"---"+A.zoo.getAnimalNum(cat));
    }

}

class Animal{
    private String name;
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
}

class Zoo{
//    ConcurrentHashMap<Animal,Integer> concurrentHashMap = new ConcurrentHashMap<>();
    HashMap<Animal,Integer> m = new HashMap<>();
    public  int  getAnimalNum(Animal animal){
        int val= m.getOrDefault(animal,0);
        return val;
    }
    public synchronized int addAnimalNum(Animal animal, int addNum){
        int val=m.getOrDefault(animal,0);
        val = val+addNum;
            m.put(animal,val);
        return m.get(animal);

    }
    public synchronized int removeAnimalNum(Animal animal, int removeNum){
        int val=m.getOrDefault(animal,0);
        if (val==0||val<removeNum){
            return 0;
        }
        val=val-removeNum;
        m.put(animal,val);
        return m.get(animal);
    }
}