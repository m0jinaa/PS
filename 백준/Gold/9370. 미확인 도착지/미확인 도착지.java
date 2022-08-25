//다익스트라
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main{
	static int[] dist;
	static int[] minDist;
	static ArrayList<int[]>[] graph;
	static int max = Integer.MAX_VALUE;
	static Queue<int[]> q = new PriorityQueue<int[]>((n1,n2)->n1[1]-n2[1]);
	public static void getPath(int a) {
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
	}
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int tc = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		for(int T = 0;T<tc;T++) {
			StringTokenizer st = new StringTokenizer(br.readLine()," ");
			int n = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());
			int t = Integer.parseInt(st.nextToken());
			st = new StringTokenizer(br.readLine()," ");
			int s = Integer.parseInt(st.nextToken());
			int g = Integer.parseInt(st.nextToken());
			int h = Integer.parseInt(st.nextToken());
			dist = new int[n+1];
			graph = new ArrayList[n+1];
			for(int i = 1;i<=n;i++) {
				graph[i] = new ArrayList<int[]>();
			}
			int a,b,c;
			int d = 0;
			for(int i = 0;i<m;i++) {
				st = new StringTokenizer(br.readLine()," ");
				a = Integer.parseInt(st.nextToken());
				b = Integer.parseInt(st.nextToken());
				c = Integer.parseInt(st.nextToken());
				if(a==g&&b==h||a==h&&b==g)
					d = c;
				graph[a].add(new int[] {b,c});
				graph[b].add(new int[] {a,c});
			}
			getPath(s);
			minDist = Arrays.copyOf(dist, n+1);//1번부터 모든 지점까지의 최단거리
			int d1 = dist[g];//s->g
			int d2 = dist[h];//s->h
			int[]gDist,hDist;
			getPath(g);
			gDist = Arrays.copyOf(dist, n+1);
			getPath(h);
			hDist = Arrays.copyOf(dist, n+1);
			ArrayList<Integer> dest = new ArrayList<Integer>();

			for(int i = 0;i<t;i++) {
				int cand = Integer.parseInt(br.readLine());//목적지후보
				if(d1+d+hDist[cand]==minDist[cand])
					dest.add(cand);
				else if(d2+d+gDist[cand]==minDist[cand])
					dest.add(cand);
			}		
			dest.sort((de1,de2)->de1-de2);
			for(int de:dest) {
				sb.append(de).append(" ");
			}
			sb.append("\n");
		}
		System.out.print(sb);
	}
}