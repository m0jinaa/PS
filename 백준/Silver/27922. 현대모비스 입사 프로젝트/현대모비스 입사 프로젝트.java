import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine(), " ");

		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());

		int[] ab = new int[n];
		int[] ac = new int[n];
		int[] bc = new int[n];

		int a, b, c;

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			a = Integer.parseInt(st.nextToken());
			b = Integer.parseInt(st.nextToken());
			c = Integer.parseInt(st.nextToken());

			ab[i] = a + b;
			ac[i] = a + c;
			bc[i] = b + c;
		}

		Arrays.sort(ab);
		Arrays.sort(ac);
		Arrays.sort(bc);

		int sumAB = 0;
		int sumAC = 0;
		int sumBC = 0;

		for (int i = n - 1; i >= n - k; i--) {
			sumAB += ab[i];
			sumAC += ac[i];
			sumBC += bc[i];
		}

		int answer = Math.max(sumAB, Math.max(sumAC, sumBC));

		System.out.println(answer);
	}
}