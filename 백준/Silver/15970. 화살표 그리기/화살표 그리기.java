import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static final int INF = 1_000_000;

	static class Dot implements Comparable<Dot> {
		int x, y;// x:위치 , y: 색깔

		public Dot(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}

		@Override
		public int compareTo(Dot d) {
			if (this.y != d.y) {
				return this.y - d.y;
			} else {
				return this.x - d.x;
			}
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int n = Integer.parseInt(br.readLine());

		Dot[] dots = new Dot[n];
		int x, y;
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			x = Integer.parseInt(st.nextToken());
			y = Integer.parseInt(st.nextToken());
			dots[i] = new Dot(x, y);
		}

		Arrays.sort(dots);

		long answer = 0;
		int min;
		for (int i = 0; i < n; i++) {
			min = INF;
			if (i > 0 && dots[i - 1].y == dots[i].y) {
				min = Math.min(min, dots[i].x - dots[i - 1].x);
			}
			if (i < n - 1 && dots[i + 1].y == dots[i].y) {
				min = Math.min(min, dots[i + 1].x - dots[i].x);
			}

			if (min != INF) {
				answer += min;
			}
		}

		System.out.println(answer);
	}
}