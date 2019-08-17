package com;

import javax.swing.tree.TreeNode;
import java.util.*;


public class LeetCode {



    public boolean searchMatrix(int[][] matrix, int target) {
        return search(matrix, target, 0, matrix.length*matrix[0].length -1);
    }

    public boolean search(int[][] matrix, int target, int start, int end){
        int row = (end)/matrix[0].length;
        int column = (end)%matrix[0].length;
        if(start==end)
            return target==matrix[row][column];

        int mid = (start) +(end-start)/2;
        if(target<= matrix[mid/matrix[0].length][mid%matrix[0].length])
            return search(matrix, target, start, mid);
        else
            return search(matrix, target, mid+1, end);


    }
}
