package 백준문제;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Boj1991 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder preorderSB = new StringBuilder();
    static StringBuilder inorderSB = new StringBuilder();
    static StringBuilder postorderSB = new StringBuilder();
    static char[] tree;
    static int N;

    public static void main(String[] args) throws IOException {

        N = Integer.parseInt(br.readLine());
        tree = new char[(int) Math.pow(2, N) + 2];
        Arrays.fill(tree, '0');

        // 배열로 구현한 트리 초기화
        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            char parentNode = st.nextToken().charAt(0);
            char leftChildNode = st.nextToken().charAt(0);
            char rightChildNode = st.nextToken().charAt(0);

            // 자식이 있는지?
            if (leftChildNode != '.' || rightChildNode != '.') {

                // 루트노드라면 초기화
                if (parentNode == 'A') {
                    tree[1] = parentNode;
                    if (leftChildNode != '.') {
                        tree[2] = leftChildNode;
                    }
                    if (rightChildNode != '.') {
                        tree[3] = rightChildNode;
                    }
                }

                // 그 외 값이면 배열에서 찾아서 초기화
                else {
                    int idx = 0;
                    for (int j = 0; j < tree.length; j++) {
                        if (tree[j] == parentNode) {
                            idx = j;
                        }
                    }
                    if (leftChildNode != '.') {
                        tree[idx * 2] = leftChildNode;
                    }
                    if (rightChildNode != '.') {
                        tree[idx * 2 + 1] = rightChildNode;
                    }
                }
            }
        }

        preorder(1);
        inorder(1);
        postorder(1);

        System.out.println(preorderSB.toString());
        System.out.println(inorderSB.toString());
        System.out.println(postorderSB.toString());

    }

    static void preorder(int start) {

        preorderSB.append(tree[start]);
        int leftChildNode = start * 2;
        int rightChildNode = start * 2 + 1;

        if (leftChildNode <= tree.length && tree[leftChildNode] != '0') {
            preorder(start * 2);
        }
        if (rightChildNode <= tree.length && tree[rightChildNode] != '0') {
            preorder(start * 2 + 1);
        }
    }

    static void inorder(int start) {

        int leftChildNode = start * 2;
        int rightChildNode = start * 2 + 1;

        if (leftChildNode <= tree.length && tree[leftChildNode] != '0') {
            inorder(leftChildNode);
        }
        inorderSB.append(tree[start]);
        if (rightChildNode <= tree.length && tree[rightChildNode] != '0') {
            inorder(rightChildNode);
        }
    }

    static void postorder(int start) {

        int leftChildNode = start * 2;
        int rightChildNode = start * 2 + 1;

        if (leftChildNode <= tree.length && tree[leftChildNode] != '0') {
            postorder(leftChildNode);
        }
        if (rightChildNode <= tree.length && tree[rightChildNode] != '0') {
            postorder(rightChildNode);
        }
        postorderSB.append(tree[start]);
    }
}
