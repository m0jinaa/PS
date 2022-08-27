import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main{
	static int n,m;
	static int[] dp;
	static ArrayList<int[]>[] graph ;
	static int result;
	static int[] way;
	static Queue<int[]> q = new PriorityQueue<int[]>((n1,n2)->n1[1]<n2[1]?-1:1);
	static void dijkstra() {
		Arrays.fill(dp,Integer.MAX_VALUE);
		dp[1] = 0;
		int[] now;
		int x,sum;
		q.clear();
		q.offer(new int[] {1,0});//현재위치, 시간
		while(!q.isEmpty()) {
			now = q.poll();
			x = now[0];
			sum = now[1];
			if(x==n) {
				break;
			}
			if(dp[x]<sum)
				continue;
			for(int[] next:graph[x]) {
				if(dp[next[0]]>sum+next[1]) {
					dp[next[0]] = sum+next[1];
					q.add(new int[] {next[0],dp[next[0]]});
					way[next[0]] = x;
				}
			}
		}		
	}
	static void block(int a, int b) {
		Arrays.fill(dp,Integer.MAX_VALUE);
		dp[1] = 0;
		int[] now;
		int x,sum;
		q.clear();
		q.offer(new int[] {1,0});//현재위치, 시간
		while(!q.isEmpty()) {
			now = q.poll();
			x = now[0];
			sum = now[1];
			if(x==n) {
				break;
			}
			if(dp[x]<sum)
				continue;
			for(int[] next:graph[x]) {
				if(x==a&&next[0]==b||x==b&&next[0]==a)
					continue;
				if(dp[next[0]]>sum+next[1]) {
					dp[next[0]] = sum+next[1];
					q.add(new int[] {next[0],dp[next[0]]});
				}
			}
		}		
	}
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		dp = new int[n+1];
		
		graph = new ArrayList[n+1];
		for(int i = 1;i<=n;i++) {
			graph[i] = new ArrayList<int[]>();
		}
		int a,b,c;
		for(int i = 0;i<m;i++) {
			st = new StringTokenizer(br.readLine()," ");
			a = Integer.parseInt(st.nextToken());
			b = Integer.parseInt(st.nextToken());
			c = Integer.parseInt(st.nextToken());
			graph[a].add(new int[] {b,c});
			graph[b].add(new int[] {a,c});
		}
		int original;
		way = new int[n+1];
		dijkstra();
		original = dp[n];
		int answer = 0;
		int max = 0;
		for(int i = 1;i<=n;i++) {
			block(i,way[i]);
			max = max<dp[n]?dp[n]:max;
		}	
		System.out.println(max!=Integer.MAX_VALUE?max-original:-1);
		//System.out.println(Arrays.toString(dp[n]));
	}
}