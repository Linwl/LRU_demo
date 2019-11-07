package com.linwl.lrudemo.entity;

import lombok.Data;

/**
 * @author ：linwl
 * @date ：Created in 2019/11/7 14:52
 * @description ：
 * @modified By：
 */
@Data
public class ListNode<K,V> {

    /**
     * 索引key
     */
    private K key;

    /**
     * 数据
     */
    private V value;

    /**
     * 上一个节点
     */
    private ListNode<K,V> prev;

    /**
     * 下一个节点
     */
    private ListNode<K,V> next;

    public ListNode(K key,V value)
    {
        this.key =key;
        this.value =value;
    }

    public ListNode()
    {

    }
}
