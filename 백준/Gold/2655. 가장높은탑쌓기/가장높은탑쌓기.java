import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static class Brick implements Comparable<Brick> {
		int ind, b, h, w;

		public Brick(int ind, int b, int h, int w) {
			super();
			this.ind = ind;
			this.b = b;
			this.h = h;
			this.w = w;
		}

		@Override
		public int compareTo(Brick brick) {
			return brick.b - this.b;
		}
	}

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		int n = Integer.parseInt(br.readLine());

		Brick[] brick = new Brick[n];

		int b, h, w;

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());

			b = Integer.valueOf(st.nextToken());
			h = Integer.valueOf(st.nextToken());
			w = Integer.valueOf(st.nextToken());

			brick[i] = new Brick(i + 1, b, h, w);
		}

		Arrays.sort(brick);

		int[] height = new int[n];

		int max = 0;
		boolean exist;

		for (int i = 0; i < n; i++) {
			exist = false;
			for (int j = i - 1; j >= 0; j--) {
				if (brick[i].w < brick[j].w) {
					exist = true;
					height[i] = Math.max(height[i], height[j] + brick[i].h);
				}
			}

			if (!exist) {
				height[i] = brick[i].h;
			}
			max = Math.max(max, height[i]);
		}

		int cnt = 0;

		while (n > 0) {
			if (height[n - 1] == max) {
				sb.append(brick[n - 1].ind).append("\n");
				max -= brick[n - 1].h;
				cnt++;
			}
			n--;
		}

		System.out.println(cnt);
		System.out.print(sb.toString());
	}
}