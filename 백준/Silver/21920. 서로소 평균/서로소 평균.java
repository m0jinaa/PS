import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int gcd(int a, int b) {
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
		StringTokenizer st;

		int n = Integer.parseInt(br.readLine());

		int[] nums = new int[n];

		st = new StringTokenizer(br.readLine(), " ");

		for (int i = 0; i < n; i++) {
			nums[i] = Integer.parseInt(st.nextToken());
		}

		int x = Integer.parseInt(br.readLine());

		double sum = 0;
		int c = 0;

		for (int a : nums) {
			if (gcd(a, x) == 1) {
				sum += a;
				c++;
			}
		}

		double answer = sum / c;

		System.out.println(answer);
	}
}