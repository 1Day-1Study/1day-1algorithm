package 백준문제;

import java.io.*;

class Boj9093 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        // 문장의 수 만큼 반복
        for (int i = 0; i < N; i++) {
            String[] split = br.readLine().split(" ");

            // 문장을 단어단위로 나눠서 반복
            for (int j = 0; j < split.length; j++) {

                // 단어를 거꾸로 맨끝부터 출력
                for (int k = split[j].length() - 1; k >= 0; k--) {
                    bw.write(split[j].charAt(k));
                }
                bw.write(" ");
            }
            bw.write("\n");
        }
        bw.flush();
        bw.close();
    }

}

