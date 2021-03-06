package com.jia.leetCode;

import java.util.Arrays;
import java.util.Comparator;

/**
 * 给出一个区间的集合，请合并所有重叠的区间。

示例 1:

输入: [[1,3],[2,6],[8,10],[15,18]]
输出: [[1,6],[8,10],[15,18]]
解释: 区间 [1,3] 和 [2,6] 重叠, 将它们合并为 [1,6].
示例 2:

输入: [[1,4],[4,5]]
输出: [[1,5]]
解释: 区间 [1,4] 和 [4,5] 可被视为重叠区间。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/merge-intervals
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author Administrator
 *
 */
public class Pro0056 {

    public int[][] merge(int[][] intervals) {
        if(intervals == null || intervals.length == 0) {
            return intervals;
        }
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] -o2[0];
            }
        });

        int last = 0;
        int[][] ans = new int[intervals.length][2];
        int index = 0;
        for(int i = 1; i<intervals.length; i++){

            if(intervals[i][0] <= intervals[last][1]){
                intervals[last][1] = Math.max(intervals[last][1], intervals[i][1]);
            }else{
                ans[index][0] = intervals[last][0];
                ans[index][1] = intervals[last][1];
                ++index;
                last = i;
            }
        }
        ans[index][0] = intervals[last][0];
        ans[index][1] = intervals[last][1];
        return Arrays.copyOf(ans, index+1);
    }

}
