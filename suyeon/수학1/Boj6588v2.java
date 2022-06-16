package suyeon.수학1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//6588 골드바흐의 추측
public class Boj6588v2 {
    //2보다 큰 모든 짝순느 두 개의 소수(prime number)의 합으로 표시할 수 있다.
    //이 때 하나의 소수를 두 번 사용 허용!

    static boolean[] isPrime;
    public static void main(String[] args) throws NumberFormatException, IOException {
        //에라토스테네스의 체를 이용해서, 소수를 구한다.
        //구해진 소수로 주어진 값을 만들 수 있는지 확인

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int num = Integer.parseInt(br.readLine());

        isPrime = new boolean[num + 1];

        getPrime();

    }
    public static void getPrime(){

        isPrime[0] = true;
        isPrime[1] = true;


    }
}
