package suyeon.위상정렬;

import java.util.*;

public class Boj2637_3 {

    static int n, m; // 부품 종류 수, 부품 조합 가짓수
    static int[] completeCount; //완제품을 생산하기 위해 각 부품이 몇 개씩 사용되어야하는지 담는 배열
    static int[] inDegree; //특정 노드로 들어오는 간선의 개수 (역으로 갈 것)
    static int[][] parts; // 부품별 제작에 필요한 부품 종류와 개수
    static boolean[] isElement; // 기본 부품 : true, 중간부품 or 완성품 : false

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        n = scan.nextInt();
        m = scan.nextInt();

        completeCount = new int[n + 1];
        inDegree = new int[n + 1];
        parts = new int[n + 1][n + 1];
        isElement = new boolean[n + 1];


        for (int i = 0; i < m; i++) {
            int a = scan.nextInt();
            int b = scan.nextInt();

            parts[a][b] = scan.nextInt();
            inDegree[b]++;
            isElement[a] = true; //기본부품
        }

        Queue q = new LinkedList<>();

        for (int i = 1; i <= n; i++) {
            if (inDegree[i] == 0) {
                q.add(i);
                completeCount[i] = 1;
            }
        }

        while (!q.isEmpty()) {
            //node는 현재 부품이고 i는 이 부품을 생성하기 위한 부품 (여러개의 i로 node를 생성)
            int node = (int) q.poll();
            //node 7부터 시작
            for (int i = 1; i <= n; i++) {
                if (parts[node][i] != 0) {
                    // 필요한 부품들이 가진 기본 부품 * 부품의 개수
                    completeCount[i] += completeCount[node] * parts[node][i];
                    inDegree[i]--;

                    if (inDegree[i] == 0)
                        q.add(i);
                }
            }
        }

        // print
        for (int i = 1; i <= n; i++) {
            if (!isElement[i])
                System.out.print(i + " " + completeCount[i] + "\n");
        }

    }
}