import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main{
	static int[] height;
	static long[] asc,desc;
	static ArrayList<Node>[] graph; 
	static int n;
	static class Node{
		int x;
		long d;
		public Node(int x, long d) {
			super();
			this.x = x;
			this.d = d;
		}
	}
	static void dijkstra(int start, long[] save) {
		save[start] = 0;
		Queue<Node> q = new PriorityQueue<Node>((n1,n2)->n1.d<n2.d?-1:1);
		q.offer(new Node(start,0));
		Node now;
		int x;
		long d;
		while(!q.isEmpty()) {
			now = q.poll();
			x = now.x;
			d = now.d;
			if(save[x]<d)
				continue;
			for(Node next:graph[x]) {
				if(height[next.x]<=height[x])
					continue;
				if(save[next.x]>d+next.d) {
					save[next.x] = d+next.d;
					q.offer(new Node(next.x,save[next.x]));
				}
			}
		}
	}
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int d = Integer.parseInt(st.nextToken());
		int e = Integer.parseInt(st.nextToken());
		
		height = new int[n+1];
		st = new StringTokenizer(br.readLine()," ");
		for(int i = 1;i<=n;i++)
			height[i] = Integer.parseInt(st.nextToken());
		
		graph = new ArrayList[n+1];
		for(int i = 1;i<=n;i++) {
			graph[i] = new ArrayList<Node>();
		}
		int a,b;
		long c;
		for(int i = 0;i<m;i++) {
			st = new StringTokenizer(br.readLine()," ");
			a = Integer.parseInt(st.nextToken());
			b = Integer.parseInt(st.nextToken());
			c = Long.parseLong(st.nextToken());
			graph[a].add(new Node(b,c));
			graph[b].add(new Node(a,c));
		}
		
		asc = new long[n+1];
		desc = new long[n+1];
		Arrays.fill(asc, Long.MAX_VALUE);
		Arrays.fill(desc, Long.MAX_VALUE);
		asc[1] = 0;
		desc[n] = 0;
		dijkstra(1,asc);
		dijkstra(n,desc);
		long answer = Long.MIN_VALUE;
		boolean notFound = true;
		for(int i = 2;i<n;i++) {
			if(asc[i]==Long.MAX_VALUE||desc[i]==Long.MAX_VALUE)
				continue;
			notFound = false;
			answer = Math.max(answer,height[i]*e-(asc[i]+desc[i])*d);
		}
		if(notFound) {
			System.out.println("Impossible");
		}
		else
			System.out.println(answer);	
	}
}