import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int n = Integer.parseInt(br.readLine());

		st = new StringTokenizer(br.readLine(), " ");

		int[] poll = new int[n + 2];

		for (int i = 1; i <= n; i++) {
			poll[i] = Integer.parseInt(st.nextToken());
		}

		poll[0] = poll[n + 1] = 10001;

		int[] down = new int[n + 2];
		int[] up = new int[n + 2];

		for (int i = 1; i <= n; i++) {
			for (int j = 0; j < i; j++) {
				if (poll[j] > poll[i])
					down[i] = Math.max(down[i], down[j] + 1);
			}
		}

		for (int i = n; i > 0; i--) {
			for (int j = n + 1; j > i; j--) {
				if (poll[j] > poll[i])
					up[i] = Math.max(up[i], up[j] + 1);
			}
		}

		int answer = 0;

		for (int i = 1; i <= n; i++) {
			answer = Math.max(answer, down[i] + up[i] - 1);
		}

		System.out.println(answer);
	}
}