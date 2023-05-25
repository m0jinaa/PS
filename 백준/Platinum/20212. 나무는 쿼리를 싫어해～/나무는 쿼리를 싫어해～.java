import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {
	static class Query implements Comparable<Query> {
		int ind, ord, type, i, j;
		int k;

		public Query(int ind, int ord, int type, int i, int j, int k) {
			super();
			this.ind = ind;
			this.ord = ord;
			this.type = type;
			this.i = i;
			this.j = j;
			this.k = k;
		}

		@Override
		public int compareTo(Query o) {
			if (this.ord != o.ord)
				return this.ord - o.ord;
			else if (this.type != o.type)
				return this.type - o.type;
			else
				return this.ind - o.ind;
		}		
	}

	static class Node {
		Node left, right;
		long val;
		long lazy;

		public Node() {
			this.left = null;
			this.right = null;
			this.val = 0;
			this.lazy = 0;
		}

		public void propagation(long l, long r) {
			if (this.lazy == 0)
				return;
			this.val += lazy * (r - l + 1);
			if (l == r) {
				this.lazy = 0;
				return;
			}
			if (this.left == null) {
				this.left = new Node();
			}
			if (this.right == null) {
				this.right = new Node();
			}

			this.left.lazy += this.lazy;
			this.right.lazy += this.lazy;
			this.lazy = 0;
		}

		public void update(long l, long r, long s, long e, long v) {
			this.propagation(l, r);

			if (r < s || e < l)
				return;
			else if (s <= l && r <= e) {
				this.lazy += v;
				this.propagation(l, r);
			} else {
				long m = (l + r) / 2;
				if (this.left == null) {
					this.left = new Node();
				}
				if (this.right == null) {
					this.right = new Node();
				}
				this.left.update(l, m, s, e, v);
				this.right.update(m + 1, r, s, e, v);
				this.val = this.left.val + this.right.val;

			}

		}

		public long get(long l, long r, long s, long e) {
			this.propagation(l, r);
			if (r < s || e < l)
				return 0;
			else if (s <= l && r <= e) {
				return this.val;
			} else {
				long m = (l + r) / 2;
				long answer = 0;
				if (this.left != null) {
					answer += this.left.get(l, m, s, e);
				}
				if (this.right != null) {
					answer += this.right.get(m + 1, r, s, e);
				}
				return answer;
			}
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();

		HashSet<Integer> set = new HashSet<>();
		int first = 0;
		int second = 0;

		int n = Integer.parseInt(br.readLine());
		int type, s, e, k;
		LinkedList<Query> queries = new LinkedList<>();

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			type = Integer.parseInt(st.nextToken());
			s = Integer.parseInt(st.nextToken());
			e = Integer.parseInt(st.nextToken());
			k = Integer.parseInt(st.nextToken());
			set.add(s);
			set.add(e);
			if (type == 1) {
				queries.add(new Query(-1, ++first, type, s, e, k));
			} else {
				queries.add(new Query(second++, k, type, s, e, 0));
			}
		}
		
		Collections.sort(queries);
		
		long[] answer = new long[second];
		
		Node root = new Node();
		
		for(Query q : queries) {
			if(q.type==1) {
				root.update(1, 1_000_000_000, q.i, q.j, q.k);
			}
			else {
				answer[q.ind] = root.get(1, 1_000_000_000, q.i, q.j);
			}
		}
		
		for(long ans : answer) {
			sb.append(ans).append("\n");
		}
		
		System.out.print(sb.toString());
	}
}