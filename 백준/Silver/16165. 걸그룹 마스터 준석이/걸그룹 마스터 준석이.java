import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		HashMap<String,String[]> group = new HashMap<>();
		
		HashMap<String,String> member = new HashMap<>();
		String g;
		int t;
		String mem;
		
		while(n-->0) {
			g = br.readLine();
			t = Integer.parseInt(br.readLine());
			String[] mems = new String[t];
			for(int i = 0;i<t;i++) {
				mems[i] = br.readLine();
				member.put(mems[i], g);
			}
			
			Arrays.sort(mems);
			
			group.put(g, mems);
		}
		
		String x;
		int mode;
		while(m-->0) {
			
			x = br.readLine();
			mode = Integer.parseInt(br.readLine());
			
			switch(mode) {
			case 0:
				for(String memb: group.get(x)) {
					sb.append(memb).append("\n");
				}
				break;
			case 1:
				sb.append(member.get(x)).append("\n");
			}
		}
		
		System.out.print(sb.toString());
	}
}