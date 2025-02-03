import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());

		int[] s = new int[n];

		for (int i = 0; i < n; i++) {
			s[i] = Integer.parseInt(br.readLine());
		}

		Arrays.sort(s);

		int answer = 2_000_001;

		for (int i = 0, j = n - 1; i < j; i++, j--) {
			answer = Math.min(answer, s[i] + s[j]);
		}

		System.out.println(answer);
	}
}