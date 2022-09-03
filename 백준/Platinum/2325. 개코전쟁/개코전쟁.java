import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main{
	static int n,m;
	static ArrayList<int[]>[] graph;
	static int[] route;
	static int[] dist;
	static void dijkstra() {
		Arrays.fill(dist, Integer.MAX_VALUE);
		Queue<int[]> q = new PriorityQueue<int[]>((n1,n2)->n1[1]-n2[1]);
		dist[1] = 0;
		route[1] = 1;
		int[] now;
		int x,d;
		q.add(new int[] {1,0});
		while(!q.isEmpty()) {
			now = q.poll();
			x = now[0];
			d = now[1];
			if(dist[x]<d)
				continue;
			for(int[] next:graph[x]) {
				if(dist[next[0]]<=d+next[1])
					continue;
				dist[next[0]] = d+next[1];
				q.add(new int[] {next[0],dist[next[0]]});
				route[next[0]] = x;
			}
		}
	}
	static void dijkstra(int a, int b) {//a와 b사이는 건너갈 수 없음
		Arrays.fill(dist, Integer.MAX_VALUE);
		Queue<int[]> q = new PriorityQueue<int[]>((n1,n2)->n1[1]-n2[1]);
		dist[1] = 0;
		route[1] = 1;
		int[] now;
		int x,d;
		q.add(new int[] {1,0});
		while(!q.isEmpty()) {
			now = q.poll();
			x = now[0];
			d = now[1];
			if(dist[x]<d)
				continue;
			for(int[] next:graph[x]) {
				if(x==a&&next[0]==b ||dist[next[0]]<=d+next[1])
					continue;
				dist[next[0]] = d+next[1];
				q.add(new int[] {next[0],dist[next[0]]});
			}
		}
	}
	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		route = new int[n+1];
		dist = new int[n+1];
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
		dijkstra(); //최단거리까지의 route 구하기
		b = n;
		int answer = 0;
		while(b!=1) {//최단거리를 구성하는 edge 하나씩 없애보면서 최단거리 구하기
			a = route[b];
			dijkstra(a,b);
			answer = answer<dist[n]?dist[n]:answer;
			b = a;
		}
		System.out.println(answer);
	}
}
