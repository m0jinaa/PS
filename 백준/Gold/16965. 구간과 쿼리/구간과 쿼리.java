import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {
	static LinkedList<Integer>[] canGo;
	static boolean[] v;
	static LinkedList<Integer> q;

	static boolean check(int x, int y) {
		q.clear();
		Arrays.fill(v, false);

		q.add(x);
		v[x] = true;

		int now;

		while (!q.isEmpty()) {
			now = q.poll();

			if (now == y)
				return true;

			for (int nx : canGo[now]) {
				if (v[nx])
					continue;
				v[nx] = true;
				q.add(nx);
			}
		}

		return false;
	}

	static class Interval {
		int ind, a, b;

		public Interval(int ind, int a, int b) {
			super();
			this.ind = ind;
			this.a = a;
			this.b = b;
		}

		public boolean canGo(Interval c) {
			return (c.a < this.a && this.a < c.b) || (c.a < this.b && this.b < c.b);
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		int n = Integer.parseInt(br.readLine());

		canGo = new LinkedList[n + 1];
		v = new boolean[n + 1];
		q = new LinkedList<>();

		int o, a, b;

		LinkedList<Interval> list = new LinkedList<>();
		Interval c;

		int ind = 1;

		while (n-- > 0) {
			st = new StringTokenizer(br.readLine(), " ");

			o = Integer.parseInt(st.nextToken());
			a = Integer.parseInt(st.nextToken());
			b = Integer.parseInt(st.nextToken());

			if (o == 1) {
				c = new Interval(ind, a, b);
				canGo[ind++] = new LinkedList<>();

				for (Interval i : list) {
					if (i.canGo(c))
						canGo[i.ind].add(c.ind);

					if (c.canGo(i))
						canGo[c.ind].add(i.ind);
				}

				list.add(c);
			} else {
				if (check(a, b))
					sb.append("1\n");
				else {
					sb.append("0\n");
				}
			}
		}

		System.out.print(sb.toString());
	}
}