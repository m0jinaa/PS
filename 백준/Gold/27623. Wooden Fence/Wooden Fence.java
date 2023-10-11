import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
	static ArrayList<Integer> wood;
	static boolean[] dp;
	static int half;

	static boolean possible() {
		dp[0] = true;

		for (int x : wood) {
			for (int i = half; i >= x; i--) {
				dp[i] |= dp[i - x];
			}
		}

		return dp[half];
	}

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int n = Integer.parseInt(br.readLine());

		st = new StringTokenizer(br.readLine(), " ");

		int total = 0;

		int x;

		wood = new ArrayList<>();

		for (int i = 0; i < n; i++) {
			x = Integer.parseInt(st.nextToken());
			total += x;
			if (x == 2) {
				wood.add(1);
				wood.add(1);
			} else {
				wood.add(x);
			}
		}
		boolean can = false;
		if (total % 2 == 0) {
			half = total / 2;
			dp = new boolean[half + 1];

			can = possible();
		}

		System.out.println(can ? "YES" : "NO");
	}
}