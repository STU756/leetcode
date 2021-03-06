package com.jia.leetCode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 1213. 三个有序数组的交集
 * 给出三个均为 严格递增排列 的整数数组 arr1，arr2 和 arr3。

返回一个由 仅 在这三个数组中 同时出现 的整数所构成的有序数组。

 

示例：

输入: arr1 = [1,2,3,4,5], arr2 = [1,2,5,7,9], arr3 = [1,3,4,5,8]
输出: [1,5]
解释: 只有 1 和 5 同时在这三个数组中出现.
 

提示：

1 <= arr1.length, arr2.length, arr3.length <= 1000
1 <= arr1[i], arr2[i], arr3[i] <= 2000

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/intersection-of-three-sorted-arrays
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author Administrator
 *
 */
public class Pro1213 {
    public List<Integer> arraysIntersection(int[] arr1, int[] arr2, int[] arr3) {
        Map<Integer,Integer> map = new HashMap<>();
        List<Integer> ans = new ArrayList<>();
        for(int i = 0; i < arr1.length; i++) {
        	map.put(arr1[i], map.getOrDefault(arr1[i], 0) + 1);
        }
        for(int i = 0; i < arr2.length; i++) {
        	map.put(arr2[i], map.getOrDefault(arr2[i], 0) + 1);
        }
        for(int i = 0; i < arr3.length; i++) {
        	if(map.containsKey(arr3[i]) && map.get(arr3[i]) == 2)  ans.add(arr3[i]);
        }
        return ans;
    }
    public static void main(String[] args) {
		int[] arr1 = {1,2,3,4,5};
		int[] arr2 = {1,2,5,7,9};
		int[] arr3 = {1,3,4,5,8};
		Pro1213 pro1213 = new Pro1213();
		pro1213.arraysIntersection(arr1, arr2, arr3);
	}
}
