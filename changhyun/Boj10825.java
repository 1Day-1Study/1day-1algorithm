import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Boj10825 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        List<Student> studentList = new ArrayList<>();

        int N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            studentList.add(new Student(st.nextToken(), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
        }

        Collections.sort(studentList);

        for (int i = 0; i < studentList.size(); i++) {
            bw.write(studentList.get(i).name);
            bw.write("\n");
        }

        bw.flush();
    }

    static class Student implements Comparable<Student>{
        String name;
        int korean;
        int english;
        int math;

        public Student(String name, int korean, int english, int math) {
            this.name = name;
            this.korean = korean;
            this.english = english;
            this.math = math;
        }

        @Override
        public int compareTo(Student o) {
            int comp1 = Integer.compare(o.korean, korean);
            if (comp1 == 0) {
                int comp2 = Integer.compare(english, o.english);
                if (comp2 == 0) {
                    int comp3 = Integer.compare(o.math, math);
                    if (comp3 == 0) {
                        return name.compareTo(o.name);
                    }
                    return comp3;
                }
                return comp2;
            }
            return comp1;
        }
    }
}
