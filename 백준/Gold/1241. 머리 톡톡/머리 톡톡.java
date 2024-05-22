import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int n = Integer.parseInt(br.readLine());

		int[] num = new int[n];

		int max = 0;

		for (int i = 0; i < n; i++) {
			num[i] = Integer.parseInt(br.readLine());
			max = Math.max(max, num[i]);
		}

		int[] cnt = new int[max + 1];

		int limit;

		int[] answer = new int[n];

		for (int i = 0; i < n; i++) {
			cnt[num[i]]++;
		}

		for (int i = 0; i < n; i++) {
			limit = (int) Math.sqrt(num[i]);

			for (int j = 1; j <= limit; j++) {
				if (num[i] % j == 0) {
					answer[i] += cnt[j];
					if (num[i] / j != j)
						answer[i] += cnt[num[i] / j];
				}
			}
		}

		for (int x : answer) {
			sb.append(x - 1).append("\n");
		}

		System.out.println(sb.toString());
	}
}