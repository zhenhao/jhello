package com.zhenhao;


import com.zhenhao.utils.BTree;

public class Main {
    public static void main(String[] args) {
        BTree t = new BTree();
        int[] ret = new int[10];

        int needle = 0;
        for(int i = 0; i < 10; i++) {
            needle = (int)Math.round(Math.random() * 100);
            ret[i] = needle;
            t.insert(needle);
        }

        t.show(true);
        t.delete(ret[2]);
        System.out.println("delete " + ret[2]);
        t.show(true);
    }
}
