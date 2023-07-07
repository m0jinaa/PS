import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());

		long[] exp = new long[n];

		st = new StringTokenizer(br.readLine(), " ");

		long sum = 0;

		for (int i = 0; i < n; i++) {
			exp[i] = Long.parseLong(st.nextToken());
			sum += exp[i];
		}

		Arrays.sort(exp);

		long answer = sum * k;

		for (int i = 0; i < k; i++) {
			answer -= (exp[i] * (k - i));
		}

		System.out.println(answer);
	}
}