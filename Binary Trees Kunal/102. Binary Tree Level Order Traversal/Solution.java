class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if(root==null) return result;
        Queue<TreeNode> queue= new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty()){
            int levelSize= queue.size();
            List<Integer> currLevelList= new ArrayList<>();
            for(int i =0; i<levelSize; i++){  
                TreeNode currNode= queue.poll();
                currLevelList.add(currNode.val);
                if(currNode.left !=null) queue.add(currNode.left);
                if(currNode.right !=null) queue.add(currNode.right);

            }
            result.add(currLevelList);
        }
        return result;
    }
}