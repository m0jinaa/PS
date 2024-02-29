import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		int n = Integer.parseInt(br.readLine());
		long total = 0;
		int[] value;
		int max;
		int s, e, left, right;
		int l;
		int sum;
		while (n-- > 0) {
			l = Integer.parseInt(br.readLine());

			value = new int[l + 1];

			st = new StringTokenizer(br.readLine(), " ");

			for (int i = 1; i <= l; i++) {
				value[i] = Integer.parseInt(st.nextToken());
			}

			max = -10001;
			s = 1;
			e = 1;
			left = 1;
			right = 1;

			sum = 0;

			while (e <= l) {
				sum += value[e];

				if (sum > max) {
					max = sum;
					left = s;
					right = e;
				} else if (sum == max && right - left > e - s) {
					left = s;
					right = e;
				}
				e++;
				if (sum <= 0) {
					s = e;
					sum = 0;
				}
			}

			total += max;
			sb.append(left).append(" ").append(right).append("\n");
		}

		System.out.println(total);
		System.out.print(sb.toString());
	}
}