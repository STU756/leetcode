package com.jia.leetCode;

import java.util.ArrayList;
import java.util.List;

/**
 * 60.第k个排列
 *
 *给出集合 [1,2,3,…,n]，其所有元素共有 n! 种排列。
 *
 * 按大小顺序列出所有排列情况，并一一标记，当 n = 3 时, 所有排列如下：
 *
 * "123"
 * "132"
 * "213"
 * "231"
 * "312"
 * "321"
 * 给定 n 和 k，返回第 k 个排列。
 *
 * 说明：
 *
 * 给定 n 的范围是 [1, 9]。
 * 给定 k 的范围是[1,  n!]。
 * 示例 1:
 *
 * 输入: n = 3, k = 3
 * 输出: "213"
 * 示例 2:
 *
 * 输入: n = 4, k = 9
 * 输出: "2314"
 *
 *
 *
 */
public class Pro0060 {

    /**
     直接用回溯法做的话需要在回溯到第k个排列时终止就不会超时了, 但是效率依旧感人
     可以用数学的方法来解, 因为数字都是从1开始的连续自然数, 排列出现的次序可以推
     算出来, 对于n=4, k=15 找到k=15排列的过程:

     1 + 对2,3,4的全排列 (3!个)
     2 + 对1,3,4的全排列 (3!个)         3, 1 + 对2,4的全排列(2!个)
     3 + 对1,2,4的全排列 (3!个)-------> 3, 2 + 对1,4的全排列(2!个)-------> 3, 2, 1 + 对4的全排列(1!个)-------> 3214
     4 + 对1,2,3的全排列 (3!个)         3, 4 + 对1,2的全排列(2!个)         3, 2, 4 + 对1的全排列(1!个)

     确定第一位:
     k = 14(从0开始计数)
     index = k / (n-1)! = 2, 说明第15个数的第一位是3
     更新k
     k = k - index*(n-1)! = 2
     确定第二位:
     k = 2
     index = k / (n-2)! = 1, 说明第15个数的第二位是2
     更新k
     k = k - index*(n-2)! = 0
     确定第三位:
     k = 0
     index = k / (n-3)! = 0, 说明第15个数的第三位是1
     更新k
     k = k - index*(n-3)! = 0
     确定第四位:
     k = 0
     index = k / (n-4)! = 0, 说明第15个数的第四位是4
     最终确定n=4时第15个数为3214
     **/

    public String getPermutation(int n, int k) {
        int[] factorials = new int[n+1];//分母阶乘数
        factorials[0] = 1;
        int fac = 1;
        List<Integer> candidates = new ArrayList<Integer>();//候选数字
        for(int i = 1; i <=n; i++) {
            candidates.add(i);
            fac *= i;
            factorials[i] = fac;
        }
        k -= 1;
        StringBuilder sb = new StringBuilder();
        for(int i = n - 1; i >=0; --i) {
            int index = k / factorials[i];
            sb.append(candidates.remove(index)); //秒
            k -= index * factorials[i];
        }
        return sb.toString();
    }

}
