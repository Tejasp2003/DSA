
//intution: The method uses a Queue to perform a level-order traversal of the binary tree. It starts by adding the root node to the queue. Then, it enters a loop that continues until the queue is empty. In each iteration of the loop, it calculates the size of the current level by getting the size of the queue. It then iterates through the nodes in the current level, adding their values to a sum variable. If a node has left or right children, they are added to the queue. After the loop completes, the average value of the current level is calculated by dividing the sum by the size of the level, and the result is added to the result list.

class Solution {
    public List<Double> averageOfLevels(TreeNode root) {
        List<Double> result = new ArrayList<>();
        if(root==null) return result;
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        while(!q.isEmpty()){
            int levelSize = q.size();
            double sum=0;
            for(int i=0; i<levelSize; i++){
                TreeNode currNode = q.poll();
                sum+=currNode.val;
                if(currNode.left!=null)q.offer(currNode.left);
                if(currNode.right!=null) q.offer(currNode.right);
            }
            result.add(sum/levelSize);
        }
        return result;
    }
}