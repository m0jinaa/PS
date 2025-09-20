import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int c;
	static int[] nums;

	static int cantMake() {
		int target = 1;
		int sum = 0;

		for (int i = 0; i < c && nums[i] <= target; i++) {
			sum += nums[i];
			target = sum + 1;
		}

		return target;
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		int n = Integer.parseInt(br.readLine());

		for (int t = 1; t <= n; t++) {
			if (t != 1) {
				sb.append("\n");
			}

			c = Integer.parseInt(br.readLine());

			st = new StringTokenizer(br.readLine(), " ");

			nums = new int[c];

			for (int i = 0; i < c; i++) {
				nums[i] = Integer.parseInt(st.nextToken());
			}

			Arrays.sort(nums);

			sb.append("Set #").append(t).append(": ").append(cantMake()).append("\n");
		}

		System.out.print(sb.toString());

	}
}
