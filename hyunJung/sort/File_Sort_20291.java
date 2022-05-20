import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;


public class File_Sort_20291 {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		Map<String, Integer> files = new TreeMap<>(); 
				
		while(N-- > 0) {
			String file = br.readLine();
			String[] fileExe = file.split("\\.");
			
			if(files.containsKey(fileExe[1])) {
				files.put(fileExe[1], files.get(fileExe[1]) + 1);
			}else {
				files.put(fileExe[1], 1);
			}
		}
		
		br.close();
		
		StringBuilder sb = new StringBuilder();
		
		for(Entry<String, Integer> entry : files.entrySet()) {
			sb.append(entry.getKey()).append(' ').append(entry.getValue()).append("\n");
		}
		
		System.out.println(sb);
	}

}
