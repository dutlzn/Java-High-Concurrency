package com.example.sb2;
import java.util.*;
class Node {
    public int val;
    public Node next;
    public Node(int val) {
        this.val = val;
    }
}
public class Test {


    public static void main(String[] args) {
        Random random = new Random();
        Node root = new Node(-1);
        Node cur = root;
        int size = 10000_00;
        for(int i = 0;i<size;++i) {
            Node node = new Node(random.nextInt(100));
            cur.next = node;
            cur = cur.next;
        }
        cur.next = null;

        test1(root.next);
        System.out.println();
        test2(root.next);
    }

    public static void test1(Node root) {
        long begintime = System.nanoTime();
        Stack<Integer> stack = new Stack<Integer>();
        Node cur = root;
        int size = 0;
        while(cur != null) {
            stack.push(cur.val);
            cur = cur.next;
            size++;
        }

        long endtime1 = System.nanoTime();
        int[] result = new int[size];
        int i = 0;
        while(stack.empty() == false) {
            result[i++] = (int)stack.pop();
        }

        long endtime2 = System.nanoTime();

        System.out.print((endtime1 - begintime)/1000+"|"
                +(endtime2 - endtime1)/1000 + "|"
                +(endtime2 - begintime)/1000);
    }


    public static void test2(Node root) {
        long begintime = System.nanoTime();
        Stack<Node> stack = new Stack<>();
        Node cur = root;
        int size = 0;
        while(cur != null) {
            stack.push(cur);
            cur = cur.next;
            size++;
        }

        long endtime1 = System.nanoTime();
        int[] result = new int[size];
        int i = 0;
        while(stack.empty() == false) {
            result[i++] = (int)stack.pop().val;
        }


        long endtime2 = System.nanoTime();


        System.out.print((endtime1 - begintime)/1000+"|"
                +(endtime2 - endtime1)/1000 + "|"
                +(endtime2 - begintime)/1000);


    }
}
