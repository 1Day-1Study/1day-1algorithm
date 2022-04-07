import java.util.Scanner;
public class Boj9093 {
    public static void main(String[] args) {

        String result = "";
        int count = 0;
        Scanner scan = new Scanner(System.in);
        int number = scan.nextInt();

        while (count < number) {
            Scanner scan1 = new Scanner(System.in);
            String str2 = scan1.nextLine();
            String arr[] = str2.split(" ");

            for (int i = 0; i < arr.length; i++) {
//            System.out.println(arr[i].length());

                for (int j = arr[i].length(); j > 0; j--) {
                    String[] arr1 = arr[i].split("");
//                System.out.println(arr1[j-1]);
                    result += arr1[j - 1];

                }
                result += " ";

            }
            System.out.println("result = " + result);
            count++;
            result="";
        }
    }
}

