# 1.二分查找
```java
/**
 * 二分查找
 */
public class BinarySearch {
    static int funBinSearch(int[] array, int data) {

        int low = 0;
        int high = array.length - 1;

        while (low <= high) {

            int mid = (low + high) / 2;

            if (data == array[mid]) {
                return mid;
            } else if (data < array[mid]) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return -1;
    }

    public static void main(String[] args){

        int[] arrays = {1,2,2,5,7,8,10};

        int result = funBinSearch(arrays,5);
        System.out.println(result);
    }
}
```