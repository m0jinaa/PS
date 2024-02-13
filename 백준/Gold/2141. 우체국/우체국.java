import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static class Village implements Comparable<Village> {
		int x, a;

		public Village(int x, int a) {
			super();
			this.x = x;
			this.a = a;
		}

		@Override
		public int compareTo(Village v) {
			return this.x - v.x;
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int n = Integer.parseInt(br.readLine());

		Village[] villages = new Village[n];

		int x, a;

		long total = 0;

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine(), " ");

			x = Integer.parseInt(st.nextToken());
			a = Integer.parseInt(st.nextToken());

			villages[i] = new Village(x, a);

			total += a;
		}

		Arrays.sort(villages);

		long sum = 0;

		long mid = (total + 1) / 2;

		int answer = -1;

		for (Village v : villages) {
			sum += v.a;

			if (sum >= mid) {
				answer = v.x;
				break;
			}
		}

		System.out.println(answer);
	}
}