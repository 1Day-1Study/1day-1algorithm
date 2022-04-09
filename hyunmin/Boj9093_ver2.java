import java.io.*;
import java.util.Stack;

public class Boj9093_ver2 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));


        int number = Integer.parseInt(br.readLine());

        for (int m = 0; m < number; m++) {

            String input = br.readLine();
            String[] arr = input.split(" ");

            Stack<String> stack = new Stack<>();

            for (int i = 0; i < arr.length; i++) {
                String[] arr2 = arr[i].split("");
                for (int j = 0; j < arr[i].length(); j++) {
                    stack.push(arr2[j]);
                }

                for (int j = 0; j < arr[i].length(); j++) {
                    bw.write(stack.pop());
                }
                bw.write(" ");


            }
            bw.write("\n");

        }
        bw.flush();
        bw.close();
    }

}
