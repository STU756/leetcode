package com.jia.leetCode;
/**
 * 
 * 1118. 一月有多少天
 * 
 * 指定年份 Y 和月份 M，请你帮忙计算出该月一共有多少天。

 

示例 1：

输入：Y = 1992, M = 7
输出：31
示例 2：

输入：Y = 2000, M = 2
输出：29
示例 3：

输入：Y = 1900, M = 2
输出：28
 

提示：

1583 <= Y <= 2100
1 <= M <= 12

 * @author Administrator
 *
 */
public class Pro1118 {
    public int numberOfDays(int Y, int M) {
        int[] moths = {31,28,31,30,31,30,31,31,30,31,30,31};
        return M == 2?(Y%400==0 || (Y%100!=0 && Y%4==0))?29:28 : moths[M-1];
    }
}
