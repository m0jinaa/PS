import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main{
	static int[] minDist;
	static int n,m;
	static ArrayList<int[]>[] graph;
	
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		graph = new ArrayList[n+1];
		int[] dp = new int[n+1];
		minDist = new int[n+1];
		for(int i = 1;i<=n;i++) {
			graph[i] = new ArrayList<int[]>();
		}
		int a,b,c;
		Arrays.fill(minDist, Integer.MAX_VALUE);
		for(int i = 0;i<m;i++) {
			st = new StringTokenizer(br.readLine()," ");
			a = Integer.parseInt(st.nextToken());
			b = Integer.parseInt(st.nextToken());
			c = Integer.parseInt(st.nextToken());
			graph[a].add(new int[] {b,c});
			graph[b].add(new int[] {a,c});
		}
		Queue<int[]> q = new PriorityQueue<int[]>((n1,n2)->n1[1]-n2[1]);
		q.offer(new int[] {2,0});
		dp[2] = 1;
		minDist[2] = 0;
		int[] now;
		while(!q.isEmpty()) {
			now = q.poll();
			if(minDist[now[0]]<now[1])
				continue;
			for(int[] next:graph[now[0]]) {
				if(minDist[next[0]]>now[1]+next[1]) {
					minDist[next[0]]=now[1]+next[1];
					q.offer(new int[] {next[0],minDist[next[0]]});
				}
				if(minDist[next[0]]<now[1])
					dp[now[0]]+=dp[next[0]];
			}
		}
		System.out.println(dp[1]);
	}
}
