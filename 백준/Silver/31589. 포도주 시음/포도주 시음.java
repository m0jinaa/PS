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
		int k = Integer.parseInt(st.nextToken()) + 1;

		int[] wine = new int[n + 1];

		st = new StringTokenizer(br.readLine(), " ");

		for (int i = 0; i < n; i++) {
			wine[i] = Integer.parseInt(st.nextToken());
		}

		long answer = 0;

		Arrays.sort(wine);

		int l = 0;
		int r = n;

		while (k > 1) {
			answer += (wine[r--] - wine[l++]);
			k -= 2;
		}

		System.out.println(answer);
	}
}