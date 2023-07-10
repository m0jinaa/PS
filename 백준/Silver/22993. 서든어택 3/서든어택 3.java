import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int n = Integer.parseInt(br.readLine());

		st = new StringTokenizer(br.readLine(), " ");

		long power = Long.parseLong(st.nextToken());

		long[] others = new long[n - 1];

		for (int i = 0; i < n - 1; i++) {
			others[i] = Long.parseLong(st.nextToken());
		}

		Arrays.sort(others);
		boolean success = true;
		for (long x : others) {
			if (power > x) {
				power += x;
			} else {
				success = false;
				break;
			}
		}

		System.out.println(success ? "Yes" : "No");
	}
}