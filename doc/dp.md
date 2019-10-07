# 1. 动态规划概述
1. 动态规划（Dynamic Programming，DP）与分治区别在于划分的子问题是有重叠的
2. DP在求解一个问题最优解的时候，不是固定的计算合并某些子问题的解，而是根据各子问题的解的情况选择其中最优的。 
```
背包的状态转换方程 f[i,j] = Max{ f[i-1,j-Wi]+Pi( j >= Wi ),  f[i-1,j] }
1. f[i,j]:表示在前i件物品中选择若干件放在承重为 j 的背包中，可以取得的最大价值。
2. f[i-1,j-Wi]+Pi( j >= Wi ):表示前i-1个物品中选择若干件放承重为j-Wi可以取得的最大价值 + 第i件物品的价值
3. f[i-1,j]：表示前i-1个物品中选择若干件放承重为j可以取得的最大价值
```
# 2. 斐波那契数列
1. 普通递归方法求解
2. 自顶向下备忘录法（递归）
3. 自底向上（动态规划）
# 3.钢条切割问题
参考网址
> https://blog.csdn.net/u013309870/article/details/75193592
1. 数组int[] p：不同长度的钢条价格，n：钢条的长度，求长度为n的钢条怎样切割收益R最高？
2. 状态转移方程：Rn = max(Pn,R1+Rn-1,R2+Rn-2,…,Rn-1+R1);
3. 递归版本
```java
       public static int cut1(int[] prices,int n){
        if (n==0) return 0;
        int ret = Integer.MIN_VALUE;

        for (int i=1;i<=n;i++){
            /**
             *  第一次，左边一米，右边部分继续切
             *  第二次。左边两米，右边部分继续切割
             *  最后一次，左边N米，右边0
             */

            ret = Math.max(ret,prices[i-1] + cut1(prices,n-i));
            return ret;
        }

        return ret;
    }
```
4. 自顶向下备忘录
```java
 public static int cutMemo(int[] prices,int n){

        int r[] = new int[n+1];

        for (int i=0;i<=n;i++){
            r[i]=-1;
        }

        return cut(prices,n,r);
    }
    public static int cut(int[] prices,int n,int[] r){

        int q = Integer.MIN_VALUE;

        if (n==0){
            return 0;
        }else if(r[n]!=-1){
            return r[n];
        }else {
            for (int i=1;i<=n;i++){
                q = Math.max(q,prices[i-1]+cut(prices,n-i,r));
            }
        }

        return q;
    }
```
5. 自底向上递归
```java
```
# 4. 0-1背包
>https://blog.csdn.net/evillist/article/details/74455044
```java
public static int getMaxValue(int[] weight, int[] value, int w, int n) {
        int[][] table = new int[n + 1][w + 1];
        for (int i = 1; i <= n; i++) { //物品
            for (int j = 1; j <= w; j++) {  //背包大小
                if (weight[i] > j) {        
                        //当前物品i的重量比背包容量j大，装不下，肯定就是不装
                    table[i][j] = table[i - 1][j];
                    // System.out.print(table[i][j]+ " ");
                } else { //装得下，Max{装物品i， 不装物品i}
                    table[i][j] = Math.max(table[i - 1][j], table[i - 1][j - weight[i]] + value[i]);
                    //System.out.print(table[i][j]+ " ");
                }
            }
            // System.out.println();
        }
        return table[n][w];
    }

    public static void main(String[] args) {

        int n = 5, w = 10;                    //物品个数，背包容量
        int[] value = {0, 6, 3, 5, 4, 6};     //各个物品的价值
        int[] weight = {0, 2, 2, 6, 5, 4};    //各个物品的重量
        System.out.println(getMaxValue(weight,value,w,n));

    }
```
# 参考网址
> https://blog.csdn.net/u013309870/article/details/75193592
> https://blog.csdn.net/evillist/article/details/74455044