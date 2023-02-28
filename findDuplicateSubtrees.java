import java.util.*;
// Approach 1- Inorder Traversal and HashMap
class Solution { // TC O(n) SC O(n)
    public String inorder(Node root, List<Integer> ans, HashMap<String, Integer> map){
        if (root==null) return "";
        String representation="(" + inorder(root.left, ans, map) + ")" + root.val + "(" + 
        inorder(root.right, ans, map) + ")";
        map.put(representation, map.getOrDefault(representation,0)+1);
        if (map.containsKey(representation)){
            if(map.get(representation)==2){
                ans.add(root.val);
            }
        }
        return representation;
    }
    
    public List<Integer> findDuplicateSubtrees(Node root) {
        List<Integer> ans=new ArrayList<>();
        inorder(root, ans, new HashMap<String, Integer>());
        return ans;
    }
}

class findDuplicateSubtrees{
	public static void main(String[] args) {
		BinaryTree bt= new BinaryTree();
		bt.root=new Node(1);
		bt.root.left=new Node(2);
		bt.root.right=new Node(3);
		bt.root.left.left=new Node(4);
		bt.root.right.left=new Node(2);
		bt.root.right.left.left=new Node(4);
		bt.root.right.right=new Node(4);
		Solution s= new Solution();
		System.out.println(s.findDuplicateSubtrees(bt.root));
	}
}