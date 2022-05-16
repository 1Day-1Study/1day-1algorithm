package 백준문제;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Boj15970 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int N;

    public static void main(String[] args) throws IOException {

        N = Integer.parseInt(br.readLine());

        // Key,List<Value> == 색깔, List<점의 위치>
        Map<Integer, List<Integer>> map = new HashMap<>();

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int position = Integer.parseInt(st.nextToken());
            int color = Integer.parseInt(st.nextToken());

            if (map.get(color) == null) {
                map.put(color, new ArrayList<>());
            }

            map.get(color).add(position);

        }

        int sum = 0;
        for (Integer color : map.keySet()) {

            List<Integer> pointList = map.get(color);

            Collections.sort(pointList);

            for (int i = 0; i < pointList.size(); i++) {

                // 맨 왼쪽에 있는 점
                if (i == 0) {
                    sum += pointList.get(i + 1) - pointList.get(i);
                }

                // 맨 오른쪽에 있는 점
                else if (i == pointList.size() - 1) {
                    sum += pointList.get(i) - pointList.get(i - 1);
                }

                // 중간에 있는 점
                else {
                    sum += Math.min(pointList.get(i) - pointList.get(i - 1), pointList.get(i + 1) - pointList.get(i));
                }

            }

        }

        System.out.println(sum);

    }
}
