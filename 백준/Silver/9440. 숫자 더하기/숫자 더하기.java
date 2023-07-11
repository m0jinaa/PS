import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		int n;
		int[] nums;
		int answer;
		String left, right;

		while (true) {
			st = new StringTokenizer(br.readLine(), " ");

			n = Integer.parseInt(st.nextToken());

			if (n == 0)
				break;

			nums = new int[n];
			int zero = 0;
			for (int i = 0; i < n; i++) {
				nums[i] = Integer.parseInt(st.nextToken());
				if (nums[i] == 0)
					zero++;
			}

			Arrays.sort(nums);

			if (zero == 1) {
				nums[0] = nums[2];
				nums[2] = 0;
			} else if (zero > 1) {
				nums[0] = nums[zero];
				nums[zero] = 0;
				nums[1] = nums[zero + 1];
				nums[zero + 1] = 0;
			}

			left = "";
			right = "";

			for (int i = 0; i < n; i++) {
				if (i % 2 == 0) {
					left += nums[i];
				} else {
					right += nums[i];
				}
			}

			answer = Integer.parseInt(left) + Integer.parseInt(right);

			sb.append(answer).append("\n");
		}

		System.out.println(sb.toString());
	}
}