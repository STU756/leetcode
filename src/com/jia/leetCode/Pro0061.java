package com.jia.leetCode;
/**
 * 61. 旋转链表
 * 
 * 给定一个链表，旋转链表，将链表每个节点向右移动 k 个位置，其中 k 是非负数。

	示例 1:
	
	输入: 1->2->3->4->5->NULL, k = 2
	输出: 4->5->1->2->3->NULL
	解释:
	向右旋转 1 步: 5->1->2->3->4->NULL
	向右旋转 2 步: 4->5->1->2->3->NULL
	示例 2:
	
	输入: 0->1->2->NULL, k = 4
	输出: 2->0->1->NULL
	解释:
	向右旋转 1 步: 2->0->1->NULL
	向右旋转 2 步: 1->2->0->NULL
	向右旋转 3 步: 0->1->2->NULL
	向右旋转 4 步: 2->0->1->NULL
	
 * 
 * @author Administrator
 *
 */
public class Pro0061 {
    public ListNode rotateRight(ListNode head, int k) {
        ListNode tail = head;
        int len = 1;
        while(tail!=null && tail.next!= null) {
        	++len;
        	tail = tail.next;
        }
        k %= len;
        if(k == 0) return head;
        int n = len - k;
        ListNode cur = head;
        while(--n > 0) {
        	cur = cur.next;
        }
        ListNode post = cur.next;
        cur.next = null;
        tail.next = head;
        return post;
    }
}
