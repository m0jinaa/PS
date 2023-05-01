import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class Main {
	static StringBuilder sb;
	static ArrayList<String> dir;
	static int k;
	
	static class Node{
		String s;
		int depth;
		TreeMap<String, Node> children;
		
		public Node() {
			this.s = "";
			this.depth = -1;
			this.children = new TreeMap<>();
		}
		
		public Node(String s, int depth) {
			super();
			this.s = s;
			this.depth = depth;
			this.children = new TreeMap<>();
		}
		
		public void add(int ind) {
			String d = dir.get(ind);
			Node next = this.children.get(d);
			
			if(next == null) {
				next = new Node(d,this.depth+1);
				this.children.put(d, next);
			}
			
			if(ind<=k-2) {
				next.add(ind+1);
			}
		}
		
		public void print() {
			if(this.depth>=0) {
				for(int i = 0;i<this.depth;i++) {
					sb.append(" ");
				}
				sb.append(this.s).append("\n");
			}
			
			for(Node next : this.children.values()) {
				next.print();
			}
		}
	}
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		sb = new StringBuilder();
		
		StringTokenizer st;
		
		int n = Integer.parseInt(br.readLine());
		
		dir = new ArrayList<String>();
		
		Node head = new Node();
		
		for(int i = 0;i<n;i++) {
			
			dir.clear();
			
			st = new StringTokenizer(br.readLine(),"\\");
			
			while(st.hasMoreTokens()) {
				dir.add(st.nextToken());
			}
			
			k = dir.size();
			
			head.add(0);
		}
		
		head.print();
		
		System.out.print(sb.toString());
	}
}