package suyeon;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Boj10845 {
     public static void main(String args[]) throws IOException {

          Scanner scan = new Scanner(System.in);
          Queue<Integer> que = new LinkedList();

          //입력받을 테스트 수
          int testCaseCount = scan.nextInt();
          //큐에 담을 숫자
          int num = 0;

          while (testCaseCount --> 0) {

               //공백으로 구분해준다.
               //String[] input = br.readLine().split(" ");
               String command = scan.next();

               switch (command){
                    case "push":
                         num = scan.nextInt();
                         que.add(num);
                         break;

                    case "pop":
                         System.out.println(que.isEmpty()? -1 : que.poll());
                         break;

                    case "size":
                         System.out.println(que.size());
                         break;

                    case "empty":
                         System.out.println(que.isEmpty()? 1 : 0);
                         break;

                    case "front":
                         System.out.println(que.isEmpty()? -1 : que.peek());
                         break;

                    case "back":
                         System.out.println(que.isEmpty()? -1 : num);
                         break;

               }
          }

     }
}
