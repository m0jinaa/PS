import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	static int[] cake;

	static void init() {
		cake = new int[10001];

		for (int i = 1; i < 10001; i++) {
			cake[i] = i;

			for (int j = 1; j * j <= i; j++) {
				cake[i] = Math.min(cake[i], cake[i - j * j] + 1);
			}
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		init();

		int tc = Integer.parseInt(br.readLine());

		int n;

		for (int t = 1; t <= tc; t++) {
			n = Integer.parseInt(br.readLine());

			sb.append(String.format("Case #%d: %d\n", t, cake[n]));
		}

		System.out.print(sb.toString());
	}
}