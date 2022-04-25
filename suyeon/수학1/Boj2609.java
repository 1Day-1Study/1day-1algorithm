package suyeon.수학1;

import java.util.Scanner;

//최대공약수와 최소공배수
public class Boj2609 {
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);

        int a = in.nextInt();
        int b = in.nextInt();

        int d = gcd(a, b);	// 최대공약수
        int m = lcm(a, b);  // 최대공배수

        System.out.println(d);
        System.out.println(m);
        //System.out.println(a*b/c); 최대공배수 함수를 호출하지 않고 바로 구하기

    }
    static int gcd(int a, int b){
        if(b == 0) return a;
        return gcd(b, a % b);
    }

    static int lcm(int a, int b){
        return a * b/ gcd(a, b);
    }
}
