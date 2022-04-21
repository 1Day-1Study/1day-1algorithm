package suyeon.수학1;

import java.util.Scanner;

//나머지
public class Boj10430 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int a = scanner.nextInt();
        int b = scanner.nextInt();
        int c = scanner.nextInt();

        int result;

        result = (a+b)%c;
        System.out.println(result);
        result = ((a%c)+(b%c))%c;
        System.out.println(result);
        result = (a*b)%c;
        System.out.println(result);
        result = ((a%c)*(b%c))%c;
        System.out.println(result);
    }
}