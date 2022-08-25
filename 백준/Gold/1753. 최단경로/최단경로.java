import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		int v = Integer.parseInt(st.nextToken());
		int e = Integer.parseInt(st.nextToken());
		int start = Integer.parseInt(br.readLine());
		int[] dist = new int[v+1];
		boolean[] visit = new boolean[v+1];
		int max = v*10+1;
		Arrays.fill(dist, max);
		dist[start] = 0;
		visit[start]= true;
		ArrayList<int[]>[] graph = new ArrayList[v+1];
		for(int i = 1;i<=v;i++) {
			graph[i] = new ArrayList<int[]>();
		}
		int a,b,c;
		for(int i = 0;i<e;i++) {
			st = new StringTokenizer(br.readLine()," ");
			a = Integer.parseInt(st.nextToken());
			b = Integer.parseInt(st.nextToken());
			c = Integer.parseInt(st.nextToken());
			graph[a].add(new int[] {b,c});
		}
		
		Queue<int[]> q = new PriorityQueue<>((n1,n2)->n1[1]-n2[1]);
		
		q.offer(new int[] {start,0});
		int[] now;
		while(!q.isEmpty()) {
			now = q.poll();
			b = now[0];
			c = now[1];
			if(dist[b]<c)
				continue;
			for(int[] next:graph[b]) {
				if(c+next[1]<dist[next[0]]) {
					dist[next[0]] = c+next[1];
					q.offer(new int[] {next[0],dist[next[0]]});
				}
			}
		}
		StringBuilder sb = new StringBuilder();
		for(int i = 1;i<=v;i++) {
			if(dist[i]==max) {
				sb.append("INF\n");
			}
			else
				sb.append(dist[i]).append("\n");
		}
		System.out.print(sb);
	}
}