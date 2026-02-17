import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		int n = Integer.parseInt(br.readLine());
		int t = Integer.parseInt(br.readLine());

		int[] hand = new int[2 * n];

		st = new StringTokenizer(br.readLine(), " ");

		for (int i = 0; i < 2 * n; i++) {
			hand[i] = Integer.parseInt(st.nextToken());
		}

		int start = 0;

		int b;

		int lose;

		st = new StringTokenizer(br.readLine(), " ");

		while (t-- > 0) {
			b = Integer.parseInt(st.nextToken());

			lose = (start + b - 1) % (2 * n);

			sb.append(hand[lose]).append(" ");

			start = lose;
		}

		System.out.println(sb.toString());
	}
}