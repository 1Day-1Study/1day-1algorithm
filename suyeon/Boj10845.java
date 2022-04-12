package suyeon;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;

public class Boj10845 {
     public static void main(String args[]) throws IOException, Exception {
          BufferedReader br =  new BufferedReader(new InputStreamReader(System.in));
          StringBuilder sb = new StringBuilder();
          Queue<Integer> que = new LinkedList<Integer>();

          //입력받을 테스트 수
          int testCaseCount = Integer.parseInt(br.readLine());
          //큐에 담을 숫자
          int num = 0;

          while (testCaseCount --> 0) {

               //공백으로 구분해준다.
               String[] command = br.readLine().split(" ");
               //String cmd = br.readLine();


               switch (command[0]){
                    case "push":
                         //num = Integer.parseInt(br.readLine());
                         num = Integer.parseInt(command[1]);
                         que.add(num);
                         break;

                    case "pop":
                         sb.append(que.isEmpty()?-1:que.poll()).append("\n");
                         break;

                    case "size":
                         sb.append(que.size()).append("\n");
                         break;

                    case "empty":
                         sb.append(que.isEmpty()?1:0).append("\n");
                         //System.out.println(que.toString());
                         break;

                    case "front":
                         sb.append(que.isEmpty()?-1:que.peek()).append("\n");
                         break;

                    case "back":
                         sb.append(que.isEmpty()?-1:num).append("\n");
                         break;

               }
          }
          System.out.println(sb);
     }
}
