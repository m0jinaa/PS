import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Main {
	static boolean[] prime;
	static int[] nums;
	static int n;
	static Set<Integer> set;

	static void init() {
		prime = new boolean[10000000];

		Arrays.fill(prime, true);

		prime[0] = prime[1] = false;

		for (int i = 2; i < 10000000; i++) {
			if (!prime[i])
				continue;
			for (int j = i * 2; j < 10000000; j += i) {
				prime[j] = false;
			}
		}

		set = new HashSet<Integer>();
	}

	static void combi(int now, int selected) {
		if (prime[now]) {
			if(set.contains(now))
				return;
			set.add(now);
		}

		for (int i = 0; i < n; i++) {
			if ((selected & (1 << i)) != 0)
				continue;
			if (selected == 0 && nums[i] == 0)
				continue;
			combi(now * 10 + nums[i], selected | (1 << i));
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		init();

		int c = Integer.parseInt(br.readLine());
		char[] temp;
		while (c-- > 0) {

			set.clear();

			temp = br.readLine().toCharArray();
			n = temp.length;
			nums = new int[n];

			for (int i = 0; i < n; i++) {
				nums[i] = temp[i] - '0';
			}

			combi(0, 0);

			sb.append(set.size()).append("\n");
		}
        
		System.out.print(sb.toString());
	}
}