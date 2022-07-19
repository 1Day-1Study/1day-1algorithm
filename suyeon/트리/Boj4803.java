package suyeon.트리;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.StringTokenizer;
//트리
public class Boj4803 {

    static int[] parents;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int idx=1;
        while(true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken()); //정점의 개수
            int m = Integer.parseInt(st.nextToken()); //간선의 개수

            if(n==0 && m==0) break;

            parents = new int[n + 1];

            for(int i = 1; i < n+1; i++) {
                parents[i] = i; //정점의 개수만큼 부모노드가 되는 것
            }
            //간선을 나타내는 두 개의 정수 (같은 간선은 여러 번 주어지지 않는다)
            for(int i = 0; i < m; i++) {
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                //각 간선을 입력받을 때마다 union, find를 이용해,
                //서로 연결되어 트리인지, 사이클인지 찾는다.
                union(a,b);
            }

            Set<Integer> treeSet = new HashSet<>();
                    //정점의 개수 + 1만큼 반복을 돌면서 트리 개수를 찾는다.
            for(int i = 1; i < (n + 1); i++) {
                int ra = find(i);
                if(ra > 0) {
                    treeSet.add(ra);
                }
            }

            int treeNum= treeSet.size();
            if(treeNum == 0) {
                sb.append("Case " + idx +": ").append("No trees.\n");
            }else if(treeNum == 1) {
                sb.append("Case " + idx +": ").append("There is one tree.\n");
            }else if(treeNum > 1){
                sb.append("Case " + idx +": ").append("A forest of "+ treeNum+" trees.\n");
            }
            idx++;
        }

        System.out.println(sb.toString());
    }

    static int find(int x) {
        //바뀐 부모노드들을 정리
        if(parents[x] == x) return x;
        return find(parents[x]);
    }

    static void union(int x, int y) {
        int rx= find(x);
        int ry= find(y);
        if(ry < rx) {
            int tmp = rx;
            rx = ry;
            ry = tmp;
        }
        // 사이클이 나타나는 조건
        if(rx==ry) {
            //사이클이 생기면, 정점의 부모배열을 0으로 변경한다.
            parents[rx] = 0;
        }
        else {
            parents[ry] = rx;
        }
    }
}
