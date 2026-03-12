import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int n;
	static int[] A;
	static StringBuilder sb;

	static void postOrder(int s, int e) {
		if (s == e) {
			sb.append(A[s]).append(" ");
		} else {
			int mid = (s + e) / 2;
			postOrder(s, mid - 1);
			postOrder(mid + 1, e);
			sb.append(A[mid]).append(" ");
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		sb = new StringBuilder();
		StringTokenizer st;

		n = Integer.parseInt(br.readLine());

		A = new int[n + 1];

		int ind = -1;

		st = new StringTokenizer(br.readLine(), " ");

		for (int i = 1; i <= n; i++) {
			A[i] = Integer.parseInt(st.nextToken());
			if (A[i] == -1)
				ind = i;
		}

		int x = Integer.parseInt(br.readLine());

		A[ind] = x;

		Arrays.sort(A);

		postOrder(1, n);

		System.out.println(sb.toString());
	}
}