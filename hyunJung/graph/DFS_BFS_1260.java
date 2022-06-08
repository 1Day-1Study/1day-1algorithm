
import java.io.*;
import java.util.*;


public class DFS_BFS_1260 {
	static FastReader scan = new FastReader();
	static StringBuilder sb = new StringBuilder();
	

	static int N, M, V;
	
	static void input() {
		N = scan.nextInt();
		M = scan.nextInt();
		V = scan.nextInt();
		
		
	}
	
	public static void main(String[] args) {
		
	}
	
    static class FastReader {
        BufferedReader br;
        StringTokenizer st;

        public FastReader() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        public FastReader(String s) throws FileNotFoundException {
            br = new BufferedReader(new FileReader(new File(s)));
        }

        String next() {
            while (st == null || !st.hasMoreElements()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }

        long nextLong() {
            return Long.parseLong(next());
        }

        double nextDouble() {
            return Double.parseDouble(next());
        }

        String nextLine() {
            String str = "";
            try {
                str = br.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return str;
        }
    }
}
