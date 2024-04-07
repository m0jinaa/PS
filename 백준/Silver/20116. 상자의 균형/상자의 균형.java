import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine(), " ");

		int n = Integer.parseInt(st.nextToken());
		long l = Integer.parseInt(st.nextToken());

		long sum = 0;
		long c = 0;

		long left, right;

		long[] center = new long[n];

		st = new StringTokenizer(br.readLine(), " ");

		for (int i = 0; i < n; i++) {
			center[i] = Long.parseLong(st.nextToken());
		}

		sum = center[n - 1];
		c = 1;

		boolean stable = true;

		for (int i = n - 2; i >= 0; i--) {
			left = (center[i] - l) * c;
			right = (center[i] + l) * c;

			if (sum <= left || right <= sum) {
				stable = false;
				break;
			}

			sum += center[i];
			c++;
		}

		System.out.println(stable ? "stable" : "unstable");
	}
}