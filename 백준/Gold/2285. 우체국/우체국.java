import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static class Town implements Comparable<Town> {
		int x, c;

		public Town(int x, int a) {
			super();
			this.x = x;
			this.c = a;
		}

		@Override
		public int compareTo(Town v) {
			return this.x - v.x;
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int n = Integer.parseInt(br.readLine());

		Town[] towns = new Town[n];

		int x, a;

		long total = 0;

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine(), " ");

			x = Integer.parseInt(st.nextToken());
			a = Integer.parseInt(st.nextToken());

			towns[i] = new Town(x, a);

			total += a;
		}

		Arrays.sort(towns);

		long sum = 0;

		long half = (total + 1) / 2;

		int answer = -1;

		for (Town v : towns) {
			sum += v.c;

			if (sum >= half) {
				answer = v.x;
				break;
			}
		}

		System.out.println(answer);
	}
}