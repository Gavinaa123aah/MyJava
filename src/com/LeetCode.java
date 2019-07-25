package com;

import java.util.*;


public class LeetCode {
    public static void main(String[] args){

    }

    public List<List<Integer>> threeSum(int[] nums) {
        Set<List<Integer>> results = new HashSet<>();
        Map<Integer,Integer> map = getMap(nums);

        Set<Integer> setA = new HashSet<>();
        for(int i=0;i<nums.length;i++){
           if(!setA.add(nums[i]))
               continue;

            Set<Integer> setB = new HashSet<>();
            for(int k=i+1;k<nums.length;k++){
                if (!setB.add(nums[k]))
                    continue;
                Integer aim = 0-nums[i]-nums[k];
                Integer tem = map.get(aim);
                if(tem!=null&& tem!=k && tem!=i){
                    List<Integer> list = new ArrayList<>();
                    list.add(nums[i]);
                    list.add(nums[k]);
                    list.add(nums[tem]);
                    Collections.sort(list);
                    results.add(list);
                }

            }

        }
        return new ArrayList<>(results);
    }

    Map<Integer,Integer> getMap(int[] nums){
        Map<Integer,Integer> map = new TreeMap<>();
        for (int i=0;i<nums.length;i++){
            if(!map.containsKey(nums[i])){
                map.put(nums[i],i);
            }
        }
        return map;
    }
}
