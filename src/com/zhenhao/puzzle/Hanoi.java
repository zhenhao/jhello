package com.zhenhao.puzzle;

/**
 * Created by wangzhenhao on 2015/1/27.
 */
public class Hanoi {
    private int n;
    private static int t;

    public Hanoi(int n) {
        this.n = n;
        t = 0;
    }

    private void step(char a, char b, char c, int n) {
        if(n == 1) {
            System.out.println(++t + ": " + a + " -> " + c);
        } else {
            step(a, c, b, n-1);
            System.out.println(++t + ": " + a + " -> " + c);
            step(b, a, c, n-1);
        }
    }

    public void answer() {
        step('A', 'B', 'C', n);
    }
}
