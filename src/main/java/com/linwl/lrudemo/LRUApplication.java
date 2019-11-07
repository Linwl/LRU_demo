package com.linwl.lrudemo;

import com.linwl.lrudemo.entity.ListNode;
import com.linwl.lrudemo.service.LRUCache;

/**
 * @author ：linwl
 * @date ：Created in 2019/11/7 14:50
 * @description ：
 * @modified By：
 */
public class LRUApplication {

    public static void main(String[] args)
    {
        LRUCache<ListNode> cache = new LRUCache<>(4);
        ListNode<String, Integer> node1 = new ListNode<>("key1", 1);
        ListNode<String, Integer> node2 = new ListNode<>("key2", 2);
        ListNode<String, Integer> node3 = new ListNode<>("key3", 3);
        ListNode<String, Integer> node4 = new ListNode<>("key4", 4);
        ListNode<String, Integer> node5 = new ListNode<>("key5", 5);
        ListNode<String, Integer> node6 = new ListNode<>("key6", 6);
        cache.put("key1", node1);
        cache.put("key2", node2);
        cache.put("key3", node3);
        cache.put("key4", node4);
        System.out.println(cache.get("key2"));
        cache.put("key5", node5);
        System.out.println(cache.get("key1"));
        cache.put("key6", node6);
        System.out.println(cache.get("key3"));
        System.out.println(cache.get("key2"));
        System.out.println(cache.get("key6"));
    }
}
