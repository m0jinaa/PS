import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {
	static class Trash {
		int x, y;

		public Trash(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine(), " ");

		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		LinkedList<Trash> trashes = new LinkedList<>();
		LinkedList<Trash> uncleaned = new LinkedList<>();

		int v;

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < m; j++) {
				v = Integer.parseInt(st.nextToken());

				if (v == 0) {
					continue;
				}

				uncleaned.add(new Trash(i, j));

			}
		}

		int cnt = 0;
		int x, y;
		Trash t;

		while (!uncleaned.isEmpty()) {
			cnt++;

			trashes.addAll(uncleaned);
			uncleaned.clear();
			x = 0;
			y = 0;

			while (!trashes.isEmpty()) {
				t = trashes.poll();

				if (t.x >= x && t.y >= y) {
					x = t.x;
					y = t.y;
					continue;
				} else {
					uncleaned.add(t);
				}
			}
		}

		System.out.println(cnt);
	}
}