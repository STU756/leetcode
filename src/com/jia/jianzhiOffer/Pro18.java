package com.jia.jianzhiOffer;
/**
 * 面试题18. 删除链表的节点
 * 给定单向链表的头指针和一个要删除的节点的值，定义一个函数删除该节点。

返回删除后的链表的头节点。

注意：此题对比原题有改动

示例 1:

输入: head = [4,5,1,9], val = 5
输出: [4,1,9]
解释: 给定你链表中值为 5 的第二个节点，那么在调用了你的函数之后，该链表应变为 4 -> 1 -> 9.
示例 2:

输入: head = [4,5,1,9], val = 1
输出: [4,5,9]
解释: 给定你链表中值为 1 的第三个节点，那么在调用了你的函数之后，该链表应变为 4 -> 5 -> 9.
 

说明：

题目保证链表中节点的值互不相同
若使用 C 或 C++ 语言，你不需要 free 或 delete 被删除的节点
 * @author Administrator
 *
 */
public class Pro18 {
    public ListNode deleteDuplication(ListNode pHead)
    {
        if(pHead == null|| pHead.next == null) {
            return pHead;
        }
        ListNode pre = pHead, cur = pHead.next;
        if(pre.val == cur.val) {
            while(cur!=null && cur.val == pre.val) {
                cur = cur.next;
            }
            return deleteDuplication(cur);
        }else {
            pre.next = deleteDuplication(cur);
        }
        return pre;
    }

    public ListNode deleteNode(ListNode head, int val) {
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode cur = dummy;
        while(cur.next!=null && cur.next.val != val) {
            cur = cur.next;
        }
        if(cur.next!=null) {
            cur.next = cur.next.next;
        }
        return dummy.next;
    }
}
