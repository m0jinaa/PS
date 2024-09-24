import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	static int[] color;
	static boolean[] isPrime;

	static int coloring(int x) {
		isPrime = new boolean[x + 1];
		color = new int[x + 1];

		Arrays.fill(isPrime, true);

		isPrime[0] = isPrime[1] = false;

		color[1] = 1;

		int c = 2;

		int limit = (int) Math.floor(Math.sqrt(x));

		for (int i = 2; i <= x; i++) {
			if (!isPrime[i])
				continue;
			color[i] = c++;

			if (i > limit)
				continue;
			for (int j = i * i; j <= x; j += i) {
				isPrime[j] = false;
				color[j] = color[i];
			}
		}

		return c - 1;
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int n = Integer.parseInt(br.readLine());

		int k = coloring(n);

		sb.append(k).append("\n");

		for (int i = 1; i <= n; i++) {
			sb.append(color[i]).append(i == n ? "\n" : " ");
		}

		System.out.print(sb.toString());
	}
}