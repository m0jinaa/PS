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
		int m = Integer.parseInt(st.nextToken());

		int[] diff = new int[n + 1];
		int[] h = new int[n + 1];

		st = new StringTokenizer(br.readLine(), " ");

		for (int i = 0; i < n; i++) {
			h[i] = Integer.parseInt(st.nextToken());
		}

		int a, b, k;

		while (m-- > 0) {
			st = new StringTokenizer(br.readLine(), " ");
			a = Integer.parseInt(st.nextToken());
			b = Integer.parseInt(st.nextToken());

			k = Integer.parseInt(st.nextToken());

			diff[a - 1] += k;
			diff[b] += -k;
		}

		int d = diff[0];

		int ind = 1;

		while (ind <= n) {
			d = (diff[ind++] += d);
		}

		for (int i = 0; i < n; i++) {
			sb.append(h[i] + diff[i]).append(" ");
		}
		System.out.println(sb.toString());
	}
}