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

		int[] state = new int[n + 1];

		char[] row = br.readLine().toCharArray();

		for (int i = 0; i < n; i++) {
			state[i + 1] = row[i] - '0';
		}

		int o, x, y, c;

		while (q-- > 0) {
			st = new StringTokenizer(br.readLine(), " ");

			o = Integer.parseInt(st.nextToken());

			if (o == 1) {
				x = Integer.parseInt(st.nextToken());
				state[x] = 1 - state[x];
			} else {
				x = Integer.parseInt(st.nextToken());
				y = Integer.parseInt(st.nextToken());

				c = y - x + 1;

				if (c >= 4) {
					sb.append("YES\n");
				} else if (c == 1) {
					sb.append("NO\n");
				} else if (c == 2) {
					if (state[x] == state[y]) {
						sb.append("YES\n");
					} else {
						sb.append("NO\n");
					}
				} else {
					if (state[x] == state[x + 1] || state[x + 1] == state[y]) {
						sb.append("YES\n");
					} else {
						sb.append("NO\n");
					}
				}
			}
		}

		System.out.print(sb.toString());
	}
}