import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {
	static ArrayList<String> path;
	static int k;

	static class Node {
		HashMap<String, Node> children;

		public Node() {
			this.children = new HashMap<>();
		}

		public int add(int ind) {
			int cnt = 0;

			String dir = path.get(ind);
			
			Node next = this.children.get(dir);
			
			if (next == null) {
				next = new Node();
				this.children.put(dir, next);
				cnt++;
			}

			if (ind <= k - 2) {
				cnt += next.add(ind + 1);
			}

			return cnt;
		}

		public void clear() {
			this.children.clear();
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		StringTokenizer st;

		int tc = Integer.parseInt(br.readLine());
		int n, m;
		Node head = new Node();
		path = new ArrayList<>();

		for (int t = 1; t <= tc; t++) {
			head.clear();

			st = new StringTokenizer(br.readLine(), " ");

			n = Integer.parseInt(st.nextToken());
			m = Integer.parseInt(st.nextToken());

			int create = 0;

			for (int i = 0; i < n; i++) {
				path.clear();
				
				st = new StringTokenizer(br.readLine(), "/");
				
				while (st.hasMoreTokens()) {
					path.add(st.nextToken());
				}
				
				k = path.size();
				
				head.add(0);
			}

			for (int i = 0; i < m; i++) {
				path.clear();
				
				st = new StringTokenizer(br.readLine(), "/");
				
				while (st.hasMoreTokens()) {
					path.add(st.nextToken());
				}
				
				k = path.size();
				
				create += head.add(0);
			}
			
			sb.append(String.format("Case #%d: %d\n", t,create));
		}
		
		System.out.print(sb.toString());
	}

}
