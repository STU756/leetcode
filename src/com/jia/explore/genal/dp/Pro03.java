package com.jia.explore.genal.dp;

import java.util.Arrays;

/**
 * 最大子序和

 * 
 * 
 * 给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。

示例:

输入: [-2,1,-3,4,-1,2,1,-5,4],
输出: 6
解释: 连续子数组 [4,-1,2,1] 的和最大，为 6。
进阶:

如果你已经实现复杂度为 O(n) 的解法，尝试使用更为精妙的分治法求解。
 * 
 * @author Administrator
 *
 */
public class Pro03 {
    public int maxSubArray(int[] nums) {
        //前i相的最大子续和为dp[i] = max(dp[i-1] + nums[i], nums[i])
    	int pre = nums[0];
    	int max = nums[0];
    	for(int i = 1; i < nums.length; i++) {
    		pre = Math.max(pre + nums[i], nums[i]);
    		max = Math.max(max, pre);
    	}
    	return max;
    }
    public static void main(String[] args) {
		int[] nums = {-2,1,-3,4,-1,2,1,-5,4};
		Pro03 pro03 = new Pro03();
		System.out.println(pro03.maxSubArray(nums));
	}
}