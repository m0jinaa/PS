import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;

public class Main {
	static long[] sumTree;
	static int n;

	static void update(int x) {
		while (x <= n) {
			sumTree[x] += 1;
			x += (x & (-x));
		}
	}

	static long get(int x) {
		long ret = 0;

		while (x > 0) {
			ret += sumTree[x];
			x -= (x & (-x));
		}

		return ret;
	}

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int x;
		long cnt;

		n = Integer.parseInt(br.readLine());

		sumTree = new long[n + 1];

		HashMap<Integer, Integer> map = new HashMap<>();

		cnt = 0;
		int[] input = new int[n + 1];
		int[] ordered = new int[n + 1];
		input[0] = -1;
		ordered[0] = -1;
		for (int i = 1; i <= n; i++) {
			input[i] = Integer.parseInt(br.readLine());
			ordered[i] = input[i];
		}

		Arrays.sort(ordered);

		for (int i = 1; i <= n; i++) {
			map.put(ordered[i], i);
		}

		for (int i = 1; i <= n; i++) {
			x = map.get(input[i]);

			update(x);

			cnt += (i - get(x));
		}

		System.out.print(cnt);
	}
}