import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		st = new StringTokenizer(br.readLine(), " ");

		int n = Integer.parseInt(st.nextToken());
		int q = Integer.parseInt(st.nextToken());

		char[] row = br.readLine().toCharArray();

		int[] S = new int[n];

		for (int i = 0; i < n; i++) {
			S[i] = row[i] - 'A';
		}

		int o, l, r;

		int c;

		while (q-- > 0) {
			st = new StringTokenizer(br.readLine(), " ");

			o = Integer.parseInt(st.nextToken());
			l = Integer.parseInt(st.nextToken()) - 1;
			r = Integer.parseInt(st.nextToken()) - 1;

			switch (o) {
			case 1:
				c = 1;
				for (int i = l + 1; i <= r; i++) {
					if (S[i] != S[i - 1])
						c++;
				}

				sb.append(c).append("\n");
				break;
			case 2:
				for (int i = l; i <= r; i++) {
					S[i] = (S[i] + 1) % 26;
				}
				break;
			}
		}

		System.out.print(sb.toString());
	}
}