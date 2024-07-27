import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine(), " ");

		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int[] A = new int[n];
		int[] B = new int[m];

		for (int i = 0; i < n; i++) {
			A[i] = Integer.parseInt(br.readLine());
		}

		for (int i = 0; i < m; i++) {
			B[i] = Integer.parseInt(br.readLine());
		}

		int answer = 0;
		int c;

		for (int i = 0; i < n; i++) {
			c = 0;
			for (int j = i, k = 0; j < n && k < m; j++, k++) {
				if (A[j] == B[k])
					c++;
				else {
					answer = Math.max(c, answer);
					c = 0;
				}
			}

			answer = Math.max(answer, c);
		}

		for (int i = 0; i < m; i++) {
			c = 0;
			for (int j = i, k = 0; j < m && k < n; j++, k++) {
				if (B[j] == A[k])
					c++;
				else {
					answer = Math.max(c, answer);
					c = 0;
				}
			}

			answer = Math.max(answer, c);
		}

		System.out.println(answer);
	}
}