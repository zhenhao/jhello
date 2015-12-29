package com.zhenhao.puzzle;

import com.zhenhao.utils.Stack;

/**
 * Created by wangzhenhao on 2015/1/27.
 */
public class Queen {
    public static final int N = 8;
    public static int t = 0;
    public int[] Q = new int[N];

    public void answer(boolean recursive) {
        if(recursive) {
            put(0);
        } else {
            answerNoneRecursive();
        }
    }

    private void put(int n) {
        if(n == N) {
            draw(Q);
        } else {
            for(int i = 0; i < N; i++) {
                Q[n] = i;
                if(!attack(n)) {
                    put(n + 1);
                }
            }
        }
    }

    public void answerNoneRecursive() {
        Stack<Point> s = new Stack<Point>();

        for(int i = 0; i < N; i++) {
            s.push(new Point(0, i));
        }

        while(!s.empty()) {
            Point now = s.pop();
            Q[now.x] = now.y;

            if(now.x == N - 1) {
                draw(Q);
                continue;
            }

            for(int i = 0; i < N; i++) {
                Q[now.x + 1] = i;
                if(!attack(now.x + 1)) {
                    s.push(new Point(now.x + 1, i));
                }
            }
        }
    }

    public boolean attack(int n) {
        for(int i = 0; i < n; i++) {
            if (Q[n] == Q[i] || n + Q[n] == i + Q[i] || n - Q[n] == i - Q[i]) {
                return true;
            }
        }
        return false;
    }

    public void draw(int[] list) {
        System.out.println("======= " + ++t + " =======");
        for(int y : list) {
            for(int i = 0; i < N; i++) {
                System.out.print(y == i ? "Q" : "-");
            }
            System.out.println();
        }
    }
}

class Point {
    public int x;
    public int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public String toString() {
        return "(" + x + "," + y + ")";
    }
}
