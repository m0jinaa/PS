import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		
		Map<String,Integer> map = new HashMap<String,Integer>();
		
		String x;
		for(int i = 0;i<n;i++){
			x = br.readLine();
			map.put(x,map.getOrDefault(x, 0)+1);
		}
		
		for(int i = 1;i<n;i++) {
			x = br.readLine();
			map.put(x, map.get(x)+1);
		}
		
		for(String key : map.keySet()){
			if(map.get(key)%2 != 0) {
				System.out.println(key);
				break;
			}
		}	
	}
}