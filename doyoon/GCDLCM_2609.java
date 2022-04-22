package doyoon;

import java.util.*;
import java.io.*;

public class GCDLCM_2609 {

	public static void main(String[] args) throws IOException{
		//1.입력값 두개 받기 
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] strs = br.readLine().split(" ");
		int num1 = Integer.parseInt(strs[0]);
		int num2 = Integer.parseInt(strs[1]);
		
		//2.메소드 만들어서 리턴값 넣기 
		int gcd = gcd(num1,num2);
		
		//3.최대공약수, 최소공배수 출력
		System.out.println(gcd);
		System.out.println(num1*num2/gcd);
		
	}
	//유클리드 호제법 gcd(a,b) = gcd(b,r)
	public static int gcd(int num1, int num2) {
		while(num2 !=0) {
			int remain = num1 % num2;
			
			num1 = num2;
			num2 = remain;
		}
		return num1;
	}

}
