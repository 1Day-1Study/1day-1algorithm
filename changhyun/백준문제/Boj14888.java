package 백준문제;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Boj14888 {
    static int N;
    static int[] sequence;
    static boolean[] visited;
    static List<Character> operator = new ArrayList<>();
    static List<String> operatorList = new ArrayList<>();
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        sequence = new int[N];
        visited = new boolean[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            sequence[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 4; i++) {
            char c = whatOp(i);
            int cnt = Integer.parseInt(st.nextToken());
            for (int j = 0; j < cnt; j++) {
                operator.add(c);
            }
        }

        dfsForOp(0);

        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;

        for (int i = 0; i < operatorList.size(); i++) {
            String currentOp = operatorList.get(i); // + - * / +
            int temp = sequence[0];
            for (int j = 1; j < N; j++) {
                temp = calculrate(temp, sequence[j], currentOp.charAt(j - 1));
            }
            max = Math.max(temp, max);
            min = Math.min(temp, min);
        }

        System.out.println(max);
        System.out.println(min);


    }

    static char whatOp(int i) {
        if (i == 0) {
            return '+';
        } else if (i == 1) {
            return '-';
        } else if (i == 2) {
            return '*';
        } else {
            return '/';
        }
    }

    static void dfsForOp(int length) {
        if (length == N - 1) {
            operatorList.add(sb.toString());
            return;
        }

        for (int i = 0; i < N - 1; i++) {
            if (!visited[i]) {
                visited[i] = true;
                sb.append(operator.get(i));
                dfsForOp(length + 1);
                visited[i] = false;
                sb.deleteCharAt(sb.length() - 1);
            }
        }
    }

    static int calculrate(int a, int b, char c) {
        if (c == '+') {
            return a + b;
        } else if (c == '-') {
            return a - b;
        } else if (c == '*') {
            return a * b;
        } else {
            if (a < 0) {
                return -(Math.abs(a) / b);
            }
            return a / b;
        }
    }
}
