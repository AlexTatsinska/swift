
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author AlexT
 */
public class Task5_ChildPlay {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int counter = 0;
        Stack<Integer> child = new Stack<>();
        Queue<Integer> childPlay = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            child.add(sc.nextInt());
        }
        while (!child.isEmpty()) {
            if (!childPlay.isEmpty()) {
                if (child.peek() < childPlay.peek()) {
                    counter++;
                    child.pop();
                    childPlay.poll();
                } else {
                    childPlay.poll();
                    childPlay.add(child.peek());
                    child.pop();
                }
            } else {
                childPlay.add(child.peek());
                child.pop();
            }
        }
        System.out.println(counter);
    }
}
