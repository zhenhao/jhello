package com.zhenhao.utils;

/**
 * Created by wangzhenhao on 2015/1/27.
 */
public class Stack<T>{
    private List<T> l;

    public Stack() {
        l = new List<T>();
    }

    public void push(T ele) {
        l.push(ele);
    }

    public boolean empty() {
        return l.empty();
    }

    public T pop() {
        return l.pop();
    }
}
