package doyoon;

import java.io.*;
import java.util.*;
public class Unique_13144 {
    static int N;
    static int [] arr, cnt;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        //arr,cnt 배열만들고 값 담아주기 
        arr = new int[N+1];
        cnt = new int[100000 + 1];
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 1; i <= N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        toPoint();
    }
    static void toPoint(){
    	
        long ans = 0;
        
        int l = 1; 
        int r = 0;
        //현재 위치(l)에서 시작해서 조건 만족할때까지 r을 늘려나간다. 
        while(l <= N){
        	//처음쓰는 숫자인지, 범위를 안넘는지 체크 
            while(r + 1 <= N && cnt[arr[r + 1]] == 0){
                r++; //while 조건에서 이미 확인을 했으므로 안심하고 증가.
                cnt[arr[r]]++; //해당 수 썼으니 썼다고 표시 
            }
            
            ans += r - l + 1;
          //l을 한칸씩 밀면서 볼것이기 때문에 계산이 끝나고 나면 l을 한 칸 밀어준다. 
          //이전 위치의 cnt는 다음번 계산에서 제외하기 위해 cnt[arr[l]]--;
            cnt[arr[l++]]--; 
        }
        System.out.println(ans);
    }
}