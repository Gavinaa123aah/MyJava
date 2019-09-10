# 1. 动态规划概述
1. 动态规划（Dynamic Programming，DP）与分治区别在于划分的子问题是有重叠的
2. DP在求解一个问题最优解的时候，不是固定的计算合并某些子问题的解，而是根据各子问题的解的情况选择其中最优的。 
```
背包的状态转换方程 f[i,j] = Max{ f[i-1,j-Wi]+Pi( j >= Wi ),  f[i-1,j] }
1. f[i,j]:表示在前i件物品中选择若干件放在承重为 j 的背包中，可以取得的最大价值。
2. f[i-1,j-Wi]+Pi( j >= Wi ):表示前i-1个物品中选择若干件放承重为j-Wi可以取得的最大价值 + 第i件物品的价值
3. f[i-1,j]：表示前i-1个物品中选择若干件放承重为j可以取得的最大价值
```
# 1. 斐波那契数列
1. 普通递归方法求解
2. 自顶向下备忘录法（递归）
3. 自底向上（动态规划）
# 2.钢条切割问题
参考网址
> https://blog.csdn.net/u013309870/article/details/75193592
1. 数组int[] p：不同长度的钢条价格，n：钢条的长度，求长度为n的钢条怎样切割收益R最高？
2. 状态转移方程：Rn = max(Pn,R1+Rn-1,R2+Rn-2,…,Rn-1+R1);
3. 递归版本
```java
    public static int cut(int[] p,int n){
        if(n==0) return 0;
        int r = Integer.MIN_VALUE;
        for(int i=1;i<=n;i++){
            r = Math.max(r,p[i-1]+cut(p,n-i));
        }
        return r;
    }
```

# 参考网址
> https://blog.csdn.net/u013309870/article/details/75193592