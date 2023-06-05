import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int max = (1 << 26) - 1;
		int[] words = new int[n];
		int x;
		char[] word;
		for (int i = 0; i < n; i++) {
			x = 0;
			word = br.readLine().toCharArray();
			for (char c : word) {
				x |= (1 << (c - 'a'));
				if (x == max)
					break;
			}
			words[i] = x;
		}

		int status = max;
		int o, cnt;
		while (m-- > 0) {
			st = new StringTokenizer(br.readLine(), " ");
			o = Integer.parseInt(st.nextToken());
			x = st.nextToken().charAt(0) - 'a';

			if (o == 1) {
				status ^= (1 << x);
			} else {
				status |= (1 << x);
			}

			cnt = 0;

			for (int w : words) {
				if ((status & w) == w) {
					cnt++;
				}
			}

			sb.append(cnt).append("\n");
		}

		System.out.println(sb.toString());

	}
}