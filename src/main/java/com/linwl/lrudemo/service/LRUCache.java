package com.linwl.lrudemo.service;

import com.linwl.lrudemo.entity.ListNode;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author ：linwl
 * @date ：Created in 2019/11/7 14:57
 * @description ：
 * @modified By：
 */
public class LRUCache<V> {

    /**
     * 容量
     */
    private int capacity =1024;

    /**
     * 节点记录表
     */
    private Map<String, ListNode<String, V>> table = new ConcurrentHashMap<>();

    /**
     * 双向链表头部
     */
    private ListNode<String,V> head;

    /**
     * 双向链表尾部
     */
    private ListNode<String,V> tail;

    public LRUCache(int capacity)
    {
        this();
        this.capacity =capacity;
    }

    public LRUCache()
    {
        head =new ListNode<>();
        tail =new ListNode<>();
        head.setNext(tail);
        head.setPrev(null);
        tail.setPrev(head);
        tail.setNext(null);
    }


    public V get(String key)
    {
        ListNode<String,V> node = table.get(key);
       //缓存不存在
        if(node == null)
        {
            return null;
        }
        //如果存在，则需要移动Node节点到表头
        //截断node
        node.getPrev().setNext(node.getNext());
        node.getNext().setPrev(node.getPrev());
        //移动到表头
        node.setNext(head.getNext());
        node.setPrev(head);
        head.getNext().setPrev(node);
        head.setNext(node);
        table.put(key,node);
        return node.getValue();
    }

    public void put(String key,V value)
    {
        ListNode<String, V> node = table.get(key);
        //如果Node不在表中，代表缓存中并没有
        if (node == null) {
            if(table.size() == capacity)
            {
                //超容量了,移除尾部缓存
                table.remove(tail.getPrev().getKey());
                tail.setPrev(tail.getPrev().getPrev());
                tail.setNext(null);
            }
            node =new ListNode<>(key,value);
            table.put(key,node);
        }
        //移动Node节点到表头
        node.setNext(head.getNext());
        head.getNext().setPrev(node);
        node.setPrev(head);
        head.setNext(node);

    }
}
