import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		int n = Integer.parseInt(br.readLine());

		int[] mistake = new int[n + 1];

		int bef = 0;

		st = new StringTokenizer(br.readLine(), " ");

		int x;

		for (int i = 1; i <= n; i++) {
			x = Integer.parseInt(st.nextToken());
			mistake[i] = mistake[i - 1];

			if (bef > x) {
				mistake[i]++;
			}
			bef = x;
		}

		int q = Integer.parseInt(br.readLine());

		int a, b;

		while (q-- > 0) {
			st = new StringTokenizer(br.readLine(), " ");

			a = Integer.parseInt(st.nextToken());
			b = Integer.parseInt(st.nextToken());

			sb.append(mistake[b] - mistake[a]).append("\n");
		}

		System.out.print(sb.toString());
	}
}