import java.util.Arrays;

/**
 * @ClassName Hello
 * @Author Gavin
 * @Date 2019/6/9 下午12:54
 **/
class Hello {
    public static void main(String args[]){
        try{
            int a[] = new int[2];
            System.out.println("Access element three :" + a[3]);
        }catch(ArrayIndexOutOfBoundsException e){
            System.out.println("Exception thrown  :" + e);
        }
        System.out.println("Out of the block");
    }
}
