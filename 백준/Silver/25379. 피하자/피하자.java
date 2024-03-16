import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int n = Integer.parseInt(br.readLine());

		int[] nums = new int[n + 1];

		st = new StringTokenizer(br.readLine(), " ");

		for (int i = 1; i <= n; i++) {
			nums[i] = Integer.parseInt(st.nextToken());
		}

		long[] cnt = new long[2];

		long[] move = new long[2];

		int x;
		for (int i = 1; i <= n; i++) {
			x = nums[i] % 2;

			cnt[x]++;
			move[x] += cnt[1 - x];
		}

		long answer = Math.min(move[0], move[1]);

		System.out.println(answer);
	}
}