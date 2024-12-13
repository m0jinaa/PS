import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
	static class Apt implements Comparable<Apt> {
		int x, c;

		public Apt(int x, int c) {
			super();
			this.x = x;
			this.c = c;
		}

		@Override
		public int compareTo(Apt a) {
			return a.x - this.x;
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine(), " ");

		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		int s = Integer.parseInt(st.nextToken());

		ArrayList<Apt> left = new ArrayList<>();
		ArrayList<Apt> right = new ArrayList<>();

		int x, c;

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			x = Integer.parseInt(st.nextToken());
			c = Integer.parseInt(st.nextToken());

			if (x < s) {
				left.add(new Apt(s - x, c));
			} else {
				right.add(new Apt(x - s, c));
			}
		}

		Collections.sort(left);
		Collections.sort(right);

		int d = 0;

		int answer = 0;
		int time;

		for (Apt a : left) {
			if (d > a.c) {
				d -= a.c;
			} else {
				a.c -= d;
				time = (int) Math.ceil(a.c * 1.0 / k);
				d = time * k - a.c;
				answer += time * a.x * 2;
			}
		}

		d = 0;
		for (Apt a : right) {
			if (d > a.c) {
				d -= a.c;
			} else {
				a.c -= d;
				time = (int) Math.ceil(a.c * 1.0 / k);
				d = time * k - a.c;
				answer += time * a.x * 2;
			}
		}

		System.out.println(answer);
	}
}
