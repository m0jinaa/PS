import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		long answer = 0;

		int n = Integer.parseInt(br.readLine());

		long[] nums = new long[n];

		st = new StringTokenizer(br.readLine(), " ");

		for (int i = 0; i < n; i++) {
			nums[i] = Long.parseLong(st.nextToken());
		}

		Arrays.sort(nums);

		for (int i = 0; i < n; i++) {
			answer ^= (nums[i] * nums[i]);
			if (i > 0) {
				answer ^= (nums[i - 1] * nums[i]);
			}
		}
		System.out.println(answer);
	}
}