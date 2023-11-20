import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int[] nums;

	static int gcd(int x, int y) {
		int t;
		if (x < y) {
			t = x;
			x = y;
			y = t;
		}

		while (y != 0) {
			t = x % y;
			x = y;
			y = t;
		}

		return x;
	}

	static int getGCD(int s, int e) {
		int answer = nums[s];

		for (int i = s + 1; i <= e; i++) {
			answer = gcd(answer, nums[i]);
		}

		return answer;
	}

	static int getMax(int s, int e) {
		if (s == e) {
			return nums[s];
		}
		int m = (s + e - 1) / 2;

		int answer = 0;

		answer = Math.max(getGCD(s, m) + getMax(m + 1, e), getMax(s, m) + getGCD(m + 1, e));

		return answer;
	}

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int n = Integer.parseInt(br.readLine());

		nums = new int[n];

		st = new StringTokenizer(br.readLine(), " ");

		for (int i = 0; i < n; i++) {
			nums[i] = Integer.parseInt(st.nextToken());
		}

		int answer = getMax(0, n - 1);

		System.out.println(answer);
	}
}