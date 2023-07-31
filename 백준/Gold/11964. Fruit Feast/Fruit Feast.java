import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {
	static int n;
	static boolean[][] v;
	static int[] dx;

	static class Fruit {
		int x, water;

		public Fruit(int x, int water) {
			super();
			this.x = x;
			this.water = water;
		}

	}

	static boolean inRange(int x) {
		if (x < 0 || x > n)
			return false;
		return true;
	}

	static int getMax() {
		LinkedList<Fruit> q = new LinkedList<>();
		q.add(new Fruit(0, 0));
		int answer = 0;
		Fruit now;
		int y;
		while (!q.isEmpty()) {
			now = q.poll();
			answer = Math.max(now.x, answer);
			for (int i = 0; i < 2; i++) {
				y = now.x + dx[i];

				if (!inRange(y) || v[y][now.water])
					continue;
				v[y][now.water] = true;
				q.add(new Fruit(y, now.water));
			}

			if (now.water == 0) {
				y = now.x / 2;
				if (v[y][1])
					continue;
				v[y][1] = true;
				q.add(new Fruit(y, 1));
			}

		}
		return answer;
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		n = Integer.parseInt(st.nextToken());
		int a = Integer.parseInt(st.nextToken());
		int b = Integer.parseInt(st.nextToken());

		dx = new int[] { a, b };

		v = new boolean[n + 1][2];

		System.out.println(getMax());
	}
}