// O(N^2) time O(N) space

// class Solution {
//     private int height(TreeNode root){
//         if(root==null) return 0;
//         return Math.max(height(root.left), height(root.right))+1;
//     }
//     public boolean isBalanced(TreeNode root) {
//         if(root == null) return true;
//         int left = height(root.left);
//         int right= height(root.right);
//         return Math.abs(left-right)<=1 && isBalanced(root.left) && isBalanced(root.right);
        
//     }
// }

// O(N) time O(N) space

class Solution {
    private int height(TreeNode root){
        if(root==null) return 0;
        int left = height(root.left); if(left ==-1) return -1;
        int right = height(root.right); if(right == -1) return -1;
        if(Math.abs(left-right)>1)return -1;
        return Math.max(left,right )+1;
    }
    public boolean isBalanced(TreeNode root) {
       return height(root)!=-1;
        
    }
}
