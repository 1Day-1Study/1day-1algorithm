package suyeon.수학1;

import java.util.Scanner;

//소수찾기
public class Boj1978 {
    //소수 : 1과 자신 이외는 자연수로 나눌 수 없는 수
    //소수를 찾는 방법 : 에라토스테네스의 체
    static boolean[] arr;
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);

        int num = sc.nextInt();
        int[] array = new int[num];
        int max = Integer.MIN_VALUE; //0도 가능

        for (int i = 0; i < array.length; i++) {
            array[i] = sc.nextInt();
            if(array[i] > max) max = array[i];
        }

        arr = new boolean[max + 1];

        calculate(max);

        int count = 0;

        for (int i = 0; i < array.length; i++) {
            if(!arr[array[i]]) count++;
        }

        System.out.println(count);
    }

    //에라토스테네스의 체
    public static void calculate(int max){

        arr[0] = true;
        arr[1] = true;

        for (int i = 2; i <  arr.length; i++) {
            //이미 소수가 아니라고 판명난 수들은 지나간다.
            if(arr[i]) continue;

            //여기서 걸리는 숫자들은 소수가 아니다. true 마킹이 된 숫자들은 소수XXX
            for (int j = i * i; j < max + 1; j= j + i) {
                arr[j] = true;
            }
        }
    }
}
