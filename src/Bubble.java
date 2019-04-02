/**
 * 冒泡排序
 */
public class Bubble {

    static void funBubbleSort(int[] array) {

        boolean flag = true;

        for (int i = 0; i < array.length-1; i++) {



            for (int j = 0; j < array.length-i-1; j++) {

                if (array[j] >array[j+1]) {

                    int temp = array[j];
                    array[j] = array[j+1];
                    array[j+1] = temp;
                }
            }
        }

        for (int i = 0; i < array.length; i++) {
            System.out.println(array[i]);
        }

    }
    public static void main(String[] args){

        int[] data = {1,5,3,2};
        funBubbleSort(data);



    }
}
