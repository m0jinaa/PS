import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int gcd(int a, int b) {
		if (a == 0 || b == 0)
			return 0;

		int t;

		while (b != 0) {
			t = a % b;
			a = b;
			b = t;
		}

		return a;
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		int tc = Integer.parseInt(br.readLine());
		int[] nums;
		int n;

		int max;

		while (tc-- > 0) {

			max = 0;

			st = new StringTokenizer(br.readLine(), " ");
			n = st.countTokens();

			nums = new int[n];

			for (int i = 0; i < n; i++) {
				nums[i] = Integer.parseInt(st.nextToken());
				for (int j = 0; j < i; j++) {
					max = Math.max(max, gcd(nums[i], nums[j]));
				}
			}

			sb.append(max).append("\n");
		}

		System.out.print(sb.toString());
	}
}