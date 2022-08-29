import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main{
	static int n,m,k;
	static int[] meeting;
	static ArrayList<Node>[] graph;
	static long[] dist;
	static Queue<Node> q = new PriorityQueue<Node>((n1,n2)->n1.d<n2.d?-1:1);
	static class Node{
		int city;
		long d;
		public Node(int city, long d) {
			super();
			this.city = city;
			this.d = d;
		}
	}
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		meeting = new int[k];
		graph = new ArrayList[n+1];
		for(int i = 1;i<=n;i++) {
			graph[i] = new ArrayList<Node>();
		}
		
		dist = new long[n+1];
		int a,b;
		long c;
		for(int i = 0;i<m;i++) {
			st = new StringTokenizer(br.readLine()," ");
			a = Integer.parseInt(st.nextToken());
			b = Integer.parseInt(st.nextToken());
			c = Long.parseLong(st.nextToken());
			graph[b].add(new Node(a,c));
		}
		int answerCity = 0;
		long answerDist = -1;		
		st = new StringTokenizer(br.readLine()," ");
		Arrays.fill(dist, Long.MAX_VALUE);
		for(int i = 0;i<k;i++) {
			int num = Integer.parseInt(st.nextToken());
			q.offer(new Node(num,0));
			dist[num] = 0;
		}

		Node now;
		int x;
		long d;
		
		while(!q.isEmpty()) {
			now = q.poll();
			x = now.city;
			d = now.d;
			if(dist[x]<d)
				continue;
			for(Node next:graph[x]) {
				if(dist[next.city]>d+next.d) {
					dist[next.city] = d+next.d;
					q.offer(new Node(next.city,dist[next.city]));
				}
			}
		}
		for(int i = 1;i<=n;i++) {
			if(answerDist<dist[i]) {
				answerDist = dist[i];
				answerCity = i;
			}
		}
		System.out.println(answerCity);
		System.out.println(answerDist);
	}
}