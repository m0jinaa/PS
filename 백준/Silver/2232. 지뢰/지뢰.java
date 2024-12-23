import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	static int n;
	static Mine[] mines;
	static int[] impact;
	static boolean[] blow;
	static boolean[] exists;

	static void init() {
		mines = new Mine[n];
		impact = new int[n];
		blow = new boolean[n];
		exists = new boolean[n];

		Arrays.fill(exists, true);
	}

	static class Mine implements Comparable<Mine> {
		int p, i;

		public Mine(int p, int i) {
			super();
			this.p = p;
			this.i = i;
		}

		@Override
		public int compareTo(Mine m) {
			return m.p - this.p;
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		n = Integer.parseInt(br.readLine());

		init();

		int p;

		for (int i = 0; i < n; i++) {
			p = Integer.parseInt(br.readLine());
			mines[i] = new Mine(p, i);
			impact[i] = p;
		}

		Arrays.sort(mines);

		int now;

		for (Mine m : mines) {
			if (!exists[m.i])
				continue;
			blow[m.i] = true;

			// 오른쪽, 왼쪽 연쇄반응 확인
			now = m.i;
			while (now < n - 1 && exists[now + 1] && impact[now + 1] < impact[now]) {
				exists[now + 1] = false;
				now++;
			}
			now = m.i;
			while (now > 0 && exists[now - 1] && impact[now - 1] < impact[now]) {
				exists[now - 1] = false;
				now--;
			}
		}

		for (int i = 0; i < n; i++) {
			if (!blow[i])
				continue;
			sb.append(i + 1).append("\n");
		}

		System.out.println(sb.toString());
	}
}