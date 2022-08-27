import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main{
	static int n,p,k;
	static ArrayList<Node>[] graph;
	static long[] count;
	static Queue<Node> q = new PriorityQueue<Node>((n1,n2)->n1.price<n2.price?-1:1);
	static class Node{
		int id;
		long price;
		int cnt;
		public Node(int id, long price, int cnt) {
			super();
			this.id = id;
			this.price = price;
			this.cnt = cnt;
		}
		public Node(int id, long price) {
			super();
			this.id = id;
			this.price = price;
		}
	}
	static boolean dijkstra(int limit) {
		Arrays.fill(count, Long.MAX_VALUE);
		
		q.clear();
		q.add(new Node(1,0,0));
		Node now;
		while(!q.isEmpty()) {
			now = q.poll();
			
			if(count[now.id]<now.cnt)
				continue;
			if(now.id==n)
				return true;
			for(Node next:graph[now.id]) {
				if(next.price>limit) {
					if(now.cnt<k && count[next.id]>now.cnt+1) {
						count[next.id] = now.cnt+1;
						q.add(new Node(next.id,now.price,now.cnt+1));
					}
				}
				else if(count[next.id]>now.cnt) {
					count[next.id]=now.cnt;
					q.add(new Node(next.id,next.price,now.cnt));
				}
			}
		}
		
		return false;
	}
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		n = Integer.parseInt(st.nextToken());
		p = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		int a,b;
		long c;
		graph = new ArrayList[n+1];
		count = new long[n+1];
		for(int i = 0;i<=n;i++) {
			graph[i] = new ArrayList<Node>();
		}
		for(int i = 0;i<p;i++) {
			st = new StringTokenizer(br.readLine()," ");
			a = Integer.parseInt(st.nextToken());
			b = Integer.parseInt(st.nextToken());
			c = Long.parseLong(st.nextToken());
			
			graph[a].add(new Node(b,c));
			graph[b].add(new Node(a,c));
		}
		
		int left = 0;
		int right = 1_000_000;
		int mid;
		int answer = -1;
		while(left<=right) {
			mid = (left+right)/2;
			if(dijkstra(mid)) {
				answer = mid;
				right = mid-1;
			}
			else {
				left = mid+1;
			}
		}
		System.out.println(answer);
	}
}
