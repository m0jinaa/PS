import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		StringTokenizer st;

		int n;

		String[] name;
		int scenario = 0;
		while (true) {
			n = Integer.parseInt(br.readLine());

			if (n == 0)
				break;

			scenario++;

			name = new String[n + 1];

			for (int i = 1; i <= n; i++) {
				name[i] = br.readLine();
			}

			int[] cnt = new int[n + 1];
			int x;

			for (int i = 1; i < 2 * n; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				x = Integer.parseInt(st.nextToken());
				cnt[x]++;
			}

			for (int i = 1; i <= n; i++) {
				if (cnt[i] == 1) {
					sb.append(scenario).append(" ").append(name[i]).append("\n");
					break;
				}
			}
		}

		System.out.println(sb.toString());
	}
}