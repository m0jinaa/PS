import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int n = Integer.parseInt(br.readLine());
		
		int x,y;
		
		Map<Integer,Integer> horizontal = new HashMap<>();
		Map<Integer,Integer> vertical = new HashMap<>();
		
		long answer = 0;
		
		int cnt;
		while(n-->0) {
			st = new StringTokenizer(br.readLine()," ");
			x = Integer.parseInt(st.nextToken());
			y = Integer.parseInt(st.nextToken());
			
			cnt = horizontal.getOrDefault(x, 0);
			if(cnt<=1)
				answer+=cnt;
			horizontal.put(x,cnt+1);

			cnt = vertical.getOrDefault(y, 0);
			
			if(cnt<=1)
				answer+=cnt;
			vertical.put(y,cnt+1);
		
		}
		
		System.out.println(answer);
	}
}