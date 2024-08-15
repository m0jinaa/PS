import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());

		long answer = n;

		int m, c, v;

		for (int i = 2; i < n; i = m + 1) {
			v = ((n - 1) / i) + 1;
			m = (n - 1) / ((n - 1) / i);
			c = m - i + 1;

			answer += (c * v);
		}

		if (answer != 1)
			answer++;

		System.out.println(answer);
	}
}