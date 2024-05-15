import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		int tc = Integer.parseInt(br.readLine());
		int a, b, target;
		boolean[][] isFriend;

		for (int t = 1; t <= tc; t++) {
			if (t != 1)
				sb.append("\n");

			sb.append("Data Set ").append(t).append(":\n");

			st = new StringTokenizer(br.readLine(), " ");

			int n = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());

			isFriend = new boolean[n + 1][n + 1];

			while (m-- > 0) {
				st = new StringTokenizer(br.readLine(), " ");

				a = Integer.parseInt(st.nextToken());
				b = Integer.parseInt(st.nextToken());

				isFriend[a][b] = true;
				isFriend[b][a] = true;
			}

			target = Integer.parseInt(br.readLine());

			for (int i = 1; i <= n; i++) {
				if (isFriend[target][i])
					sb.append(i).append(" ");
			}

			sb.append("\n");
		}

		System.out.print(sb.toString());
	}
}