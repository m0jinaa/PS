import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int[] paint;
	static int[] targets;
	static boolean[] used;
	static ArrayList<Integer>[] shot;
	
	static boolean dfs(int x) {
		for(int target : shot[x]) {
			if(used[target])
				continue;
			used[target] = true;
			if(paint[target]==0 || dfs(paint[target])) {
				paint[target] = x;
				targets[x] = target;
				return true;
			}
		}
		return false;
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		paint = new int[n+1];
		used = new boolean[n+1];
		targets = new int[n+1];
		shot = new ArrayList[n+1];
		
		for(int i = 1;i<=n;i++) {
			shot[i] = new ArrayList<>();
		}
		
		int a,b;
		
		for(int i = 0;i<m;i++) {
			st = new StringTokenizer(br.readLine()," ");
			a = Integer.parseInt(st.nextToken());
			b = Integer.parseInt(st.nextToken());
			
			shot[a].add(b);
			shot[b].add(a);
			
		}
		
		int cnt = 0;
		
		for(int i = 1;i<=n;i++) {
			Arrays.fill(used, false);
			
			if(dfs(i)) {
				cnt++;
			}
		}
		
		if(cnt==n) {
			for(int i = 1;i<=n;i++) {
				sb.append(targets[i]).append("\n");
			}
		}
		else {
			sb.append("Impossible\n");
		}
		
		System.out.print(sb.toString());
	}
}