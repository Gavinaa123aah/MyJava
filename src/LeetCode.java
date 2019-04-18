import java.util.*;

class LeetCode {
    public String function(String s){
        String[] array = s.split(" ");
//        Stack<String> stack = new Stack<String>();
//        String result = "";
//        for(int i =0;i<s.length();i++){
//            if(s.charAt(i)==' '){
//                stack.push(" ");
//            }else{
//                stack.push((String.valueOf(s.charAt(i))));
//            }
//        }
//
//        while(!stack.empty()){
//            result=result+stack.pop();
//        }
        for (int i=0;i<array.length;i++){
            System.out.println(array[i]);
        }
        return null;

    }

    public static void main(String[] args){
        LeetCode s = new LeetCode();
       s.function("Let's take LeetCode contest");
    }
}