import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Boj10866 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        Deque<Integer> deque = new LinkedList<>();

        int N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            switch (st.nextToken()) {
                case "push_front":
                    int X1 = Integer.parseInt(st.nextToken());
                    deque.offerFirst(X1);
                    break;

                case "push_back":
                    int X2 = Integer.parseInt(st.nextToken());
                    deque.offerLast(X2);
                    break;

                case "pop_front":
                    if (!deque.isEmpty()) {
                        sb.append(deque.poll()).append("\n");
                    } else {
                        sb.append(-1).append("\n");
                    }
                    break;

                case "pop_back":
                    if (!deque.isEmpty()) {
                        sb.append(deque.pollLast()).append("\n");
                    } else {
                        sb.append(-1).append("\n");
                    }
                    break;

                case "size":
                    sb.append(deque.size()).append("\n");
                    break;

                case "empty":
                    if (deque.isEmpty()) {
                        sb.append(1).append("\n");
                    } else {
                        sb.append(0).append("\n");
                    }
                    break;

                case "front":
                    if (!deque.isEmpty()) {
                        sb.append(deque.peek()).append("\n");
                    } else {
                        sb.append(-1).append("\n");
                    }
                    break;

                case "back":
                    if (!deque.isEmpty()) {
                        sb.append(deque.peekLast()).append("\n");
                    } else {
                        sb.append(-1).append("\n");
                    }
                    break;

            }

        }

        System.out.println(sb.toString());

    }

}
