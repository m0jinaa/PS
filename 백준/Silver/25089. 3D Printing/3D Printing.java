import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		int tc = Integer.parseInt(br.readLine());

		int[] min = new int[4];
		int sum, v;

		for (int t = 1; t <= tc; t++) {

			Arrays.fill(min, 1000001);

			for (int i = 0; i < 3; i++) {
				st = new StringTokenizer(br.readLine(), " ");

				for (int j = 0; j < 4; j++) {
					min[j] = Math.min(min[j], Integer.parseInt(st.nextToken()));
				}
			}

			sum = 0;

			for (int x : min) {
				sum += x;
			}

			sb.append("Case #").append(t).append(":");

			if (sum < 1000000) {
				sb.append(" IMPOSSIBLE\n");
			} else {
				sum = 1000000;

				for (int x : min) {
					v = Math.min(x, sum);

					sb.append(" ").append(v);
					sum -= v;
				}

				sb.append("\n");
			}
		}

		System.out.print(sb.toString());
	}
}