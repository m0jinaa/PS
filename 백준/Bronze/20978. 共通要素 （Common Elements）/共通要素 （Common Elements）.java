import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		final int MAX = 100;

		st = new StringTokenizer(br.readLine(), " ");

		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		boolean[] A = new boolean[MAX + 1];

		int a;

		st = new StringTokenizer(br.readLine(), " ");

		while (n-- > 0) {
			a = Integer.parseInt(st.nextToken());

			A[a] = true;
		}

		int[] B = new int[m];

		st = new StringTokenizer(br.readLine(), " ");

		for (int i = 0; i < m; i++) {
			B[i] = Integer.parseInt(st.nextToken());
		}

		Arrays.sort(B);

		for (int b : B) {
			if (!A[b])
				continue;
			A[b] = false;
			sb.append(b).append("\n");
		}

		System.out.print(sb.toString());
	}
}