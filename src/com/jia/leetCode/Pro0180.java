package com.jia.leetCode;
/**
 * 
 * 
 * 编写一个 SQL 查询，查找所有至少连续出现三次的数字。

+----+-----+
| Id | Num |
+----+-----+
| 1  |  1  |
| 2  |  1  |
| 3  |  1  |
| 4  |  2  |
| 5  |  1  |
| 6  |  2  |
| 7  |  2  |
+----+-----+
例如，给定上面的 Logs 表， 1 是唯一连续出现至少三次的数字。

+-----------------+
| ConsecutiveNums |
+-----------------+
| 1               |
+-----------------+

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/consecutive-numbers
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author Administrator
 *
 */
public class Pro0180 {
/**
 * select distinct a.Num as ConsecutiveNums from
(select t.Num, 
    @cnt:=IF(@pre=t.Num, @cnt + 1, 1) as cnt,
    @pre:=t.Num as pre
from Logs as t, (Select @pre:=null, @cnt:=0) as b) as a
where a.cnt >= 3;
 */
}
