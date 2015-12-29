package com.zhenhao.utils;

/**
 * Created by wangzhenhao on 2015/1/27.
 */
public class Queue<T> {
    private List<T> l;

    public Queue() {
        l = new List<T>();
    }

    public void push(T ele) {
        l.insert(0, ele);
    }

    public boolean empty() {
        return l.empty();
    }

    public T pop() {
        return l.pop();
    }
}
