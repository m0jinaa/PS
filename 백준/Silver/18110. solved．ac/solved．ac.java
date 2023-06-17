import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());

		int[] nums = new int[n];

		int sum = 0;

		for (int i = 0; i < n; i++) {
			nums[i] = Integer.parseInt(br.readLine());
			sum += nums[i];
		}

		int x = (int) Math.round(n * 0.15);

		Arrays.sort(nums);

		for (int i = 0; i < x; i++) {
			sum -= nums[i];
			sum -= nums[n - 1 - i];
		}

		int answer = (int) Math.round(sum * 1.0 / (n - 2 * x));

		System.out.println(answer);
	}
}