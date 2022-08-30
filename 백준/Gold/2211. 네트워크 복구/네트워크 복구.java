import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;
import java.util.StringTokenizer;

public class Main{
	static int[] bef;
	static int n,m;
	static ArrayList<int[]>[] graph;
	static int[] dist;
	static class Node{
		int x,y;

		public Node(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}

		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + x;
			result = prime * result + y;
			return result;
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			Node other = (Node) obj;
			if (x != other.x)
				return false;
			if (y != other.y)
				return false;
			return true;
		}
		
	}
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		bef = new int[n+1];
		graph = new ArrayList[n+1];
		for(int i = 1;i<=n;i++) {
			graph[i] = new ArrayList<int[]>();
		}
		dist = new int[n+1];
		Arrays.fill(dist, Integer.MAX_VALUE);
		int a,b,c;
		for(int i = 0;i<m;i++) {
			st = new StringTokenizer(br.readLine()," ");
			a = Integer.parseInt(st.nextToken());
			b = Integer.parseInt(st.nextToken());
			c = Integer.parseInt(st.nextToken());
			graph[a].add(new int[] {b,c});
			graph[b].add(new int[] {a,c});
		}
		
		dist[1] = 0;
		bef[1] = 1;
		Queue<int[]> q = new PriorityQueue<int[]>((n1,n2)->n1[1]-n2[1]);
		q.add(new int[] {1,0});
		int[] now;
		int x,d;
		while(!q.isEmpty()) {
			now = q.poll();
			x = now[0];
			d = now[1];
			//System.out.println(x+" "+d);
			if(dist[x]<d)
				continue;
			for(int[] next:graph[x]) {
				if(dist[next[0]]>d+next[1]) {
					dist[next[0]] = d+next[1];
					bef[next[0]] = x;
					q.add(new int[] {next[0],dist[next[0]]});
				}
			}
		}
		
		Set<Node> set = new HashSet<Node>();
		int v;
		for(int i = 2;i<=n;i++) {
			v = i;
			while(v!=1) {
				if(bef[v]<v) {
					set.add(new Node(bef[v],v));
				}
				else
					set.add(new Node(v,bef[v]));
				v = bef[v];
			}
		}
		System.out.println(set.size());
		for(Node row:set) {
			System.out.println(row.x+" "+row.y);
		}
	}
}