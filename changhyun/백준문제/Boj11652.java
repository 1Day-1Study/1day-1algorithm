package 백준문제;

import java.io.*;
import java.util.*;

public class Boj11652 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        Map<String, Integer> cardMap = new HashMap<>();
        int N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            String n = br.readLine();
            cardMap.put(n, cardMap.getOrDefault(n, 0) + 1);
        }

        List<Card> cardList = new ArrayList<>();
        for (String key : cardMap.keySet()) {
            cardList.add(new Card(key, cardMap.get(key)));
        }
        Collections.sort(cardList);

        bw.write(cardList.get(0).number);
        bw.flush();
    }

    static class Card implements Comparable<Card>{
        String number;
        int value;

        public Card(String number, int value) {
            this.number = number;
            this.value = value;
        }

        @Override
        public int compareTo(Card o) {
            int comp1 = Integer.compare(o.value, value);
            if (comp1 == 0) {
                return Long.compare(Long.parseLong(number), Long.parseLong(o.number));
            }
            return comp1;
        }
    }
}
