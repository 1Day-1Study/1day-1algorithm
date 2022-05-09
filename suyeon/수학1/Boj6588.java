package suyeon.수학1;

import java.io.*;

public class Boj6588 {
    public static boolean[] primeNums = new boolean[10001];

    public static void getPrime() {
        for(int i = 2; i < Math.sqrt(primeNums.length); i++) {
            if(primeNums[i])
                continue;
            for(int j = i * i; j < primeNums.length; j += i)
                primeNums[j] = true;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        getPrime();

        int count = 0;

        while(count != n) {
            count++;
            int getNum = Integer.parseInt(br.readLine());
            int a = getNum / 2;
            int b = getNum / 2;

            while(a > 0) {
                if(primeNums[a] == false && primeNums[b] == false) {
                    System.out.println(a + " " + b);
                    break;
                }
                else {
                    a--;
                    b++;
                }
            }
        }
    }
}
