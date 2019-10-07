package com;

import java.util.*;

class Main {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack();

        char[] arr = s.toCharArray();

        for (int i=0;i<arr.length;i++){
            if (arr[i]=='('){
                stack.push(')');
            }else if (arr[i]== '['){
                stack.push(']');
            }else if (arr[i]== '{'){
                stack.push('}');
            }else {
                if (stack.isEmpty() || stack.pop()!=arr[i]){
                    return false;
                }
            }
        }

        return stack.isEmpty();
    }

}
