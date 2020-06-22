package com.jia.leetCode;

/**
 * 1013.将数组分成和相等的三个部分
 * 给定一个整数数组 A，只有我们可以将其划分为三个和相等的非空部分时才返回 true，否则返回 false。

形式上，如果我们可以找出索引 i+1 < j 且满足 (A[0] + A[1] + ... + A[i] == A[i+1] + A[i+2] + ... + A[j-1] == A[j] + A[j-1] + ... + A[A.length - 1]) 就可以将数组三等分。

 

示例 1：

输出：[0,2,1,-6,6,-7,9,1,2,0,1]
输出：true
解释：0 + 2 + 1 = -6 + 6 - 7 + 9 + 1 = 2 + 0 + 1
示例 2：

输入：[0,2,1,-6,6,7,9,-1,2,0,1]
输出：false
示例 3：

输入：[3,3,6,5,-2,2,5,1,-9,4]
输出：true
解释：3 + 3 = 6 = 5 - 2 + 2 + 5 + 1 - 9 + 4
 

提示：

3 <= A.length <= 50000
-10000 <= A[i] <= 10000
 * @author Administrator
 *
 */
public class Pro1013 {
	/*
    public boolean canThreePartsEqualSum(int[] A) {
        int sum = 0;
        for(int a : A) {
        	sum+=a;
        }
        if(sum%3!=0) return false;
        int path = sum /3;
        sum = 0;
        int count = 0;
        for(int i = 0; i < A.length; i++) {
        	sum += A[i];
        	if(sum == path) {
        		sum = 0;
        		++count;
        	}
        }
        return count == 3;
    }
    */
    public boolean canThreePartsEqualSum(int[] A) {
        int sum = 0;
        for(int a : A) {
            sum += a;
        }
        if(sum % 3 != 0) return false;
        int path = sum / 3;
        int count = 0;
        sum = 0;
        for(int i = 0; i < A.length; i++) {
            sum += A[i];
            if(sum == path) {
                sum = 0;
                ++count;
            }
        }
        return count >= 3;

    }
    public static void main(String[] args) {
		int[] A = {10,-10,10,-10,10,-10,10,-10};
		Pro1013 pro1013 = new Pro1013();
		System.out.println(pro1013.canThreePartsEqualSum(A));;
	}
}
