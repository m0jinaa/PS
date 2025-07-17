import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	static int n;
	static int[] nums;
	static int[] digit = new int[9];
	static boolean[] selected;

	static int check() {
		Arrays.fill(digit, 0);

		int x;
		int ind;
		int c = 0;
		for (int i = 0; i < n; i++) {
			if (!selected[i])
				continue;
			c++;
			x = nums[i];
			ind = 0;
			while (x > 0) {
				digit[ind] += x % 10;
				x /= 10;
				ind++;
			}
		}

		for (int i = 0; i < 9; i++) {
			if (digit[i] > 9)
				return -1;
		}

		return c;

	}

	static int select(int ind) {
		if (ind == n) {
			return check();
		}

		selected[ind] = true;
		int ret = select(ind + 1);

		selected[ind] = false;
		ret = Math.max(ret, select(ind + 1));

		return ret;
	}

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		n = Integer.parseInt(br.readLine());

		selected = new boolean[n];
		nums = new int[n];

		for (int i = 0; i < n; i++) {
			nums[i] = Integer.parseInt(br.readLine());
		}

		int answer = select(0);

		System.out.println(answer);
	}
}