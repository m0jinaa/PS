import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		st = new StringTokenizer(br.readLine(), " ");

		int n = Integer.parseInt(st.nextToken());
		int q = Integer.parseInt(st.nextToken());

		int[] nums = new int[n];

		st = new StringTokenizer(br.readLine(), " ");

		for (int i = 0; i < n; i++) {
			nums[i] = Integer.parseInt(st.nextToken());
		}

		int[] quality = new int[n];

		int ind;

		int sum = 0;

		int mul = 1;

		for (int i = 0; i < 4; i++) {
			mul *= nums[i];
		}

		quality[0] = mul;
		sum = mul;

		for (int i = 1; i < n; i++) {
			quality[i] = quality[i - 1] / nums[i - 1] * nums[(i + 3) % n];
			sum += quality[i];
		}

		st = new StringTokenizer(br.readLine(), " ");

		int x;

		while (q-- > 0) {
			x = Integer.parseInt(st.nextToken()) - 1;

			for (int i = -3; i < 1; i++) {
				ind = (x + i + n) % n;

				sum -= (2 * quality[ind]);
				quality[ind] *= -1;
			}

			sb.append(sum).append("\n");
		}

		System.out.print(sb.toString());
	}
}