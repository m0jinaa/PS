import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Main{

	public static int gcd(int x, int y) {
		if (x > y) {
			int t = x;
			x = y;
			y = t;
		}
		int t;
		while (x != 0 && y != 0) {
			t = y % x;
			y = x;
			x = t;
		}

		return x + y;
	}

	public static class Node {
		int x, y;

		public Node(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}

		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + x;
			result = prime * result + y;
			return result;
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			Node other = (Node) obj;
			if (x != other.x)
				return false;
			if (y != other.y)
				return false;
			return true;
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int n = Integer.parseInt(br.readLine());

		HashSet<Node> positive = new HashSet<>();
		HashSet<Node> negative = new HashSet<>();
		int x, y;
		int v;
		while (n-- > 0) {
			st = new StringTokenizer(br.readLine(), " ");
			x = Integer.parseInt(st.nextToken());
			y = Integer.parseInt(st.nextToken());

			v = gcd(Math.abs(x), Math.abs(y));
			x /= v;
			y /= v;
			if (x == 0) {
				if (y > 0) {
					positive.add(new Node(x, y));
				} else {
					negative.add(new Node(x, y));
				}
			} else {
				if (x > 0) {
					positive.add(new Node(x, y));
				} else {
					negative.add(new Node(x, y));
				}
			}
		}
		System.out.println(positive.size() + negative.size());
	}
}