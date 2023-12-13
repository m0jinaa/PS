import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static class Gift implements Comparable<Gift> {
		int p, v;

		public Gift(int p, int v) {
			super();
			this.p = p;
			this.v = v;
		}

		@Override
		public int compareTo(Gift g) {
			return this.p - g.p;
		}
	}

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine(), " ");

		int n = Integer.parseInt(st.nextToken());
		int d = Integer.parseInt(st.nextToken());

		long sum = 0;

		Gift[] gifts = new Gift[n];

		int p, v;

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine(), " ");

			p = Integer.parseInt(st.nextToken());
			v = Integer.parseInt(st.nextToken());

			gifts[i] = new Gift(p, v);
		}

		Arrays.sort(gifts);

		int s = 0;
		int e = 0;

		long answer = 0;

		while (e < n) {
			sum += gifts[e].v;

			while (gifts[e].p - gifts[s].p >= d) {
				sum -= gifts[s++].v;
			}

			answer = Math.max(sum, answer);

			e++;
		}

		System.out.println(answer);
	}
}