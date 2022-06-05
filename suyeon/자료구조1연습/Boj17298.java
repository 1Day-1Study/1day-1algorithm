package suyeon.자료구조1연습;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;
//오큰수
public class Boj17298 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuffer sb = new StringBuffer();
    static Stack<Integer> stack = new Stack<>();
    static int A[], NGE[];
    static int testcase;

    //list[i]를 스택에 담기 전에 자신보다 작은 값들을 전부 pop한 후에 남아있는 stack의 top == 오큰수
    static void find() {
        //배열을 거꾸로 탐색한다.
        for (int i = testcase - 1; i >= 0; i--) {
            System.out.println("func i :" +i);

            //i번째 값보다 작은 값은 미리 제거, 큰 값만 남아 있으면 pass
            while (!stack.isEmpty() && stack.peek() <= A[i])
                stack.pop();

            //i번째 A값보다 큰 수가 없으므로 -1을 담아준다.
            // i번째 A의 값 == 오큰수
            if (stack.isEmpty())
                NGE[i] = -1;
            else
                NGE[i] = stack.peek();

            stack.add(A[i]);
        }
    }

    static void input() throws Exception {
        st = new StringTokenizer(br.readLine());
        testcase = Integer.parseInt(st.nextToken());
        A = new int[testcase];
        NGE = new int[testcase];

        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < testcase; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }
    }

    static void print() {
        for (int i = 0; i < testcase; i++) {
            sb.append(NGE[i] + " ");
        }
        System.out.println(sb.toString() + "\n");
    }


    public static void main(String[] args) throws Exception {
        input();
        find();
        print();
    }

}