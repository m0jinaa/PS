import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());

		int max = n;
		int ind = -1;

		int[] nums = new int[n];
		for (int i = 0; i < n; i++) {
			nums[i] = Integer.parseInt(br.readLine());

			if (nums[i] == max) {
				ind = i;
			}
		}

		max--;

		int answer = n - ind - 1;

		for (int i = ind - 1; i >= 0; i--) {
			if (nums[i] != max) {
				answer++;
			} else {
				max--;
			}
		}

		System.out.println(answer);
	}
}