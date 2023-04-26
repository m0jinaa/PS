import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Map.Entry;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class Main {
	static StringBuilder sb;
	static class Node {
		int d;
		String w;
		boolean end = false;
		TreeMap<String, Node> children;

		public Node(String w, int d, boolean end) {
			super();
			this.w = w;
			this.d = d;
			this.end = end;
			this.children = new TreeMap<>();
		}

		public Node() {
			this.d = -1;
			this.children = new TreeMap<>();
		}

		public void add(int ind, String[] arr) {
			Node next = this.children.getOrDefault(arr[ind],new Node(arr[ind],this.d+1,ind==arr.length-1));
			if(!next.end)
				next.add(ind+1, arr);
			this.children.put(arr[ind], next);
		}
		public void print() {
			if(this.d>=0) {
				while(d-->0) {
					sb.append("--");
				}
				sb.append(this.w).append("\n");
			}
			if(end)
				return;
			for(Entry<String, Node> node : this.children.entrySet()) {
				node.getValue().print();
			}
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		sb = new StringBuilder();
		StringTokenizer st;

		int n = Integer.parseInt(br.readLine());

		Node head = new Node();
		String[] arr;
		int k;
		while(n-->0) {
			st = new StringTokenizer(br.readLine()," ");
			k = Integer.parseInt(st.nextToken());
			arr = new String[k];
			for(int i = 0;i<k;i++) {
				arr[i] = st.nextToken();
			}
			head.add(0, arr);
		}
		
		head.print();
		
		System.out.println(sb.toString());
	}
}