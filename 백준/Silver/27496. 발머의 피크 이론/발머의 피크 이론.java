import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine(), " ");

		int n = Integer.parseInt(st.nextToken());
		int l = Integer.parseInt(st.nextToken());

		int[] sum = new int[n + 1];

		int x;

		st = new StringTokenizer(br.readLine(), " ");

		int now;

		int answer = 0;

		for (int i = 1; i <= n; i++) {
			x = Integer.parseInt(st.nextToken());
			sum[i] = sum[i - 1] + x;
			if (i < l) {
				now = sum[i];
			} else {
				now = sum[i] - sum[i - l];
			}

			if (129 <= now && now <= 138) {
				answer++;
			}
		}

		System.out.println(answer);
	}
}