import java.io.*;
import java.util.*;

class Boj10828 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static Stack<Integer> stack = new Stack<>();
    static int N;

    public static void main(String[] args) throws IOException {

        N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            process();
        }

        bw.flush();
        bw.close();
    }

    static void process() throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        String command = st.nextToken();

        // push 명령 처리
        if (command.equals("push")) {
            int X = Integer.parseInt(st.nextToken());
            stack.push(X);
        }

        // pop 명령 처리
        else if (command.equals("pop")) {
            if (!stack.isEmpty()) {
                bw.write(String.valueOf(stack.pop()));
                bw.write("\n");
            } else {
                bw.write(String.valueOf(-1));
                bw.write("\n");
            }
        }

        // size 명령 처리
        else if (command.equals("size")) {
            int size = stack.size();
            bw.write(String.valueOf(size));
            bw.write("\n");
        }

        // empty 명령 처리
        else if (command.equals("empty")) {
            if (stack.isEmpty()) {
                bw.write(String.valueOf(1));
                bw.write("\n");
            } else {
                bw.write(String.valueOf(0));
                bw.write("\n");
            }
        }

        // top 명령 처리
        else if (command.equals("top")) {
            if (!stack.isEmpty()) {
                bw.write(String.valueOf(stack.peek()));
                bw.write("\n");
            } else {
                bw.write(String.valueOf(-1));
                bw.write("\n");
            }
        }

        // 그 외 나머지
        else {
            return;
        }
    }
}
