package com.jia.leetCode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 给你两个数组，arr1 和 arr2，

arr2 中的元素各不相同
arr2 中的每个元素都出现在 arr1 中
对 arr1 中的元素进行排序，使 arr1 中项的相对顺序和 arr2 中的相对顺序相同。未在 arr2 中出现过的元素需要按照升序放在 arr1 的末尾。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/relative-sort-array
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author Administrator
 *
 *
 *	桶排序
 */
public class Pro1122 {
    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        int[] m = new int[1001];

        int[] ref = new int[arr1.length];

        for(int i = 0; i < arr1.length; i++) {
            m[arr1[i]]++;
        }

        int cnt = 0;
        for(int i = 0; i < arr2.length; i++) {
            while(m[arr2[i]] > 0) {
                ref[cnt++] = arr2[i];
                m[arr2[i]]--;
            }
        }

        for(int i = 0; i < 1001; i++) {
            while(m[i] > 0) {
                ref[cnt++] = i;
                m[i]--;
            }
        }
        return ref;
}
    public static void main(String[] args) {
    	Pro1122 pro1122 = new Pro1122();
    	int[] arr1 = {2,3,1,3,2,4,6,7,9,2,19};
    	int[] arr2 = {2,1,4,3,9,6};
    	System.out.println(Arrays.toString(pro1122.relativeSortArray(arr1, arr2)));
	}
}
