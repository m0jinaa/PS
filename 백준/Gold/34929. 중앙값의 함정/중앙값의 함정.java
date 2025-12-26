import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		int n = Integer.parseInt(br.readLine());

		int[] nums = new int[n];

		st = new StringTokenizer(br.readLine(), " ");

		for (int i = 0; i < n; i++) {
			nums[i] = Integer.parseInt(st.nextToken());
		}

		if (n != 1) {
			Arrays.sort(nums);
			sb.append(nums[n - 2]).append("\n");

			sb.append(nums[0]).append(" ").append(nums[1]).append(" ").append(nums[2]).append("\n");

			for (int i = 1; i < n - 2; i += 2) {
				sb.append(nums[i]).append(" ").append(nums[i + 2]).append(" ").append(nums[i + 3]).append("\n");

			}
		} else {
			sb.append(nums[0]).append("\n");
		}

		System.out.print(sb.toString());
	}
}