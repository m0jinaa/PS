import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static class Chocolate implements Comparable<Chocolate> {
		int h, w;

		public Chocolate(int h) {
			super();
			this.h = h;
		}

		public void setW(int w) {
			this.w = w;
		}

		@Override
		public int compareTo(Chocolate c) {
			return this.h - c.h;
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int n = Integer.parseInt(br.readLine());

		Chocolate[] chocos = new Chocolate[n];

		int h, w;

		st = new StringTokenizer(br.readLine(), " ");

		for (int i = 0; i < n; i++) {
			h = Integer.parseInt(st.nextToken());

			chocos[i] = new Chocolate(h);
		}

		long sum = 0;
		long answer = 0;

		st = new StringTokenizer(br.readLine(), " ");

		for (int i = 0; i < n; i++) {
			w = Integer.parseInt(st.nextToken());

			chocos[i].setW(w);
			sum += w;
		}

		Arrays.sort(chocos);

		for (Chocolate c : chocos) {
			answer = Math.max(answer, c.h * sum);
			sum -= c.w;
		}

		System.out.println(answer);
	}
}