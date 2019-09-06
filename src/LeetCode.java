import java.util.LinkedList;
import java.util.Stack;

class TreeNode{
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
        }

class LeetCode{
    public String serialize(TreeNode root) {

        Stack<TreeNode> stack = new Stack<>();
        StringBuilder stringBuilder = new StringBuilder();
        String flag = "";

        while (root!=null || !stack.isEmpty()){
            if (root!=null){
                stack.push(root);
                stringBuilder.append(flag);
                flag = ",";
                stringBuilder.append(root.val);
                root=root.left;

            }else {
                stringBuilder.append(flag);
                stringBuilder.append("#");
                TreeNode treeNode = stack.pop();
                root = treeNode.right;
            }
        }

        return stringBuilder.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {

        if (data == null) return null;
        String[] arrays = data.split(",");

        TreeNode root = new TreeNode(Integer.valueOf(arrays[0]));

        Stack<TreeNode> s = new Stack<>();
        s.push(root);

        boolean leftIsExist = true;
        for (int i=1; i<arrays.length ;i++){

           TreeNode node = arrays[i].equals("#") ? null : new TreeNode(Integer.valueOf(arrays[0]));
           if (leftIsExist){
               s.peek().left = node;
               if (node==null) leftIsExist = false;
           }else {
               s.pop().right = node;
               leftIsExist = true;
           }

           if (node!=null) s.push(node);
        }

        return root;
    }

    public static void main(String[] args){
       new LeetCode();
    }
 }