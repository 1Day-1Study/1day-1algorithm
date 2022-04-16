package doyoon;

import java.util.*;

public class FlipWords_17413 {
	
	static void print(Stack stk) {
		while (!stk.empty()) {
			System.out.print(stk.pop());
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Stack stk = new Stack();

		String sen = sc.nextLine();
		boolean check = false;

		for (int i = 0; i < sen.length(); i++) {
			//1.<>태그와 태그 내용일 경우
			if (sen.charAt(i) == '<') {
				print(stk); 
				check = true;
				System.out.print(sen.charAt(i));
			} else if (sen.charAt(i) == '>') {
				check = false;
				System.out.print(sen.charAt(i));
			} else if (check) {
				System.out.print(sen.charAt(i));
			}
			//2.태그 밖의 내용 (공백 or 문자열)
			else {
				if (sen.charAt(i) == ' ') {
					print(stk);
					System.out.print(sen.charAt(i));
				}

				else {
					stk.push(sen.charAt(i));
				}
			}

		}

		print(stk);

	}

}