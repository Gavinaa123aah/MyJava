import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.List;

class LeetCode {
    public List<Integer> findDuplicates(int[] nums){
        Map<Integer,Integer> map = new HashMap<Integer,Integer>();

        for(Integer num:nums){
//            System.out.println(num);
            if (map.containsKey(num)){
                map.put(num,map.get(num)+1);
            }else {
                map.put(num,1);
            }
        }
        List<Integer> result = new LinkedList<Integer>();
        for(Integer v:map.keySet()){
            if(map.get(v)==2){
                result.add(v);
            }
        }
        return result;
    }

    public static void main(String[] args){
        LeetCode s = new LeetCode();
        int[] nums = {2,34,5,5,6,6,7,8,0};
        s.findDuplicates(nums);
    }
}