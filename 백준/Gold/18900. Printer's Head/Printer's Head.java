import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int n = Integer.parseInt(br.readLine());

		int[] location = new int[n + 1];

		st = new StringTokenizer(br.readLine(), " ");

		int x;

		for (int i = 1; i <= n; i++) {
			x = Integer.parseInt(st.nextToken());
			location[x] = i;
		}

		int answer = 0;

		if (n == 1) {
			answer = 1;
		} else {
			int now = n;
			while (now > 1) {
				answer++;
				if (location[now] > location[now - 1]) {
					while (now > 1 && location[now] > location[now - 1]) {
						now--;
					}
				} else {
					while (now > 1 && location[now] < location[now - 1]) {
						now--;
					}
				}

				now--;
			}

			if (now == 1) {
				answer++;
			}
		}

		System.out.println(answer);
	}
}