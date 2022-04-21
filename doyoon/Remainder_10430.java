package doyoon;

import java.util.*;

public class Remainder_10430 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		//1.입력받기
		int A = sc.nextInt();
		int B = sc.nextInt();
		int C = sc.nextInt();
		
		//2.결과값 출력
		System.out.println((A+B)%C);
		System.out.println(((A%C)+(B%C))%C);
		System.out.println((A*B)%C);
		System.out.println(((A%C)*(B%C))%C);
	}

}
