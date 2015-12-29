package com.zhenhao.utils;

/**
 * Created by wangzhenhao on 2015/1/27.
 */
public class BTree {
    private class Node {
        int ele;
        Node left, right, parent;

        Node(int ele) {
            this.ele = ele;
            left = right = parent = null;
        }
    }

    Node root;

    public BTree() {
        root = null;
    }

    /**
     * 插入一个元素.
     * @param ele 元素值
     */
    public void insert(int ele) {
        if(null == root) {
            root = new Node(ele);
            root.parent = null;
        } else {
            insert(ele, root);
        }
    }

    private void insert(int ele, Node x) {
        if(ele >= x.ele) {
            if(null == x.right) {
                x.right = new Node(ele);
                x.right.parent = x;
            } else {
                insert(ele, x.right);
            }
        } else {
            if(null == x.left) {
                x.left = new Node(ele);
                x.left.parent = x;
            } else {
                insert(ele, x.left);
            }
        }
    }

    /**
     * 查找一个元素.
     * @param ele 元素值
     * @return 是否含有该元素
     */
    public boolean search(int ele) {
        return null != search(ele, root);
    }

    private Node search(int ele, Node x) {
        if(x == null) {
            return null;
        }
        if(x.ele == ele) {
            return x;
        } else if (ele > x.ele) {
            return search(ele, x.right);
        } else {
            return search(ele, x.left);
        }
    }

    /**
     * 删除一个元素.
     * @param ele 元素值
     */
    public void delete(int ele) {
        Node x = search(ele, root);

        if(null != x) {
            delete(x);
        }
    }

    private void delete(Node x) {
        if(null == x.parent) {
            if(null == x.right && null == x.left) {
                root = null;
            }
            else if(null == x.left) {
                root = x.right;
                x.right.parent = null;
            } else if (null == x.right) {
                root = x.left;
                x.left.parent = null;
            } else {
                root = x.left;
                Node p = root;
                while(null != p.right) {
                    p = p.right;
                }
                p.right = x.right;
                x.right.parent = p;
            }
        } else if(x == x.parent.left) {
            if(null == x.left && null == x.right) {
                x.parent.left = null;
            } else if(null == x.left) {
                x.parent.left = x.right;
                x.right.parent = x.parent;
            } else if(null == x.right) {
                x.parent.left = x.left;
                x.left.parent = x.parent;
            } else {
                x.parent.left = x.left;
                Node p = x.left;
                while(null != p.right) {
                    p = p.right;
                }
                p.right = x.right;
                x.right.parent = p;
            }
        } else {
            if(null == x.left && null == x.right) {
                x.parent.right = null;
            } else if(null == x.left) {
                x.parent.right = x.right;
                x.right.parent = x.parent;
            } else if(null == x.right) {
                x.parent.right = x.left;
                x.left.parent = x.parent;
            } else {
                x.parent.right = x.left;
                Node p = x.left;
                while(null != p.right) {
                    p = p.right;
                }
                p.right = x.right;
                x.right.parent = p;
            }
        }
    }

    /**
     * 先序遍历.
     * @param recursive 是否允许递归
     */
    public void showF(boolean recursive) {
        if(recursive) {
            showF(root);
        } else {
            showNoRecursiveF();
        }
    }

    private void showF(Node x) {
        if(null != x) {
            System.out.print(x.ele + ",");
            showF(x.left);
            showF(x.right);
        }
    }

    private void showNoRecursiveF() {
        Stack<Node> s = new Stack<Node>();
        if(null != root) {
            s.push(root);
        }
        while(!s.empty()) {
            Node p = s.pop();
            System.out.print(p.ele + ",");
            if(null != p.right) {
                s.push(p.right);
            }
            if(null != p.left) {
                s.push(p.left);
            }
        }
    }

    /**
     * 中序遍历.
     * @param recursive 是否允许递归
     */
    public void show(boolean recursive) {
        if(recursive) {
            show(root);
        } else {
            showNoRecursive();
        }
        System.out.println();
    }

    private void show(Node x) {
        if(null != x) {
            show(x.left);
            System.out.print(x.ele + ",");
            show(x.right);
        }
    }

    private void showNoRecursive() {
        Stack<Node> s = new Stack<Node>();
        Node p = root;
        while(null != p) {
            s.push(p);
            p = p.left;
        }
        while(!s.empty()) {
            p = s.pop();
            System.out.print(p.ele + ",");
            p = p.right;
            while(null != p) {
                s.push(p);
                p = p.left;
            }
        }
    }

    /**
     * 后序遍历.
     * @param recursive 是否允许递归
     */
    public void showL(boolean recursive) {
        if(recursive) {
            showL(root);
        } else {
            showNoRecursiveL();
        }
    }

    public void showL(Node x) {
        if(null != x) {
            showL(x.left);
            showL(x.right);
            System.out.print(x.ele + ",");
        }
    }

    private void showNoRecursiveL() {
        Stack<Node> s = new Stack<Node>();
        Stack<Integer> s2 = new Stack<Integer>();
        if(null != root) {
            s.push(root);
        }
        while(!s.empty()) {
            Node p = s.pop();
            s2.push(p.ele);
            if(null != p.left) {
                s.push(p.left);
            }
            if(null != p.right) {
                s.push(p.right);
            }
        }
        while(!s2.empty()) {
            System.out.print(s2.pop() + ",");
        }
    }
}
