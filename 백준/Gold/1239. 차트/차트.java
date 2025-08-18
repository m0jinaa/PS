import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int n;
	static int answer = 0;
	static int[] dogs;
	static int[] chart;
	static boolean[] used;

	static void check() {
		int ret = 0;
		int s = 0;
		int e = -1;
		int sum = 0;

		while (s < n && e < 2 * n) {
			if (sum == 50) {
				ret++;
				if (e < 2 * n - 1) {
					sum -= chart[s++];
					sum += chart[++e];
				} else {
					break;
				}
			} else if (sum < 50) {
				if (e < 2 * n - 1) {
					sum += chart[++e];
				} else {
					break;
				}
			} else {
				sum -= chart[s++];
			}
		}
		answer = Math.max(answer, ret / 2);
	}

	static void combi(int x) {
		if (x == n) {
			check();
		} else {
			for (int i = 0; i < n; i++) {
				if (used[i])
					continue;

				used[i] = true;
				chart[x] = dogs[i];
				chart[n + x] = dogs[i];
				combi(x + 1);
				used[i] = false;
			}
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		n = Integer.parseInt(br.readLine());

		dogs = new int[n];
		chart = new int[2 * n];
		used = new boolean[n];

		st = new StringTokenizer(br.readLine(), " ");

		for (int i = 0; i < n; i++) {
			dogs[i] = Integer.parseInt(st.nextToken());
		}

		combi(0);

		System.out.println(answer);
	}
}