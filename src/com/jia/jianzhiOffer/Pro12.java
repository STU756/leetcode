package com.jia.jianzhiOffer;

/**
 *面试题12. 矩阵中的路径
 *请设计一个函数，用来判断在一个矩阵中是否存在一条包含某字符串所有字符的路径。路径可以从矩阵中的任意一格开始，每一步可以在矩阵中向左、右、上、下移动一格。如果一条路径经过了矩阵的某一格，那么该路径不能再次进入该格子。例如，在下面的3×4的矩阵中包含一条字符串“bfce”的路径（路径中的字母用加粗标出）。
 *
 * [["a","b","c","e"],
 * ["s","f","c","s"],
 * ["a","d","e","e"]]
 *
 * 但矩阵中不包含字符串“abfb”的路径，因为字符串的第一个字符b占据了矩阵中的第一行第二个格子之后，路径不能再次进入这个格子。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "ABCCED"
 * 输出：true
 * 示例 2：
 *
 * 输入：board = [["a","b"],["c","d"]], word = "abcd"
 * 输出：false
 * 提示：
 *
 * 1 <= board.length <= 200
 * 1 <= board[i].length <= 200
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/ju-zhen-zhong-de-lu-jing-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 */
public class Pro12 {
    private int rows;
    private int cols;
    int[] dx = {1, -1, 0, 0};
    int[] dy = {0, 0, 1, -1};
    private boolean[][] visited;
    public boolean exist(char[][] board, String word) {
        this.rows = board.length;
        this.cols = board[0].length;
        visited = new boolean[rows][cols];
        for(int r = 0; r < rows; r++) {
            for(int c = 0; c < cols; c++) {
                if(board[r][c] == word.charAt(0) && bracktracking(board, r, c, word, 0)) {
                    return true;
                }
            }
        }
        return false;
    }
    private boolean bracktracking(char[][] board,int r, int c, String word, int index) {
        if(index == word.length()) {
            return true;
        }
        if(r>=0 && r < rows && c>=0 && c< cols && board[r][c] == word.charAt(index) && !visited[r][c]) {
            visited[r][c] = true;
            for(int i = 0; i < 4; i++) {
                if(bracktracking(board, r + dx[i], c + dy[i], word, index + 1)){
                    return true;
                }
            }
            visited[r][c] = false;
        }
        return false;
    }
}