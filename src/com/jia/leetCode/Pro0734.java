package com.jia.leetCode;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
/**
 * 734. 句子相似性
 * 
 * 给定两个句子 words1, words2 （每个用字符串数组表示），和一个相似单词对的列表 pairs ，判断是否两个句子是相似的。

	例如，当相似单词对是 pairs = [["great", "fine"], ["acting","drama"], ["skills","talent"]]的时候，"great acting skills" 和 "fine drama talent" 是相似的。
	
	注意相似关系是不具有传递性的。例如，如果 "great" 和 "fine" 是相似的，"fine" 和 "good" 是相似的，但是 "great" 和 "good" 未必是相似的。
	
	但是，相似关系是具有对称性的。例如，"great" 和 "fine" 是相似的相当于 "fine" 和 "great" 是相似的。
	
	而且，一个单词总是与其自身相似。例如，句子 words1 = ["great"], words2 = ["great"], pairs = [] 是相似的，尽管没有输入特定的相似单词对。
	
	最后，句子只会在具有相同单词个数的前提下才会相似。所以一个句子 words1 = ["great"] 永远不可能和句子 words2 = ["doubleplus","good"] 相似。
	
	 
	
	注：
	
	words1 and words2 的长度不会超过 1000。
	pairs 的长度不会超过 2000。
	每个pairs[i] 的长度为 2。
	每个 words[i] 和 pairs[i][j] 的长度范围为 [1, 20]。

 * 
 * @author Administrator
 *
 */
public class Pro0734 {
    public boolean areSentencesSimilar(String[] words1, String[] words2, List<List<String>> pairs) {
        if(words1.length!=words2.length) return false;
        Map<String,String> map = new HashMap<>();
        for(List<String> pair: pairs) {
            map.put(pair.get(0), pair.get(1));
            map.put(pair.get(1), pair.get(0));
        }
        for(int i = 0; i < words1.length; i++) {
            if(!map.get(words1[i]).equals(words2[i])) return false;
        }
        return true;
    }
}
