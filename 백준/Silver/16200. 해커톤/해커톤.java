import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int n = Integer.parseInt(br.readLine());

		int[] X = new int[n];

		st = new StringTokenizer(br.readLine(), " ");

		for (int i = 0; i < n; i++) {
			X[i] = Integer.parseInt(st.nextToken());
		}

		Arrays.sort(X);

		int cnt = 0;

		for (int i = 0; i < n;) {
			cnt++;
			i += X[i];
		}

		System.out.println(cnt);
	}
}