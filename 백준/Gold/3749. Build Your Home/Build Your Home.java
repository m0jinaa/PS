import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = null;

		int n;
		double[][] dots;
		double space;

		while (true) {
			space = 0;

			if (st == null || !st.hasMoreTokens())
				st = new StringTokenizer(br.readLine());

			n = Integer.parseInt(st.nextToken());

			if (n == 0) {
				break;
			} else {
				dots = new double[n][2];

				for (int i = 0; i < n; i++) {
					if (st == null || !st.hasMoreTokens())
						st = new StringTokenizer(br.readLine());

					dots[i][0] = Double.parseDouble(st.nextToken());
					if (st == null || !st.hasMoreTokens())
						st = new StringTokenizer(br.readLine());

					dots[i][1] = Double.parseDouble(st.nextToken());
				}

				for (int i = 0; i < n; i++) {
					space += dots[i][0] * dots[(i + 1) % n][1] - dots[i][1] * dots[(i + 1) % n][0];
				}

				space = Math.abs(space) / 2;
			}

			sb.append((int) Math.round(space)).append("\n");
		}

		System.out.print(sb.toString());
	}
}