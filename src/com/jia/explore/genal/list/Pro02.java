package com.jia.explore.genal.list;
/**
 * 
 * 删除链表的倒数第N个节点
给定一个链表，删除链表的倒数第 n 个节点，并且返回链表的头结点。

示例：

给定一个链表: 1->2->3->4->5, 和 n = 2.

当删除了倒数第二个节点后，链表变为 1->2->3->5.
说明：

给定的 n 保证是有效的。

进阶：

你能尝试使用一趟扫描实现吗？
 * 
 * @author Administrator
 *
 */
public class Pro02 {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode first = head;
        while(n--!=0) {
            first = first.next;
        }
        if(first==null) return head.next;
        ListNode second = head;
        while(first.next !=null) {
            first = first.next;
            second = second.next;
        }
        second.next = second.next.next;
        return head;
    }
}
