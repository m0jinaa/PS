import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		int n = Integer.parseInt(br.readLine());

		int[] loc = new int[n + 1];
		int[] A = new int[n + 1];

		st = new StringTokenizer(br.readLine(), " ");

		int x;

		for (int i = 1; i <= n; i++) {
			x = Integer.parseInt(st.nextToken());
			A[i] = x;
			loc[x] = i;
		}

		long[] move = new long[n + 1];

		int d;

		for (int i = 1; i <= n; i++) {
			if (A[i] == i)
				continue;

			d = Math.abs(i - loc[i]);
			move[A[i]] += d;
			move[i] += d;

			loc[A[i]] = loc[i];
			A[loc[i]] = A[i];
			A[i] = i;
			loc[i] = i;
		}

		for (int i = 1; i <= n; i++) {
			sb.append(move[i]).append(" ");
		}

		System.out.println(sb.toString());
	}
}