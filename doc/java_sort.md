# 1.冒泡排序
```java
/**
 * 冒泡排序思路：
 * （1）每一趟把最大的一个数往下沉
 * （2）若某一趟没有发生交换，则说明已经有序，排序终止
 * 
 * 最好时间复杂度o(N)
 * 最坏时间复杂度o(N*N)
 * 平均时间复杂度o(N*N)
 */
public class Bubble {

    static int[]  funBubbleSort(int[] array) {
        boolean flag = true;
        for(int i = 0;i<array.length-1 && flag;i++){
            flag=false;
            for(int j=0;j<array.length-i-1;j++) {
                 if (array[j]>array[j+1]){
                     int temp = array[j];
                     array[j] = array[j+1];
                     array[j+1] = temp;
                     flag=true;
                 }
            }
        }
        return array;
    }
    
    public static void main(String[] args){

        int[] data = {1,5,3,2};
        int[] result = funBubbleSort(data);
        for (int dd:result) {
            System.out.println(dd);
        }
    }
}
```

2. 快速排序