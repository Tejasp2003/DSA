class Solution {
    public List<Double> Successor(TreeNode root, int key) {
        List<Double> result = new ArrayList<>();
        if(root==null) return result;
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        while(!q.isEmpty()){
            TreeNode currNode = q.poll();
           
            if(currNode.left!=null)q.offer(currNode.left);
            if(currNode.right!=null) q.offer(currNode.right);
           
            if(currNode.val == key) break;
        }
        return queue.peek();
    }
    
}