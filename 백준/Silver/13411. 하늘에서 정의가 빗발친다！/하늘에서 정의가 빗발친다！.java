import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static class Robot implements Comparable<Robot> {
		int ind;
		int x, y, v;
		double t;

		public Robot(int ind, int x, int y, int v) {
			super();
			this.ind = ind;
			this.x = x;
			this.y = y;
			this.v = v;
			t = Math.sqrt(x * x + y * y) / v;
		}

		@Override
		public int compareTo(Robot r) {
			if (this.t != r.t) {
				return this.t < r.t ? -1 : 1;
			} else {
				return this.ind - r.ind;
			}
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		StringTokenizer st;

		int n = Integer.parseInt(br.readLine());

		Robot[] robots = new Robot[n];
		int x, y, v;

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine(), " ");

			x = Integer.parseInt(st.nextToken());
			y = Integer.parseInt(st.nextToken());
			v = Integer.parseInt(st.nextToken());

			robots[i] = new Robot(i + 1, x, y, v);
		}

		Arrays.sort(robots);

		for (Robot r : robots) {
			sb.append(r.ind).append("\n");
		}

		System.out.println(sb.toString());
	}
}