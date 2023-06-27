import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		int c = Integer.parseInt(br.readLine());
		int n, x, sum, mean;
		int[] nums = new int[101];
		int cnt;
		double answer;
		while (c-- > 0) {
			st = new StringTokenizer(br.readLine(), " ");

			n = Integer.parseInt(st.nextToken());

			Arrays.fill(nums, 0);

			sum = 0;

			for (int i = 0; i < n; i++) {
				x = Integer.parseInt(st.nextToken());
				sum += x;
				nums[x]++;
			}

			cnt = 0;

			mean = (int) (sum * 1.0 / n);

			for (int i = 0; i <= mean; i++) {
				cnt += nums[i];
			}

			answer = (n - cnt) * 100 * 1.0 / n;

			sb.append(String.format("%.03f%%\n", answer));
		}

		System.out.println(sb.toString());
	}
}