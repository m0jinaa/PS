import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {
	static int c, p, x, l;
	static double[] half;
	static int[] left;
	static ArrayList<Integer>[] tradeWith;
	static boolean[] gone;

	static boolean bfs() {
		LinkedList<Integer> q = new LinkedList<>();

		q.add(l);
		gone[l] = true;

		int now;

		while (!q.isEmpty()) {
			now = q.poll();

			for (int y : tradeWith[now]) {
				if (gone[y])
					continue;

				left[y]--;
				if (left[y] <= half[y]) {
					gone[y] = true;
					q.add(y);
				}
			}
		}

		return gone[x];
	}

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine(), " ");

		c = Integer.parseInt(st.nextToken());
		p = Integer.parseInt(st.nextToken());
		x = Integer.parseInt(st.nextToken());
		l = Integer.parseInt(st.nextToken());

		half = new double[c + 1];
		left = new int[c + 1];
		gone = new boolean[c + 1];

		tradeWith = new ArrayList[c + 1];

		for (int i = 1; i <= c; i++) {
			tradeWith[i] = new ArrayList<>();
		}

		int a, b;

		for (int i = 0; i < p; i++) {
			st = new StringTokenizer(br.readLine(), " ");

			a = Integer.parseInt(st.nextToken());
			b = Integer.parseInt(st.nextToken());

			tradeWith[a].add(b);
			tradeWith[b].add(a);

			left[a]++;
			left[b]++;

		}

		for (int i = 1; i <= c; i++) {
			half[i] = left[i] * 1.0 / 2;
		}

		boolean answer = bfs();

		System.out.println(answer ? "leave" : "stay");
	}
}