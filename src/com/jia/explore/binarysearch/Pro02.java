package com.jia.explore.binarysearch;
/**
 * 
 * x的平方根
 * 
 * 实现 int sqrt(int x) 函数。

	计算并返回 x 的平方根，其中 x 是非负整数。
	
	由于返回类型是整数，结果只保留整数的部分，小数部分将被舍去。
	
	示例 1:
	
	输入: 4
	输出: 2
	示例 2:
	
	输入: 8
	输出: 2
	说明: 8 的平方根是 2.82842..., 
     由于返回类型是整数，小数部分将被舍去。
 * 
 * @author Administrator
 *
 */
/**
 * 二分查找法应用于搜索平方根的思想很简单，其实就是“猜”，但是是有策略的“猜”，用“排除法”在有限的区间里，一次排除一半的区间元素，最后只剩下一个数，这个数就是题目要求的向下取整的平方根整数。

牛顿法最初提出的时候，是用于求解方程的根，它的基本思想是“以直代曲”，在迭代中搜索得到方程的近似解。

方法一：二分法
思路分析：使用二分法搜索平方根的思想很简单，就类似于小时候我们看的电视节目中的“猜价格”游戏，高了就往低了猜，低了就往高了猜，范围越来越小。因此，使用二分法猜算术平方根就很自然。

一个数的平方根肯定不会超过它自己，不过直觉还告诉我们，一个数的平方根最多不会超过它的一半，例如 88 的平方根，88 的一半是 44，4^2=16>84 
2
 =16>8，如果这个数越大越是如此，因此我们要计算一下，这个边界是多少。为此，解如下不等式：

\left(\cfrac{a}{2}\right)^2 \ge a
( 
2
a
​	
 ) 
2
 ≥a

意即：如果一个数的一半的平方大于它自己，那么这个数的取值范围。解以上不等式得 a \ge 4a≥4 或者 a \le 0a≤0。

于是边界值就是 44，那么对 00、11、22、33 分别计算结果，很容易知道，这 44 个数的平方根依次是 00、11、11、11。

注意：这 44 个特值如果没有考虑到，有可能导致你设置的搜索边界不正确。在使用二分法寻找平方根的时候，要特别注意边界值的选择，以下给出两个参考代码。

参考代码 1：所有的数都放在一起考虑，为了照顾到 00 把左边界设置为 00，为了照顾到 11 把右边界设置为 x // 2 + 1。

作者：liweiwei1419
链接：https://leetcode-cn.com/problems/sqrtx/solution/er-fen-cha-zhao-niu-dun-fa-python-dai-ma-by-liweiw/
来源：力扣（LeetCode）
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 * @author Administrator
 *
 */
public class Pro02 {
    public int mySqrt(int x) {
    	//long类型照顾特殊测试用例2147395599，mid*mid会溢出
    	//left = 0照顾0把左边界设为0，right=x/2+1 加一是为了照顾右边界1
    	long left = 0, right = x / 2 + 1;
    	while(left < right) {
    		//这里一定取右中位数，如果取左中位数，代码会进入死循环
    		long mid = (left + right + 1) >> 1;
    		if(mid * mid > x) {
    			right = mid - 1;
    		}else {
    			left = mid;
    		}
    	}
    	return (int) left;
    }
}
