import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		int c = Math.min(2, Integer.parseInt(br.readLine().replace(".", "")) / 99);

		int n = Integer.parseInt(br.readLine());

		st = new StringTokenizer(br.readLine(), " ");

		int[] cnt = new int[n + 1];

		int x;
		int max = 0;

		for (int i = 1; i <= n; i++) {
			x = Integer.parseInt(st.nextToken());
			max = Math.max(max, x);

			cnt[i] = cnt[i - 1] + (x == 0 ? 1 : 0);
		}

		int s = 1;
		int e = 1;
		int answer = 0;

		while (e <= n) {
			if (cnt[e] - cnt[s - 1] > c) {
				s++;
			} else {
				answer = Math.max(answer, e - s + 1);
				e++;
			}
		}

		sb.append(answer).append("\n").append(max);

		System.out.println(sb.toString());
	}
}