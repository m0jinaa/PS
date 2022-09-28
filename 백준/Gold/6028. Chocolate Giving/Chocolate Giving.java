import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main{
	static int n,m,b;
	static ArrayList<int[]>[]graph;
	static int[] dist;
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		b = Integer.parseInt(st.nextToken());
		graph = new ArrayList[n+1];
		dist = new int[n+1];
		for(int i = 1;i<=n;i++) {
			graph[i] = new ArrayList<int[]>();
		}
		Arrays.fill(dist, Integer.MAX_VALUE);
		
		int r,s,l; 
		
		for(int i = 0;i<m;i++) {
			st = new StringTokenizer(br.readLine()," ");
			r = Integer.parseInt(st.nextToken());
			s = Integer.parseInt(st.nextToken());
			l = Integer.parseInt(st.nextToken());
			graph[r].add(new int[] {s,l});
			graph[s].add(new int[] {r,l});
		}
		
		Queue<int[]> q = new PriorityQueue<int[]>((n1,n2)->n1[1]-n2[1]);
		q.add(new int[] {1,0});
		dist[1] = 0;
		int[] now;
		int x,d;
		while(!q.isEmpty()) {
			now = q.poll();
			x = now[0];
			d = now[1];
			if(dist[x]<d)
				continue;
			for(int[] next:graph[x]) {
				if(dist[next[0]]>d+next[1]) {
					dist[next[0]] = d+next[1];
					q.add(new int[] {next[0],dist[next[0]]});
				}
			}
		}
		StringBuilder sb = new StringBuilder();
		for(int i = 0;i<b;i++) {
			st = new StringTokenizer(br.readLine()," ");
			r = Integer.parseInt(st.nextToken());
			s = Integer.parseInt(st.nextToken());
			sb.append(dist[r]+dist[s]).append("\n");
		}
		System.out.println(sb.toString());
	}
}
