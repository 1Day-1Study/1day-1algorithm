import java.io.*;

public class Boj9012 {

    public static String check(String temp) {

        String sample = "";
        int left_parentheses = 0;
        int right_parentheses = 0;
        String VPS[] = temp.split("");
        for (int i = 0; i < VPS.length; i++) {

            if (VPS[0].equals(")") || VPS[VPS.length - 1].equals("(")) {
                return "NO";
            } else {
                if (VPS[i].equals("(")) {
                    left_parentheses++;
                }
                if (VPS[i].equals(")")) {
                    right_parentheses++;
                }

            }
        }

        if (left_parentheses == right_parentheses) {
            for (int i = 0; i < VPS.length; i++) {
                for (int j = 1; j < VPS.length; j++) {
                    if (VPS[i].equals("(") && VPS[j].equals(")")) {
                        VPS[i] = "";
                        VPS[j] = "";
                    }
                }
                sample+=VPS[i];
            }
            if(sample.equals("")) {
                return "YES";
            } else {
                return "NO";
            }
        } else {
            return "NO";
        }
    }


    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int number = Integer.parseInt(bf.readLine());

        for (int j = 0; j < number; j++) {
            String VPS=bf.readLine();
            String result=check(VPS);
            bw.write(result);
            bw.write("\n");

        }
        bw.flush();
        bw.close();

    }
}