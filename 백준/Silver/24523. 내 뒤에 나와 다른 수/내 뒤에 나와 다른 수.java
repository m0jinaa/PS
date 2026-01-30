import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		int n = Integer.parseInt(br.readLine());

		st = new StringTokenizer(br.readLine(), " ");

		int[] A = new int[n + 1];

		for (int i = 1; i <= n; i++) {
			A[i] = Integer.parseInt(st.nextToken());
		}

		int first = -1;
		int second = -1;

		int[] J = new int[n + 1];

		for (int i = n; i > 0; i--) {
			if (first == -1) {
				J[i] = -1;
			} else if (A[first] != A[i]) {
				J[i] = first;
				second = first;
			} else {
				J[i] = second;
			}
			first = i;
		}

		for (int i = 1; i <= n; i++) {
			sb.append(J[i]).append(i == n ? "\n" : " ");
		}

		System.out.print(sb.toString());
	}
}