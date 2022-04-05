package suyeon;

import java.io.*;
import java.util.Stack;


public class Boj10828 {

    public static void main(String[] args) throws IOException {
        // IO
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        Stack<Integer> s = new Stack<>();

        //입력받은 값을 형변환한다.
        int num = Integer.parseInt(br.readLine());

        for (int i = 0; i < num; i++) {
            //공백으로 구분해준다.
            String[] input = br.readLine().split(" ");

            switch (input[0]) {
                case "push":
                    s.push(Integer.parseInt(input[1]));
                    break;
                case "pop":
                    if (s.empty()) {
                        bw.write("-1" + "\n");
                    } else {
                        bw.write(s.pop() + "\n");
                    }
                    break;
                case "size":
                    bw.write(s.size() + "\n");
                    break;
                case "empty":
                    if (s.empty()) {
                        bw.write("1" + "\n");
                    } else {
                        bw.write("0" + "\n");
                    }
                    break;
                case "top":
                    if (s.empty()) {
                        bw.write("-1" + "\n");
                    } else {
                        //stack의 첫 번째 값을 확인한다.
                        bw.write(s.peek() + "\n");
                    }
                    break;
            }

        }
        bw.flush();
        bw.close();
    }
}