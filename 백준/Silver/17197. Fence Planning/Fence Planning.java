import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static Cow[] cows;

	static class Cow {
		int p;
		int minX, minY, maxX, maxY;

		public Cow(int p, int minX, int minY, int maxX, int maxY) {
			super();
			this.p = p;
			this.minX = minX;
			this.minY = minY;
			this.maxX = maxX;
			this.maxY = maxY;
		}

		private static int find(int x) {
			if (cows[x].p != x) {
				cows[x].p = find(cows[x].p);
			}

			return cows[x].p;
		}

		public static void union(int x, int y) {
			x = find(x);
			y = find(y);

			if (x == y)
				return;

			if (x > y) {
				int t = x;
				x = y;
				y = t;
			}

			cows[y].p = x;
			cows[x].minX = Math.min(cows[x].minX, cows[y].minX);
			cows[x].minY = Math.min(cows[x].minY, cows[y].minY);
			cows[x].maxX = Math.max(cows[x].maxX, cows[y].maxX);
			cows[x].maxY = Math.max(cows[x].maxY, cows[y].maxY);
		}

		public int getPerimeter() {
			int perimeter = 2 * (this.maxX - this.minX) + 2 * (this.maxY - this.minY);

			return perimeter;
		}
	}

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine(), " ");

		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		cows = new Cow[n + 1];

		int x, y;

		for (int i = 1; i <= n; i++) {
			st = new StringTokenizer(br.readLine(), " ");

			x = Integer.parseInt(st.nextToken());
			y = Integer.parseInt(st.nextToken());

			cows[i] = new Cow(i, x, y, x, y);
		}

		int a, b;

		while (m-- > 0) {
			st = new StringTokenizer(br.readLine(), " ");

			a = Integer.parseInt(st.nextToken());
			b = Integer.parseInt(st.nextToken());

			Cow.union(a, b);
		}

		int answer = Integer.MAX_VALUE;

		int perimeter;

		for (int i = 1; i <= n; i++) {
			if (cows[i].p != i)
				continue;

			perimeter = cows[i].getPerimeter();
			answer = Math.min(answer, perimeter);
		}

		System.out.println(answer);
	}
}