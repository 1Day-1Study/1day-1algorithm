package suyeon.정렬;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
//수열정렬


public class Boj1015 {

        public static int[] P;
        static Elem[] B;
        public static int N;
        public static StringBuilder str = new StringBuilder();

        static class Elem implements Comparable<Elem> {
            // compareTo를 custom 해주기 위해 Comparable 인터페이스를 받는다.
            public int num, idx;

            @Override
            public int compareTo(Elem other) {
                return num - other.num; // 비내림차순의 정렬을 성립하기 위해 compareTo를 해준다.
            }
        }



        public static void main(String[] args) throws IOException {
            input();
            sort();
            System.out.println(str);

        }

        public static void input() throws IOException {

            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

            N = Integer.parseInt(br.readLine()); //배열의 크기를 받고
            String[] split = br.readLine().split(" ");
            B = new Elem[N];
            P = new int[N];

            for(int i=0;i<N;i++) {
                B[i] = new Elem();
                B[i].num = Integer.parseInt(split[i]);// 각각의 숫자를 num에 담아줌
                B[i].idx = i; //배열의 index를 받는다.
            }

        }

        public static void sort() {
            Arrays.sort(B); // 비내림차순으로 custom 한 sort를 해준다.
            for(int i =0;i<N; i++) {
                P[B[i].idx] =i; //정렬을 한 B의 index값을 받으면 P의 Num의 값을 알 수있다.
            }
            for(int i=0; i<N; i++) {
                str.append(P[i]).append(' ');
                //해당 값들을 출력할 수 있게 str에 append해준다.
            }
            str.append('\n');
        }

}
