import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main{
	static int n,m;
	static int[] price;
	static long[][] dp;
	static ArrayList<Node>[] graph;
	static class Node{
		int x;
		int d;
		int min;
		long cost;
		
		public Node(int x, int min, long cost) {
			super();
			this.x = x;
			this.min = min;
			this.cost = cost;
		}
		public Node(int x, int d) {
			super();
			this.x = x;
			this.d = d;
		}
		
	}
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine()," ");
		price = new int[n+1];
		dp = new long[n+1][2501];
		
		int a,b,c;
		graph = new ArrayList[n+1];
		for(int i = 1;i<=n;i++) {
			price[i] = Integer.parseInt(st.nextToken());
			graph[i] = new ArrayList<Node>();
			Arrays.fill(dp[i], Long.MAX_VALUE);
		}
		
		for(int i = 0;i<m;i++) {
			st = new StringTokenizer(br.readLine()," ");
			a = Integer.parseInt(st.nextToken());
			b = Integer.parseInt(st.nextToken());
			c = Integer.parseInt(st.nextToken());
			graph[a].add(new Node(b,c));
			graph[b].add(new Node(a,c));
		}
		
		Queue<Node> q = new PriorityQueue<Node>((n1,n2)->n1.cost<n2.cost?-1:1);
		
		dp[1][price[1]] = 0;
		q.add(new Node(1,price[1],0));
		Node now;
		int p,np;
		long cost,ncost;
		long answer = 0;
		while(!q.isEmpty()) {
			now = q.poll();
			a = now.x;
			p = now.min;
			cost = now.cost;
			if(a==n) {
				answer = cost;
				break;
			}
			if(dp[a][p]<cost)
				continue;
			for(Node next:graph[a]) {
				np = p<price[next.x]?p:price[next.x];
				ncost = cost+next.d*p;
				if(dp[next.x][p]>ncost) {
					dp[next.x][p] = ncost;
					q.add(new Node(next.x,np,ncost));
				}
			}		
		}
		System.out.println(answer);	
	}
}