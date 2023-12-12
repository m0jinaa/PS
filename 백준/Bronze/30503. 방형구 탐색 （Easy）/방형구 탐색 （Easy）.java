import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int[] flower;

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		int n = Integer.parseInt(br.readLine());

		flower = new int[n];

		st = new StringTokenizer(br.readLine(), " ");

		for (int i = 0; i < n; i++) {
			flower[i] = Integer.parseInt(st.nextToken());
		}

		int q = Integer.parseInt(br.readLine());

		int o, l, r, k, cnt;

		while (q-- > 0) {
			st = new StringTokenizer(br.readLine(), " ");

			o = Integer.parseInt(st.nextToken());
			l = Integer.parseInt(st.nextToken()) - 1;
			r = Integer.parseInt(st.nextToken()) - 1;

			switch (o) {
			case 1:
				k = Integer.parseInt(st.nextToken());
				cnt = 0;
				for (int i = l; i <= r; i++) {
					if (flower[i] == k) {
						cnt++;
					}
				}

				sb.append(cnt).append("\n");
				break;
			case 2:
				for (int i = l; i <= r; i++) {
					flower[i] = 0;
				}
				break;
			}
		}

		System.out.println(sb.toString());
	}
}