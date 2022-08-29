import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main{
	static int n,m;
	static ArrayList<Node>[] graph;
	static class Node{
		int x;
		long d;
		int even;
		public Node(int x, long d) {
			super();
			this.x = x;
			this.d = d;
		}
		public Node(int x, long d, int even) {
			super();
			this.x = x;
			this.d = d;
			this.even = even;
		}
		
	}
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
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
			graph[a].add(new Node(b,c*2));
			graph[b].add(new Node(a,c*2));
		}
		
		long[] fox = new long[n+1];
		long[][] wolf = new long[2][n+1];
		
		Arrays.fill(fox, Long.MAX_VALUE);
		Arrays.fill(wolf[0], Long.MAX_VALUE);
		Arrays.fill(wolf[1], Long.MAX_VALUE);
		fox[1] = 0;
		wolf[0][1] = 0;

		
		Queue<Node> fq = new PriorityQueue<Node>((n1,n2)->n1.d<n2.d?-1:1);
		Queue<Node> wq = new PriorityQueue<Node>((n1,n2)->n1.d<n2.d?-1:1);
		fq.offer(new Node(1,0));
		wq.offer(new Node(1,0,0));
		Node now;
		int x;
		long d,nd;
		int ev,nev;
		while(!fq.isEmpty()) {
			now = fq.poll();
			x = now.x;
			d = now.d;
			if(fox[x]<d)
				continue;
			for(Node next:graph[x]) {
				nd = d+next.d;
				if(fox[next.x]>nd) {
					fox[next.x] = nd;
					fq.offer(new Node(next.x,nd));
				}
			}
		}

		while(!wq.isEmpty()) {
			now = wq.poll();
			x = now.x;
			d = now.d;
			ev = now.even;
			if(wolf[ev][x]<d)
				continue;
			for(Node next:graph[x]) {
				nev = 1-ev;
				nd = d+(ev==1?next.d*2:next.d/2);
				if(wolf[nev][next.x]>nd) {
					wolf[nev][next.x] = nd;
					wq.offer(new Node(next.x,nd,nev));
				}					
			}
		}

		int answer = 0;
		for(int i = 2;i<=n;i++) {
			if(fox[i]<Math.min(wolf[0][i], wolf[1][i]))
				answer++;
		}
		System.out.println(answer);
	}
}