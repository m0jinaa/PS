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

		st = new StringTokenizer(br.readLine(), " ");

		int[] nums = new int[n];

		for (int i = 0; i < n; i++) {
			nums[i] = Integer.parseInt(st.nextToken());
		}

		int s = Integer.parseInt(br.readLine());
		int max, ind, t;

		for (int i = 0; i < n && s > 0; i++) {
			max = nums[i];
			ind = -1;

			for (int j = i + 1; j < n && (j - i) <= s; j++) {
				if (nums[j] > max) {
					max = nums[j];
					ind = j;
				}
			}

			if (ind == -1)
				continue;

			s -= (ind - i);

			t = nums[ind];
			for (int j = ind; j > i; j--) {
				nums[j] = nums[j - 1];
			}
			nums[i] = t;

		}

		for (int x : nums) {
			sb.append(x).append(" ");
		}

		System.out.println(sb.toString());
	}
}