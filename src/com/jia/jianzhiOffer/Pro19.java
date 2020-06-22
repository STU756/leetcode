package com.jia.jianzhiOffer;
/**
 * 题目描述
请实现一个函数用来匹配包括'.'和'*'的正则表达式。模式中的字符'.'表示任意一个字符，
而'*'表示它前面的字符可以出现任意次（包含0次）。 在本题中，匹配是指字符串的所有字符匹配整个模式。
例如，字符串"aaa"与模式"a.a"和"ab*ac*a"匹配，但是与"aa.a"和"ab*a"均不匹配
 * @author Administrator
 *
 */
public class Pro19 {
    public boolean match(char[] str, char[] pattern)
    {
        int m = str.length, n = pattern.length;
        boolean[][] dp = new boolean[m+1][n+1];
        dp[0][0] = true;
        for(int i = 1; i <=n; i++) {
            if(i>1 && pattern[i-1] == '*'){
                dp[0][i] = dp[0][i - 2];//忽略掉（[a-z]|.|(A-Z)）*
            }
        }
        for(int i = 1; i <= m; i++) {
            for(int j = 1; j <= n; j++) {
                if(str[i-1] == pattern[j-1] || pattern[j-1]=='.'){
                    dp[i][j] = dp[i-1][j-1];
                }else if(pattern[j - 1] =='*') {
                    if(pattern[j-2] == str[i-1] || pattern[j-2]=='.') {
                        dp[i][j] |= dp[i][j - 2];//忽略a*
                        dp[i][j] |= dp[i][j-1];   //a*匹配一个    a,这里有点拗口，dp[i][j]只匹配一个,即看s[0..i]与没有带*时p[0..j-1]是否匹配
                        dp[i][j] |= dp[i-1][j];     //a*匹配多个 ...aa     即s[0..i-1]是否与  p[0..j]是否匹配
                    }else {
                        //忽略a*
                        dp[i][j] = dp[i][j-2];
                    }
                }
            }
        }
        return dp[m][n];
    }
}
