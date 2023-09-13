import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int n, l;
	static int[][] sendTo;
	static long[] total;
	static final int MOD = 1_000_000_007;

	static long getCnt(int x) {
		if (total[x] != -1)
			return total[x];
		else if (x > l) {
			return total[x] = 1;
		}

		long sum = 0;

		for (int y : sendTo[x]) {
			getCnt(y);
			sum += total[y];
			sum %= MOD;
		}

		return total[x] = sum;
	}

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		st = new StringTokenizer(br.readLine(), " ");

		n = Integer.parseInt(st.nextToken());
		l = Integer.parseInt(st.nextToken());
		total = new long[n + 1];

		sendTo = new int[l + 1][];
		Arrays.fill(total, -1);
		int m;

		for (int i = 1; i <= l; i++) {
			st = new StringTokenizer(br.readLine(), " ");

			m = Integer.parseInt(st.nextToken());
			sendTo[i] = new int[m];

			for (int j = 0; j < m; j++) {
				sendTo[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		getCnt(1);

		int unique = 0;

		for (int i = l + 1; i <= n; i++) {
			if (total[i] != -1)
				unique++;
		}
		sb.append(total[1]).append(" ").append(unique).append("\n");

		System.out.print(sb.toString());
	}
}