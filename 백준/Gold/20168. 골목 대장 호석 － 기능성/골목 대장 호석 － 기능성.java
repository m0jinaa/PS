import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main{
	static int n,m,a,b,c;
	static int[] dp;
	static ArrayList<int[]>[] graph;
	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		a = Integer.parseInt(st.nextToken());
		b = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		
		graph = new ArrayList[n+1];
		dp = new int[n+1];
		Arrays.fill(dp, Integer.MAX_VALUE);
		for(int i = 1;i<=n;i++) {
			graph[i] = new ArrayList<int[]>();
		}
		int answer = -1;
		int x,y,z;
		for(int i = 0;i<m;i++) {
			st = new StringTokenizer(br.readLine()," ");
			x = Integer.parseInt(st.nextToken());
			y = Integer.parseInt(st.nextToken());
			z = Integer.parseInt(st.nextToken());
			graph[x].add(new int[] {y,z});
			graph[y].add(new int[] {x,z});
		}
		Queue<int[]> q = new PriorityQueue<int[]>((n1,n2)->n1[1]-n2[1]);
		dp[a] = 0;
		q.add(new int[] {a,0,0});
		int nc,cost,total,nt;
		int[] now;
		while(!q.isEmpty()) {
			now = q.poll();
			x = now[0];
			cost = now[1];
			total = now[2];
			if(dp[x]<cost)
				continue;
			if(x==b) {
				answer = cost;
				break;
			}
			for(int[] next:graph[x]) {
				nc = Math.max(cost, next[1]);
				nt = total+next[1];
				if(dp[next[0]]>nc &&nt<=c) {
					dp[next[0]] = nc;
					q.add(new int[] {next[0],nc,nt});
				}
			}
		}
		System.out.println(answer);
	}
}