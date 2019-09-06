1. 动态规划（Dynamic Programming，DP）与分治区别在于划分的子问题是有重叠的
2. DP在求解一个问题最优解的时候，不是固定的计算合并某些子问题的解，而是根据各子问题的解的情况选择其中最优的。 
```
背包的状态转换方程 f[i,j] = Max{ f[i-1,j-Wi]+Pi( j >= Wi ),  f[i-1,j] }
1. f[i,j]:表示在前i件物品中选择若干件放在承重为 j 的背包中，可以取得的最大价值。
2. f[i-1,j-Wi]+Pi( j >= Wi ):表示前i-1个物品中选择若干件放承重为j-Wi可以取得的最大价值 + 第i件物品的价值
3. f[i-1,j]：表示前i-1个物品中选择若干件放承重为j可以取得的最大价值
```
