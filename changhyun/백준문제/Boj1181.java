package 백준문제;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Boj1181 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static Set<Word> wordSet = new TreeSet<>(); //TreeSet으로만 정답이 안맞음, 왠지 모르겠음..
    static List<Word> wordList = new ArrayList<>();
    static int N;

    public static void main(String[] args) throws IOException {

        N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            wordSet.add(new Word(br.readLine()));
        }

        for (Word word : wordSet) {
            wordList.add(new Word(word.word));
        }

        Collections.sort(wordList);


        for (Word word : wordList) {
            sb.append(word.word).append("\n");
        }
        System.out.println(sb.toString());
    }

    static class Word implements Comparable<Word>{
        String word;

        public Word(String word) {
            this.word = word;
        }

        @Override
        public int compareTo(Word o) {
            int cmp = Integer.compare(word.length(), o.word.length());
            if (cmp == 0) {
                return word.compareTo(o.word);
            }
            return cmp;
        }
    }
}
