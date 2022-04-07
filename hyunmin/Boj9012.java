import java.util.Scanner;

public class Boj9012 {

    public String check(String temp) {

        int left_parentheses=0;
        int right_parentheses=0;
        String VPS[]=temp.split("");
        for (int i = 0; i < VPS.length; i++) {

            if(VPS[i].equals("(")) {
                left_parentheses++;
            }
            if(VPS[i].equals(")")) {
                right_parentheses++;
            }
        }

        if(left_parentheses==right_parentheses) {
            return "YES";
        } else {
            return "NO";
        }
    }


    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        Boj9012 boj9012 = new Boj9012();
        System.out.print("입력 갯수 T:");
        int i = Integer.parseInt(scanner.nextLine());

        for (int j = 0; j < i; j++) {
//            Scanner scanner1 = new Scanner(System.in);
            String VPS=scanner.nextLine();
            String result=boj9012.check(VPS);
            System.out.println(result);

        }


    }
}