package com.jia.leetCode;
/**
 * 表 point_2d 保存了所有点（多于 2 个点）的坐标 (x,y) ，这些点在平面上两两不重合。

 

写一个查询语句找到两点之间的最近距离，保留 2 位小数。

 

| x  | y  |
|----|----|
| -1 | -1 |
| 0  | 0  |
| -1 | -2 |
 

最近距离在点 (-1,-1) 和(-1,2) 之间，距离为 1.00 。所以输出应该为：

 

| shortest |
|----------|
| 1.00     |
 

注意：任意点之间的最远距离小于 10000 。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/shortest-distance-in-a-plane
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * 
 * @author Administrator
 *
 */
public class Pro0612 {
/**
 * SELECT
    round(SQRT(min((POW(p1.x - p2.x, 2) + POW(p1.y - p2.y, 2)))),2) AS shortest
FROM
    point_2d p1
        JOIN
    point_2d p2 ON p1.x != p2.x OR p1.y != p2.y
 */
}
