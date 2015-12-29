package com.zhenhao.utils;

import java.util.EmptyStackException;

/**
 * Created by wangzhenhao on 2015/1/27.
 */
public class List<T> {
    private class Node {
        T ele;
        Node prev, next;
        
        Node(T ele) {
            this.ele = ele;
            this.prev = this.next = null;
        }
    }

    private Node head;
    private Node tail;
    private int length;
    public List() {
        head = tail = null;
        length = 0;
    }

    public int len() {
        return this.length;
    }

    public boolean empty() {
        return len() == 0;
    }

    public void insert(int pos, T ele) {
        if(empty()) {
            head = new Node(ele);
            tail = head;
        } else if(pos == 0) {
            Node n = new Node(ele);
            n.next = head;
            head.prev = n;
            head = n;
        } else if(pos >= len()) {
            Node n = new Node(ele);
            n.prev = tail;
            tail.next = n;
            tail = n;
        } else {
            Node p = head;
            Node q = p;
            while(p != null && pos > 0) {
                q = p;
                p = p.next;
                pos--;
            }
            Node n = new Node(ele);
            n.prev = q;
            n.next = q.next;
            q.next.prev = n;
            q.next = n;
        }
        length++;
    }

    public void push(T ele) {
        if(empty()) {
            head = new Node(ele);
            tail = head;
        } else {
            Node n = new Node(ele);
            n.prev = tail;
            tail.next = n;
            tail = n;
        }
        length++;
    }

    public T pop() {
        if(empty()) {
            throw new EmptyStackException();
        }
        T v = tail.ele;
        tail = tail.prev;
        length--;
        if(length == 0) {
            head = tail;
        }
        return v;
    }
}
