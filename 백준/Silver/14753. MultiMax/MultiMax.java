import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int n = Integer.parseInt(br.readLine());

		int[] nums = new int[n];

		st = new StringTokenizer(br.readLine(), " ");

		for (int i = 0; i < n; i++) {
			nums[i] = Integer.parseInt(st.nextToken());
		}

		Arrays.sort(nums);

		int answer = -1_000_000_007;

		int left = nums[0] * nums[1];
		int right = nums[n - 1] * nums[n - 2];

		answer = Math.max(left, right);

		left *= nums[n - 1];
		right *= nums[n - 3];

		answer = Math.max(answer, left);
		answer = Math.max(answer, right);

		System.out.println(answer);
	}
}