import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main{
	static ArrayList<Integer>[] graph;
	static boolean[] connected;
	static int[] work;
	
	public static boolean dfs(int x) {
		for(int i:graph[x]) {
			if(connected[i])
				continue;
			connected[i] = true;
			
			if(work[i]==0 || dfs(work[i])) {
				work[i] = x;
				return true;
			}
		}
		
		return false;
	}
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		work = new int[m + 1];
		connected = new boolean[m + 1];
		graph = new ArrayList[n + 1];

		int c, w;

		for (int i = 1; i <= n; i++) {
			graph[i] = new ArrayList<Integer>();
			st = new StringTokenizer(br.readLine(), " ");

			c = Integer.parseInt(st.nextToken());
			while (c-- > 0) {
				w = Integer.parseInt(st.nextToken());
				graph[i].add(w);
			}
		}
		int answer = 0;
		for(int i = 1;i<=n;i++) {
			Arrays.fill(connected, false);
			if(dfs(i)) {
				answer++;
			}
		}		
		System.out.println(answer);
	}
}