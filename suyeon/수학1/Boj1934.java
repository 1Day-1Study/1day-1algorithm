package suyeon.수학1;

import java.util.Scanner;

//최소공배수
public class Boj1934 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        int testcase = in.nextInt();

        for(int i = 0; i < testcase; i++) {

            int a = in.nextInt();
            int b = in.nextInt();

            int d = gcd(a, b);	// 최소 공배수 구하기

            sb.append(a * b / d).append('\n');
        }
        System.out.println(sb);
    }
    public static int gcd(int a, int b){

        int temp;
        while(b!=0){
            temp = b;
            b = a % b;
            a = temp;
        }

        return a;
    }
}
