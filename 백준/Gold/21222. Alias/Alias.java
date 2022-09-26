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
	static int n,m;
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
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		StringBuilder sb = new StringBuilder();
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		String a,b;
		int c;
		graph = new HashMap<String,ArrayList<Node>>();
		Set<String> key = new HashSet<String>();
		
		for(int i = 0;i<m;i++) {
			st = new StringTokenizer(br.readLine()," ");
			a = st.nextToken();
			b = st.nextToken();
			key.add(a);
			key.add(b);
			c = Integer.parseInt(st.nextToken());
			graph.putIfAbsent(a, new ArrayList<Node>());
			graph.get(a).add(new Node(b,c));
		}
		
		Map<String, HashMap<String, Long>> time = new HashMap<String,HashMap<String,Long>>();
		
		for(String s:key) {
			time.put(s, new HashMap<String,Long>());
			for(String ss:key) {
				time.get(s).put(ss, Long.MAX_VALUE);
			}
		}
		Queue<Node> q = new PriorityQueue<Node>((n1,n2)->n1.t<n2.t?-1:1);
		for(String s:key) {
			q.clear();
			q.add(new Node(s,0));
			time.get(s).put(s, 0L);
			Node now;
			while(!q.isEmpty()) {
				now = q.poll();
				if(time.get(s).get(now.key)<now.t)
					continue;
				for(Node next:graph.getOrDefault(now.key, new ArrayList<Node>())) {
					if(time.get(s).get(next.key)>now.t+next.t) {
						time.get(s).put(next.key,now.t+next.t);
						q.add(new Node(next.key,now.t+next.t));
					}
				}
			}
		}
		
		int qq = Integer.parseInt(br.readLine());
		for(int i = 0;i<qq;i++) {
			st = new StringTokenizer(br.readLine()," ");
			a = st.nextToken();
			b = st.nextToken();
			sb.append(time.get(a).get(b)==Long.MAX_VALUE?"Roger":time.get(a).get(b)).append("\n");
		}
		System.out.println(sb.toString());		
	}
}