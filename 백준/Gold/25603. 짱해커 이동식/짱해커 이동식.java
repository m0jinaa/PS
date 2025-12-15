import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int n, k;
	static int[] cost;

	static boolean check(int x) {
		int bef = -1;

		for (int i = 0; i < n; i++) {
			if(cost[i]>x)
				continue;
			else if (i - bef > k)
				return false;
			bef = i;
		}

		return (n - bef) <= k;
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine(), " ");

		n = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());

		cost = new int[n];

		st = new StringTokenizer(br.readLine(), " ");

		int min = 1_000_000_007;
		int max = 0;

		for (int i = 0; i < n; i++) {
			cost[i] = Integer.parseInt(st.nextToken());
			min = Math.min(min, cost[i]);
			max = Math.max(max, cost[i]);
		}

		int answer = 1_000_000_007;

		int mid;

		while (min <= max) {
			mid = (min + max) / 2;

			if (check(mid)) {
				answer = mid;
				max = mid - 1;
			} else {
				min = mid + 1;
			}
		}

		System.out.println(answer);
	}
}