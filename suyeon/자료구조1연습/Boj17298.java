package suyeon.자료구조1연습;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Boj17298 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuffer sb = new StringBuffer();
    static Stack<Integer> s = new Stack<>();
    static int list[], ans[];
    static int N;

    static void print() {
        for (int i = 0; i < N; i++) {
            sb.append(ans[i] + " ");
        }

        System.out.println(sb.toString() + "\n");
    }

    static void func() {
        for (int i = N - 1; i >= 0; i--) {
            while (!s.isEmpty() && s.peek() <= list[i])
                s.pop();

            if (s.isEmpty())
                ans[i] = -1;
            else
                ans[i] = s.peek();

            s.add(list[i]);
        }
    }

    static void input() throws Exception {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        list = new int[N];
        ans = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            list[i] = Integer.parseInt(st.nextToken());
        }
    }

    public static void main(String[] args) throws Exception {
        input();
        func();
        print();
    }

}