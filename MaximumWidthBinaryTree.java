/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class MetaNode{
    TreeNode t;
    int depth;
    int nodeNumber;
    public MetaNode(TreeNode t,int depth,int nodeNumber){
        this.t=t;
        this.depth=depth;
        this.nodeNumber=nodeNumber;
    }
}
public class MaximumWidthBinaryTree {
    public int widthOfBinaryTree(TreeNode root) {
        Deque<MetaNode> queue = new LinkedList<>();
        MetaNode n = new MetaNode(root,1,1);
        queue.add(n);
        int max = Integer.MIN_VALUE;
        while(!queue.isEmpty()){
            
            if(queue.getFirst().depth==queue.getLast().depth){
                max = Math.max(max,queue.getLast().nodeNumber - queue.getFirst().nodeNumber +1);
            }
            MetaNode m = queue.removeFirst();
            if(m.t.left!=null){
                MetaNode l = new MetaNode(m.t.left,m.depth+1,m.nodeNumber*2);
                queue.add(l);
            }
            if(m.t.right!=null){
                MetaNode r = new MetaNode(m.t.right,m.depth+1,m.nodeNumber*2+1);
                queue.add(r);
            }
        }
        return max;
    }
}
