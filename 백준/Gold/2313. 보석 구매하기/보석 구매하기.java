import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		int n = Integer.parseInt(br.readLine());
		long total = 0;
		int[] sum;
		int max;
		int s, e;
		int l;
		int v;
		while (n-- > 0) {
			l = Integer.parseInt(br.readLine());

			sum = new int[l + 1];

			st = new StringTokenizer(br.readLine(), " ");

			for (int i = 1; i <= l; i++) {
				sum[i] = sum[i - 1] + Integer.parseInt(st.nextToken());
			}

			max = -10001;
			s = -1;
			e = -1;

			for (int i = 1; i <= l; i++) {
				for (int j = i; j <= l; j++) {
					v = sum[j] - sum[i - 1];
					if (v > max) {
						max = v;
						s = i;
						e = j;
					} else if (v == max && e - s > j - i) {
						s = i;
						e = j;
					}
				}
			}

			total += max;
			sb.append(s).append(" ").append(e).append("\n");
		}

		System.out.println(total);
		System.out.print(sb.toString());
	}
}