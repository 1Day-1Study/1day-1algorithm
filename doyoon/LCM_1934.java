package doyoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class LCM_1934 {

	public static void main(String[] args) throws Exception {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			//1.테스트 케이스 갯수 입력
			int n = Integer.parseInt(br.readLine());
			
			BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
			
			
			StringTokenizer st;
			
			
			for (int i = 0; i < n; i++) {
				//2.테스트할 숫자들 공백으로 나눈 후 최대 공약수, 최소공배수 구하기
				st = new StringTokenizer(br.readLine()," ");
				
				int num1 = Integer.parseInt(st.nextToken());
				int num2 = Integer.parseInt(st.nextToken());
				
				int gcd = gcd(num1,num2);
				
				bw.write(num1*num2/gcd+"\n");
			}
			//3.출력하기
			bw.flush();
			bw.close();

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


