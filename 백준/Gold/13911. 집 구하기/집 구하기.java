import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main{
	static int v,e;
	static ArrayList<Node>[] graph;
	static long[] mdist, sdist;
	static class Node{
		int x;
		long d;
		public Node(int x, long d) {
			super();
			this.x = x;
			this.d = d;
		}
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		
		v = Integer.parseInt(st.nextToken());
		e = Integer.parseInt(st.nextToken());
		
		graph = new ArrayList[v+1];
		for(int i = 1;i<=v;i++) {
			graph[i] = new ArrayList<Node>();
		}
		Queue<Node>mq = new PriorityQueue<Node>((n1,n2)->n1.d<n2.d?-1:1);
		Queue<Node>sq = new PriorityQueue<Node>((n1,n2)->n1.d<n2.d?-1:1);
		int a,b;
		long c;
		
		for(int i = 0;i<e;i++) {
			st = new StringTokenizer(br.readLine()," ");
			a = Integer.parseInt(st.nextToken());
			b = Integer.parseInt(st.nextToken());
			c = Long.parseLong(st.nextToken());
			graph[a].add(new Node(b,c));
			graph[b].add(new Node(a,c));
		}
		
		int m,x,s,y;
		mdist = new long[v+1];
		sdist = new long[v+1];
		Arrays.fill(mdist, Long.MAX_VALUE);
		Arrays.fill(sdist, Long.MAX_VALUE);
		st = new StringTokenizer(br.readLine()," ");
		m = Integer.parseInt(st.nextToken());
		x = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine()," ");
		int ind;
		for(int i = 0;i<m;i++) {
			ind = Integer.parseInt(st.nextToken());
			mdist[ind] = 0;
			mq.add(new Node(ind,0));
		}

		st = new StringTokenizer(br.readLine()," ");
		s = Integer.parseInt(st.nextToken());
		y = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine()," ");
		for(int i = 0;i<s;i++) {
			ind = Integer.parseInt(st.nextToken());
			sdist[ind] = 0;
			sq.add(new Node(ind,0));
		}
		Node now;
		while(!mq.isEmpty()) {
			now = mq.poll();
			if(mdist[now.x]<now.d)
				continue;
			for(Node next:graph[now.x]) {
				if(now.d+next.d<=x&&mdist[next.x]>now.d+next.d) {
					mdist[next.x] = now.d+next.d;
					mq.add(new Node(next.x,mdist[next.x]));
				}
			}
		}
		while(!sq.isEmpty()) {
			now = sq.poll();
			if(sdist[now.x]<now.d)
				continue;
			for(Node next:graph[now.x]) {
				if(now.d+next.d<=y&&sdist[next.x]>now.d+next.d) {
					sdist[next.x] = now.d+next.d;
					sq.add(new Node(next.x,sdist[next.x]));
				}
			}
		}
		long answer = Long.MAX_VALUE;
		for(int i = 1;i<=v;i++) {
			if(mdist[i]!=0&&mdist[i]!=Long.MAX_VALUE&&sdist[i]!=0&&sdist[i]!=Long.MAX_VALUE) {
				answer = Math.min(answer, mdist[i]+sdist[i]);
			}
		}
		System.out.println(answer!=Long.MAX_VALUE?answer:-1);
	}
}