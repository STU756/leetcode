package com.jia.leetCode;

/**
 * 243. 最短单词距离
 * 
 * 给定一个单词列表和两个单词 word1 和 word2，返回列表中这两个单词之间的最短距离。

示例:
假设 words = ["practice", "makes", "perfect", "coding", "makes"]

输入: word1 = “coding”, word2 = “practice”
输出: 3
输入: word1 = "makes", word2 = "coding"
输出: 1
注意:
你可以假设 word1 不等于 word2, 并且 word1 和 word2 都在列表里。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/shortest-word-distance
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author Administrator
 *
 */
public class Pro0243 {
	public int shortestDistance(String[] words, String word1, String word2) {
	    int minDistance = words.length;
	    int index1 = -1, index2 = -1;
	    for(int i = 0; i < words.length; i++) {
	        if(words[i].equals(word1)) {
	            index1 = i;
	        }
	        if(words[i].equals(word2)) {
	            index2 = i;
	        }
	        if(index1 != -1 && index2 != -1) {
	        minDistance = Math.min(minDistance, Math.abs(index1 - index2));
	        }
	    }
	    return minDistance;
	}
}
