import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		int tc = Integer.parseInt(br.readLine());

		int n;
		int[] nums;

		int a, b, s, e, sum, max;

		while (tc-- > 0) {
			n = Integer.parseInt(br.readLine());

			st = new StringTokenizer(br.readLine(), " ");

			nums = new int[n];

			for (int i = 0; i < n; i++) {
				nums[i] = Integer.parseInt(st.nextToken());
			}

			s = 0;
			e = 0;
			a = 0;
			b = 0;
			sum = -1001;
			max = -1001;
			for (int i = 0; i < n; i++) {
				if (sum < 0) {
					sum = nums[i];
					a = i;
					b = i;
				} else {
					sum += nums[i];
					b = i;
				}

				if (max < sum) {
					max = sum;
					s = a;
					e = b;
				}
			}

			sb.append(s + 1).append(" ").append(e + 1).append("\n");
		}

		System.out.print(sb.toString());
	}
}