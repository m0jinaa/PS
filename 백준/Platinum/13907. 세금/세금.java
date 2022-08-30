import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main{
	static int s,e,n,m,k;
	static int[][] cost;
	static ArrayList<int[]>[] graph;
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		StringBuilder sb = new StringBuilder();
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine()," ");
		s = Integer.parseInt(st.nextToken());
		e = Integer.parseInt(st.nextToken());
		graph = new ArrayList[n+1];
		cost = new int[n+1][n];
		for(int i = 1;i<=n;i++) {
			graph[i] = new ArrayList<int[]>();
			Arrays.fill(cost[i], Integer.MAX_VALUE);
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
		Queue<int[]> q = new PriorityQueue<int[]>((n1,n2)->n1[2]-n2[2]);
		q.offer(new int[] {s,0,0});
		cost[s][0] = 0;
		int[] now;
		int x,cnt;
		int min = Integer.MAX_VALUE;
		int minCnt = Integer.MAX_VALUE;
		while(!q.isEmpty()) {
			now = q.poll();
			x = now[0];
			cnt = now[1];
			c = now[2];
			if(x==e) {
				if(min>c) {
					min = c;
					minCnt = cnt;
				}
				continue;
			}
			if(cost[x][cnt]<c||cnt>=minCnt||cnt>=n-1)
				continue;
			for(int[] next:graph[x]) {
				if(cost[next[0]][cnt+1]>c+next[1]) {
					cost[next[0]][cnt+1] = c+next[1];
					q.offer(new int[] {next[0],cnt+1,c+next[1]});
				}
			}
		}
		sb.append(min).append("\n");
		int v, val;
		for(int i = 0;i<k;i++) {
			v = Integer.parseInt(br.readLine());
			val = cost[e][minCnt]+=minCnt*v;
			for(int j = 1;j<minCnt;j++) {
				if(cost[e][j]!=Integer.MAX_VALUE) {
					val = Math.min(val, cost[e][j]+=v*j);					
				}
			}
			sb.append(val).append("\n");
		}
		System.out.print(sb);
	}
}