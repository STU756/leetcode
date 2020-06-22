package com.jia.leetCode;

import java.util.ArrayList;
import java.util.List;

/**
 * 872.叶子相似的树
 * 
 * 请考虑一颗二叉树上所有的叶子，这些叶子的值按从左到右的顺序排列形成一个 叶值序列 。

	
	
	举个例子，如上图所示，给定一颗叶值序列为 (6, 7, 4, 9, 8) 的树。
	
	如果有两颗二叉树的叶值序列是相同，那么我们就认为它们是 叶相似 的。
	
	如果给定的两个头结点分别为 root1 和 root2 的树是叶相似的，则返回 true；否则返回 false 。
	
	 
	
	提示：
	
	给定的两颗树可能会有 1 到 100 个结点。

 * 
 * @author Administrator
 *
 */
public class Pro0872 {
	public boolean leafSimilar(TreeNode root1, TreeNode root2) {
		List<Integer> leaf1 = new ArrayList<>();
		List<Integer> leaf2 = new ArrayList<>();
		dfs(root1, leaf1);
		dfs(root2, leaf2);
		return leaf1.equals(leaf2);
	}

	private void dfs(TreeNode node, List<Integer> leafList) {
		// TODO Auto-generated method stub
		if(node == null) return;
		if(node.left == null && node.right == null)
			leafList.add(node.val);
		dfs(node.left, leafList);
		dfs(node.right, leafList);
	}
}	
