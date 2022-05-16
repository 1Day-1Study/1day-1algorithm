import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Card_1_11652 {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		HashMap<Long, Integer> cards = new HashMap<Long, Integer>();
		
		int max=1;
		Long card;
		for(int i=0; i<N; i++) {
			card = Long.parseLong(br.readLine());
			
			if(cards.containsKey(card)) {
				int val = cards.get(card);
				
				if(val + 1 > max) {
					max = val + 1;
				}
				cards.put(card, val + 1);
			}else {
				cards.put(card, 1);
			}
		}
		
		List<Long> list = new ArrayList<Long>();
		for(Map.Entry<Long, Integer> temp : cards.entrySet() ) {
			if(temp.getValue() == max) {
				list.add(temp.getKey());
			}
		}
		Collections.sort(list);
		System.out.println(list.get(0));
		
		br.close();
	}
}
