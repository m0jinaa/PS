import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		
		int k = Integer.parseInt(st.nextToken());
		int l = Integer.parseInt(st.nextToken());
		
		Map<String,Integer> map = new HashMap<>();
		String n;
		for(int i= 0;i<l;i++) {
			n = br.readLine();
			map.put(n, i);
		}
		
		ArrayList<Entry<String,Integer>> list = new ArrayList<>(map.entrySet());
		
		Collections.sort(list, new Comparator<Entry<String,Integer>>() {

			@Override
			public int compare(Entry<String, Integer> e1, Entry<String, Integer> e2) {
				return e1.getValue()-e2.getValue();
			}
		});
		
		StringBuilder sb = new StringBuilder();
		
		for(int i = 0;i<list.size() && i<k;i++) {
			sb.append(list.get(i).getKey()).append("\n");
		}
		
		System.out.println(sb.toString());
	}
}