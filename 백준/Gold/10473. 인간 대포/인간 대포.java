import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main{
	static double startx,starty,endx,endy;
	static double[][] cannon;
	static ArrayList<Node>[] graph;
	static class Node{
		int x;
		double t;
		public Node(int x, double t) {
			super();
			this.x = x;
			this.t = t;
		}
	}
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		startx = Double.parseDouble(st.nextToken());
		starty = Double.parseDouble(st.nextToken());
		st = new StringTokenizer(br.readLine()," ");
		endx = Double.parseDouble(st.nextToken());
		endy = Double.parseDouble(st.nextToken());
		
		int n = Integer.parseInt(br.readLine());
		cannon = new double[n][2];
		graph = new ArrayList[n+2];
		for(int i = 0;i<n+2;i++) {
			graph[i] = new ArrayList<Node>();
		}
		
		double a, b;
		double dist;
		double times;
		
		times = Math.sqrt(Math.pow(endx-startx, 2)+Math.pow(endy-starty, 2))/5;
		graph[0].add(new Node(n+1,times));
		graph[n+1].add(new Node(0,times));
		for(int i = 0;i<n;i++) {
			st = new StringTokenizer(br.readLine()," ");
			a = Double.parseDouble(st.nextToken());
			b = Double.parseDouble(st.nextToken());
			dist = Math.sqrt(Math.pow(a-startx, 2)+Math.pow(b-starty, 2));
			graph[0].add(new Node(i+1,dist/5));
			graph[i+1].add(new Node(0,Math.min(dist/5, Math.abs(dist-50)/5+2)));
				
			dist = Math.sqrt(Math.pow(a-endx, 2)+Math.pow(b-endy, 2));
			graph[n+1].add(new Node(i+1,dist/5));
			graph[i+1].add(new Node(n+1,Math.min(dist/5, Math.abs(dist-50)/5+2)));

				
			for(int j = 0;j<i;j++) {
				dist = Math.sqrt(Math.pow(a-cannon[j][0], 2)+Math.pow(b-cannon[j][1], 2));
				times = Math.min(dist/5, Math.abs(dist-50)/5+2);
				graph[i+1].add(new Node(j+1,times));
				graph[j+1].add(new Node(i+1,times));
			}
			cannon[i][0] = a;
			cannon[i][1] = b;
		}
		
		double[] time = new double[n+2];
		Arrays.fill(time, Double.MAX_VALUE);
		time[0] = 0;
		Queue<Node> q = new PriorityQueue<Node>((n1,n2)->n1.t<n2.t?-1:1);
		
		q.add(new Node(0,0));
		Node now;
		int x;
		double t;
		while(!q.isEmpty()) {
			now = q.poll();
			x = now.x;
			t = now.t;
			
			if(time[x]<t)
				continue;
			for(Node next:graph[x]) {
				if(time[next.x]>t+next.t) {
					time[next.x] = t+next.t;
					q.add(new Node(next.x, time[next.x]));
				}
			}
			
		}
		System.out.println(time[n+1]);
	}
}