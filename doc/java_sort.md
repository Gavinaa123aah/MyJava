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

# 2. 快速排序
```java
/**
 *快速排序:
 *从数列中挑出一个元素，称为 “基准”（base）；
 *重新排序数列，所有元素比基准值小的摆放在基准前面，所有元素比基准值大的摆在基准的后面（相同的数可以到任一边）。
 *在这个分区退出之后，该基准就处于数列的中间位置。这个称为分区（partition）操作；
 *递归地（recursive）把小于基准值元素的子数列和大于基准值元素的子数列排序。
 *
 * 复杂度：
 * 平均：o(n*log(n))
 * 最好：o(n*log(n))
 * 最坏：o(n*n)
 * 空间：o(nlog(n))
 */
public class QuickSort   {

    public static int[] quick(int left,int right, int[] arrays){
        if (left>right){
            return new int[]{};
        }

        int i = left;
        int j = right;
        int base = arrays[i];

        while (i<j){
            while (arrays[j]>=base && i<j){
                j--;
            }
            while (arrays[i]<=base && i<j){
                i++;
            }

            if (i<j){
                int temp = arrays[i];
                arrays[i] = arrays[j];
                arrays[j] = temp;
            }
        }

        arrays[left] = arrays[i];
        arrays[i] = base;// 一趟排序结束

        quick(left, i-1, arrays);
        quick(i+1,right,arrays);

        return arrays;

    }


    public static void main(String[] args){
        int[] array={18,15,6,67,8,19};
        int result[] = quick(0,array.length-1,array);

        for (int i=0;i<result.length;i++){
            System.out.println(result[i]);
        }

    }

}
```

# 3.插入排序
```java
/**
 * InsertSort
 * (1) 第一趟，将第1个元素放到第1个位置
 * (2) 第二趟，将第2个元素根据大小插入到已经排号序的位置
 * (3) 第三趟，将第3个元素根据大小插入到[1,2]的合适位置
 * (4) 第四趟，将第4个元素根据大小插入到[1,3]的合适位置
 * ......
 * (5) 第n趟，将第n个元素根据大小插入到[1,n-1]的合适的位置
 *
 **/
public class InsertSort {

    static int[] insertSort(int[] arrays){
        for(int i=1;i<arrays.length;i++){

            int preIndex = i-1;
            int current = arrays[i];

            while (current<arrays[preIndex] && preIndex>=0){
                arrays[preIndex+1]=arrays[preIndex];
                preIndex--;
            }
            arrays[preIndex+1] = current;
        }
        return arrays;
    }

    public static void main(String[] args){

        int[] data = {1,5,3,2};
        int[] result = insertSort(data);
        for (int dd:result) {
            System.out.println(dd);
        }
    }
}
```

# 4.选择排序
```java
/**
 * 选择排序：每趟从未排序的部分，选出最小的值放到排好序的部分的末尾
 * （1）第一趟，从[1,n]中选取最小的放到第1个位置
 * （2）第二趟，从第[2,n]中选取最小的放到第2个位置
 *  ...
 * （3）第m趟，从[m,n]（m<=n）中选取最小的放到第m个位置
 */
public class SelectSort {

    static int[] selectSort(int[] arrays){
        int minIndex;
        for (int i=0; i<arrays.length-1; i++){
            minIndex = i;
            for (int j=i; j<arrays.length; j++){
                if (arrays[j] < arrays[minIndex]){
                    minIndex = j;
                }
            }
           // 注意：这个地方用到引用传递
           swap(arrays, i, minIndex);
        }
        return arrays;
    }

    static void swap(int arrays[], int i, int j){
        int temp = arrays[i];
        arrays[i] = arrays[j];
        arrays[j] = temp;
    }

    public static void main(String[] args){

        int[] data = {1,5,3,2};
        int[] result = selectSort(data);
        for (int dd:result) {
            System.out.println(dd);
        }
    }
}
```

# 参考
>https://www.cnblogs.com/onepixel/p/7674659.html