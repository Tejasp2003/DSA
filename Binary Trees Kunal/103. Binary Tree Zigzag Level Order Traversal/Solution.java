class Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        if(root==null) return ans;
        Queue<TreeNode> q= new LinkedList<>();
        q.offer(root);
        boolean reverse= false;
        while(!q.isEmpty()){
            int levelSize= q.size();
            LinkedList<Integer> temp = new LinkedList<>();
            for(int i=0; i<levelSize; i++){
                TreeNode currNode = q.poll();
                if(reverse){
                    temp.addFirst(currNode.val);
                }
                else{
                    temp.add(currNode.val);
                }
                if(currNode.left!=null) q.offer(currNode.left);
                if(currNode.right!=null) q.offer(currNode.right);
                
               
              
            }
             ans.add(temp);
                reverse = !reverse;
        }
        return ans;

    }
}