import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		int n = Integer.parseInt(br.readLine());

		int[] crosswalk = new int[n];

		st = new StringTokenizer(br.readLine(), " ");

		for (int i = 0; i < n; i++) {
			crosswalk[i] = Integer.parseInt(st.nextToken());
		}

		long[] left = new long[n + 1];

		st = new StringTokenizer(br.readLine(), " ");

		for (int i = 0; i < n - 1; i++) {
			left[i] = (i > 0 ? left[i - 1] : 0) + Integer.parseInt(st.nextToken());
		}

		long[] right = new long[n + 1];

		st = new StringTokenizer(br.readLine(), " ");

		for (int i = 0; i < n - 1; i++) {
			right[i] = Integer.parseInt(st.nextToken());
		}

		for (int i = n - 2; i >= 0; i--) {
			right[i] += right[i + 1];
		}

		int select = -1;
		long total = Long.MAX_VALUE;

		long temp;

		for (int i = 0; i < n; i++) {
			temp = crosswalk[i] + (i > 0 ? left[i - 1] : 0) + right[i];

			if (temp < total) {
				total = temp;
				select = i + 1;
			}
		}

		sb.append(select).append(" ").append(total);

		System.out.println(sb.toString());
	}
}