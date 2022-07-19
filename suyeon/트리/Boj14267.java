package suyeon.트리;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

//회사문화1
public class Boj14267 {
    static List<Integer>[] list; //상사 직원 관계 인접리스트 배열
    static int[] compliment; //칭찬받은 데이터 저장

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int n = Integer.parseInt(st.nextToken()); //직원수
        int m = Integer.parseInt(st.nextToken()); //최소 칭찬 횟수

        list = new ArrayList[n+1];
        //직원 수 만큼 인접리스트를 만들어준다.
        for(int i=1; i<n+1; i++) {
            list[i] = new ArrayList<>();
        }

        st = new StringTokenizer(br.readLine());
        for(int a=1; a<n+1; a++) {
            //직속상사의 번호
            int b = Integer.parseInt(st.nextToken());
            //상사가 없는 경우 (사장은 1번)
            if(b!=-1) {
                list[b].add(a);
            }
        }

        compliment = new int[n+1];
        for(int i=0; i<m; i++) {
            st = new StringTokenizer(br.readLine());
            //직속상사로부터 칭찬을 받은 직원번호
            int employee = Integer.parseInt(st.nextToken());
            //칭찬 수치
            int w = Integer.parseInt(st.nextToken());
            compliment[employee] += w; //칭찬받은 모든 데이터를 배열에 저장한다.

        }
        dfs(1);
        for(int i=1; i<n+1; i++) {
            System.out.print(compliment[i]+" ");
        }
    }

    static void dfs(int idx) {
        for(int next : list[idx]) {
            //트리 전위순회를 통해 부모 노드부터 차례대로 값을 갱신해준다.
            compliment[next] += compliment[idx];
            dfs(next);
        }
    }
}
