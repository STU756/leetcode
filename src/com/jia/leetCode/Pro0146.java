package com.jia.leetCode;

import java.util.HashMap;
import java.util.Map;

/**
 * LRUCache  最近最少使用
 * 使用哈希表 + 双端链表 实现
 *
 *
 */
public class Pro0146 {
    /**
     * 缓存映射表
     */
    private Map<Integer, DLinkNode> cache = new HashMap<>();
    private int size;
    private int capacity;
    private DLinkNode head, tail;

    /**
     * 链表节点类
     */
    private static class DLinkNode{
        Integer key;
        Integer value;
        DLinkNode prev;
        DLinkNode next;
        DLinkNode(){

        }
        DLinkNode(Integer key, Integer value) {
            this.key = key;
            this.value = value;
        }
    }

    public Pro0146(int capacity) {
        //初始化缓存大小，容量和头尾节点
        this.size = 0;
        this.capacity = capacity;
        head = new DLinkNode();
        tail = new DLinkNode();
        head.next = tail;
        tail.prev = head;
    }


    /**
     * 获取节点
     * @param key  节点的键
     * @return  返回节点的值
     */
    public int get(int key) {
        DLinkNode node = cache.get(key);
        if(node == null) {
            return -1;
        }
        //移动到链表的头部
        moveToHead(node);
        return node.value;
    }

    private void moveToHead(DLinkNode node) {
        removeNode(node);
        addToHead(node);
    }

    public void put(int key, int value) {
        DLinkNode node = cache.get(key);
        if(node == null) {
            DLinkNode newNode = new DLinkNode(key, value);
            cache.put(key, newNode);
            //添加到链表头部
            addToHead(newNode);
            ++size;
            //如果缓存已满，需要清理尾部节点
            if(size > capacity) {
                DLinkNode tail = removeTail();
                cache.remove(tail.key);
                --size;
            }
        }else {
            node.value = value;
            //移动到链表的头部
            moveToHead(node);
        }
    }

    private DLinkNode removeTail() {
        DLinkNode node = tail.prev;
        //删除节点
        removeNode(node);
        return node;
    }

    private void removeNode(DLinkNode node) {
        node.next.prev = node.prev;
        node.prev.next = node.next;
    }

    private void addToHead(DLinkNode node) {
        node.prev = head;
        node.next = head.next;
        head.next.prev = node;
        head.next = node;
    }
}
