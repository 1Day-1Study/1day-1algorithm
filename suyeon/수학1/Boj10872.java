package suyeon.수학1;

import java.io.*;
//10872 팩토리얼
public class Boj10872 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int input = Integer.parseInt(br.readLine());

        int sum = factorial(input);
        System.out.println(sum);

    }

    public static int factorial(int num) {
        if(num <= 1) return 1; // 0!=1
        int result = num * factorial(num - 1);
        return result;
    }

}