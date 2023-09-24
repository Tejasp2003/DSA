// intution: level order traversal and add the last element of each level to the ans list

class Solution {
    public List<Integer> rightSideView(TreeNode root) {
        
        List<Integer> ans = new ArrayList<>();
        if(root==null) return ans;
        Queue<TreeNode> q= new LinkedList<>();
        q.offer(root);
        while(!q.isEmpty()){
            int levelSize = q.size();
            for(int i=0; i<levelSize; i++){
                TreeNode currNode = q.poll();
                if(i==levelSize-1){
                    ans.add(currNode.val);
                }
                if(currNode.left!=null) q.offer(currNode.left);
                if(currNode.right!=null) q.offer(currNode.right);
            }
        }
        return ans;
    }
}