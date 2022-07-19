package suyeon.트리;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

//촌수계산
public class Boj2644 {
    static int end, count = -1; //촌수를 구할 사람(끝점), 촌수
    static boolean[] visited;
    static ArrayList<ArrayList<Integer>> list = new ArrayList<>(); // 양방향 인접리스트
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine()); //전체 사람의 수
        visited = new boolean[n + 1];
        for (int i = 0; i <= n; i++) list.add(new ArrayList<>());

        StringTokenizer st = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st.nextToken()); //촌수를 여기부터 계산해서 (시작점)
        end = Integer.parseInt(st.nextToken()); //이사람까지의 촌수를 구할 것 (끝점)

        int m = Integer.parseInt(br.readLine()); //부모 자식들 간의 관계의 개수

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            // 양방향
            list.get(from).add(to);  //from -> to
            list.get(to).add(from);  // to -> from
        }
        // 시작 정점, 촌 수
        dfs(start, 0);
        System.out.println(count);
    }

    private static void dfs(int point, int cnt) {
        visited[point] = true;
        for (int x : list.get(point)) {
            if (!visited[x]) { //방문하지 않았으면
                if (x == end) { //end에 도달하면
                     count = cnt + 1;
                    return;
                }
                //다음 촌수로 이동
                dfs(x, cnt + 1);
            }
        }
    }
}