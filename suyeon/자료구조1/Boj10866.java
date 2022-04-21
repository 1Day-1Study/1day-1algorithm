package suyeon.자료구조1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

//백준 10866 덱
public class Boj10866 {

    public static void main(String args[]) throws IOException{

        BufferedReader br =  new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        Deque<Integer> deque = new LinkedList<Integer>();

        int testCaseCount = Integer.parseInt(br.readLine());

        while(testCaseCount --> 0){

            String[] input = br.readLine().split(" ");


            switch(input[0]){
                case "push_front":
                    deque.addFirst(Integer.parseInt(input[1]));
                    //System.out.println(deque.toString());
                    break;

                case "push_back":
                    deque.addLast(Integer.parseInt(input[1]));
                    //System.out.println(deque.toString());
                    break;

                case "pop_front":
                    sb.append(deque.isEmpty()? -1 : deque.pollFirst()).append("\n");
                    //System.out.println(deque.isEmpty()? -1 : deque.pollFirst());
                    break;

                case "pop_back":
                    sb.append(deque.isEmpty()? -1 : deque.pollLast()).append("\n");
                    //System.out.println(deque.isEmpty()? -1 : deque.pollLast());
                    break;

                case "size":
                    sb.append(deque.size()).append("\n");
                    //System.out.println(deque.size());
                    break;

                case "empty":
                    sb.append(deque.isEmpty()? 1 : 0).append("\n");
                    //System.out.println(deque.isEmpty()? 1 : 0);
                    break;

                case "front":
                    sb.append(deque.isEmpty()? -1 : deque.getFirst()).append("\n");
                    //System.out.println(deque.isEmpty()? -1 : deque.getFirst());
                    break;

                case "back":
                    sb.append(deque.isEmpty()? -1 : deque.getLast()).append("\n");
                    //System.out.println(deque.isEmpty()? -1 : deque.getLast());
                    break;
            }
        }
        System.out.println(sb);
    }

}
