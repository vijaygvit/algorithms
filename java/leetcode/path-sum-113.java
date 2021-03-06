/**
 * Given a binary tree and a sum, find all root-to-leaf paths where each path's sum equals the given sum.
 */
public class Solution {
  public List<List<Integer>> hasPathSum(TreeNode root, int sum) {
    List<List<Integer>> list = new ArrayList<List<Integer>>();
    if (root == null) return list;
    List<Integer> cur = new ArrayList<Integer>();
    hasPathSum(root, sum, list, cur);
    return list;
  }

  public void helper(TreeNode node, int sum, List<List<Integer>> list, List<Integer> cur) {
    if (node == null) return;
    if (isLeaf(node)) {
      if (sum == node.val) {
        cur.add(node.val);
        list.add(new ArrayList<Integer>(cur));
      }

      return;
    }

    cur.add(node.val);

    hasPathSum(root.left, sum - root.val, list, new ArrayList<Integer>(cur));
    hasPathSum(root.right, sum - root.val, list, new ArrayList<Integer>(cur));
  }

  public boolean isLeaf(TreeNode node) {
    return node != null && node.left == null && node.right == null;
  }
}