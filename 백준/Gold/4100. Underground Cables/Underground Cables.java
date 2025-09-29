import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main{
	static int n;
	static int[] parent;

	static int find(int x) {
		if (parent[x] != x) {
			parent[x] = find(parent[x]);
		}

		return parent[x];
	}

	static boolean union(int x, int y) {
		x = find(x);
		y = find(y);

		if (x == y)
			return false;
		else if (x < y)
			parent[y] = x;
		else
			parent[x] = y;

		return true;
	}

	static class Line implements Comparable<Line> {
		int a, b;
		double d;

		public Line(int a, int b, double d) {
			super();
			this.a = a;
			this.b = b;
			this.d = d;
		}

		@Override
		public int compareTo(Line l) {
			if (this.d < l.d)
				return -1;
			else if (this.d > l.d)
				return 1;
			else
				return 0;
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		int n;
		int x, y;
		double d;
		double answer;
		int[][] dots;
		LinkedList<Line> lines = new LinkedList<>();

		while (true) {

			n = Integer.parseInt(br.readLine());

			if (n == 0)
				break;

			answer = 0;
			lines.clear();
			dots = new int[n][2];
			parent = new int[n];

			for (int i = 0; i < n; i++) {
				parent[i] = i;

				st = new StringTokenizer(br.readLine(), " ");

				x = Integer.parseInt(st.nextToken());
				y = Integer.parseInt(st.nextToken());

				for (int j = 0; j < i; j++) {
					d = Math.sqrt(Math.pow(x - dots[j][0], 2) + Math.pow(y - dots[j][1], 2));

					lines.add(new Line(i, j, d));
				}

				dots[i][0] = x;
				dots[i][1] = y;
			}

			Collections.sort(lines);

			for (Line l : lines) {
				if (!union(l.a, l.b))
					continue;
				answer += l.d;
			}

			sb.append(String.format("%.02f\n", answer));
		}

		System.out.print(sb.toString());
	}
}