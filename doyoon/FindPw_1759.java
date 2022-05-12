package doyoon;

import java.io.*;
import java.util.*;

public class FindPw_1759 {
	static char[] arr; //
	static boolean[] visited; //방문 유무 확인
	static int l, c; // 암호자리수, 암호일 가능성있는 알파벳의 갯수 
	
	
	public static void main(String[] args) throws IOException{
		
		//입력값을 받고 문자열을 분리하기
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		l = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		
		arr = new char[c];
		visited = new boolean[c];
		
		st = new StringTokenizer(br.readLine());
		
		//hasmoreTokens: 사용할 수 있는 토큰이 존재한다면 true 
		for(int i= 0; st.hasMoreTokens(); i++) {
			arr[i] = st.nextToken().charAt(0);
		}
		//문자열 정렬하기 
		Arrays.sort(arr);
		
		dfs(0, 0);
		
		br.close();		
	}
	public static void dfs(int level, int length){
		if(length == l) {
			StringBuilder sb = new StringBuilder();
			int vowel = 0; //모음
			int consonant = 0; //자음
			
			for(int i=0; i<c; i++) {
				if(visited[i]) {
					//모음이라면 
					if(isVowel(arr[i])) {
						vowel++;
					}
					//자음이라면 
					else {
						consonant++;
					}
					sb.append(arr[i]);
				}
			}
			//모음이 1개이상이고 자음이 2개이상이면 출력
			if(vowel >=1 && consonant >= 2) {
				System.out.println(sb);
			}
		}
		else {
			for(int i = level; i <c; i++) {
				visited[i] = true;
				dfs(i+1,length+1);
				visited[i] = false;
			}
		}
		
	}
	
	public static boolean isVowel(char c) {
		if(c== 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u' ) {
			return true;
		}
		else {
			return false;
		}
		
	}

}
