package com.jia.leetCode;
/**
 * 质数排列
 * 
 * 请你帮忙给从 1 到 n 的数设计排列方案，使得所有的「质数」都应该被放在「质数索引」（索引从 1 开始）上；你需要返回可能的方案总数。

让我们一起来回顾一下「质数」：质数一定是大于 1 的，并且不能用两个小于它的正整数的乘积来表示。

由于答案可能会很大，所以请你返回答案 模 mod 10^9 + 7 之后的结果即可。

 

示例 1：

输入：n = 5
输出：12
解释：举个例子，[1,2,5,4,3] 是一个有效的排列，但 [5,2,3,4,1] 不是，因为在第二种情况里质数 5 被错误地放在索引为 1 的位置上。
示例 2：

输入：n = 100
输出：682289015
 

提示：

1 <= n <= 100

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/prime-arrangements
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * 
 * @author Administrator
 *
 */
public class Pro1175 {
	private static final int MODVALUE = 1000000007;
    public int numPrimeArrangements(int n) {
    	//质数个数为m，非质数个数为n-m,根据题目全排列为A(m,m)*A(n-m,n-m)
    	int m = countPrimes(n);
    	long ans = 1;//防止Integer溢出
    	for(int i = 2; i <= m; i++) {
    		ans *= i;
    		ans %= MODVALUE;
    	}
    	for(int i = 2; i <= n - m; i++) {
    		ans *= i;
    		ans %= MODVALUE;
    	}
    	return (int) ans;
    } 
    private int countPrimes(int n) {
    	int ans = 0;
    	for(int i = 2; i <= n; i++) {
    		if(isPrime(i)) 
    			++ans;
    	}
    	return ans;
    }
	private boolean isPrime(int n) {
		if(n<2) return false;
		for(int i =2; i<= Math.sqrt(n); i++) { //2和3已经是质数不需要讨论，该循环没有包含到
			if(n%i ==0) return false;
		}
		return true;
	}
	public static void main(String[] args) {
		Pro1175 pro1175 = new Pro1175();
		System.out.println(pro1175.countPrimes(5));;
	}
}
