// intution: on each level we will check if the current node is equal to x or y if it is equal to x or y then we will set the flag to true and store the parent of the current node in the parent variable if the current node is equal to x or y and the parent of the current node is equal to the parent of the other node then we will return false else we will return true

class Solution {
    public boolean isCousins(TreeNode root, int x, int y) {
        if(root==null || root.val==x || root.val==y) return false;
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        while(!q.isEmpty()){
            int levelSize= q.size();
            boolean isXexist = false;
            boolean isYexist = false;
            for(int i=0; i<levelSize; i++){
                TreeNode currNode = q.poll();
                if(currNode.val == x) isXexist = true;
                if(currNode.val == y) isYexist = true;
                if(currNode.left != null && currNode.right!=null){
                    if(currNode.left.val==x && currNode.right.val==y)return false;
                    if(currNode.left.val==y && currNode.right.val==x)return false;
                }
                if(currNode.left!=null)q.offer(currNode.left);
                if(currNode.right!=null)q.offer(currNode.right);

            }
            if(isXexist && isYexist) return true;
        }
        return false;
    }
}