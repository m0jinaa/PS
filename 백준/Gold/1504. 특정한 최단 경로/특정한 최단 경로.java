//다익스트라
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int[] dist;
	static ArrayList<int[]>[] graph;
	static int max = Integer.MAX_VALUE;
	static Queue<int[]> q = new PriorityQueue<int[]>((n1,n2)->n1[1]-n2[1]);
	public static int getPath(int a, int b) {
		Arrays.fill(dist, max);
		dist[a] = 0;
		q.clear();
		q.offer(new int[] {a,0});
		int[] now;
		int y,c;
		while(!q.isEmpty()) {
			now = q.poll();
			y = now[0];
			c = now[1];
			if(dist[y]<c)
				continue;
			for(int[] next:graph[y]) {
				if(dist[next[0]]>c+next[1]) {
					dist[next[0]] = c+next[1];
					q.offer(new int[] {next[0],dist[next[0]]});
				}
			}
		}
		return dist[b];
	}
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		int n = Integer.parseInt(st.nextToken());
		int e = Integer.parseInt(st.nextToken());
		dist = new int[n+1];
		graph = new ArrayList[n+1];
		for(int i = 1;i<=n;i++) {
			graph[i] = new ArrayList<int[]>();
		}
		int a,b,c;
		for(int i = 0;i<e;i++) {
			st = new StringTokenizer(br.readLine()," ");
			a = Integer.parseInt(st.nextToken());
			b = Integer.parseInt(st.nextToken());
			c = Integer.parseInt(st.nextToken());
			graph[a].add(new int[] {b,c});
			graph[b].add(new int[] {a,c});
		}
		st = new StringTokenizer(br.readLine()," ");
		int v1 = Integer.parseInt(st.nextToken());
		int v2 = Integer.parseInt(st.nextToken());
		int d1 = getPath(1,v1);
		int d2 = getPath(v2,n);
		int d3 = getPath(1,v2);
		int d4 = getPath(v1,n);
		int d5 = getPath(v1,v2);
		int result = 0;
		if(d1==max||d2==max||d5==max) {
			result = -1;
		}
		else {
			result = d1+d2+d5;
		}
		if(d3!=max&&d4!=max&&d5!=max) {
			if(result!=-1)
				result = Math.min(result,d3+d4+d5);
			else
				result = d3+d4+d5;
		}
		
		System.out.println(result);
	}
}