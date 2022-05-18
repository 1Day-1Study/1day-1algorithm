package 백준문제;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Boj1015 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        List<Number> numberList = new ArrayList<>();
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            numberList.add(new Number(i, Integer.parseInt(st.nextToken())));
        }

        Collections.sort(numberList);

        int[] p = new int[N];

        // p[정렬한 A 배열의 idx] = i
        for (int i = 0; i < N; i++) {
            p[numberList.get(i).idx] = i;
        }

        for (int i = 0; i < N; i++) {
            bw.write(p[i]+" ");
        }

        bw.flush();
    }

    static class Number implements Comparable<Number>{
        int idx;
        int value;

        public Number(int idx, int value) {
            this.idx = idx;
            this.value = value;
        }

        @Override
        public int compareTo(Number o) {
            return Integer.compare(value, o.value);
        }
    }
}
