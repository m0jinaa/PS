import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;
import java.util.StringTokenizer;

public class Main{
	static int n;
	static String start,end;
	static Map<String,ArrayList<Node>> graph;
	static class Node{
		String key;
		long t;
		public Node(String key, long t) {
			super();
			this.key = key;
			this.t = t;
		}
		
	}
	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		Queue<Node> q = new PriorityQueue<Node>((n1,n2)->n1.t<n2.t?-1:1);
		int TC = Integer.parseInt(br.readLine());
		for(int T = 0;T<TC;T++) {
			
			st = new StringTokenizer(br.readLine()," ");
			n = Integer.parseInt(st.nextToken());
			start = st.nextToken();
			end = st.nextToken();
			String a,b;
			int c;
			graph = new HashMap<String,ArrayList<Node>>();
			Set<String> key = new HashSet<String>();
			
			for(int i = 0;i<n;i++) {
				st = new StringTokenizer(br.readLine()," ");
				a = st.nextToken();
				b = st.nextToken();
				key.add(a);
				key.add(b);
				c = Integer.parseInt(st.nextToken());
				graph.putIfAbsent(a, new ArrayList<Node>());
				graph.putIfAbsent(b, new ArrayList<Node>());
				graph.get(a).add(new Node(b,c));
				graph.get(b).add(new Node(a,c));
			}
			
			Map<String, Long> time = new HashMap<String,Long>();
			
			for(String s:key) {
				time.put(s, Long.MAX_VALUE);
			}
			q.clear();
			q.add(new Node(start,0));
			time.put(start, 0L);
			Node now;
			while(!q.isEmpty()) {
				now = q.poll();
				if(time.get(now.key)<now.t)
					continue;
				for(Node next:graph.getOrDefault(now.key, new ArrayList<Node>())) {
					if(time.get(next.key)>now.t+next.t) {
						time.put(next.key,now.t+next.t);
						q.add(new Node(next.key,now.t+next.t));
					}
				}
			}
			sb.append(start).append(" ").append(end).append(" ").append(time.get(end)).append("\n");
			
		}
		System.out.println(sb.toString());	
	}
}
