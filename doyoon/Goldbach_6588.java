package doyoon;

import java.util.Scanner;

public class Goldbach_6588 {
	public static final int MAX = 1000000;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		//2부터 n 까지 n-1개를 저장할 수 있는 배열 할당
		//배열 참조 번호와 소수와 일치하도록 배열의 크기는 n+1길이만큼 할당
		//(인덱스 번호 0 과 1은 사용하지 않음) 
		boolean [] isPrime = new boolean[MAX+1];
		
		//1.초기화 (배열에 2부터 1,000,000 까지 true 값 담아주기)
		for (int i = 2; i <= MAX; i++) {
			isPrime[i] = true;
		}
		//2. i의 배수를 다 false 값으로 바꿔준다 (단, i는 제외하기) 
		for (int i = 2; i <= MAX; i++) {
			for (int j = i*2; j <= MAX; j+=i) {
				if(!isPrime[j]) continue;
				isPrime[j]=false;
			}
		}
		//3. 입력 값 받기
		while(true) {
			int n = sc.nextInt();
			//ok는 두 홀 수 소수의 합으로 n을 나타낼 수 없는 경우를 확인하기 위한 변수 
			boolean ok = false;
			//입력의 마지막줄에 0 하나 주어지면 끝나도록 하기 
			if(n == 0)
				break;
			// 소수 + 소수 이므로  i 와 n-i 둘다 true 이면 소수이다.
			for (int i = 2; i <= n/2; i++) {
				if(isPrime[i] && isPrime[n-i]) {
					System.out.println(n+" = "+i+" + "+(n-i));
					//n을 만들 수 있는 방법이 여러가지라면, b-a가 가장 큰 것을 출력한다. 
					//== a가 가장 작은 수여야 한다. 
					//가장 처음에 나온 i 가 정답이 된다
					//ex) 20 : 3 17 / 7 13 
					ok=true;
					break;
				}
			}
			//두 홀수 소수의 합으로 n을 나타낼 수 없는 경우 
			if(!ok) {
				System.out.println("Goldbach's conjecture is wrong.");
			}
		}
	}
}
