import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine(), " ");

		int n = Integer.parseInt(st.nextToken());
		int t = Integer.parseInt(st.nextToken());

		int limit = 2 * ((int) Math.sqrt(t));
		int[] divider = new int[limit + 1];

		int ind = 0;

		for (int i = 1; i <= t; i++) {
			if (t % i == 0) {
				divider[ind++] = i;
			}
		}

		divider[ind] = Integer.MAX_VALUE;
		int s, e, m;

		int closest;

		int a;

		st = new StringTokenizer(br.readLine(), " ");

		int answer = 0;

		while (n-- > 0) {
			a = Integer.parseInt(st.nextToken());

			s = 0;
			e = ind - 1;
			closest = 0;

			while (s <= e) {
				m = (s + e) / 2;

				if (divider[m] <= a) {
					closest = m;
					s = m + 1;
				} else {
					e = m - 1;
				}
			}

			answer += Math.min(a - divider[closest], divider[closest + 1] - a);
		}

		System.out.println(answer);
	}
}