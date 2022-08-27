import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int n,m,k;
	static class Node{
		int id,cnt;
		long cost;
		

		public Node(int id, int cnt, long cost) {
			super();
			this.id = id;
			this.cnt = cnt;
			this.cost = cost;
		}


		public Node(int id, long cost) {
			super();
			this.id = id;
			this.cost = cost;
		}
	}
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		long[][] dp = new long[n+1][k+1];
		
		ArrayList<Node>[] graph = new ArrayList[n+1];
		for(int i = 1;i<=n;i++) {
			graph[i] = new ArrayList<Node>();
		}
		for(int i = 0;i<=n;i++) {
			Arrays.fill(dp[i], Long.MAX_VALUE);
		}
		int a,b,c;
		for(int i = 0;i<m;i++) {
			st = new StringTokenizer(br.readLine()," ");
			a = Integer.parseInt(st.nextToken());
			b = Integer.parseInt(st.nextToken());
			c = Integer.parseInt(st.nextToken());
			graph[a].add(new Node(b,c));
			graph[b].add(new Node(a,c));
		}
		
		dp[1][0] = 0;
		Queue<Node> q = new PriorityQueue<Node>((n1,n2)->n1.cost<n2.cost?-1:1);
		Node now;
		int cnt,x,nx;
		long sum;
		q.offer(new Node(1,0,0));//현재위치, 포장횟수, 시간
		long answer = 0;
		while(!q.isEmpty()) {
			now = q.poll();
			x = now.id;
			cnt = now.cnt;
			sum = now.cost;
			if(x==n) {
				answer = sum;
				break;
			}
			if(dp[x][cnt]<sum)
				continue;
			for(Node nd:graph[x]) {
				nx = nd.id;
				if(cnt<k&&dp[nx][cnt+1]>sum) {
					dp[nx][cnt+1] = sum;
					q.add(new Node(nx,cnt+1,sum));
				}
				if(dp[nx][cnt]>sum+nd.cost) {
					dp[nx][cnt] = sum+nd.cost;
					q.add(new Node(nx,cnt,sum+nd.cost));
				}
			}
		}
		System.out.println(answer);
	}
}