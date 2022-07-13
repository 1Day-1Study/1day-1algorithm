package 백준문제;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Boj16472 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static Map<Character, Integer> map = new HashMap<>();
    static int N;

    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());

        String str = br.readLine();

        int max = 0;
        int alphaKindCnt = 0;
        int left = 0;
        int right = 0;
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);

            // 처음으로 등록하는 알파벳일 경우
            if (!map.containsKey(c) || map.get(c) == 0) {
                alphaKindCnt++;

                // 인식할 수 있는 알파벳의 종류를 넘은 경우 체크
                if (alphaKindCnt > N) {
                    while (alphaKindCnt != N) {
                        char removeAlphabet = str.charAt(left);
                        map.put(removeAlphabet, map.get(removeAlphabet) - 1);
                        left++;
                        if (map.get(removeAlphabet) == 0) {
                            alphaKindCnt--;
                        }
                    }
                }
            }

            map.put(c, map.getOrDefault(c, 0) + 1);
            right++;

            max = Math.max(max, right - left);

        }

        System.out.println(max);

    }
}
