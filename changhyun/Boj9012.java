import java.io.*;
import java.util.Stack;

class Boj9012 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            bw.write(isVPS(br.readLine()));
            bw.write("\n");
        }

        bw.flush();
        bw.close();
    }

    static String isVPS(String str) {
        Stack<Character> ps = new Stack<>();

        // 처음 오는 괄호가
        // 닫는 괄호라면 NO 리턴
        if (str.charAt(0) == ')') {
            return "NO";
        }

        ps.add(str.charAt(0));

        for (int i = 1; i < str.length(); i++) {

            char c = str.charAt(i);

            // 닫는 괄호일 경우
            if (c == ')') {
                if (ps.isEmpty()) {
                    return "NO";
                }
                ps.pop();
            }

            // 여는 괄호일 경우
            else {
                ps.add('(');
            }
        }

        // 스택안에 괄호가 남아 있는 경우
        if (!ps.isEmpty()) {
            return "NO";
        }
        return "YES";
    }
}
